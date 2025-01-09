import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Game {


    // BOARD INDICES:

    /*
    [ [[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[0,6],[0,7]],
       [[1,0],[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]],
       [[2,0],[2,1],[2,2],[2,3],[2,4],[2,5],[2,6],[2,7]],
       [[3,0],[3,1],[3,2],[3,3],[3,4],[3,5],[3,6],[3,7]],
       [[4,0],[4,1],[4,2],[4,3],[4,4],[4,5],[4,6],[4,7]],
       [[5,0],[5,1],[5,2],[5,3],[5,4],[5,5],[5,6],[5,7]],
       [[6,0],[6,1],[6,2],[6,3],[6,4],[6,5],[6,6],[6,7]],
       [[7,0],[7,1],[7,2],[7,3],[7,4],[7,5],[7,6],[7,7]] ]

     */

    private int promotionCount;
    private Piece[][] Board = new Piece[8][8]; // This is the board

    private ArrayList<Piece> whitePieces;
    private ArrayList<Piece> blackPieces;
    public String turn; // either white or black

    private int moveNumber; // keep track of move number

    private ArrayList<Piece[][]> boardCopies;

    private ArrayList<Integer> boardCopyCount;

    private ArrayList<String> whiteMoves;
    private ArrayList<String> blackMoves;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";



    Pawn aPawnWhite;
    Pawn bPawnWhite;
    Pawn cPawnWhite;
    Pawn dPawnWhite;
    Pawn ePawnWhite;
    Pawn fPawnWhite;
    Pawn gPawnWhite;
    Pawn hPawnWhite;

    Knight bKnightWhite;
    Knight gKnightWhite;
    Bishop cBishopWhite;
    Bishop fBishopWhite;
    Rook aRookWhite;
    Rook hRookWhite;

    Queen queenWhite;
    King kingWhite;
    Pawn aPawnBlack;
    Pawn bPawnBlack;
    Pawn cPawnBlack;
    Pawn dPawnBlack;
    Pawn ePawnBlack;
    Pawn fPawnBlack;
    Pawn gPawnBlack;
    Pawn hPawnBlack;

    Knight bKnightBlack;
    Knight gKnightBlack;
    Bishop cBishopBlack;
    Bishop fBishopBlack;
    Rook aRookBlack;
    Rook hRookBlack;

    Queen queenBlack;
    King kingBlack;


    public Game(){
        moveNumber = 0;
        promotionCount = 0;

        aPawnWhite = new Pawn("P","White", new int[]{6,0},new int[]{6,0},new ArrayList<int[]>(Arrays.asList(new int[]{5,0}, new int[]{4,0})));
        bPawnWhite = new Pawn("P","White", new int[]{6, 1},new int[]{6,1},new ArrayList<int[]>(Arrays.asList(new int[]{5,1},new int[]{4,1})));
        cPawnWhite = new Pawn("P","White", new int[]{6, 2},new int[]{6,2},new ArrayList<int[]>(Arrays.asList(new int[]{5,2}, new int[]{4,2})));
        dPawnWhite = new Pawn("P","White", new int[]{6, 3},new int[]{6,3},new ArrayList<int[]>(Arrays.asList(new int[]{5,3}, new int[]{4,3})));
        ePawnWhite = new Pawn("P","White", new int[]{6, 4},new int[]{6,4},new ArrayList<int[]>(Arrays.asList(new int[]{5,4}, new int[]{4,4})));
        fPawnWhite = new Pawn("P","White", new int[]{6, 5},new int[]{6,5},new ArrayList<int[]>(Arrays.asList(new int[]{5,5}, new int[]{4,5})));
        gPawnWhite = new Pawn("P","White", new int[]{6, 6},new int[]{6,6},new ArrayList<int[]>(Arrays.asList(new int[]{5,6}, new int[]{4,6})));
        hPawnWhite = new Pawn("P","White", new int[]{6, 7},new int[]{6,0},new ArrayList<int[]>(Arrays.asList(new int[]{5,7}, new int[]{4,7})));

        bKnightWhite = new Knight("N","White", new int[]{7,1},new int[]{7,1},new ArrayList<int[]>(Arrays.asList(new int[]{5,0}, new int[]{5,2})));
        gKnightWhite = new Knight("N", "White", new int[]{7,6}, new int[]{7,6}, new ArrayList<int[]>(Arrays.asList(new int[]{5,5}, new int[]{5,7})));

        cBishopWhite = new Bishop("B", "White", new int[]{7,2}, new int[]{7,2}, new ArrayList<int[]>());
        fBishopWhite = new Bishop("B", "White", new int[]{7,5}, new int[]{7,5}, new ArrayList<int[]>());

        aRookWhite = new Rook("R", "White", new int[]{7,0}, new int[]{7,0}, new ArrayList<int[]>());
        hRookWhite = new Rook("R", "White", new int[]{7,7}, new int[]{7,7}, new ArrayList<int[]>());

        queenWhite = new Queen("Q", "White", new int[]{7,3}, new int[]{7,3}, new ArrayList<int[]>());

        kingWhite = new King("K", "White", new int[]{7,4}, new int[]{7,4}, new ArrayList<int[]>());

        aPawnBlack = new Pawn("P","Black", new int[]{1, 0},new int[]{1,0},new ArrayList<int[]>(Arrays.asList(new int[]{2,0}, new int[]{3,0})));
        bPawnBlack = new Pawn("P","Black", new int[]{1, 1},new int[]{1,1},new ArrayList<int[]>(Arrays.asList(new int[]{2,1}, new int[]{3,1})));
        cPawnBlack = new Pawn("P","Black", new int[]{1, 2},new int[]{1,2},new ArrayList<int[]>(Arrays.asList(new int[]{2,2}, new int[]{3,2})));
        dPawnBlack = new Pawn("P","Black", new int[]{1, 3},new int[]{1,3},new ArrayList<int[]>(Arrays.asList(new int[]{2,3}, new int[]{3,3})));
        ePawnBlack = new Pawn("P","Black", new int[]{1, 4},new int[]{1,4},new ArrayList<int[]>(Arrays.asList(new int[]{2,4}, new int[]{3,4})));
        fPawnBlack = new Pawn("P","Black", new int[]{1, 5},new int[]{1,5},new ArrayList<int[]>(Arrays.asList(new int[]{2,5}, new int[]{3,5})));
        gPawnBlack = new Pawn("P","Black", new int[]{1, 6},new int[]{1,6},new ArrayList<int[]>(Arrays.asList(new int[]{2,6}, new int[]{3,6})));
        hPawnBlack = new Pawn("P","Black", new int[]{1, 7},new int[]{1,0},new ArrayList<int[]>(Arrays.asList(new int[]{2,7}, new int[]{3,7})));

        bKnightBlack = new Knight("N", "Black", new int[]{0,1}, new int[]{0,1}, new ArrayList<int[]>(Arrays.asList(new int[]{2,0}, new int[]{2,2})));
        gKnightBlack = new Knight("N", "Black", new int[]{0,6}, new int[]{0,6}, new ArrayList<int[]>(Arrays.asList(new int[]{2,5}, new int[]{2,7})));

        cBishopBlack = new Bishop("B", "Black", new int[]{0,2}, new int[]{0,2}, new ArrayList<int[]>());
        fBishopBlack = new Bishop("B", "Black", new int[]{0,5}, new int[]{0,5}, new ArrayList<int[]>());

        aRookBlack = new Rook("R", "Black", new int[]{0,0}, new int[]{0,0}, new ArrayList<int[]>());
        hRookBlack = new Rook("R", "Black", new int[]{0,7}, new int[]{0,7}, new ArrayList<int[]>());

        queenBlack = new Queen("Q", "Black", new int[]{0,3}, new int[]{0,3}, new ArrayList<int[]>());

        kingBlack = new King("K", "Black", new int[]{0,4}, new int[]{0,4}, new ArrayList<int[]>());


        Piece[] Rank8 = new Piece[8];
        Rank8[0] = aRookBlack;
        Rank8[1] = bKnightBlack;
        Rank8[2] = cBishopBlack;
        Rank8[3] = queenBlack;
        Rank8[4] = kingBlack;
        Rank8[5] = fBishopBlack;
        Rank8[6] = gKnightBlack;
        Rank8[7] = hRookBlack;

        Piece[] Rank7 = new Piece[8];
        Rank7[0] = aPawnBlack;
        Rank7[1] = bPawnBlack;
        Rank7[2] = cPawnBlack;
        Rank7[3] = dPawnBlack;
        Rank7[4] = ePawnBlack;
        Rank7[5] = fPawnBlack;
        Rank7[6] = gPawnBlack;
        Rank7[7] = hPawnBlack;

        Piece[] empty = new Piece[8];

        empty[0] = null;
        empty[1] = null;
        empty[2] = null;
        empty[3] = null;
        empty[4] = null;
        empty[5] = null;
        empty[6] = null;
        empty[7] = null;

        Piece[] Rank2 = new Piece[8];
        Rank2[0] = aPawnWhite;
        Rank2[1] = bPawnWhite;
        Rank2[2] = cPawnWhite;
        Rank2[3] = dPawnWhite;
        Rank2[4] = ePawnWhite;
        Rank2[5] = fPawnWhite;
        Rank2[6] = gPawnWhite;
        Rank2[7] = hPawnWhite;

        Piece[] Rank1 = new Piece[8];
        Rank1[0] = aRookWhite;
        Rank1[1] = bKnightWhite;
        Rank1[2] = cBishopWhite;
        Rank1[3] = queenWhite;
        Rank1[4] = kingWhite;
        Rank1[5] = fBishopWhite;
        Rank1[6] = gKnightWhite;
        Rank1[7] = hRookWhite;

        Board[0] = Rank8;
        Board[1] = Rank7;
        Board[2] = empty.clone();
        Board[3] = empty.clone();
        Board[4] = empty.clone();
        Board[5] = empty.clone();
        Board[6] = Rank2;
        Board[7] = Rank1;


        whitePieces = new ArrayList<Piece>();
        whitePieces.add(aPawnWhite);
        whitePieces.add(bPawnWhite);
        whitePieces.add(cPawnWhite);
        whitePieces.add(dPawnWhite);
        whitePieces.add(ePawnWhite);
        whitePieces.add(fPawnWhite);
        whitePieces.add(gPawnWhite);
        whitePieces.add(hPawnWhite);
        whitePieces.add(aRookWhite);
        whitePieces.add(bKnightWhite);
        whitePieces.add(cBishopWhite);
        whitePieces.add(queenWhite);
        whitePieces.add(kingWhite);
        whitePieces.add(fBishopWhite);
        whitePieces.add(gKnightWhite);
        whitePieces.add(hRookWhite);

        blackPieces = new ArrayList<Piece>();
        blackPieces.add(aPawnBlack);
        blackPieces.add(bPawnBlack);
        blackPieces.add(cPawnBlack);
        blackPieces.add(dPawnBlack);
        blackPieces.add(ePawnBlack);
        blackPieces.add(fPawnBlack);
        blackPieces.add(gPawnBlack);
        blackPieces.add(hPawnBlack);
        blackPieces.add(aRookBlack);
        blackPieces.add(bKnightBlack);
        blackPieces.add(cBishopBlack);
        blackPieces.add(queenBlack);
        blackPieces.add(kingBlack);
        blackPieces.add(fBishopBlack);
        blackPieces.add(gKnightBlack);
        blackPieces.add(hRookBlack);

        boardCopies = new ArrayList<>();
        boardCopyCount = new ArrayList<>();


        whiteMoves = new ArrayList<String>();
        blackMoves = new ArrayList<String>();

        turn = "White";

    }

    public Piece[][] getBoard(){
    return Board;}

    public void setSquare(Piece piece, int[] square){
        Board[square[0]][square[1]] = piece;
    }

    public Piece getSquare(int[] square){return Board[square[0]][square[1]];}

    public Piece getSquare(int[] square, Piece[][] board){return board[square[0]][square[1]];} // operator overloading

    public void addPromotionCount(){
        promotionCount++;
    }
    public int getPromotionCount(){return promotionCount;}

    public ArrayList<Piece> getWhitePieces(){
        return whitePieces;
    }

    public ArrayList<Piece> getBlackPieces(){
        return blackPieces;
    }

    public int getMoveNumber(){return moveNumber;}
    public void addMoveNumber(int addition){
        moveNumber += addition;
    }

    public void addWhitePiece(Piece piece){
        whitePieces.add(piece);
    }

    public void addBlackPiece(Piece piece){
        blackPieces.add(piece);
    }

    public boolean removePiece(int[] square){
        for(Piece piece: whitePieces){
            if(Arrays.equals(square,piece.currentSquare)){ // remove the piece
                whitePieces.remove(piece);
                return true;
            }
        }

        for(Piece piece: blackPieces){
            if(Arrays.equals(square, piece.currentSquare)){
                blackPieces.remove(piece);
                return true;
            }
        } return false;
    }



    public boolean hasWhitePiece(int[] square){
        if(Board[square[0]][square[1]] == null){
            return false;
        } else if(Board[square[0]][square[1]].colour.equals("White")){
            return true;
        } else{
            return false;
        }
    }

    public boolean hasBlackPiece(int[] square){
        if(Board[square[0]][square[1]] == null){
            return false;
        } else if(Board[square[0]][square[1]].colour.equals("Black")){
            return true;
        } else{
            return false;
        }
    }

    public boolean hasNoPiece(int[] square){
        if(Board[square[0]][square[1]] == null){
            return true;
        } return false;
    }

    public boolean whitePawnJustMovedTwo(int[] square){ // this function is for the en passant rule
        if(Board[square[0]][square[1]] instanceof Pawn && Board[square[0]][square[1]].colour.equals("White")){ // if the square is a pawn & the pawn is white
                if(Arrays.equals(Board[square[0]][square[1]].previousSquare, new int[]{6, square[1]})){ // the previous square was a starting square
                    return true;
                }
            }
        return false;
    }
    public boolean blackPawnJustMovedTwo(int[] square){ // this function is for the en passant rule
        if(Board[square[0]][square[1]] instanceof Pawn && Board[square[0]][square[1]].colour.equals("Black")){ // if the square is a pawn & the pawn is white
            if(Arrays.equals(Board[square[0]][square[1]].previousSquare, new int[]{1, square[1]})){ // the previous square was a starting square
                return true;
            }
        }
        return false;
    }

    public boolean isDefendedByWhite(int[] square) { // note this function can only be used after pieces have been refreshed

            for (Piece piece : whitePieces) {
                if (piece instanceof Pawn) {
                    for (int[] move : ((Pawn) piece).getCaptureDirections()) {
                        if (Arrays.equals(move, square)) {
                            return true;
                        }
                    }
                } else {

                    for (int[] move : piece.availableSquares) {
                        if (Arrays.equals(move, square)) {
                            return true;
                        }
                    }
                }
            }
            return false;

        }

        public boolean isDefendedByBlack(int[] square){
            for (Piece piece : blackPieces) {
                if (piece instanceof Pawn) {
                    for (int[] move : ((Pawn) piece).getCaptureDirections()) {
                        if (Arrays.equals(move, square)) {
                            return true;
                        }
                    }
                } else {

                    for (int[] move : piece.availableSquares) {
                        if (Arrays.equals(move, square)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }


    public String arrayToAlgebraicNotation(int[] square) {
        String letter = null;
        switch (square[1]) {

            case 0:
                letter = "a";
                break;
            case 1:
                letter = "b";
                break;
            case 2:
                letter = "c";
                break;
            case 3:
                letter = "d";
                break;
            case 4:
                letter = "e";
                break;
            case 5:
                letter = "f";
                break;
            case 6:
                letter = "g";
                break;
            case 7:
                letter = "h";
                break;
        }

        Integer number = (8-square[0]);

        String numberText = number.toString();
        return letter+numberText;

    }

    public boolean isSameBoard(Piece[][] board1, Piece[][] board2) {
        for(int i = 0; i<8; i++) {
            for (int j = 0; j < 8; j++) {

                if(board1[i][j] == null){
                    if(board2[i][j] != null){
                        return false;
                    }
                } else if(board2[i][j] == null){
                    if(board1[i][j] != null){
                        return false;
                    }
                } else if (!(board1[i][j].equals(board2[i][j]))) { // if different pieces
                    return false;

                }
            }
        } return true;
    }

    public boolean addBoardCopy() { // always add the board to the list, then
        int count = 0;
        for (Piece[][] boardCopy : boardCopies) {
            if(isSameBoard(boardCopy,Board)){
                System.out.println("same board detected");
                Piece[][] copy = Board.clone();
                for(int i = 0; i< copy.length; i++){
                    copy[i] = Board[i].clone();
                }
                boardCopies.add(copy);
                boardCopyCount.set(count,boardCopyCount.get(count)+1);
                boardCopyCount.add(1);
                return true;

            }
            count++;

        } // all boards have been searched no match
        System.out.println("unique board");

        Piece[][] copy = Board.clone();
        for(int i = 0; i< copy.length; i++){
            copy[i] = Board[i].clone();
        }
        boardCopies.add(copy);
        boardCopyCount.add(1);
        return false;
    }

    public ArrayList<Piece[][]> getBoardCopies(){
        return boardCopies;
    }

    public ArrayList<Integer> getBoardCopyCount(){
        return boardCopyCount;
    }


    public void printBoard(){
        for(Piece[] rank: Board){
            System.out.print("\n");
            for(Piece piece: rank){
                if(piece == null){
                    System.out.print("_");
                } else{
                    if(piece.colour.equals("White")){
                        System.out.print(piece.name);
                    } else {
                        System.out.print(ANSI_YELLOW + piece.name + ANSI_RESET);
                    }
                }
            }
        }
        System.out.println("");
    }

    public void printBoard(Piece[][] board){
        for(Piece[] rank: board){
            System.out.print("\n");
            for(Piece piece: rank){
                if(piece == null){
                    System.out.print("_");
                } else{
                    if(piece.colour.equals("White")){
                        System.out.print(piece.name);
                    } else {
                        System.out.print(ANSI_YELLOW + piece.name + ANSI_RESET);
                    }
                }
            }
        }
        System.out.println("");
    }

    public String moveInChessNotation(Piece piece, Piece promotedPiece, int[] oldSquare, int[] newSquare){

        // what we need to accomplish:

        // pawn moves: a4, a5, axb6  but also if the king becomes in check we have a4+ (plus means check)
        // hashtag means checkmate: a4#
        // promotion is like: a8=Q or a8=N (knight or queen respectively
        // O-O is kingside castle O-O-O is queenside castle
        // pawn: ""
        // knight: "N"
        // bishop: "B"
        // rook: "R"
        // queen: "Q"
        // king: "K"
        // then must deal with disambiguation (if the same type of piece could have reached the same square,
        // either the rank, file, or both must be stated in notation.

        // so steps for this function should:
        //     - piece type add to string
        //     - determine if there is disambiguation
        //     - check if it is a capture
        //     - if pawn promotion add that here
        //     - check if it is check / checkmate


        // for disambiguation:
        // look through all similar pieces to see if they could have moved to the square.
        // If not, no clarification needed
        // If yes, compare rank and file to see what to change
        // finish looping. If only 1 shared movement, alter this movement
        // if 2 shared movements state the previous square using the arrayToAlgebraicNotation() function

        if(piece.colour.equals("White")){

        if(getSquare(newSquare) == null){ // this is NOT a capture (except for en passant)

            if(piece instanceof Pawn){
                // pawn either is pushing forward here or promoting
                String newSquareString = arrayToAlgebraicNotation(newSquare);


            } else if(piece instanceof Knight){


            } else if(piece instanceof Bishop){

            } else if(piece instanceof Rook){

            } else if(piece instanceof Queen){

            } else{
                // this is a king
            }

        } else{
            // this IS a capture
            if(piece instanceof Pawn){

            }else if(piece instanceof Knight){

            } else if(piece instanceof Bishop){

            } else if(piece instanceof Rook){

            } else if(piece instanceof Queen){

            } else{
                // this is a king
            }
        } } else{
            // here colour is black
            if(getSquare(newSquare) == null){ // this is NOT a capture (except for en passant)

                if(piece instanceof Pawn){
                    // pawn either is pushing forward here or promoting
                    String newSquareString = arrayToAlgebraicNotation(newSquare);


                } else if(piece instanceof Knight){


                } else if(piece instanceof Bishop){

                } else if(piece instanceof Rook){

                } else if(piece instanceof Queen){

                } else{
                    // this is a king
                }

            } else{
                // this IS a capture
                if(piece instanceof Pawn){

                }else if(piece instanceof Knight){

                } else if(piece instanceof Bishop){

                } else if(piece instanceof Rook){

                } else if(piece instanceof Queen){

                } else{
                    // this is a king
                }
            }
        }

        return "false";
    }



}
