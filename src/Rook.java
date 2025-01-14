import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }
    public void refresh(Game game) {
        availableSquares.clear();
        updateRowsAndColumns(game);

    }
}
