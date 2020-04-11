package Tiles;

public abstract class Tile {
    protected final TileType tileType;

    protected Tile(TileType tileType){
        this.tileType = tileType;
    }

    public TileType getTileType(){
        return tileType;
    }

    public int getLetterFactor(){
        return 1;
    }

    public int getWordFactor(){
        return 1;
    }
}
