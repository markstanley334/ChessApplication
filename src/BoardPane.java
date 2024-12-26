import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BoardPane extends Pane {

    private ToggleButton[][] buttons;

    public BoardPane(){

        GridPane gridPane = new GridPane();

        gridPane.relocate(50,50);

        int rows = 8;
        int cols = 8;

        // as the images change depending on the specific  piece, each button needs its own imageview

        Image whiteRookA = new Image("whiterook.png");
        Image whiteRookH = new Image("whiterook.png");
        Image whiteKnightB = new Image("whiteknight.png");
        Image whiteKnightG = new Image("whiteknight.png");
        Image whiteBishopC = new Image("whitebishop.png");
        Image whiteBishopF = new Image("whitebishop.png");
        Image whiteQueen = new Image("whitequeen.png");
        Image whiteKing = new Image("whiteking.png");
        Image whitePawnA = new Image("whitepawn.png");
        Image whitePawnB = new Image("whitepawn.png");
        Image whitePawnC = new Image("whitepawn.png");
        Image whitePawnD = new Image("whitepawn.png");
        Image whitePawnE = new Image("whitepawn.png");
        Image whitePawnF = new Image("whitepawn.png");
        Image whitePawnG = new Image("whitepawn.png");
        Image whitePawnH = new Image("whitepawn.png");


        Image blackRookA = new Image("blackrook.png");
        Image blackRookH = new Image("blackrook.png");
        Image blackKnightB = new Image("blackknight.png");
        Image blackKnightG = new Image("blackknight.png");
        Image blackBishopC = new Image("blackbishop.png");
        Image blackBishopF = new Image("blackbishop.png");
        Image blackQueen = new Image("blackqueen.png");
        Image blackKing = new Image("blackking.png");
        Image blackPawnA = new Image("blackpawn.png");
        Image blackPawnB = new Image("blackpawn.png");
        Image blackPawnC = new Image("blackpawn.png");
        Image blackPawnD = new Image("blackpawn.png");
        Image blackPawnE = new Image("blackpawn.png");
        Image blackPawnF = new Image("blackpawn.png");
        Image blackPawnG = new Image("blackpawn.png");
        Image blackPawnH = new Image("blackpawn.png");


        Color lightgray = Color.LIGHTGRAY;
        Color blue = Color.DARKCYAN;

        buttons = new ToggleButton[8][8];

        for(int row = 0; row < rows; row++){
            for( int col = 0; col < cols; col++){
                ToggleButton button = new ToggleButton(); // "" + (row*cols + col + 1)

                button.setPrefSize(95,95);

                buttons[row][col] = button;

                switch(row){

                    case 0:
                        switch(col){
                            case 0:
                                ImageView imageViewBRA = new ImageView(blackRookA);
                                button.setGraphic(imageViewBRA);
                                break;
                            case 1:
                                ImageView imageViewBKB = new ImageView(blackKnightB);
                                button.setGraphic(imageViewBKB);
                                break;
                            case 2:
                                ImageView imageViewBBC = new ImageView(blackBishopC);
                                button.setGraphic(imageViewBBC);
                                break;
                            case 3:
                                ImageView imageViewBQ = new ImageView(blackQueen);
                                button.setGraphic(imageViewBQ);
                                break;
                            case 4:
                                ImageView imageViewBK = new ImageView(blackKing);
                                button.setGraphic(imageViewBK);
                                break;
                            case 5:
                                ImageView imageViewBBF = new ImageView(blackBishopF);
                                button.setGraphic(imageViewBBF);
                                break;
                            case 6:
                                ImageView imageViewBKG = new ImageView(blackKnightG);
                                button.setGraphic(imageViewBKG);
                                break;
                            case 7:
                                ImageView imageViewBRH = new ImageView(blackRookH);
                                button.setGraphic(imageViewBRH);
                                break;
                        }
                        break;

                    case 1:
                        switch(col){
                            case 0:
                                ImageView imageViewBPA = new ImageView(blackPawnA);
                                button.setGraphic(imageViewBPA);
                                break;
                            case 1:
                                ImageView imageViewBPB = new ImageView(blackPawnB);
                                button.setGraphic(imageViewBPB);
                                break;
                            case 2:
                                ImageView imageViewBPC = new ImageView(blackPawnC);
                                button.setGraphic(imageViewBPC);
                                break;
                            case 3:
                                ImageView imageViewBPD = new ImageView(blackPawnD);
                                button.setGraphic(imageViewBPD);
                                break;
                            case 4:
                                ImageView imageViewBPE = new ImageView(blackPawnE);
                                button.setGraphic(imageViewBPE);
                                break;
                            case 5:
                                ImageView imageViewBPF = new ImageView(blackPawnF);
                                button.setGraphic(imageViewBPF);
                                break;
                            case 6:
                                ImageView imageViewBPG = new ImageView(blackPawnG);
                                button.setGraphic(imageViewBPG);
                                break;
                            case 7:
                                ImageView imageViewBPH = new ImageView(blackPawnH);
                                button.setGraphic(imageViewBPH);
                                break;
                        }
                        break;

                    case 6:
                        switch(col){
                            case 0:
                                ImageView imageViewWPA = new ImageView(whitePawnA);
                                button.setGraphic(imageViewWPA);
                                break;
                            case 1:
                                ImageView imageViewWPB = new ImageView(whitePawnB);
                                button.setGraphic(imageViewWPB);
                                break;
                            case 2:
                                ImageView imageViewWPC = new ImageView(whitePawnC);
                                button.setGraphic(imageViewWPC);
                                break;
                            case 3:
                                ImageView imageViewWPD = new ImageView(whitePawnD);
                                button.setGraphic(imageViewWPD);
                                break;
                            case 4:
                                ImageView imageViewWPE = new ImageView(whitePawnE);
                                button.setGraphic(imageViewWPE);
                                break;
                            case 5:
                                ImageView imageViewWPF = new ImageView(whitePawnF);
                                button.setGraphic(imageViewWPF);
                                break;
                            case 6:
                                ImageView imageViewWPG = new ImageView(whitePawnG);
                                button.setGraphic(imageViewWPG);
                                break;
                            case 7:
                                ImageView imageViewWPH = new ImageView(whitePawnH);
                                button.setGraphic(imageViewWPH);
                                break;
                        }

                        break;

                    case 7:
                        switch(col){
                            case 0:
                                ImageView imageViewWRA = new ImageView(whiteRookA);
                                button.setGraphic(imageViewWRA);
                                break;
                            case 1:
                                ImageView imageViewWKB = new ImageView(whiteKnightB);
                                button.setGraphic(imageViewWKB);
                                break;
                            case 2:
                                ImageView imageViewWBC = new ImageView(whiteBishopC);
                                button.setGraphic(imageViewWBC);
                                break;
                            case 3:
                                ImageView imageViewWQ = new ImageView(whiteQueen);
                                button.setGraphic(imageViewWQ);
                                break;
                            case 4:
                                ImageView imageViewWK = new ImageView(whiteKing);
                                button.setGraphic(imageViewWK);
                                break;
                            case 5:
                                ImageView imageViewWBF = new ImageView(whiteBishopF);
                                button.setGraphic(imageViewWBF);
                                break;
                            case 6:
                                ImageView imageViewWKG = new ImageView(whiteKnightG);
                                button.setGraphic(imageViewWKG);
                                break;
                            case 7:
                                ImageView imageViewWRH = new ImageView(whiteRookH);
                                button.setGraphic(imageViewWRH);
                                break;
                        }
                        break;



                }


                if((row + col) % 2 == 0){
                    button.setStyle("-fx-background-color: " + toRgbString(lightgray) + ";");
                } else{
                    button.setStyle("-fx-background-color: " + toRgbString(blue));
                }



                gridPane.add(button,col,row);
            }
        }

        getChildren().add(gridPane);
    }

//    private void buttonEvents(ToggleButton toggleButton, int row, int col){
//        int[] buttonCoordinates = new int[2];
//        buttonCoordinates[0] = row; // save the coordinates for later
//        buttonCoordinates[1] = col;
//        toggleButton.setOnMousePressed(event ->{
//            System.out.println("button: (" + row + "," + col + ")");
//
//        });
//    }

    public ToggleButton[][] getToggleButtons(){return buttons;}

    private String toRgbString(Color color){
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
