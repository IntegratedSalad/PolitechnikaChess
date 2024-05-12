package Chess;

import Pieces.EmptyPiece;

public class Map {

    private static final int BOARD_SIZE_WIDTH = 8;
    private static final int BOARD_SIZE_HEIGHT = 8;

    private Piece[][] mapArray;

    private void Map() {
        mapArray = new Piece[BOARD_SIZE_WIDTH][BOARD_SIZE_HEIGHT];

        for (int y = 0; y < BOARD_SIZE_HEIGHT; y++) {
            for (int x = 0; x < BOARD_SIZE_WIDTH; x++) {
                Piece emptyPiece = new EmptyPiece(x, y);
                mapArray[y][x] = emptyPiece;
            }
        }
    }

    public Piece[][] getMapArray() {
        return mapArray;
    }

    public void printMap() {

    }
}
