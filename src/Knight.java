import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }

    public void refresh(Game game){

        availableSquares.clear();

        if(colour.equals("White")){

            // there are 8 squares to check, some might not be on the board, and some might have pieces from the moving colour

            // first check towards a8

            if (currentSquare[1] >= 2){
                if(currentSquare[0] >= 1) {
                    if (!game.hasWhitePiece(new int[]{currentSquare[0] - 1, currentSquare[1] - 2})) {
                        availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] - 2});
                    }
                }
            }

            if (currentSquare[0] >= 2){
                if(currentSquare[1] >= 1){
                    if (!game.hasWhitePiece(new int[]{currentSquare[0]-2, currentSquare[1]-1})){
                        availableSquares.add(new int[]{currentSquare[0]-2,currentSquare[1]-1});
                    }
                }
            }

            // next check towards h8

            if (currentSquare[1] <= 5){
                if(currentSquare[0] >= 1){
                    if (!game.hasWhitePiece(new int[]{currentSquare[0] - 1, currentSquare[1] + 2})){
                        availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] + 2});
                    }
                }
            }

            if (currentSquare[0] >= 2){
                if(currentSquare[1] <= 6){
                    if(!game.hasWhitePiece(new int[]{currentSquare[0]-2,currentSquare[1]+1})){
                        availableSquares.add(new int[]{currentSquare[0]-2,currentSquare[1]+1});
                    }
                }
            }

            // next do towards a1

            if (currentSquare[0]<=6){
                if (currentSquare[1] >= 2){
                    if(!game.hasWhitePiece(new int[]{currentSquare[0]+1,currentSquare[1]-2})){
                        availableSquares.add(new int[]{currentSquare[0]+1,currentSquare[1]-2});
                    }
                }
            }

            if (currentSquare[1] >= 1){
                if (currentSquare[0] <= 5){
                    if(!game.hasWhitePiece(new int[]{currentSquare[0]+2,currentSquare[1]-1})){
                        availableSquares.add(new int[]{currentSquare[0]+2,currentSquare[1]-1});
                    }
                }
            }

            // next do towards h1

            if (currentSquare[0] <= 6){
                if(currentSquare[1] <= 5){
                    if(!game.hasWhitePiece(new int[]{currentSquare[0]+1,currentSquare[1]+2})){
                        availableSquares.add(new int[]{currentSquare[0]+1,currentSquare[1]+2});
                    }
                }
            }

            if (currentSquare[1] <= 6){
                if (currentSquare[0] <= 5){
                    if(!game.hasWhitePiece(new int[]{currentSquare[0]+2,currentSquare[1]+1})){
                        availableSquares.add(new int[]{currentSquare[0]+2,currentSquare[1]+1});
                    }
                }
            }
        } else if (colour.equals("Black")){

            // first check towards a8

            if (currentSquare[1] >= 2){
                if(currentSquare[0] >= 1) {
                    if (!game.hasBlackPiece(new int[]{currentSquare[0] - 1, currentSquare[1] - 2})) {
                        availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] - 2});
                    }
                }
            }

            if (currentSquare[0] >= 2){
                if(currentSquare[1] >= 1){
                    if (!game.hasBlackPiece(new int[]{currentSquare[0]-2, currentSquare[1]-1})){
                        availableSquares.add(new int[]{currentSquare[0]-2,currentSquare[1]-1});
                    }
                }
            }

            // next check towards h8

            if (currentSquare[1] <= 5){
                if(currentSquare[0] >= 1){
                    if (!game.hasBlackPiece(new int[]{currentSquare[0] - 1, currentSquare[1] + 2})){
                        availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] + 2});
                    }
                }
            }

            if (currentSquare[0] >= 2){
                if(currentSquare[1] <= 6){
                    if(!game.hasBlackPiece(new int[]{currentSquare[0]-2,currentSquare[1]+1})){
                        availableSquares.add(new int[]{currentSquare[0]-2,currentSquare[1]+1});
                    }
                }
            }

            // next do towards a1

            if (currentSquare[0]<=6){
                if (currentSquare[1] >= 2){
                    if(!game.hasBlackPiece(new int[]{currentSquare[0]+1,currentSquare[1]-2})){
                        availableSquares.add(new int[]{currentSquare[0]+1,currentSquare[1]-2});
                    }
                }
            }

            if (currentSquare[1] >= 1){
                if (currentSquare[0] <= 5){
                    if(!game.hasBlackPiece(new int[]{currentSquare[0]+2,currentSquare[1]-1})){
                        availableSquares.add(new int[]{currentSquare[0]+2,currentSquare[1]-1});
                    }
                }
            }

            // next do towards h1

            if (currentSquare[0] <= 6){
                if(currentSquare[1] <= 5){
                    if(!game.hasBlackPiece(new int[]{currentSquare[0]+1,currentSquare[1]+2})){
                        availableSquares.add(new int[]{currentSquare[0]+1,currentSquare[1]+2});
                    }
                }
            }

            if (currentSquare[1] <= 6){
                if (currentSquare[0] <= 5){
                    if(!game.hasBlackPiece(new int[]{currentSquare[0]+2,currentSquare[1]+1})){
                        availableSquares.add(new int[]{currentSquare[0]+2,currentSquare[1]+1});
                    }
                }
            }
        } else{
            System.out.println("Error: refresh ran on null square");
        }


    }
}









