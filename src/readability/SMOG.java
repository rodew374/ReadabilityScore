package readability;

public class SMOG extends Score {
    SMOG(Text text) {
        score = 1.043 * Math.sqrt(text.polySyllables * 30.0 / text.sentences) + 3.1291;
    }
}
