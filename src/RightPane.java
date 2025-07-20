import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RightPane extends Pane {
    private Button forwardsButton, backwardsButton, flipBoardButton, resetButton;

    private ListView<Integer> moveNumbers;
    private ListView<String> whiteMoves;
    private ListView<String> blackMoves;

    public Button getResetButton() { return  resetButton;}

    public Button getFlipBoardButton() { return flipBoardButton;}

    public RightPane() {
        VBox buttonBox = new VBox(10);
        buttonBox.relocate(50,50);

        resetButton = new Button("Restart game");
        resetButton.setStyle("-fx-font: 12 arial;");
        resetButton.setPrefSize(105,40);

        buttonBox.getChildren().addAll(resetButton);
        getChildren().addAll(buttonBox);
    }
}
