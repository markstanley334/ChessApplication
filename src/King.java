import java.util.ArrayList;



public class King extends Piece{

    private boolean isInCheck;

    private boolean hasMoved;
    public King(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
        hasMoved = false;
    }

    public boolean move(int[] newSquare, Game game){
        hasMoved = true;
        previousSquare = currentSquare;
        currentSquare = newSquare;

        return false;
    }




    public void refresh(){
        availableSquares.clear();

        // check in queen directions to pin my own pieces (looking for bishop or queen on diagonal and rook or queen on straight files)


        if (colour.equals("White")){




        } else{ // if the colour is black


        }


    }
}
