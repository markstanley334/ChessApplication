import java.util.ArrayList;

public class Queen extends Piece{
    public Queen(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }

    public void refresh(Game game){
        availableSquares.clear();

        int min;
        int max;
        if (currentSquare[0] <= currentSquare[1]){
            min = currentSquare[0];
            max = currentSquare[1];
        } else{
            min = currentSquare[1];
            max = currentSquare[0];
        }

        // run the rook refresh and bishop refresh together

        if (colour.equals("White")) {

            for (int i = 1; i <= currentSquare[0]; i++) { // going up
                int[]movement = new int[]{currentSquare[0]-i,currentSquare[1]};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<=7-currentSquare[0];i++){ // going down
                int[]movement = new int[]{currentSquare[0]+i,currentSquare[1]};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<=7-currentSquare[1];i++){ // going right
                int[] movement = new int[]{currentSquare[0],currentSquare[1]+i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<= currentSquare[1]; i++){ // going left
                int[] movement = new int[]{currentSquare[0],currentSquare[1]-i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            // next run the bishop refresh

            for(int i = 1; i<= min; i++){ // check upper left squares
                int[] movement = new int[]{currentSquare[0]-i, currentSquare[1]-i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for(int i = 1; i<= 7-max; i++){ // check lower right squares
                int[] movement = new int[]{currentSquare[0]+i,currentSquare[1]+i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
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
                int[] movement = new int[]{currentSquare[0]-i,currentSquare[1]+i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for(int i = 1; i<= 7-max; i++ ){ // check lower left squares
                int[] movement = new int[]{currentSquare[0]+i,currentSquare[1]-i};
                if(game.hasWhitePiece(movement)){
                    break;
                } else if(game.hasBlackPiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

        } else if (colour.equals("Black")){

            for (int i = 1; i <= currentSquare[0]; i++) { // going up
                int[]movement = new int[]{currentSquare[0]-i,currentSquare[1]};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<=7-currentSquare[0];i++){ // going down
                int[]movement = new int[]{currentSquare[0]+i,currentSquare[1]};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<=7-currentSquare[1];i++){ // going right
                int[] movement = new int[]{currentSquare[0],currentSquare[1]+i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for (int i = 1; i<= currentSquare[1]; i++){ // going left
                int[] movement = new int[]{currentSquare[0],currentSquare[1]-i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }


            // next run the bishop refresh

            for(int i = 1; i<= min; i++){ // check upper left squares
                int[] movement = new int[]{currentSquare[0]-i, currentSquare[1]-i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for(int i = 1; i<= 7-max; i++){ // check lower right squares
                int[] movement = new int[]{currentSquare[0]+i,currentSquare[1]+i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
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
                int[] movement = new int[]{currentSquare[0]-i,currentSquare[1]+i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

            for(int i = 1; i<= 7-max; i++ ){ // check lower left squares
                int[] movement = new int[]{currentSquare[0]+i,currentSquare[1]-i};
                if(game.hasBlackPiece(movement)){
                    break;
                } else if(game.hasWhitePiece(movement)){
                    availableSquares.add(movement);
                    break;
                } else{
                    availableSquares.add(movement);
                }
            }

        } else{
            System.out.println("Error: refresh ran on null square");
        }
    }
}
