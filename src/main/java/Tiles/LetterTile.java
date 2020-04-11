package Tiles;

public class LetterTile extends Tile {
    private final char letter;

    public LetterTile(char letter){
        super(TileType.LETTER);
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
}
