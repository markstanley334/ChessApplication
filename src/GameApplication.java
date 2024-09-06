import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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


        primaryStage.setTitle("Chess Application");

        view.getFbButtonPane().getForwardsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("The forwards button is working");
            }
        });

        view.getFbButtonPane().getBackwardsButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("The backwards button is working");
            }
        });

        view.getFbButtonPane().getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("The reset button is working");
            }
        });

        view.getFbButtonPane().getFlipBoardButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("The flip board button is working");
            }
        });


        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aStartingPane,1350,850));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Initialize/start
    }
}
