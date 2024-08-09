import java.util.ArrayList;
import java.util.Objects;

public class Pawn extends Piece{

    


    public Pawn(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);

    }

    public void refresh(Game game){

        if(Objects.equals(colour, "White")){

            if (currentSquare[0] == 0){
                promote(currentSquare, game);
            } else{

            for(int i = currentSquare[0]; i>=0; i--) {

            }
            }
        } else {


            for (int i = currentSquare[0]) {

            }
        }



        availableSquares.clear();
        // first find if square ahead is blocked

    }

    public Piece promote(int[] square, Game game){
        game.addPromotionCount();
        Queen promotedQueen = new Queen("Q"+game.getPromotionCount(),"White", square, square,new ArrayList<int[]>());
        promotedQueen.refresh(game);

        return promotedQueen;
    }
}
