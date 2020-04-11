package LetterRules;

public class StandardLetterRules extends LetterRules {
    // The pattern is [LETTER], [SCORE], [COUNT]
    // The null character '\0' is used to indicate the blank letter tile found in the standard Scrabble game
    private static final int[] RULES = new int[]{
            'A', 1, 9,
            'B', 3, 2,
            'C', 3, 2,
            'D', 2, 4,
            'E', 1, 12,
            'F', 4, 2,
            'G', 2, 3,
            'H', 4, 2,
            'I', 1, 9,
            'J', 8, 1,
            'K', 5, 1,
            'L', 1, 4,
            'M', 3, 2,
            'N', 1, 6,
            'O', 1, 8,
            'P', 3, 2,
            'Q', 10, 1,
            'R', 1, 6,
            'S', 1, 4,
            'T', 1, 6,
            'U', 1, 4,
            'V', 4, 2,
            'W', 4, 2,
            'X', 8, 1,
            'Y', 4, 2,
            'Z', 10, 1,
            '\0', 0, 2
    };

    public StandardLetterRules(){
        super(RULES);
    }
}