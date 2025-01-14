import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }

    public void refresh(Game game){
        availableSquares.clear();
        updateDiagonals(game);
        updateRowsAndColumns(game);
    }
}
