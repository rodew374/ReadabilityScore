package readability;

/**
 * This class represents the Flesch–Kincaid readability tests. It stores the name of the score and calculates the score for the passed Text
 * object.
 */
public class FK extends Score {

    /**
     * Constructor for Score FK.
     * @param text A Text object.
     */
    FK(Text text) {
        name = "Flesch–Kincaid readability tests";
        score = 0.39 * text.words / text.sentences + 11.8 * text.syllables / text.words - 15.59;
    }
}
