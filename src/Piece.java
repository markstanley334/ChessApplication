import java.util.ArrayList;

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
        availableSquares = new ArrayList<>();

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


    public void updateDiagonals(Game game){

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

        } else if(colour.equals("Black")){

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


    public void updateRowsAndColumns(Game game) {
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




