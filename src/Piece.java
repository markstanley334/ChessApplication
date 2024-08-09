import java.util.ArrayList;

public abstract class Piece {

    protected String name; // for display purposes
    protected String colour; // white or black

    protected ArrayList<int[]> availableSquares; // list of available squares

    protected int[] currentSquare; // current square

    protected int[] previousSquare; // previous square

    public Piece(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares){
        name = initName;
        colour = initColour;
        currentSquare = initCurrentSquare;
        previousSquare = initPreviousSquare;
        availableSquares = initAvailableSquares;
    }

    public Piece(){
        name = "";
        colour = "";
        currentSquare = new int[2];
        previousSquare = new int[2];
        availableSquares = new ArrayList<int[]>();

    }

    public void move(int[] newSquare){ // this will move a piece to a new square (could be a capture)
        previousSquare = currentSquare;
        currentSquare = newSquare;
    }

    public void refresh(Game game){} // this method will refresh a piece to ensure all the squares are possible to move to.

    public void addAvailableSquare(int[] newSquare){ // adds a square the piece can move to.
        availableSquares.add(newSquare);
    }


}
