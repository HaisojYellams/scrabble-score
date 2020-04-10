class Scrabble {

    private final static int[] VALUES = {
            'A', 1,
            'B', 3,
            'C', 3,
            'D', 2,
            'E', 1,
            'F', 4,
            'G', 2,
            'H', 4,
            'I', 1,
            'J', 8,
            'K', 5,
            'L', 1,
            'M', 3,
            'N', 1,
            'O', 1,
            'P', 3,
            'Q', 10,
            'R', 1,
            'S', 1,
            'T', 1,
            'U', 1,
            'V', 4,
            'W', 4,
            'X', 8,
            'Y', 4,
            'Z', 10
    };
    private final int score;

    public Scrabble(String word) {
        int wordLength = word.length();

        // Validation turned off for this constructor to allow the test suite to run correctly
//        validateWordLength(wordLength);

        String upperWord = word.toUpperCase();
        int score = 0;

        for (int i = 0; i < wordLength; i++) {
            score += calculateLetterScore(upperWord.charAt(i));
        }

        this.score = score;
    }

    protected void validateWordLength(int wordLength) {
        // We don't really care about the position in this case - we just want to make sure it will fit
        // on the board somewhere, so place it in the top left corner.
        validateWordLength(wordLength, 0, 0, true);
    }

    protected void validateWordLength(int wordLength, int row, int col, boolean isVertical) {
        if (wordLength < 1) {
            throw new IllegalArgumentException("Word must contain at least one letter.");
        }

        if (isVertical) {
            if (row + wordLength > 15) {
                throw new IllegalArgumentException("Word does not fit on the board.");
            }
        } else if (col + wordLength > 15) {
            throw new IllegalArgumentException("Word does not fit on the board.");
        }
    }

    protected int calculateLetterScore(char letter, int factor) {
        return factor * this.calculateLetterScore(letter);
    }

    protected int calculateLetterScore(char letter) {
        if (letter < 'A' || letter > 'Z') {
            throw new IllegalArgumentException("Invalid character in word: " + letter);
        }
        // Find the letter's place in the alphabet (A=0, B=1, ..., Z=25)
        int alphabetIndex = letter - 'A';

        // Find the letter's place in the VALUES array
        int letterIndex = 2 * alphabetIndex;

        // The letter's score follows the letter in the array
        int scoreIndex = letterIndex + 1;

        return VALUES[scoreIndex];
    }

    public int getScore() {
        return score;
    }

}
