import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Testing class.
 */
public class GameLogicTest {

    /**
     * Test if constructor gives correct score if it is positive.
     */
    @Test
    public void testGetScorePositive() {
        GameLogic logic = new GameLogic(3, 2);
        assertEquals(logic.getScore(), 3);
    }

    /**
     * Test if score is zero if given so.
     */
    @Test
    public void testGetScoreZero() {
        GameLogic logic = new GameLogic(0,2);
        assertEquals(logic.getScore(), 0);
    }

    /**
     * Test if score if negative score is changed into zero.
     */
    @Test
    public void testGetScoreNegative() {
        GameLogic logic = new GameLogic(-3, 2);
        assertEquals(logic.getScore(), 0);
    }

    /**
     * Test if adding to score is correct if it was 0 before.
     */
    @Test
    public void testAddScoreZero() {
        GameLogic logic = new GameLogic(0, 2);
        logic.addScore();
        assertEquals(logic.getScore(), 5);
    }

    /**
     * Test adding points to negative score.
     */
    @Test
    public void testAddScoreToNegative() {
        GameLogic logic = new GameLogic(-3, 2);
        logic.addScore();
        assertEquals(logic.getScore(), 5);
    }

    /**
     * Test adding points to a big score.
     */
    @Test
    public void testAddScoreBig() {
        GameLogic logic = new GameLogic(299, 2);
        logic.addScore();
        assertEquals(logic.getScore(), 304);
    }

    /**
     * Test setting negative lives.
     */
    @Test
    public void testGetLivesNegative() {
        GameLogic logic = new GameLogic(33, -4);
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test setting zero lives.
     */
    @Test
    public void testGetLivesZero() {
        GameLogic logic = new GameLogic(5, 0);
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test setting positive lives.
     */
    @Test
    public void testGetLivesPositive() {
        GameLogic logic = new GameLogic(5, 3);
        assertEquals(logic.getLives(), 3);
    }

    /**
     * Test removing one life from three lives.
     */
    @Test
    public void testRemoveLifeFromThree() {
        GameLogic logic = new GameLogic(5, 3);
        logic.removeLife();
        assertEquals(logic.getLives(), 2);
    }

    /**
     * Test removing one life from one life.
     */
    @Test
    public void testRemoveLifeFromOne() {
        GameLogic logic = new GameLogic(3, 1);
        logic.removeLife();
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test removing life from zero.
     */
    @Test
    public void testRemoveLifeFromZero() {
        GameLogic logic = new GameLogic(3, 0);
        logic.removeLife();
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test setting score to zero.
     */
    @Test
    public void testSetScoreZero() {
        GameLogic logic = new GameLogic(3, 2);
        logic.setScore(0);
        assertEquals(logic.getScore(), 0);
    }

    /**
     * Test setting score to positive value.
     */
    @Test
    public void testSetScorePositive() {
        GameLogic logic = new GameLogic(3, 2);
        logic.setScore(55);
        assertEquals(logic.getScore(), 55);
    }

    /**
     * Test setting score to negative value, expected 0.
     */
    @Test
    public void testSetScoreNegative() {
        GameLogic logic = new GameLogic(3, 4);
        logic.setScore(-3);
        assertEquals(logic.getScore(), 3);
    }

    /**
     * Test setting lives to zero.
     */
    @Test
    public void testSetLifeZero() {
        GameLogic logic = new GameLogic(3, 4);
        logic.setLives(0);
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test setting lives to positive value.
     */
    @Test
    public void testSetLivesPositive() {
        GameLogic logic = new GameLogic(3, 4);
        logic.setLives(4);
        assertEquals(logic.getLives(), 4);
    }

    /**
     * Test setting lives to negative value.
     */
    @Test
    public void testSetLivesNegative() {
        GameLogic logic = new GameLogic(3, 2);
        logic.setLives(-2);
        assertEquals(logic.getLives(), 2);
    }

    /**
     * Test setting negative lives to negative value, expected 0.
     */
    @Test
    public void testSetNegativeLivesNegativeLife() {
        GameLogic logic = new GameLogic(2, -3);
        logic.setLives(-2);
        assertEquals(logic.getLives(), 0);
    }

    /**
     * Test setting negative score to negative value, expected 0.
     */
    @Test
    public void testSetNegativeScoreNegativeScore() {
        GameLogic logic = new GameLogic(-3, 2);
        logic.setScore(-4);
        assertEquals(logic.getScore(), 0);
    }
}
