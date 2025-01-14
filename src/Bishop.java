import java.util.ArrayList;

public class Bishop extends Piece{


    public Bishop(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }

    public void refresh(Game game){
        availableSquares.clear(); // clear the available squares
        updateDiagonals(game);

    }
}
