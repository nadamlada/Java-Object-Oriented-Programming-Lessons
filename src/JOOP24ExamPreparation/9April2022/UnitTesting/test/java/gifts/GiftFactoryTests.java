package gifts;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class GiftFactoryTests {
    @Test
    public void testGetCountIfFactoryIsNull() {
        GiftFactory giftFactory = new GiftFactory();
        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testGetCountHappyPath() {
        GiftFactory giftFactory = new GiftFactory();

        Gift gift = new Gift("kon", 20.0);

        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
        //TODO: да се сравни дали точно този подарък се е създал
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateGiftWithGiftThatIsInCollectionThrow() {
        GiftFactory giftFactory = new GiftFactory();

        Gift gift = new Gift("kon", 20.0);

        giftFactory.createGift(gift);
        giftFactory.createGift(gift);
    }


    @Test
    public void testCreateGiftHappyPath() {
        GiftFactory giftFactory = new GiftFactory();

        Gift gift = new Gift("kon", 20.0);
        Gift gift1 = new Gift("stol", 10.0);

        giftFactory.createGift(gift);
        Assert.assertEquals(1, giftFactory.getCount());
        //TODO: да се сравни дали точно този подарък се е създал

        giftFactory.createGift(gift1);
        Assert.assertEquals(2, giftFactory.getCount());
        //TODO: да се сравни дали точно този подарък се е създал
    }


    @Test(expected = NullPointerException.class)
    public void testRemoveGiftWhenNameIsNullThrow() {
        GiftFactory giftFactory = new GiftFactory();

        Gift gift = new Gift("kon", 20.0);

        giftFactory.createGift(gift);
        giftFactory.removeGift(null);
    }

    @Test
    public void testRemoveGiftHappyPath() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("kon", 20.0);
        giftFactory.createGift(gift);

        Assert.assertEquals(1, giftFactory.getCount());
        giftFactory.removeGift(gift.getType());

        Assert.assertEquals(0, giftFactory.getCount());
    }

    @Test
    public void testGetPresentWithLeastMagicWhenThereIsNoAnyExpectNull() {
        GiftFactory giftFactory = new GiftFactory();
        Assert.assertNull(giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void testGetPresentWithLeastMagicHappyPath() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("kon", 20.0);
        Gift gift2 = new Gift("chuk", 10.0);

        giftFactory.createGift(gift);
        giftFactory.createGift(gift2);

        Assert.assertEquals(gift2, giftFactory.getPresentWithLeastMagic());
        //TODO: да се сравни дали точно този подарък е подаден
    }

    @Test
    public void testGetPresentWhenNoPresentsReturnNull() {
        GiftFactory giftFactory = new GiftFactory();
        giftFactory.getPresent("stol");
    }

    @Test
    public void testGetPresentHappyPath() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("kon", 20.0);
        giftFactory.createGift(gift);

        Assert.assertEquals(gift, giftFactory.getPresent("kon"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetPresentsHappyPath() {
        GiftFactory giftFactory = new GiftFactory();
        Gift gift = new Gift("kon", 20.0);
        giftFactory.createGift(gift);

        Collection<Gift> unmodifiablePresents = giftFactory.getPresents();
        Assert.assertEquals(1, unmodifiablePresents.size());

        Gift gift2 = new Gift("chuk", 10.0);

        unmodifiablePresents.add(gift2);

        Assert.assertEquals(1, unmodifiablePresents.size());
    }


}
