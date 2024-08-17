import java.util.ArrayList;

public class run
{

    public static void main(String[] args){
        Game run = new Game();

        Queen testQueen = new Queen("Q","White",new int[]{1,2}, new int[]{1,2},new ArrayList<int[]>());
        Piece[] Board = new Piece[3];
        Board[0] = testQueen;

        ArrayList<Piece> testing = new ArrayList<>();
        testing.add(testQueen);
        Board[0].colour = "Black";
        System.out.println(testQueen.colour);


        for(Piece p: testing){
            System.out.println(p.colour);
        }
//        for(Piece[] rank: run.getBoard()){
//            System.out.println("\n");
//            for(Piece piece: rank){
//                if(piece == null){
//                    System.out.print("");
//                } else{
//                System.out.print(piece.name);
//                }
//            }
//        }





    }

}
