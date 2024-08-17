import java.util.ArrayList;
import java.util.Arrays;

public class Bishop extends Piece{


    public Bishop(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }

    public void refresh(Game game){

        availableSquares.clear(); // clear the available squares

        int min;
        int max;
        if (currentSquare[0] <= currentSquare[1]){
            min = currentSquare[0];
            max = currentSquare[1];
        } else{
            min = currentSquare[1];
            max = currentSquare[0];
        }

        // need to go all 4 directions

        // upper left decrements both square indices

        if(colour.equals("White")){

            for(int i = 1; i<= min; i++){ // check upper left squares
                if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]-i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]-i});
                }
            }

            for(int i = 1; i<= 7-max; i++){ // check lower right squares
                if(game.hasWhitePiece(new int[]{currentSquare[0]+i, currentSquare[1]+i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]+i,currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]+i});
                }
            }

            if (currentSquare[0] <= 7-currentSquare[1]){
                min = currentSquare[0];
                max = 7-currentSquare[1];
            } else{
                min = 7-currentSquare[1];
                max = currentSquare[0];
            }
            // check upper right squares
            for(int i = 1; i<= min; i++){
                if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]+i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]+i});
                }
            }

            for(int i = 1; i<= 7-max; i++ ){ // check lower left squares
                if(game.hasWhitePiece(new int[]{currentSquare[0]+i,currentSquare[1]-i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]+i,currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]-i});
                }
            }

        } else if(colour.equals("Black")){

            for(int i = 1; i<= min; i++){ // check upper left squares
                if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]-i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]-i});
                }
            }

            for(int i = 1; i<= 7-max; i++){ // check lower right squares
                if(game.hasBlackPiece(new int[]{currentSquare[0]+i, currentSquare[1]+i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]+i,currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]+i});
                }
            }

            if (currentSquare[0] <= 7-currentSquare[1]){
                min = currentSquare[0];
                max = 7-currentSquare[1];
            } else{
                min = 7-currentSquare[1];
                max = currentSquare[0];
            }
            // check upper right squares
            for(int i = 1; i<= min; i++){
                if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]+i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]+i});
                }
            }

            for(int i = 1; i<= 7-max; i++ ){ // check lower left squares
                if(game.hasBlackPiece(new int[]{currentSquare[0]+i,currentSquare[1]-i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]+i,currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]-i});
                }
            }

        } else{
            System.out.println("Error: refresh ran on null square");
        }



    }
}
