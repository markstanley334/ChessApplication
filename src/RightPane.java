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


    public Button getForwardsButton() {return forwardsButton;}

    public Button getBackwardsButton() {return backwardsButton;}

    public Button getResetButton() { return  resetButton;}

    public Button getFlipBoardButton() { return flipBoardButton;}

    public RightPane() {

        VBox vbox = new VBox(20);

        vbox.relocate(0,50);

        HBox listViews = new HBox();

        moveNumbers = new ListView<>();
        moveNumbers.setPrefSize(50,700);

        whiteMoves = new ListView<>();
        whiteMoves.setPrefSize(200,700);

        blackMoves = new ListView<>();
        blackMoves.setPrefSize(200,700);

        listViews.getChildren().addAll(moveNumbers,whiteMoves,blackMoves);


        HBox buttonBox = new HBox(10);



        forwardsButton = new Button("->");
        forwardsButton.setStyle("-fx-font: 12 arial;");
        forwardsButton.setPrefSize(105,40);

        backwardsButton = new Button("<-");
        backwardsButton.setStyle("-fx-font: 12 arial;");
        backwardsButton.setPrefSize(105,40);

        resetButton = new Button("Restart game");
        resetButton.setStyle("-fx-font: 12 arial;");
        resetButton.setPrefSize(105,40);

        flipBoardButton = new Button("Flip Board");
        flipBoardButton.setStyle("-fx-font: 12 arial;");
        flipBoardButton.setPrefSize(105,40);


        buttonBox.getChildren().addAll(backwardsButton,forwardsButton,resetButton,flipBoardButton);


        vbox.getChildren().addAll(listViews,buttonBox);

        getChildren().addAll(vbox);
    }
}
