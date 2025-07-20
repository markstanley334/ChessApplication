import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BoardPane extends Pane {

    private ToggleButton[][] buttons;

    private Circle[][] circles;

    private double circleRadius;

    private double buttonSize;

    private Image whiteRookA;
    private Image whiteRookH;
    private Image whiteKnightB;
    private Image whiteKnightG;
    private Image whiteBishopC;
    private Image whiteBishopF;
    private Image whiteQueen;
    private Image whiteKing;
    private Image whitePawnA;
    private Image whitePawnB;
    private Image whitePawnC;
    private Image whitePawnD;
    private Image whitePawnE;
    private Image whitePawnF;
    private Image whitePawnG;
    private Image whitePawnH;
    private Image blackRookA;
    private Image blackRookH;
    private Image blackKnightB;
    private Image blackKnightG;
    private Image blackBishopC;
    private Image blackBishopF;
    private Image blackQueen;
    private Image blackKing;
    private Image blackPawnA;
    private Image blackPawnB;
    private Image blackPawnC;
    private Image blackPawnD;
    private Image blackPawnE;
    private Image blackPawnF;
    private Image blackPawnG;
    private Image blackPawnH;

    public BoardPane(){

        GridPane gridPane = new GridPane();

        gridPane.relocate(50,50);

        int rows = 8;
        int cols = 8;

        // as the images change depending on the specific  piece, each button needs its own imageview

        whiteRookA = new Image("Images/whiterook.png");
        whiteRookH = new Image("Images/whiterook.png");
        whiteKnightB = new Image("Images/whiteknight.png");
        whiteKnightG = new Image("Images/whiteknight.png");
        whiteBishopC = new Image("Images/whitebishop.png");
        whiteBishopF = new Image("Images/whitebishop.png");
        whiteQueen = new Image("Images/whitequeen.png");
        whiteKing = new Image("Images/whiteking.png");
        whitePawnA = new Image("Images/whitepawn.png");
        whitePawnB = new Image("Images/whitepawn.png");
        whitePawnC = new Image("Images/whitepawn.png");
        whitePawnD = new Image("Images/whitepawn.png");
        whitePawnE = new Image("Images/whitepawn.png");
        whitePawnF = new Image("Images/whitepawn.png");
        whitePawnG = new Image("Images/whitepawn.png");
        whitePawnH = new Image("Images/whitepawn.png");

        blackRookA = new Image("Images/blackrook.png");
        blackRookH = new Image("Images/blackrook.png");
        blackKnightB = new Image("Images/blackknight.png");
        blackKnightG = new Image("Images/blackknight.png");
        blackBishopC = new Image("Images/blackbishop.png");
        blackBishopF = new Image("Images/blackbishop.png");
        blackQueen = new Image("Images/blackqueen.png");
        blackKing = new Image("Images/blackking.png");
        blackPawnA = new Image("Images/blackpawn.png");
        blackPawnB = new Image("Images/blackpawn.png");
        blackPawnC = new Image("Images/blackpawn.png");
        blackPawnD = new Image("Images/blackpawn.png");
        blackPawnE = new Image("Images/blackpawn.png");
        blackPawnF = new Image("Images/blackpawn.png");
        blackPawnG = new Image("Images/blackpawn.png");
        blackPawnH = new Image("Images/blackpawn.png");


        Color lightgray = Color.LIGHTGRAY;
        Color blue = Color.DARKCYAN;

        buttons = new ToggleButton[8][8];
        circles = new Circle[8][8];

        circleRadius = 8;
        buttonSize = 95;


        for(int row = 0; row < rows; row++){
            for( int col = 0; col < cols; col++){
                ToggleButton button = new ToggleButton(); // "" + (row*cols + col + 1)

                Circle circle = new Circle(circleRadius, Color.TRANSPARENT); // Initially transparent

                button.setPrefSize(buttonSize,buttonSize);

                buttons[row][col] = button;
                circles[row][col] = circle;

                switch(row){

                    case 0:
                        switch(col){
                            case 0:
                                ImageView imageViewBRA = new ImageView(blackRookA);
                                StackPane braStackPane = new StackPane();
                                braStackPane.getChildren().addAll(imageViewBRA,circle);
                                button.setGraphic(braStackPane);
                                break;
                            case 1:
                                ImageView imageViewBNB = new ImageView(blackKnightB);
                                StackPane bnbStackPane = new StackPane();
                                bnbStackPane.getChildren().addAll(imageViewBNB,circle);
                                button.setGraphic(bnbStackPane);
                                break;
                            case 2:
                                ImageView imageViewBBC = new ImageView(blackBishopC);
                                StackPane bbcStackPane = new StackPane();
                                bbcStackPane.getChildren().addAll(imageViewBBC,circle);
                                button.setGraphic(bbcStackPane);
                                break;
                            case 3:
                                ImageView imageViewBQ = new ImageView(blackQueen);
                                StackPane bqStackPane = new StackPane();
                                bqStackPane.getChildren().addAll(imageViewBQ,circle);
                                button.setGraphic(bqStackPane);
                                break;
                            case 4:
                                ImageView imageViewBK = new ImageView(blackKing);
                                StackPane bkStackPane = new StackPane();
                                bkStackPane.getChildren().addAll(imageViewBK,circle);
                                button.setGraphic(bkStackPane);
                                break;
                            case 5:
                                ImageView imageViewBBF = new ImageView(blackBishopF);
                                StackPane bbfStackPane = new StackPane();
                                bbfStackPane.getChildren().addAll(imageViewBBF,circle);
                                button.setGraphic(bbfStackPane);
                                break;
                            case 6:
                                ImageView imageViewBNG = new ImageView(blackKnightG);
                                StackPane bngStackPane = new StackPane();
                                bngStackPane.getChildren().addAll(imageViewBNG,circle);
                                button.setGraphic(bngStackPane);
                                break;
                            case 7:
                                ImageView imageViewBRH = new ImageView(blackRookH);
                                StackPane brhStackPane = new StackPane();
                                brhStackPane.getChildren().addAll(imageViewBRH,circle);
                                button.setGraphic(brhStackPane);
                                break;
                        }
                        break;

                    case 1:
                        switch(col){
                            case 0:
                                ImageView imageViewBPA = new ImageView(blackPawnA);
                                StackPane abStackPane = new StackPane();
                                abStackPane.getChildren().addAll(imageViewBPA,circle);
                                button.setGraphic(abStackPane);
                                break;
                            case 1:
                                ImageView imageViewBPB = new ImageView(blackPawnB);
                                StackPane bbStackPane = new StackPane();
                                bbStackPane.getChildren().addAll(imageViewBPB,circle);
                                button.setGraphic(bbStackPane);
                                break;
                            case 2:
                                ImageView imageViewBPC = new ImageView(blackPawnC);
                                StackPane cbStackPane = new StackPane();
                                cbStackPane.getChildren().addAll(imageViewBPC,circle);
                                button.setGraphic(cbStackPane);
                                break;
                            case 3:
                                ImageView imageViewBPD = new ImageView(blackPawnD);
                                StackPane dbStackPane = new StackPane();
                                dbStackPane.getChildren().addAll(imageViewBPD,circle);
                                button.setGraphic(dbStackPane);
                                break;
                            case 4:
                                ImageView imageViewBPE = new ImageView(blackPawnE);
                                StackPane ebStackPane = new StackPane();
                                ebStackPane.getChildren().addAll(imageViewBPE,circle);
                                button.setGraphic(ebStackPane);
                                break;
                            case 5:
                                ImageView imageViewBPF = new ImageView(blackPawnF);
                                StackPane fbStackPane = new StackPane();
                                fbStackPane.getChildren().addAll(imageViewBPF,circle);
                                button.setGraphic(fbStackPane);
                                break;
                            case 6:
                                ImageView imageViewBPG = new ImageView(blackPawnG);
                                StackPane gbStackPane = new StackPane();
                                gbStackPane.getChildren().addAll(imageViewBPG,circle);
                                button.setGraphic(gbStackPane);
                                break;
                            case 7:
                                ImageView imageViewBPH = new ImageView(blackPawnH);
                                StackPane hbStackPane = new StackPane();
                                hbStackPane.getChildren().addAll(imageViewBPH,circle);
                                button.setGraphic(hbStackPane);
                                break;
                        }
                        break;

                    case 6: // still must change to imageview
                        switch(col){
                            case 0:
                                ImageView imageViewWPA = new ImageView(whitePawnA);
                                StackPane wpaStackPane = new StackPane();
                                wpaStackPane.getChildren().addAll(imageViewWPA,circle);
                                button.setGraphic(imageViewWPA);
                                break;
                            case 1:
                                ImageView imageViewWPB = new ImageView(whitePawnB);
                                StackPane wpbStackPane = new StackPane();
                                wpbStackPane.getChildren().addAll(imageViewWPB,circle);
                                button.setGraphic(imageViewWPB);
                                break;
                            case 2:
                                ImageView imageViewWPC = new ImageView(whitePawnC);
                                StackPane wpcStackPane = new StackPane();
                                wpcStackPane.getChildren().addAll(imageViewWPC,circle);
                                button.setGraphic(imageViewWPC);
                                break;
                            case 3:
                                ImageView imageViewWPD = new ImageView(whitePawnD);
                                StackPane wpdStackPane = new StackPane();
                                wpdStackPane.getChildren().addAll(imageViewWPD,circle);
                                button.setGraphic(imageViewWPD);
                                break;
                            case 4:
                                ImageView imageViewWPE = new ImageView(whitePawnE);
                                StackPane wpeStackPane = new StackPane();
                                wpeStackPane.getChildren().addAll(imageViewWPE,circle);
                                button.setGraphic(imageViewWPE);
                                break;
                            case 5:
                                ImageView imageViewWPF = new ImageView(whitePawnF);
                                StackPane wpfStackPane = new StackPane();
                                wpfStackPane.getChildren().addAll(imageViewWPF,circle);
                                button.setGraphic(imageViewWPF);
                                break;
                            case 6:
                                ImageView imageViewWPG = new ImageView(whitePawnG);
                                StackPane wpgStackPane = new StackPane();
                                wpgStackPane.getChildren().addAll(imageViewWPG,circle);
                                button.setGraphic(imageViewWPG);
                                break;
                            case 7:
                                ImageView imageViewWPH = new ImageView(whitePawnH);
                                StackPane wphStackPane = new StackPane();
                                wphStackPane.getChildren().addAll(imageViewWPH,circle);
                                button.setGraphic(imageViewWPH);
                                break;
                        }

                        break;

                    case 7:
                        switch(col){
                            case 0:
                                ImageView imageViewWRA = new ImageView(whiteRookA);
                                StackPane wraStackPane = new StackPane();
                                wraStackPane.getChildren().addAll(imageViewWRA,circle);
                                button.setGraphic(wraStackPane);
                                break;
                            case 1:
                                ImageView imageViewWNB = new ImageView(whiteKnightB);
                                StackPane wnbStackPane = new StackPane();
                                wnbStackPane.getChildren().addAll(imageViewWNB,circle);
                                button.setGraphic(wnbStackPane);
                                break;
                            case 2:
                                ImageView imageViewWBC = new ImageView(whiteBishopC);
                                StackPane wbcStackPane = new StackPane();
                                wbcStackPane.getChildren().addAll(imageViewWBC,circle);
                                button.setGraphic(wbcStackPane);
                                break;
                            case 3:
                                ImageView imageViewWQ = new ImageView(whiteQueen);
                                StackPane wqStackPane = new StackPane();
                                wqStackPane.getChildren().addAll(imageViewWQ,circle);
                                button.setGraphic(wqStackPane);
                                break;
                            case 4:
                                ImageView imageViewWK = new ImageView(whiteKing);
                                StackPane wkStackPane = new StackPane();
                                wkStackPane.getChildren().addAll(imageViewWK,circle);
                                button.setGraphic(wkStackPane);
                                break;
                            case 5:
                                ImageView imageViewWBF = new ImageView(whiteBishopF);
                                StackPane wbfStackPane = new StackPane();
                                wbfStackPane.getChildren().addAll(imageViewWBF,circle);
                                button.setGraphic(wbfStackPane);
                                break;
                            case 6:
                                ImageView imageViewWNG = new ImageView(whiteKnightG);
                                StackPane wngStackPane = new StackPane();
                                wngStackPane.getChildren().addAll(imageViewWNG,circle);
                                button.setGraphic(wngStackPane);
                                break;
                            case 7:
                                ImageView imageViewWRH = new ImageView(whiteRookH);
                                StackPane wrhStackPane = new StackPane();
                                wrhStackPane.getChildren().addAll(imageViewWRH,circle);
                                button.setGraphic(wrhStackPane);
                                break;
                        }
                        break;


                    default: // for the empty spaces

                        ImageView blankView = new ImageView();
                        StackPane blankStackPane = new StackPane();
                        blankStackPane.getChildren().addAll(blankView,circle);
                        button.setGraphic(blankStackPane);
                }


                if((row + col) % 2 == 0){
                    button.setStyle("-fx-background-color: rgb(238,238,210);");



                } else{
                    //button.setStyle("-fx-background-color: " + toRgbString(blue));
                    button.setStyle("-fx-background-color: rgb(118,150,86);");


//                    button.setStyle("-fx-background-color: blue;");

                }

                gridPane.add(button,col,row);
            }
        }

        getChildren().add(gridPane);
    }
    public ToggleButton[][] getToggleButtons(){return buttons;}
    public Circle[][] getCircles(){return circles;}

    public void changeGraphic(Game model, Piece piece, int[] square){
            ImageView changedView;
            if(piece instanceof Pawn) { // loop through 4th or 5th rank to see if en passant applies
                if (piece.colour.equals("White")) {
                    if(model.blackPawnJustMovedTwo(new int[]{square[0]+1,square[1]})){
                        // en passant applies
                        ImageView passantView = new ImageView();
                        StackPane blankPane = new StackPane();
                        blankPane.getChildren().addAll(passantView, circles[square[0]+1][square[1]]);
                        buttons[square[0]+1][square[1]].setGraphic(blankPane);
                    }
                    changedView = new ImageView(whitePawnA);
                } else {
                    if(model.whitePawnJustMovedTwo(new int[]{square[0]-1,square[1]})){
                        // en passant applies
                        ImageView passantView = new ImageView();
                        StackPane blankPane = new StackPane();
                        blankPane.getChildren().addAll(passantView, circles[square[0]-1][square[1]]);
                        buttons[square[0]-1][square[1]].setGraphic(blankPane);
                    }
                    changedView = new ImageView(blackPawnA);
                }
            } else if (piece instanceof Knight) {
                if (piece.colour.equals("White")) {
                    changedView = new ImageView(whiteKnightB);
                } else{
                    changedView = new ImageView(blackKnightB);
                }
            } else if (piece instanceof Bishop) {
                if(piece.colour.equals("White")) {
                    changedView = new ImageView(whiteBishopC);
                } else{
                    changedView = new ImageView(blackBishopC);
                }
            } else if (piece instanceof Rook) {
                if(piece.colour.equals("White")) {
                    changedView = new ImageView(whiteRookA);
                } else{
                    changedView = new ImageView(blackRookA);
                }
            } else if (piece instanceof Queen) {
                if(piece.colour.equals("White")) {
                    changedView = new ImageView(whiteQueen);
                } else {
                    changedView = new ImageView(blackQueen);
                }
            } else { // king case
                if(piece.colour.equals("White")) {
                    changedView = new ImageView(whiteKing);
                } else{
                    changedView = new ImageView(blackKing);
                }
            }

                StackPane wqStackPane = new StackPane();
                wqStackPane.getChildren().addAll(changedView, circles[square[0]][square[1]]);
                buttons[square[0]][square[1]].setGraphic(wqStackPane);

                ImageView blankView = new ImageView();
                StackPane blankPane = new StackPane();
                blankPane.getChildren().addAll(blankView, circles[piece.currentSquare[0]][piece.currentSquare[1]]);
                buttons[piece.currentSquare[0]][piece.currentSquare[1]].setGraphic(blankPane);
            }
}
