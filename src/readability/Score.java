package readability;

/**
 * This is the parent class to all readability scores (ARI, FK, SMOG, CL).
 */
public abstract class Score {
    /**
     * The index's readability score. Each score's constructor calculates it differently.
     */
    protected double score;
    /**
     * The name of the score.
     */
    protected String name;

    /**
     * Calls the getAgeRange() and displays the Score's data to the user.
     */
    protected void display() {
        System.out.printf("\n%s: %.2f (about %d-year-olds).", name, score, getAge());
    }

    /**
     * Provides the appropriate Age for the calculated score.
     * @return int Age
     */
    protected int getAge() {
        switch ((int) Math.round(score)) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 24;
            case 14:
                return 25;
            default:
                return 0;
        }
    }
}
