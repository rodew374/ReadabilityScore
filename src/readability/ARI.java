package readability;

public class ARI extends Score {
    ARI(Text text) {
        score = 4.71 * text.characters / text.words + 0.5 * text.words / text.sentences - 21.43;
    }
}
