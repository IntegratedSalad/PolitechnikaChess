public class Map {

    private static final int BOARD_SIZE_WIDTH = 8;
    private static final int BOARD_SIZE_HEIGHT = 8;

    private Piece[][] mapArray;

    private void Map() {
        mapArray = new Piece[BOARD_SIZE_WIDTH][BOARD_SIZE_HEIGHT];

        for (int x = 0; x < BOARD_SIZE_WIDTH; x++) {
            for (int y = 0; y < BOARD_SIZE_HEIGHT; y++) {


            }
        }
    }

    public Piece[][] getMapArray() {
        return mapArray;
    }
}
