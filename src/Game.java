import java.util.ArrayList;
import java.util.Arrays;
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
    private String turn; // either white or black

    private int moveNumber; // keep track of move number



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
        blackPieces.add(bKnightBlack);
        blackPieces.add(cBishopBlack);
        blackPieces.add(queenBlack);
        blackPieces.add(kingBlack);
        blackPieces.add(fBishopBlack);
        blackPieces.add(gKnightBlack);
        blackPieces.add(hRookBlack);

    }

    public Piece[][] getBoard(){
    return Board;}

    public void setSquare(Piece piece, int[] square){
        Board[square[0]][square[1]] = piece;
    }

    public Piece getSquare(int[] square){return Board[square[0]][square[1]];}

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

    public void addWhitePiece(Piece piece){
        whitePieces.add(piece);
    }

    public void addBlackPiece(Piece piece){
        blackPieces.add(piece);
    }

    public boolean hasWhitePiece(int[] square){
        if(Board[square[0]][square[1]] == null){
            return false;
        } else if(Objects.equals(Board[square[0]][square[1]].colour, "White")){
            return true;
        } else{
            return false;
        }
    }

    public boolean hasBlackPiece(int[] square){
        if(Board[square[0]][square[1]] == null){
            return false;
        } else if(Objects.equals(Board[square[0]][square[1]].colour, "Black")){
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

    public void printBoard(){
        for(Piece[] rank: Board){
            System.out.println("\n");
            for(Piece piece: rank){
                if(piece == null){
                    System.out.print("");
                } else{
                System.out.print(piece.name);
                }
            }
        }
    }
}
