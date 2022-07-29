import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {
    private static final int TARGET_EXPERIENCE = 10;
    private static final String HERO_NAME = "Petko";

    @Test
    public void testGainingExperienceWhenTargetDies() {
        Weapon weaponMock = Mockito.mock(Weapon.class);
        TargetInterface targetInterfaceMock = Mockito.mock(TargetInterface.class);

        Mockito.when(targetInterfaceMock.isDead()).thenReturn(true);
        Mockito.when(targetInterfaceMock.giveExperience()).thenReturn(TARGET_EXPERIENCE);

        Hero hero = new Hero(HERO_NAME, weaponMock);
        //Act
        hero.attack(targetInterfaceMock);
        //Assert
        Assert.assertEquals(TARGET_EXPERIENCE, hero.getExperience());
    }
}
