package Tiles;

public abstract class MultiplierTile extends Tile {
    protected final int factor;

    protected MultiplierTile(TileType tileType, int factor) {
        super(tileType);
        this.factor = factor;
    }
}
