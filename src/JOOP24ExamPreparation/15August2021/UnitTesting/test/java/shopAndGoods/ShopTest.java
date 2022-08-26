package shopAndGoods;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShopTest {

    @Test
    public void test_Constructor_HappyPath() {
        Shop shop = new Shop();
        Assert.assertEquals(12, shop.getShelves().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addGoods_ifShelfDoesntExistThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("dracaena", "D");
        shop.addGoods("ShelvesNotInitialized", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_addGoods_ifShelfIsAlreadyTaken() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        Goods goods2 = new Goods("tradescantia", "T");
        shop.addGoods("Shelves1", goods1);
        shop.addGoods("Shelves1", goods2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void test_addGoods_goodsAresAlreadyInShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);
        shop.addGoods("Shelves2", goods1);
    }

    @Test
    public void test_addGoods_HappyPath() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);

        List<Goods> notNullGoods = shop.getShelves().values().stream()
                .filter(v -> v != null)
                .collect(Collectors.toList());

        Assert.assertEquals(1, notNullGoods.size());
        Assert.assertEquals("dracaena", notNullGoods.get(0).getName());
    }

    @Test
    public void test_addGoods_HappyPathTestMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");

        String expectedMessage = shop.addGoods("Shelves1", goods1);

        Assert.assertEquals("Goods: D is placed successfully!", expectedMessage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_whenShelfDoesntExistThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);
        shop.removeGoods("ShelfDoesntExist", goods1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeGoods_whenGoodsInThatShelfDoesntExistThrow() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);

        Goods goods2 = new Goods("tradescantia", "T");

        shop.removeGoods("Shelves1", goods2);
    }

    @Test
    public void test_removeGoods_HappyPAth() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);

        Assert.assertTrue(shop.getShelves().containsValue(goods1));
        shop.removeGoods("Shelves1", goods1);

        Assert.assertFalse(shop.getShelves().containsValue(goods1));
    }

    @Test
    public void test_removeGoods_HappyPathTestMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);

        String expectedString = shop.removeGoods("Shelves1", goods1);

        Assert.assertEquals("Goods: D is removed successfully!", expectedString);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getShelves_isUnmodifiableCollection() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods1 = new Goods("dracaena", "D");
        shop.addGoods("Shelves1", goods1);

        Map<String, Goods> shelvesUnmodifiableCollection = shop.getShelves();
        shelvesUnmodifiableCollection.put("Shelves2", goods1);
    }
}