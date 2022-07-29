import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DUMMY_EXPERIENCE = 10;
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;
    private static final int BROKEN_AXE_DURABILITY = 0;

    private Dummy dummy;

    @Before
    public void setup() {
       dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testWeaponLosesDurabilityAfterEachAttack() {
        Axe axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        axe.attack(dummy);
        Assert.assertEquals(AXE_ATTACK - Axe.DURABILITY_LOSS, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAttackingWithABrokenWeapon() {
        Axe axe = new Axe(AXE_ATTACK, BROKEN_AXE_DURABILITY);
        axe.attack(dummy);
    }
}