package heroRepository;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {

    @Test(expected = NullPointerException.class)
    public void testCreateHeroWhenHeroIsNullThrow() {
        HeroRepository heroRepository = new HeroRepository();
        heroRepository.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateHeroWhenHeroExists() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);
        heroRepository.create(hero);
    }

    @Test
    public void testCreateHeroHappyHath() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertEquals(0, heroRepository.getCount());

        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());
        Assert.assertEquals(hero, heroRepository.getHero("Pesho"));
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithNullNameThrow() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);

        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithEmptyNameThrow() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);

        heroRepository.remove("");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveWithNotTrimmedNameThrow() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);

        heroRepository.remove("           ");
    }

    @Test
    public void testRemoveHappyPath() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());

        heroRepository.remove("Pesho");
        Assert.assertEquals(0, heroRepository.getCount());
    }

    @Test
    public void testBooleanRemoveHeroNotInRepository() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);

        Assert.assertFalse(heroRepository.remove("Gosho"));
    }

    @Test
    public void testGetHeroWithHighestLevelReturnNull() {
        HeroRepository heroRepository = new HeroRepository();
        Assert.assertNull(heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelHappyPath() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        Hero hero2 = new Hero("Gosho", 2);

        heroRepository.create(hero);
        Assert.assertEquals(1, heroRepository.getCount());

        heroRepository.create(hero2);
        Assert.assertEquals(2, heroRepository.getCount());

        Hero heroWithHighestLevel = heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero2, heroWithHighestLevel);
    }

    //тест дали връща ънмодифайъбъл колекшън
    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesUnmodifiableCollection() {
        HeroRepository heroRepository = new HeroRepository();
        Hero hero = new Hero("Pesho", 1);
        heroRepository.create(hero);

        Collection<Hero> heroes = heroRepository.getHeroes();
        Hero hero2 = new Hero("Gosho", 2);
        heroes.add(hero2);
    }
}
