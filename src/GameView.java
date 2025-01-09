import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameView extends Pane {
    private RightPane rightPane;

    private BoardPane boardGridPane;

    private ListView<Integer> moveNumbers;
    private ListView<String> whiteMoves;
    private ListView<String> blackMoves;

    public RightPane getFbButtonPane(){
        return rightPane;
    }

    public BoardPane getBoardGridPane(){return boardGridPane;}
    public GameView(){

        HBox hbox = new HBox(20);


        Label label1 = new Label("Mark Stanley: Chess Application");
        label1.relocate(300, 10);
        label1.setStyle("-fx-font-size:20");


        rightPane = new RightPane();
        boardGridPane = new BoardPane();

        hbox.getChildren().addAll(boardGridPane,rightPane);

        getChildren().addAll(label1,hbox);

        setPrefSize(1350,850);
    }
    public void update(Game model, boolean reset){
            if(reset){
                System.out.println("resetting board");
            } else{

            }
    }


}
