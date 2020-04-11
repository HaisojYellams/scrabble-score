package Boards;

import Tiles.EmptyTile;
import Tiles.Tile;

public abstract class ScrabbleBoard {
    protected final int width;
    protected final int height;
    protected final Tile[][] boardState;
    protected final int startRow;
    protected final int startColumn;
    protected boolean firstWord = true;

    protected ScrabbleBoard(int width, int height, int startRow, int startColumn){
        this.width = width;
        this.height = height;
        this.boardState = new Tile[height][width];
        this.startRow = startRow;
        this.startColumn = startColumn;

        fillBoardWithEmptyTiles();
    }

    private void fillBoardWithEmptyTiles(){
        for (int row = 0; row < height; row++){
            for (int column = 0; column < width; column++){
                boardState[row][column] = new EmptyTile();
            }
        }
    }
}
