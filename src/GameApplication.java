import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class GameApplication extends Application {

    private Game model;

    public void start(Stage primaryStage) {

        model = new Game();
        Pane aStartingPane = new Pane();
        GameView view = new GameView();
        aStartingPane.getChildren().add(view);

        view.update(model,false);

        ToggleButton[][] buttons = view.getBoardGridPane().getToggleButtons();
        if (buttons == null) {
            System.out.println("toggleButtons is null");
        }


        primaryStage.setTitle("Chess Application");

        view.getFbButtonPane().getForwardsButton().setOnAction(event -> {
            System.out.println("The forwards button is working");
        });

        view.getFbButtonPane().getBackwardsButton().setOnAction(actionEvent -> {
            System.out.println("The backwards button is working");
        });

        view.getFbButtonPane().getResetButton().setOnAction(actionEvent -> {
                System.out.println("The reset button is working");

        });

        view.getFbButtonPane().getFlipBoardButton().setOnAction(actionEvent -> {
            System.out.println("The flip board button is working");
        });

        for(int row = 0; row<8; row++) {
            for (int col = 0; col < 8; col++) {
                int[] buttonCoordinates = new int[2];
                buttonCoordinates[0] = row; // save the coordinates for later
                buttonCoordinates[1] = col;
                final int finalRow = row;
                final int finalCol = col;
                view.getBoardGridPane().getToggleButtons()[finalRow][finalCol].setOnMousePressed(event -> {
                    System.out.println("button: (" + finalRow + "," + finalCol + ")");
                    System.out.println("testing coords:" + buttonCoordinates[0]+buttonCoordinates[1]);

                    // loop through all pieces of colour and turn off buttons
                    // each square has a transparent circle that lights up if a piece can move there.
                    // if a piece can be captured, add a dark border around the square
                });
            }
        }

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aStartingPane,1350,850));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Initialize/start
    }
}
