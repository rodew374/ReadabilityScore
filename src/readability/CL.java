package readability;

import org.jetbrains.annotations.NotNull;

public class CL extends Score {
    private int L;
    private int S;

    CL(Text text) {
        name = "Coleman-Liau index";
        setL(text);
        setS(text);
        score = 0.0588 * L - 0.296 * S - 15.8;
    }

    private void setL(Text text) {
        String[] words = text.text.split("\\s");
        int[] count = new int[text.words / 100];
        int index = 0;
        int total = 0;

        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < 100; j++) {
                count[i] += words[index++].toCharArray().length;
            }
        }

        for (int n : count) {
            total += n;
        }

        L = total / count.length;

    }

    private void setS(@NotNull Text text) {
        String[] sentences = text.text.split("[.?!]");
        int[] counter = new int[text.words / 100];
        int index = 0;
        int total = 0;
        int divisor = counter.length;

        for (int i = 0; i < counter.length; i++) {
            int wordCount = 0;
            while (wordCount < 100 && index < sentences.length) {
                wordCount += sentences[index++].trim().split(" ").length;
                counter[i]++;
            }

            if (wordCount < 100) {
                counter[i] = 0;
            }
        }

        for (int n : counter) {
            if (n == 0) {
                divisor--;
            }

            total += n;
        }

        S = total / divisor;
    }
}
