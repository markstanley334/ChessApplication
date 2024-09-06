import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
    }


    public void refresh(Game game) {

        availableSquares.clear();

        // need to go all four directions: up, down, left, right

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

        } else{
            System.out.println("Error: refresh ran on null square");
        }

    }
}
