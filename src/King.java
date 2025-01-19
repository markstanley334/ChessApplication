import java.util.ArrayList;
import java.util.Arrays;


public class King extends Piece {

    private boolean isInCheck;

    private int checkingPieces;

    private int[] checkingPieceSquare;

    public King(String initName, String initColour, int[] initCurrentSquare, int[] initPreviousSquare, ArrayList<int[]> initAvailableSquares) {
        super(initName, initColour, initCurrentSquare, initPreviousSquare, initAvailableSquares);
        checkingPieces = 0;
        checkingPieceSquare = new int[2];
    }

    // only change to move function is to move the rook when castling

    public void move(int[] newSquare, Game game) { // this will move a piece to a new square (could be a capture)
        if (Arrays.equals(newSquare, new int[]{7, 2}) && Arrays.equals(currentSquare, new int[]{7, 4})) {
            // then we are white castling queenside
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare); // king has moved 2
        } else if (Arrays.equals(newSquare, new int[]{7, 6}) && Arrays.equals(currentSquare, new int[]{7, 4})) {
            // then we are white castling kingside
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare); // king has moved 2
        } else if (Arrays.equals(newSquare, new int[]{0, 2}) && Arrays.equals(currentSquare, new int[]{0, 4})) {
            // then we are white castling queenside
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare); // king has moved 2
        } else if (Arrays.equals(newSquare, new int[]{0, 6}) && Arrays.equals(currentSquare, new int[]{0, 4})) {
            // then we are white castling kingside
            previousSquare = currentSquare;
            currentSquare = newSquare;
            game.setSquare(null, previousSquare);
            game.setSquare(this, newSquare); // king has moved 2
        } else {

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
    }

    public void refresh(Game game) {

        availableSquares.clear();
        checkingPieces = 0;
        isInCheck = false;

        // check in queen directions to pin own pieces (looking for bishop or queen on diagonal and rook or queen on straight files)
        // also use this to see if king is in check


        if (colour.equals("White")) {

            /*

            for (Piece piece : game.getWhitePieces()) {
                piece.blockingSquares.clear();
            }

            int min;
            int max;
            if (currentSquare[0] <= currentSquare[1]) {
                min = currentSquare[0];
                max = currentSquare[1];
            } else {
                min = currentSquare[1];
                max = currentSquare[0];
            }

            int whitePieceCount = 0;
            int[] whitePieceSquare = new int[2];


            for (int i = 1; i <= min; i++) { // check upper left squares
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1] - i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) { // if we find a white piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone();
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break; // in any case of a black piece, we stop the loop
                }
            }

            whitePieceCount = 0;
            for (int i = 1; i <= 7 - max; i++) { // check lower right squares
                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1] + i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) { // if we find a white piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone();
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }

            if (currentSquare[0] <= 7 - currentSquare[1]) {
                min = currentSquare[0];
                max = 7 - currentSquare[1];
            } else {
                min = 7 - currentSquare[1];
                max = currentSquare[0];
            }
            // check upper right squares
            whitePieceCount = 0;
            for (int i = 1; i <= min; i++) {
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1] + i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) { // if we find a white piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone();
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare)) instanceof Queen) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }

            whitePieceCount = 0;
            for (int i = 1; i <= 7 - max; i++) { // check lower left square
                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1] - i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) { // if we find a white piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone();
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }


            // now we must check rook directions for a queen or rook in a similar manner
            whitePieceCount = 0;
            for (int i = 1; i <= currentSquare[0]; i++) { // going up
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1]};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) {
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= 7 - currentSquare[0]; i++) { // going down

                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1]};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) {
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= 7 - currentSquare[1]; i++) { // going right
                int[] viewingSquare = new int[]{currentSquare[0], currentSquare[1] + i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) {
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= currentSquare[1]; i++) { // going left
                int[] viewingSquare = new int[]{currentSquare[0], currentSquare[1] - i};
                if (game.hasWhitePiece(viewingSquare)) {
                    if (whitePieceCount == 1) {
                        break;
                    }
                    whitePieceCount++;
                    whitePieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasBlackPiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (whitePieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(whitePieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            // next opponents knights to see if in check

            for (Piece piece : game.getBlackPieces()) {
                if (piece instanceof Knight) {
                    for (int[] move : piece.availableSquares) {
                        if (Arrays.equals(move, currentSquare)) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = piece.currentSquare.clone();
                        }
                    }
                }
            }

            */


            // now we look to update our availablemoves arraylist.
            if (currentSquare[0] == 0) {
                if (currentSquare[1] == 0) {
                    // top left corner

                    int[] square = new int[]{1, 0};
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 1;
                    square[1] = 1;
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 0;
                    square[1] = 1;
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                } else if (currentSquare[1] == 7) {
                    // top right corner
                    int[] square = new int[]{0, 6};
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 1;
                    square[1] = 7;
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = 6;
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                } else {
                    // top middle
                    int[] square = new int[]{0, currentSquare[1] + 1};
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = currentSquare[1] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 1;
                    square[1] = currentSquare[1] + 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1];
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                }
            } else if (currentSquare[0] == 7) {
                if (currentSquare[1] == 0) {
                    // bottom left
                    int[] square = new int[]{7, 1};
                    if (!game.hasWhitePiece(square)) { // if no white piece
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 6;
                    square[1] = 0;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else if (currentSquare[1] == 7) {
                    // bottom right
                    int[] square = new int[]{7, 6};
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 6;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 7;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else {


                    int c = 0;
                    System.out.println("Should be here");
                    // bottom middle
                    int[] square = new int[]{7, currentSquare[1] + 1};
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    for(int[] spot: availableSquares){
                        System.out.println(Arrays.toString(spot) + Integer.toString(c));
                    }
                    c++;


                    square[1] = currentSquare[1] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    

                    square[0] = 6;
                    square[1] = currentSquare[1] + 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                   

                    square[1] = currentSquare[1];
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    

                    square[1] = currentSquare[1] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    for(int[] spot: availableSquares){
                        System.out.println(Arrays.toString(spot) + Integer.toString(c));
                    }
                    c++;
                }
            } else {
                if (currentSquare[1] == 0) {
                    // middle left
                    int[] square = new int[]{currentSquare[0] - 1, 0};
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] + 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0];
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else if (currentSquare[1] == 7) {
                    // middle right
                    int[] square = new int[]{currentSquare[0] - 1, 7};
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] + 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 6;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0];
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else {
                    // all middle squares

                    for(int[] spot: availableSquares){
                        System.out.println(Arrays.toString(spot));
                    }

                    int[] square = new int[]{currentSquare[0] + 1, currentSquare[1]}; // below
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1; // above
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1] + 1; // above right
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0]; // right
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0] + 1; // below right
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }


                    square[1] = currentSquare[1] - 1; // below left
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0]; // left middle
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0] - 1;
                    if (!game.hasWhitePiece(square)) {
                        if (!game.isDefendedByBlack(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                }
            }


            /*
                // we also need to see which pieces can block
                if (isInCheck) {
                    if (checkingPieces == 2) {
                        // this is a double check, so the king MUST move
                        for (Piece piece : game.getWhitePieces()) {
                            if (!(piece instanceof King)) {
                                piece.availableSquares.clear();
                            }
                        }
                    } else { // here there is only one piece checking
                        if (!(game.getSquare(checkingPieceSquare) instanceof Knight)) {
                            // if it's not a knight, pieces might be able to block.
                            // now we need to determine if we have to parse the squares
                            // up, down, left, right, up left, up right, down left, down right.

                            if (currentSquare[0] == checkingPieceSquare[0]) {
                                // checking rook directions on same rank (left and right)
                                if (currentSquare[1] < checkingPieceSquare[1]) {
                                    // we need to look right
                                    int cS = currentSquare[1] + 1;

                                    while (cS < checkingPieceSquare[1]) {
                                        int[] loopSquare = new int[]{currentSquare[0], cS};
                                        for (Piece piece : game.getWhitePieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS++;
                                    }

                                } else {
                                    // we need to look left
                                    int cS = currentSquare[1] - 1;

                                    while (cS > checkingPieceSquare[1]) {
                                        int[] loopSquare = new int[]{currentSquare[0], cS};
                                        for (Piece piece : game.getWhitePieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS--;
                                    }
                                }
                            } else if (currentSquare[1] == checkingPieceSquare[1]) {
                                // checking rook directions on same file (up and down)
                                if (currentSquare[0] < checkingPieceSquare[0]) {

                                    // we need to look down
                                    int cS = currentSquare[0] + 1;

                                    while (cS < checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, currentSquare[1]};
                                        for (Piece piece : game.getWhitePieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                            cS++;
                                        }
                                    }
                                } else {
                                    // we need to look up
                                    int cS = currentSquare[0] - 1;

                                    while (cS > checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, currentSquare[1]};
                                        for (Piece piece : game.getWhitePieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS--;
                                    }
                                }

                            } else {
                                // in this case, we know we are checking the squares in bishop direction

                                if (checkingPieceSquare[0] < currentSquare[0]) {
                                    // piece is above
                                    if (checkingPieceSquare[1] < currentSquare[1]) {
                                        // check above left
                                        // we can use either the rank or file as we stop the loop when we reach the bishop.
                                        int cS = currentSquare[0] - 1;
                                        int cS2 = currentSquare[1] - 1;

                                        while (cS > checkingPieceSquare[0]) {
                                            int[] loopSquare = new int[]{cS, cS2};
                                            for (Piece piece : game.getWhitePieces()) {
                                                if (!(piece instanceof King)) {
                                                    if (piece.availableSquares.contains(loopSquare)) {
                                                        piece.blockingSquares.add(loopSquare);
                                                    }
                                                }
                                            }
                                            cS--;
                                            cS2--;

                                        }
                                    } else {
                                        // check above right
                                        int cS = currentSquare[0] - 1;
                                        int cS2 = currentSquare[1] + 1;

                                        while (cS > checkingPieceSquare[0]) {
                                            int[] loopSquare = new int[]{cS, cS2};
                                            for (Piece piece : game.getWhitePieces()) {
                                                if (!(piece instanceof King)) {
                                                    if (piece.availableSquares.contains(loopSquare)) {
                                                        piece.blockingSquares.add(loopSquare);
                                                    }
                                                }
                                            }
                                            cS--;
                                            cS2++;

                                        }
                                    }
                                } else {
                                    if (checkingPieceSquare[1] < currentSquare[1]) {
                                        // check below left
                                        int cS = currentSquare[0] + 1;
                                        int cS2 = currentSquare[1] - 1;

                                        while (cS > checkingPieceSquare[0]) {
                                            int[] loopSquare = new int[]{cS, cS2};
                                            for (Piece piece : game.getWhitePieces()) {
                                                if (!(piece instanceof King)) {
                                                    if (piece.availableSquares.contains(loopSquare)) {
                                                        piece.blockingSquares.add(loopSquare);
                                                    }
                                                }
                                            }
                                            cS++;
                                            cS2--;

                                        }
                                    } else {
                                        // check below right
                                        int cS = currentSquare[0] + 1;
                                        int cS2 = currentSquare[1] + 1;

                                        while (cS > checkingPieceSquare[0]) {
                                            int[] loopSquare = new int[]{cS, cS2};
                                            for (Piece piece : game.getWhitePieces()) {
                                                if (!(piece instanceof King)) {
                                                    if (piece.availableSquares.contains(loopSquare)) {
                                                        piece.blockingSquares.add(loopSquare);
                                                    }
                                                }
                                            }
                                            cS++;
                                            cS2++;

                                        }
                                    }
                                }
                            }
                        }

                        // see if checking piece can be captured and add blocking squares

                        for (Piece piece : game.getWhitePieces()) {
                            if (!(piece instanceof King)) {
                                if (piece instanceof Pawn) {
                                    // have to check diagonals

                                    for (int[] square : ((Pawn) piece).getCaptureDirections()) {
                                        if (Arrays.equals(square, checkingPieceSquare)) {
                                            int[] attackSquare = square.clone();
                                            piece.availableSquares.clear();
                                            piece.availableSquares.add(attackSquare);
                                            piece.availableSquares.addAll(piece.blockingSquares);
                                            break;
                                        }
                                    }
                                } else {
                                    for (int[] square : piece.availableSquares) {
                                        if (Arrays.equals(square, checkingPieceSquare)) {
                                            int[] attackSquare = square.clone();
                                            piece.availableSquares.clear();
                                            piece.availableSquares.add(attackSquare);
                                            piece.availableSquares.addAll(piece.blockingSquares);
                                            break;
                                        }
                                    }
                                }
                            }


                        }
                    }

                } else{

                    */
            // aren't in check maybe we can castle.
            // now all available squares for the king are added to his list EXCEPT castling. Let's do this now:

            int[] a1 = new int[]{7, 0};
            int[] h1 = new int[]{7, 7};
            int[] e1 = new int[]{7, 4};
            boolean piecesMovedLeft = false;
            boolean piecesMovedRight = false;

            for (Piece[][] board : game.getBoardCopies()) {

                // for each board

                if (game.getSquare(e1, board) == null) {
                    piecesMovedRight = true;
                    piecesMovedLeft = true;
                    break;
                }

                if (game.getSquare(a1, board) == null) { // a1 is empty => can't castle
                    piecesMovedLeft = true;
                } else if (game.getSquare(a1, board).colour.equals("Black")) {
                    piecesMovedLeft = true; // if black piece or not rook
                }

                if (game.getSquare(h1, board) == null) {
                    piecesMovedRight = true;
                } else if (game.getSquare(h1, board).colour.equals("Black")) {
                    piecesMovedRight = true;
                }
            }

            if (!piecesMovedLeft) {
                // check for queenside castle
                int[] d1 = new int[]{7, 3};
                int[] c1 = new int[]{7, 2};
                int[] b1 = new int[]{7, 1};

                if (!(game.isDefendedByBlack(c1)) && !(game.isDefendedByBlack(d1))) { // if both castling squares free
                    if (game.getSquare(c1) == null && game.getSquare(d1) == null && game.getSquare(b1) == null) {
                        availableSquares.add(new int[]{7, 2});
                    }
                }
            }

            if (!piecesMovedRight) {
                // now check for kingside castle
                int[] f1 = new int[]{7, 5};
                int[] g1 = new int[]{7, 6};

                if (!(game.isDefendedByBlack(f1)) && !(game.isDefendedByBlack(g1))) {
                    if (game.getSquare(f1) == null && game.getSquare(g1) == null) {
                        availableSquares.add(new int[]{7, 6});
                    }
                }
            }

            // ********************************************

        } else { // if the colour is black

            /*
            for(Piece piece: game.getBlackPieces()){ // clear the blocking squares
                piece.blockingSquares.clear();
            }

            int min;
            int max;
            if (currentSquare[0] <= currentSquare[1]) {
                min = currentSquare[0];
                max = currentSquare[1];
            } else {
                min = currentSquare[1];
                max = currentSquare[0];
            }

            int blackPieceCount = 0;
            int[] blackPieceSquare = new int[2];


            for (int i = 1; i <= min; i++) { // check upper left squares
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1] - i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) { // if we find a black piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone();
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break; // in any case of a black piece, we stop the loop
                }
            }

            blackPieceCount = 0;
            for (int i = 1; i <= 7 - max; i++) { // check lower right squares
                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1] + i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) { // if we find a black piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone();
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }

            if (currentSquare[0] <= 7 - currentSquare[1]) {
                min = currentSquare[0];
                max = 7 - currentSquare[1];
            } else {
                min = 7 - currentSquare[1];
                max = currentSquare[0];
            }
            // check upper right squares
            blackPieceCount = 0;
            for (int i = 1; i <= min; i++) {
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1] + i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) {
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone();
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare)) instanceof Queen) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }

            blackPieceCount = 0;
            for (int i = 1; i <= 7 - max; i++) { // check lower left square
                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1] - i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) { // if we find a white piece but there already is one, then there are no pins and no checks on that diagonal
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone();
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if ((game.getSquare(viewingSquare) instanceof Bishop) || (game.getSquare(viewingSquare) instanceof Queen)) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }// pinned piece can't move
                    }
                    break;
                }
            }


            // now we must check rook directions for a queen or rook in a similar manner
            blackPieceCount = 0;
            for (int i = 1; i <= currentSquare[0]; i++) { // going up
                int[] viewingSquare = new int[]{currentSquare[0] - i, currentSquare[1]};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) {
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= 7 - currentSquare[0]; i++) { // going down

                int[] viewingSquare = new int[]{currentSquare[0] + i, currentSquare[1]};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) {
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= 7 - currentSquare[1]; i++) { // going right
                int[] viewingSquare = new int[]{currentSquare[0], currentSquare[1] + i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) {
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            for (int i = 1; i <= currentSquare[1]; i++) { // going left
                int[] viewingSquare = new int[]{currentSquare[0], currentSquare[1] - i};
                if (game.hasBlackPiece(viewingSquare)) {
                    if (blackPieceCount == 1) {
                        break;
                    }
                    blackPieceCount++;
                    blackPieceSquare = viewingSquare.clone(); // keep this piece in mind
                } else if (game.hasWhitePiece(viewingSquare)) {
                    if (game.getSquare(viewingSquare) instanceof Rook || game.getSquare(viewingSquare) instanceof Queen) {
                        if (blackPieceCount == 0) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = viewingSquare.clone();
                        } else {
                            game.getSquare(blackPieceSquare).availableSquares.clear();
                        }
                    }
                    break;
                }
            }

            // next opponents knights to see if in check

            for (Piece piece : game.getWhitePieces()) {
                if (piece instanceof Knight) {
                    for (int[] move : piece.availableSquares) {
                        if (Arrays.equals(move, currentSquare)) {
                            isInCheck = true;
                            checkingPieces++;
                            checkingPieceSquare = piece.currentSquare.clone();
                        }
                    }
                }
            }

            */

            // now we look to update our availablemoves arraylist.
            if (currentSquare[0] == 0) {
                if (currentSquare[1] == 0) {
                    // top left corner

                    int[] square = new int[]{1, 0};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 1;
                    square[1] = 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 0;
                    square[1] = 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                } else if (currentSquare[1] == 7) {
                    // top right corner
                    int[] square = new int[]{0, 6};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 1;
                    square[1] = 7;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = 6;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                } else {
                    // top middle
                    int[] square = new int[]{0, currentSquare[1] + 1};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = currentSquare[1] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 1;
                    square[1] = currentSquare[1] + 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1];
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                }
            } else if (currentSquare[0] == 7) {
                if (currentSquare[1] == 0) {
                    // bottom left
                    int[] square = new int[]{7, 1};
                    if (!game.hasBlackPiece(square)) { // if no white piece
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 6;
                    square[1] = 0;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else if (currentSquare[1] == 7) {
                    // bottom right
                    int[] square = new int[]{7, 6};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = 6;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 7;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else {
                    // bottom middle
                    int[] square = new int[]{7, currentSquare[1] + 1};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[1] = currentSquare[1] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = 6;
                    square[1] = currentSquare[1] + 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1];
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                }
            } else {
                if (currentSquare[1] == 0) {
                    // middle left
                    int[] square = new int[]{currentSquare[0] - 1, 0};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] + 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0];
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else if (currentSquare[1] == 7) {
                    // middle right
                    int[] square = new int[]{currentSquare[0] - 1, 7};
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] + 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = 6;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0];
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                } else {
                    // all middle squares

                    int[] square = new int[]{currentSquare[0] + 1, currentSquare[1]}; // below
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0] - 1; // above
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[1] = currentSquare[1] + 1; // above right
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }
                    square[0] = currentSquare[0]; // right
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0] + 1; // below right
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }


                    square[1] = currentSquare[1] - 1; // below left
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0]; // left middle
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                    square[0] = currentSquare[0] - 1;
                    if (!game.hasBlackPiece(square)) {
                        if (!game.isDefendedByWhite(square)) {
                            availableSquares.add(square.clone());
                        }
                    }

                }
            }

            /*
            // we also need to see which pieces can block
            if (isInCheck) {
                if (checkingPieces == 2) {
                    // this is a double check, so the king MUST move
                    for (Piece piece : game.getBlackPieces()) {
                        if (!(piece instanceof King)) {
                            piece.availableSquares.clear();
                        }
                    }
                } else { // here there is only one piece checking
                    if (!(game.getSquare(checkingPieceSquare) instanceof Knight)) {
                        // if it's not a knight, pieces might be able to block.
                        // now we have to parse the squares
                        // up, down, left, right, up left, up right, down left, down right.

                        if (currentSquare[0] == checkingPieceSquare[0]) {
                            // checking rook directions on same rank (left and right)
                            if (currentSquare[1] < checkingPieceSquare[1]) {
                                // we need to look right
                                int cS = currentSquare[1] + 1;

                                while (cS < checkingPieceSquare[1]) {
                                    int[] loopSquare = new int[]{currentSquare[0], cS};
                                    for (Piece piece : game.getBlackPieces()) {
                                        if (!(piece instanceof King)) {
                                            if (piece.availableSquares.contains(loopSquare)) {
                                                piece.blockingSquares.add(loopSquare);
                                            }
                                        }
                                    }
                                    cS++;
                                }

                            } else {
                                // we need to look left
                                int cS = currentSquare[1] - 1;

                                while (cS > checkingPieceSquare[1]) {
                                    int[] loopSquare = new int[]{currentSquare[0], cS};
                                    for (Piece piece : game.getBlackPieces()) {
                                        if (!(piece instanceof King)) {
                                            if (piece.availableSquares.contains(loopSquare)) {
                                                piece.blockingSquares.add(loopSquare);
                                            }
                                        }
                                    }
                                    cS--;
                                }
                            }
                        } else if (currentSquare[1] == checkingPieceSquare[1]) {
                            // checking rook directions on same file (up and down)
                            if (currentSquare[0] < checkingPieceSquare[0]) {

                                // we need to look down
                                int cS = currentSquare[0] + 1;

                                while (cS < checkingPieceSquare[0]) {
                                    int[] loopSquare = new int[]{cS, currentSquare[1]};
                                    for (Piece piece : game.getBlackPieces()) {
                                        if (!(piece instanceof King)) {
                                            if (piece.availableSquares.contains(loopSquare)) {
                                                piece.blockingSquares.add(loopSquare);
                                            }
                                        }
                                        cS++;
                                    }
                                }
                            } else {
                                // we need to look up
                                int cS = currentSquare[0] - 1;

                                while (cS > checkingPieceSquare[0]) {
                                    int[] loopSquare = new int[]{cS, currentSquare[1]};
                                    for (Piece piece : game.getBlackPieces()) {
                                        if (!(piece instanceof King)) {
                                            if (piece.availableSquares.contains(loopSquare)) {
                                                piece.blockingSquares.add(loopSquare);
                                            }
                                        }
                                    }
                                    cS--;
                                }
                            }

                        } else {
                            // in this case, we know we are checking the squares in bishop direction

                            if (checkingPieceSquare[0] < currentSquare[0]) {
                                // piece is above
                                if (checkingPieceSquare[1] < currentSquare[1]) {
                                    // check above left
                                    // we can use either the rank or file as we stop the loop when we reach the bishop.
                                    int cS = currentSquare[0] - 1;
                                    int cS2 = currentSquare[1] - 1;

                                    while (cS > checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, cS2};
                                        for (Piece piece : game.getBlackPieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS--;
                                        cS2--;

                                    }
                                } else {
                                    // check above right
                                    int cS = currentSquare[0] - 1;
                                    int cS2 = currentSquare[1] + 1;

                                    while (cS > checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, cS2};
                                        for (Piece piece : game.getBlackPieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS--;
                                        cS2++;

                                    }
                                }
                            } else {
                                if (checkingPieceSquare[1] < currentSquare[1]) {
                                    // check below left
                                    int cS = currentSquare[0] + 1;
                                    int cS2 = currentSquare[1] - 1;

                                    while (cS > checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, cS2};
                                        for (Piece piece : game.getBlackPieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS++;
                                        cS2--;

                                    }
                                } else {
                                    // check below right
                                    int cS = currentSquare[0] + 1;
                                    int cS2 = currentSquare[1] + 1;

                                    while (cS > checkingPieceSquare[0]) {
                                        int[] loopSquare = new int[]{cS, cS2};
                                        for (Piece piece : game.getBlackPieces()) {
                                            if (!(piece instanceof King)) {
                                                if (piece.availableSquares.contains(loopSquare)) {
                                                    piece.blockingSquares.add(loopSquare);
                                                }
                                            }
                                        }
                                        cS++;
                                        cS2++;

                                    }
                                }
                            }
                        }
                    }

                    // see if checking piece can be captured and add blocking squares

                    for (Piece piece : game.getBlackPieces()) {
                        if (!(piece instanceof King)) {
                            if (piece instanceof Pawn) {
                                // have to check diagonals

                                for (int[] square : ((Pawn) piece).getCaptureDirections()) {
                                    if (Arrays.equals(square, checkingPieceSquare)) {
                                        int[] attackSquare = square.clone();
                                        piece.availableSquares.clear();
                                        piece.availableSquares.add(attackSquare);
                                        piece.availableSquares.addAll(piece.blockingSquares);
                                        break;
                                    }
                                }
                            } else {
                                for (int[] square : piece.availableSquares) {
                                    if (Arrays.equals(square, checkingPieceSquare)) {
                                        int[] attackSquare = square.clone();
                                        piece.availableSquares.clear();
                                        piece.availableSquares.add(attackSquare);
                                        piece.availableSquares.addAll(piece.blockingSquares);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

            } else {


             */
            // now all available squares for the king are added to his list EXCEPT castling. Let's do this now:

            int[] a8 = new int[]{0, 0};
            int[] h8 = new int[]{0, 7};
            int[] e8 = new int[]{0, 4};
            boolean piecesMovedLeft = false;
            boolean piecesMovedRight = false;

            for (Piece[][] board : game.getBoardCopies()) {

                // for each board

                if (game.getSquare(e8, board) == null) {
                    piecesMovedRight = true;
                    piecesMovedLeft = true;
                    break;
                }

                if (game.getSquare(a8, board) == null) { // a1 is empty => can't castle
                    piecesMovedLeft = true;
                } else if (game.getSquare(a8).colour.equals("White")) {
                    piecesMovedLeft = true;
                }

                if (game.getSquare(h8, board) == null) {
                    piecesMovedRight = true;
                } else if (game.getSquare(h8, board).colour.equals("White")) {
                    piecesMovedRight = true;
                }
            }

            if (!piecesMovedLeft) {
                // check for queenside castle
                int[] d8 = new int[]{0, 3};
                int[] c8 = new int[]{0, 2};
                int[] b8 = new int[]{0, 1};

                if (!(game.isDefendedByWhite(c8)) && !(game.isDefendedByWhite(d8))) { // if both castling squares free
                    if (game.getSquare(d8) == null && game.getSquare(c8) == null && game.getSquare(b8) == null) {
                        availableSquares.add(new int[]{0, 2});
                    }
                }
            }

            if (!piecesMovedRight) {
                // now check for kingside castle
                int[] f8 = new int[]{0, 5};
                int[] g8 = new int[]{0, 6};

                if (!(game.isDefendedByWhite(f8)) && !(game.isDefendedByWhite(g8))) {
                    if (game.getSquare(f8) == null && game.getSquare(g8) == null) {
                        availableSquares.add(new int[]{0, 6});
                    }
                }


            }
        }
    }

    public boolean getIsInCheck() {
        return isInCheck;
    }
}
