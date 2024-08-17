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
                if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]});
                }
            }

            for (int i = 1; i<=7-currentSquare[0];i++){ // going down
                if(game.hasWhitePiece(new int[]{currentSquare[0]+i,currentSquare[1]})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0]+i,currentSquare[1]})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]});
                }
            }

            for (int i = 1; i<=7-currentSquare[1];i++){ // going right
                if(game.hasWhitePiece(new int[]{currentSquare[0],currentSquare[1]+i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0],currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]+i});
                }
            }

            for (int i = 1; i<= currentSquare[1]; i++){ // going left
                if(game.hasWhitePiece(new int[]{currentSquare[0],currentSquare[1]-i})){
                    break;
                } else if(game.hasBlackPiece(new int[]{currentSquare[0],currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]-i});
                }
            }

            } else if (colour.equals("Black")){

            for (int i = 1; i <= currentSquare[0]; i++) { // going up
                if(game.hasBlackPiece(new int[]{currentSquare[0]-i,currentSquare[1]})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]-i,currentSquare[1]})){
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]-i,currentSquare[1]});
                }
            }

            for (int i = 1; i<=7-currentSquare[0];i++){ // going down
                if(game.hasBlackPiece(new int[]{currentSquare[0]+i,currentSquare[1]})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0]+i,currentSquare[1]})){
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0]+i,currentSquare[1]});
                }
            }

            for (int i = 1; i<=7-currentSquare[1];i++){ // going right
                if(game.hasBlackPiece(new int[]{currentSquare[0],currentSquare[1]+i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0],currentSquare[1]+i})){
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]+i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]+i});
                }
            }

            for (int i = 1; i<= currentSquare[1]; i++){ // going left
                if(game.hasBlackPiece(new int[]{currentSquare[0],currentSquare[1]-i})){
                    break;
                } else if(game.hasWhitePiece(new int[]{currentSquare[0],currentSquare[1]-i})){
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]-i});
                    break;
                } else{
                    availableSquares.add(new int[]{currentSquare[0],currentSquare[1]-i});
                }
            }

        } else{
            System.out.println("Error: refresh ran on null square");
        }

    }
}
