package Tiles;

public class WordMultiplierTile extends MultiplierTile{

    public WordMultiplierTile(int factor){
        super(TileType.WORD_MULTIPLIER, factor);
    }

    public int getWordFactor(){
        return this.factor;
    }
}
