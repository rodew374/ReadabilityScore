package readability;

/**
 * This class represents the Simple Measure of Gobbledygook. It stores the name of the score and calculates the score for the passed Text
 * object.
 */
public class SMOG extends Score {

    /**
     * Constructor for Score SMOG.
     * @param text A Text object.
     */
    SMOG(Text text) {
        name = "Simple Measure of Gobbledygook";
        score = 1.043 * Math.sqrt(text.polySyllables * 30.0 / text.sentences) + 3.1291;
    }
}
