package readability;

/**
 * This class represents the Automated Readability Index. It stores the name of the score and calculates the score for the passed Text
 * object.
 */
public class ARI extends Score {

    /**
     * Constructor for Score ARI.
     * @param text A Text object.
     */
    ARI(Text text) {
        name = "Automated Readability Index";
        score = 4.71 * text.characters / text.words + 0.5 * text.words / text.sentences - 21.43;
    }
}
