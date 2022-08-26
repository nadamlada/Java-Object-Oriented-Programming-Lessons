import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int DUMMY_HEALTH = 10;
    private static final int DEAD_DUMMY_HEALTH = 0;
    private static final int DUMMY_EXPERIENCE = 5;
    private static final int ATTACK_POINTS = 1;


    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void setup() {
        dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        deadDummy = new Dummy(DEAD_DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthIfAttacked() {
        dummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - ATTACK_POINTS, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void deadDummyThrowsAnExceptionIfAttacked() {
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test (expected = IllegalStateException.class)
    public void deadDummyCanGiveExperience() {
        dummy.giveExperience();
    }

    @Test
    public void aliveDummyCantGiveExperience() {
        int experience = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_EXPERIENCE, experience);
    }
}