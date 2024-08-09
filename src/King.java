import java.util.ArrayList;



public class King extends Piece{

    private boolean hasMoved;
    public King(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
        hasMoved = false;
    }

    public void move(int[] newSquare){
        hasMoved = true;
        previousSquare = currentSquare;
        currentSquare = newSquare;
    }

    public void refresh(){

    }
}
