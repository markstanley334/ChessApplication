import java.util.ArrayList;
import java.util.Arrays;

public abstract class Piece {

    protected String name; // for display purposes
    protected String colour; // white or black

    protected ArrayList<int[]> availableSquares; // list of available squares

    protected int[] currentSquare; // current square

    protected int[] previousSquare; // previous square

    protected ArrayList<int[]> blockingSquares;


    public Piece(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        name = initName;
        colour = initColour;
        currentSquare = initCurrentSquare;
        previousSquare = initPreviousSquare;
        availableSquares = initAvailableSquares;
        blockingSquares = new ArrayList<>();
    }

    public Piece() {
        name = "";
        colour = "";
        currentSquare = new int[2];
        previousSquare = new int[2];
        availableSquares = new ArrayList<int[]>();

    }

    public void move(int[] newSquare, Game game) { // this will move a piece to a new square (could be a capture)


        if (game.getBoard()[newSquare[0]][newSquare[1]] == null) {
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare);

        } else {

            game.removePiece(newSquare); // remove the captured piece from their respective piece list.
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare);

        }
    }


    public void refresh(Game game) {
    } // this method will refresh a piece to ensure all the squares are possible to move to.

    public void addAvailableSquare(int[] newSquare) { // adds a square the piece can move to.
        availableSquares.add(newSquare);
    }
}
