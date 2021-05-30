package readability;

/**
 * This class represents the Coleman-Liau index. It stores the name of the score and calculates the score for the passed Text
 * object.
 */
public class CL extends Score {

    /**
     * The average number of characters per 100 words.
     */
    private double L;

    /**
     * The average number of sentences per 100 words
     */
    private double S;

    /**
     * Constructor for Score CL.
     * @param text A Text object.
     */
    CL(Text text) {
        name = "Coleman-Liau index";
        calcVar(text);
        score = 0.0588 * L - 0.296 * S - 15.8;
    }

    /**
     * Calculates the average number of characters and sentences per 100 words.
     * @param text A Text object
     */
    private void calcVar(Text text) {
        double characters = text.characters;
        double words = text.words;
        double sentences = text.sentences;

        L = characters / words * 100.0;
        S = sentences / words * 100.0;
    }
}
