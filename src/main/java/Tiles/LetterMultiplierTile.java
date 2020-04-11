package Tiles;

public class LetterMultiplierTile extends MultiplierTile{

    public LetterMultiplierTile(int factor){
        super(TileType.LETTER_MULTIPLIER, factor);
    }

    @Override
    public int getLetterFactor() {
        return this.factor;
    }
}
