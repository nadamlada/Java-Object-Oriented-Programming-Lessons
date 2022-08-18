package football;

import org.junit.Assert;
import org.junit.Test;

public class FootballTeamTests {

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenNullShouldThrow() {
        FootballTeam footballTeam = new FootballTeam(null, 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenSpacesShouldThrow() {
        FootballTeam footballTeam = new FootballTeam("         ", 2);
    }

    @Test(expected = NullPointerException.class)
    public void testSetNameWhenEmptyShouldThrow() {
        FootballTeam footballTeam = new FootballTeam("", 2);
    }

    @Test
    public void testSetNameHappyPath() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Assert.assertEquals("zvezda", footballTeam.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetVacantPositionsWhenPositionsAreNegativeThrow() {
        FootballTeam footballTeam = new FootballTeam("zvezda", -2);
    }

    @Test
    public void testSetVacantPositionsHappyPAth() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Assert.assertEquals(2, footballTeam.getVacantPositions());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerWhenThereIsNoPositions() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 0);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);
    }

    @Test
    public void testAddFootballerHappyPath() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);
        Assert.assertEquals(1, footballTeam.getCount());
    }


    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerWhenFootballerIsNotInTeamThrow() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);

        footballTeam.removeFootballer("Zahari");
    }

    @Test
    public void testRemoveFootballerHappyPath() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);

        Assert.assertEquals(1, footballTeam.getCount());

        footballTeam.removeFootballer("Prokop");
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleWhenFootballerIsNotInTeamThrow() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);

        footballTeam.footballerForSale("Zahari");
    }

    @Test
    public void testFootballerForSaleHappyPath() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        footballTeam.addFootballer(footballer);

        Assert.assertEquals(1, footballTeam.getCount());

        Footballer footballer1 = footballTeam.footballerForSale("Prokop");
        Assert.assertFalse(footballer1.isActive());
    }

    @Test
    public void testGetStatisticsHappyPath() {
        FootballTeam footballTeam = new FootballTeam("zvezda", 2);
        Footballer footballer = new Footballer("Prokop");
        Footballer footballer2 = new Footballer("Zahari");

        footballTeam.addFootballer(footballer);
        footballTeam.addFootballer(footballer2);

        String statistics = footballTeam.getStatistics();
        Assert.assertEquals("The footballer Prokop, Zahari is in the team zvezda.", statistics);
    }
}
