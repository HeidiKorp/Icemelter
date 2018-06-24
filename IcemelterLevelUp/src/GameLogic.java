/**
 * Game logic.
 */
public class GameLogic {

    /**
     * Five.
     */
    private static final int FIVE = 5;

    /**
     * One.
     */
    private static final int ONE = 1;

    /**
     * Score of the game.
     */
    private int score;

    /**
     * Lives of the game.
     */
    private int lives;


    /**
     *
     * @param score Score of the game.
     * @param lives Lives to start with.
     */
    public GameLogic(int score, int lives) {
        this.score = score;
        if (score < 0) {
            this.score = 0;
        }
        this.lives = lives;
        if (lives < 0) {
            this.lives = 0;
        }
    }

    /**
     * Add five points to the score.
     */
    public void addScore() { this.score += FIVE; }

    /**
     * Get the game score.
     * @return game score.
     */
    public int getScore() { return score; }

    /**
     * Remove one life from total lives.
     */
    public void removeLife() {
        if (lives > 0) {
            this.lives -= ONE;
        }
    }

    /**
     * Get number of lives remaining.
     * @return Number of lives remaining.
     */
    public int getLives() { return lives; }

    /**
     * Set number of lives to a certain value.
     * @param life Lives to be set.
     */
    public void setLives(int life) {
        if (life >= 0) {
            this.lives = life;
        }
    }

    /**
     * Set score to a certain value.
     * @param sc score to be set.
     */
    public void setScore(int sc) {
        if (sc >= 0) {
            this.score = sc;
        }
    }
}
