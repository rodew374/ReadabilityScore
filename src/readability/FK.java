package readability;

public class FK extends Score {
    FK(Text text) {
        score = 0.39 * text.words / text.sentences + 11.8 * text.syllables / text.words - 15.59;
    }
}
