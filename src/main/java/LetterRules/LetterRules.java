package LetterRules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class LetterRules {
    protected final Map<Character, Integer> letterScores = new HashMap<>();
    protected final LetterCounts letterCounts = new LetterCounts();

    protected LetterRules() {

    }

    /**
     * This constructor requires rules to be an integer array whose length is divisible by 3.
     * For each set of 3 consecutive integers, the values are [Character (as an integer)], [Score], and [Count]
     *
     * @param rules an array of rules where consecutive sets of three ints give [Letter], [Score], and [Count]
     */
    protected LetterRules(int[] rules) {
        if (rules.length == 0) {
            throw new IllegalArgumentException("The provided rules contain no letters - no valid game.");
        }

        if (rules.length % 3 != 0) {
            throw new IllegalArgumentException("The provided rules must have a length divisible by 3.");
        }

        int numLetters = rules.length / 3;
        for (int i = 0; i < numLetters; i += 3) {
            extractRulesFromTuple(rules[i], rules[i + 1], rules[i + 2]);
        }
    }

    private void extractRulesFromTuple(int letterAsInt, int letterScore, int letterCount) {
        char letter = (char) letterAsInt;
        if (letterScores.containsKey(letter)) {
            throw new IllegalArgumentException(
                    String.format(
                            "The rules for the letter have already been defined: %c (%d)",
                            letter,
                            letterAsInt
                    )
            );
        }

        letterCounts.initializeCount(letter, letterCount);
        letterScores.put(letter, letterScore);
    }

    private boolean doAllLettersExist(List<Character> letters){
        LetterCounts inputLetterCounts = LetterCounts.fromLetters(letters);
        return letterCounts.containsAll(inputLetterCounts);
    }

}
