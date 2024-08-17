import java.util.ArrayList;
import java.util.Arrays;

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

    public boolean move(int[] newSquare, Game game) { // this will move a piece to a new square (could be a capture)


        if (game.getBoard()[newSquare[0]][newSquare[1]] == null) {
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare);
            previousSquare = currentSquare;
            currentSquare = newSquare;

            return true;
        } else {
            // func to remove from piece list
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare);
            previousSquare = currentSquare;
            currentSquare = newSquare;

            return true;
            }
        }





    public void refresh(Game game){} // this method will refresh a piece to ensure all the squares are possible to move to.

    public void addAvailableSquare(int[] newSquare){ // adds a square the piece can move to.
        availableSquares.add(newSquare);
    }

    public boolean isDefended(Game game){
        if (colour.equals("White")){

            // simply loop through all pieces available squares and if the square of the piece is there then return true else false.

            for(Piece piece: game.getWhitePieces()){
                for(int[] move: piece.availableSquares){
                    if(Arrays.equals(move,currentSquare)){
                        return true;
                    }
                }
            } return false;

        } else{
            for(Piece piece: game.getBlackPieces()){
                for(int[] move: piece.availableSquares){
                    if(Arrays.equals(move, currentSquare)){
                        return true;
                    }
                }
            } return false;
        }
    }




}
