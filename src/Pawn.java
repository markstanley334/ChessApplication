import java.util.ArrayList;

public class Pawn extends Piece {

    private ArrayList<int[]> captureDirections;


    public Pawn(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
        captureDirections = new ArrayList<>();

        if (colour.equals("White")) { // check if pawn on edges
            if (currentSquare[1] == 0) {
                captureDirections.add(new int[]{5, 1});
            } else if (currentSquare[1] == 7) {
                captureDirections.add(new int[]{5, 6});
            } else {
                captureDirections.add(new int[]{5, currentSquare[1] + 1});
                captureDirections.add(new int[]{5, currentSquare[1] - 1});
            }
        } else {
            if (currentSquare[1] == 0) {
                captureDirections.add(new int[]{2, 1});
            } else if (currentSquare[1] == 7) {
                captureDirections.add(new int[]{2, 6});
            } else {
                captureDirections.add(new int[]{2, currentSquare[1] + 1});
                captureDirections.add(new int[]{2, currentSquare[1] - 1});
            }
        }
    }

    public void refresh(Game game) {

        availableSquares.clear();

        if (colour.equals("White")) {

            if (currentSquare[0] == 6) { // this is for moving
                if (game.hasNoPiece(new int[]{4, currentSquare[1]})) {
                    availableSquares.add(new int[]{4, currentSquare[1]});
                }
            }
                if (game.hasNoPiece(new int[]{currentSquare[0] - 1, currentSquare[1]})) {
                    availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1]});
                }


            // next we do captures (also add to captureDirections ArrayList)

            if (currentSquare[1] == 0) {
                if (game.hasBlackPiece(new int[]{currentSquare[0] - 1, 1})) { // (towards h file)
                    availableSquares.add(new int[]{currentSquare[0] - 1, 1});
                }

            } else if (currentSquare[1] == 7) {
                if (game.hasBlackPiece(new int[]{currentSquare[0] - 1, 6})) { //  (towards a file)
                    availableSquares.add(new int[]{currentSquare[0] - 1, 6});
                }

            } else { // check for both diagonal captures

                if (game.hasBlackPiece(new int[]{currentSquare[0] - 1, currentSquare[1] - 1})) { // (towards a file)
                    availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] - 1});
                }

                if (game.hasBlackPiece(new int[]{currentSquare[0] - 1, currentSquare[1] + 1})) { // (towards h file)
                    availableSquares.add(new int[]{currentSquare[0] - 1, currentSquare[1] + 1});
                }

            }

            // let's not forget about the en passant rule (passing by rule)

            if (currentSquare[0] == 3) {
                if (currentSquare[1] == 0) {

                    if (game.blackPawnJustMovedTwo(new int[]{3, 1})) { // check towards h file
                        availableSquares.add(new int[]{2, 1});
                    }

                } else if (currentSquare[1] == 7) {

                    if (game.blackPawnJustMovedTwo(new int[]{3, 6})) { // check towards a file
                        availableSquares.add(new int[]{2, 6});
                    }

                } else {
                    // check both directions
                    if (game.blackPawnJustMovedTwo(new int[]{3, currentSquare[1] + 1})) { // check towards h file
                        availableSquares.add(new int[]{2, currentSquare[1] + 1});
                    }

                    if (game.blackPawnJustMovedTwo(new int[]{3, currentSquare[1] - 1})) { // check towards a file
                        availableSquares.add(new int[]{2, currentSquare[1] - 1});
                    }

                }
            }
            // now repeat but for black pawns
        } else if (colour.equals("Black")) {


            if (currentSquare[0] == 1) { // this is for moving
                if (game.hasNoPiece(new int[]{3, currentSquare[1]})) {
                    availableSquares.add(new int[]{3, currentSquare[1]});
                }
            }

            if (game.hasNoPiece(new int[]{currentSquare[0] + 1, currentSquare[1]})) {
                availableSquares.add(new int[]{currentSquare[0] + 1, currentSquare[1]});
            }

            // next we do captures

            if (currentSquare[1] == 0) {
                if (game.hasWhitePiece(new int[]{currentSquare[0] + 1, 1})) { // (towards h file)
                    availableSquares.add(new int[]{currentSquare[0] + 1, 1});
                }

            } else if (currentSquare[1] == 7) {
                if (game.hasWhitePiece(new int[]{currentSquare[0] + 1, 6})) { //  (towards a file)
                    availableSquares.add(new int[]{currentSquare[0] + 1, 6});
                }

            } else { // check for both diagonal captures

                if (game.hasWhitePiece(new int[]{currentSquare[0] + 1, currentSquare[1] - 1})) { // (towards a file)
                    availableSquares.add(new int[]{currentSquare[0] + 1, currentSquare[1] - 1});
                }

                if (game.hasWhitePiece(new int[]{currentSquare[0] + 1, currentSquare[1] + 1})) { // (towards h file)
                    availableSquares.add(new int[]{currentSquare[0] + 1, currentSquare[1] + 1});
                }

            }

            // let's not forget about the en passant rule (passing by rule)

            if (currentSquare[0] == 4) {
                if (currentSquare[1] == 0) {

                    if (game.whitePawnJustMovedTwo(new int[]{4, 1})) { // check towards h file
                        availableSquares.add(new int[]{5, 1});
                    }

                } else if (currentSquare[1] == 7) {

                    if (game.whitePawnJustMovedTwo(new int[]{4, 6})) { // check towards a file
                        availableSquares.add(new int[]{5, 6});
                    }

                } else {
                    // check both directions
                    if (game.whitePawnJustMovedTwo(new int[]{4, currentSquare[1] + 1})) { // check towards h file
                        availableSquares.add(new int[]{5, currentSquare[1] + 1});
                    }

                    if (game.whitePawnJustMovedTwo(new int[]{4, currentSquare[1] - 1})) { // check towards a file
                        availableSquares.add(new int[]{5, currentSquare[1] - 1});
                    }

                }
            }

        } else {
            System.out.println("Error: refresh ran on null square");
        }
    }


    // MAKE MOVE() FUNCTION WITH PROMOTION and with en passant

    // for en passant, you want to simply check if the move made was diagonal and there was no piece on the square.

    public Piece promote(int[] square, Game game, int pieceType) {
        // for simplicity, if pieceType is 0, that means queen, 1 is rook, 2 is bishop, 3 is knight

        if (pieceType == 0) {
            game.addPromotionCount();
            Queen promotedQueen = new Queen("Q" + game.getPromotionCount(), colour, square, square, new ArrayList<int[]>());
            game.setSquare(promotedQueen, square); // add piece to the board
            promotedQueen.refresh(game);
            if(colour.equals("White")){
                game.addWhitePiece(promotedQueen);
            } else{
                game.addBlackPiece(promotedQueen);
            }
            return promotedQueen;
        } else if(pieceType == 1){
            game.addPromotionCount();
            Rook promotedRook = new Rook("R" + game.getPromotionCount(), colour, square, square, new ArrayList<int[]>());
            game.setSquare(promotedRook, square);
            promotedRook.refresh(game);
            if(colour.equals("White")){
                game.addWhitePiece(promotedRook);
            } else{
                game.addBlackPiece(promotedRook);
            }
            return promotedRook;
        } else if (pieceType == 2){
            game.addPromotionCount();
            Bishop promotedBishop = new Bishop("B" + game.getPromotionCount(), colour, square, square, new ArrayList<int[]>());
            game.setSquare(promotedBishop,square);
            if(colour.equals("White")){
                game.addWhitePiece(promotedBishop);
            } else{
                game.addBlackPiece(promotedBishop);
            }
            return promotedBishop;
        } else if (pieceType == 3){
            game.addPromotionCount();
            Knight promotedKnight = new Knight("N" + game.getPromotionCount(), colour, square, square, new ArrayList<int[]>());
            game.setSquare(promotedKnight, square);
            if(colour.equals("White")){
                game.addWhitePiece(promotedKnight);
            } else{
                game.addBlackPiece(promotedKnight);
            }
            return promotedKnight;
        }
        return null;
    }


    public ArrayList<int[]> getCaptureDirections(){
        return captureDirections;
    }


    public void move(int[] newSquare, Game game) {
        if (game.getBoard()[newSquare[0]][newSquare[1]] == null) {
            if(newSquare[0] == 0 || newSquare[0] == 7){
                promote(newSquare,game,0); // this is queen by default
                game.getSquare(newSquare).refresh(game);
                game.removePiece(currentSquare);}
            else{

                if(currentSquare[1] != newSquare[1]) { // en passant occurance
                    if(currentSquare[0] == 3){
                        // white piece capturing black piece
                        game.removePiece(new int[]{3,newSquare[1]});
                        game.setSquare(null,new int[]{3,newSquare[1]});
                    } else{
                        // black piece capturing white piece
                        // currentSquare[0] == 4
                        game.removePiece(new int[]{4,newSquare[1]});
                        game.setSquare(null,new int[]{4,newSquare[1]});
                    }
                }

                previousSquare = currentSquare;
                currentSquare = newSquare;
                game.setSquare(null, previousSquare);
                game.setSquare(this, newSquare);
            }
        } else {
            game.removePiece(newSquare); // remove the captured piece from their respective piece list.

            if(newSquare[0] == 0 || newSquare[0] == 7){
                promote(newSquare,game,0); // this is queen by default
                game.getSquare(newSquare).refresh(game);
                game.removePiece(currentSquare); // remove this piece
            } else{
                // no promotion but capture
                previousSquare = currentSquare;
                currentSquare = newSquare;
                game.setSquare(null, previousSquare);
                game.setSquare(this, newSquare);

            }
        }
    }
}
