import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class BoardPane extends Pane {


    public BoardPane(){


        GridPane gridPane = new GridPane();

        gridPane.relocate(50,50);

        int rows = 8;
        int cols = 8;

        Color lightgray = Color.LIGHTGRAY;
        Color blue = Color.DARKCYAN;

        for(int row = 0; row < rows; row++){
            for( int col = 0; col < cols; col++){
                ToggleButton button = new ToggleButton("" + (row*cols + col + 1));

                button.setPrefSize(95,95);

                Image image = new Image("pawn.png");
                ImageView imageView = new ImageView(image);

                button.setGraphic(imageView);

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


    private String toRgbString(Color color){
        return String.format("#%02X%02X%02X",
                (int) (color.getRed() * 255),
                (int) (color.getGreen() * 255),
                (int) (color.getBlue() * 255));
    }
}
