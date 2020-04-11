package LetterRules;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCounts {
    private final Map<Character, Integer> counts = new HashMap<>();

    public static LetterCounts fromLetters(List<Character> letters) {
        LetterCounts toReturn = new LetterCounts();
        for (char letter :
                letters) {
            toReturn.initializeToZeroIfNotSet(letter);
            toReturn.incrementCount(letter);
        }

        return toReturn;
    }

    public void initializeToZeroIfNotSet(char letter) {
        if (!counts.containsKey(letter)) {
            initializeCount(letter);
        }
    }

    public void initializeCount(char letter) {
        initializeCount(letter, 0);
    }

    public void initializeCount(char letter, int count) {
        if (counts.containsKey(letter)) {
            throw new IllegalArgumentException("Letter count is already initialized: " + letter);
        }
        if (count < 0) {
            throw new IllegalArgumentException("Initial letter count must be non-negative.");
        }
        counts.put(letter, count);
    }

    public void removeCounts(LetterCounts other) {
        for (char letter :
                other.counts.keySet()) {
            this.decrementCount(letter, other.counts.get(letter));
        }
    }

    public void decrementCount(char letter, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        if (!counts.containsKey(letter)) {
            throw new IllegalArgumentException("Letter does not exist: " + letter);
        }

        int newCount = counts.get(letter) - amount;
        if (newCount < 0) {
            throw new IllegalArgumentException("Amount must not be greater than the current count.");
        }

        counts.put(letter, newCount);
    }

    public void incrementCount(char letter) {
        incrementCount(letter, 1);
    }

    public void incrementCount(char letter, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        if (!counts.containsKey(letter)) {
            throw new IllegalArgumentException("Letter does not exist: " + letter);
        }

        int newCount = counts.get(letter) + amount;
        counts.put(letter, newCount);
    }

    public boolean containsAll(LetterCounts other) {
        for (char c :
                other.counts.keySet()) {
            // The letter must be defined on the current object
            if (!this.counts.containsKey(c)) {
                return false;
            }

            // The amount in the current object must be no less than the amount on the other object
            if (this.counts.get(c) < other.counts.get(c)) {
                return false;
            }
        }

        return true;
    }
}
