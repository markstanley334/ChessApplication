import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class run
{

    public static void main(String[] args){
        Game run = new Game();



        // so here is the game

        System.out.println("Welcome to Chess");


        run.turn = "White"; // white goes first

        while(true){ // this will make the game run


            run.printBoard(); // first print the board

            run.addBoardCopy();

            // check to see if 3 fold repetition:

//            for(int boardCount: run.getBoardCopyCount()){
//                System.out.println(boardCount);
//                if(boardCount == 3){
//                    System.out.println("Game is a draw by 3 fold repetition");
//                    return;
//                }
//            }



            Scanner input = new Scanner(System.in);

            boolean stalemate = true;

            if(run.turn.equals("White")){

                // white's turn
                King whiteKing = new King("","",new int[]{}, new int[]{}, new ArrayList<>());
                Integer count = 0;
                for(Piece piece: run.getWhitePieces()){
                    System.out.print(count.toString() + " " +  piece.name + " " + Arrays.toString(piece.currentSquare)+"  ");
                    count++;

                    if(!(piece.availableSquares.isEmpty())){
                        stalemate = false;
                    }

                    if(piece instanceof King){
                        if(((King) piece).getIsInCheck()){
                            whiteKing = (King)piece;
                        }
                    }

                }

                if(stalemate){
                    if(whiteKing.getIsInCheck()){
                        System.out.println("Black wins");
                    } else{
                        System.out.println("Draw by stalemate");
                    }

                }

                int pieceIndex = input.nextInt();

                Piece selectedPiece = run.getWhitePieces().get(pieceIndex);

                System.out.println(selectedPiece.name + " " + Arrays.toString(selectedPiece.currentSquare));

                Integer count2 = 0;
                for(int[] square: selectedPiece.availableSquares){
                    System.out.print(count2.toString() + " " + Arrays.toString(square) + " ");
                    count2++;
                }

                int moveIndex = input.nextInt();

                int[] movingSquare = selectedPiece.availableSquares.get(moveIndex);

                selectedPiece.move(movingSquare,run);

                int indexCount = 0;
                int kingIndex = -1;
                for(Piece piece: run.getWhitePieces()){
                    if(!(piece instanceof King)){
                        piece.refresh(run);
                        indexCount++;
                    } else{
                        kingIndex = indexCount;
                    }
                }

//                run.getWhitePieces().get(kingIndex).refresh(run);

                for(Piece piece: run.getWhitePieces()){
                    if(piece instanceof King){
                        piece.refresh(run);
                    }
                }

                indexCount = 0;
                kingIndex = -1;
                for(Piece piece: run.getBlackPieces()){
                    if(!(piece instanceof King)){
                        piece.refresh(run);
                        indexCount++;
                    } else{
                        kingIndex = indexCount;
                    }
                }

//                run.getBlackPieces().get(kingIndex).refresh(run);

                for(Piece piece: run.getBlackPieces()){
                    if(piece instanceof King){
                        piece.refresh(run);
                    }
                }

                run.turn = "Black"; // change turn
            } else{
                // black's turn
                King blackKing = new King("","",new int[]{}, new int[]{}, new ArrayList<>());
                stalemate = true;

                Integer count = 0;
                for(Piece piece: run.getBlackPieces()){
                    System.out.print(count.toString() + " " +  piece.name + " " + Arrays.toString(piece.currentSquare)+"  ");
                    count++;

                    if(!(piece.availableSquares.isEmpty())){
                        stalemate = false;
                    }

                    if(piece instanceof King){
                        if(((King) piece).getIsInCheck()){
                            blackKing = (King)piece;
                        }
                    }
                }

                if(stalemate){
                    if(blackKing.getIsInCheck()) {
                    System.out.println("White wins");
                    break;
                    } else{
                      System.out.println("Draw by stalemate");
                    }
                }

                int pieceIndex = input.nextInt();

                Piece selectedPiece = run.getBlackPieces().get(pieceIndex);

                System.out.println(selectedPiece.name + " " + Arrays.toString(selectedPiece.currentSquare));

                Integer count2 = 0;
                for(int[] square: selectedPiece.availableSquares){
                    System.out.print(count2.toString() + " " + Arrays.toString(square) + " ");
                    count2++;
                }

                int moveIndex = input.nextInt();

                int[] movingSquare = selectedPiece.availableSquares.get(moveIndex);

                selectedPiece.move(movingSquare,run);

                int indexCount = 0;
                int kingIndex = -1;
                for(Piece piece: run.getBlackPieces()){
                    if(!(piece instanceof King)){
                        piece.refresh(run);
                        indexCount++;
                    } else{
                        kingIndex = indexCount;
                    }
                }

//                run.getBlackPieces().get(kingIndex).refresh(run);

                for(Piece piece: run.getBlackPieces()){
                    if(piece instanceof King){
                        piece.refresh(run);
                    }
                }

                indexCount = 0;
                kingIndex = -1;
                for(Piece piece: run.getWhitePieces()){
                    if(!(piece instanceof King)){
                        piece.refresh(run);
                        indexCount++;
                    } else{
                        kingIndex = indexCount;
                    }
                }

//                run.getWhitePieces().get(kingIndex).refresh(run);

                for(Piece piece: run.getWhitePieces()){
                    if(piece instanceof King){
                        piece.refresh(run);
                    }
                }

                run.turn = "White";
            }


        }

    }

}

/*
add new move to hashmap
print board
print pieces with at least one move
player selects piece
list moves
player states move
move is made
other player's turn

add board to hashmap after both players move

(log all moves in arraylist)

 */
