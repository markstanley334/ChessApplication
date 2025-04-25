import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Arrays;


public class GameApplication extends Application {

    private Game model;

    private ToggleButton[][] buttons;
    private Circle[][] circles;

    private boolean moving;

    private boolean checkmate;
    private boolean stalemate;
    private int indexCount;
    private int kingIndex;

    public void start(Stage primaryStage) {

        model = new Game();
        Pane aStartingPane = new Pane();
        GameView view = new GameView();
        aStartingPane.getChildren().add(view);

        // view.update(model,false);

        checkmate = false;

        buttons = view.getBoardGridPane().getToggleButtons();
        if (buttons == null) {
            System.out.println("toggleButtons is null");
        }

        circles = view.getBoardGridPane().getCircles();
        if(circles == null){
            System.out.println("circles is null");
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
                model = new Game();
                view.update(model,true);
                buttons = view.getBoardGridPane().getToggleButtons();
                circles = view.getBoardGridPane().getCircles();

        });

        view.getFbButtonPane().getFlipBoardButton().setOnAction(actionEvent -> {
            System.out.println("The flip board button is working");
        });


        for(int row = 0; row<8; row++) {
            for (int col = 0; col < 8; col++) {
                final int finalRow = row;
                final int finalCol = col;

                buttons[finalRow][finalCol].setOnMousePressed(event -> { // each button has an event handler

                    moving = true; // we are moving unless a piece of turn colour is selected
                    int[] buttonSquare = {finalRow, finalCol};
                    Piece piece = model.getSquare(buttonSquare); // get the piece that was clicked on

                    for (int r = 0; r < 8; r++) {
                        for (int c = 0; c < 8; c++) {

                            if((r+c)%2==0){
                                buttons[r][c].setStyle("-fx-background-color: rgb(238,238,210); -fx-border-width: 0; -fx-border-color: transparent;"); //make all borders back to normal
                            } else{
                                buttons[r][c].setStyle("-fx-background-color: rgb(118,150,86); -fx-border-width: 0; -fx-border-color: transparent;"); //make all borders back to normal

                            }
                                circles[r][c].setFill(Color.TRANSPARENT); // make all circles disappear
                        }
                    }

                    if (model.turn.equals("White")) {

                        // first of all, update the white pieces
                        stalemate = true;

                        if(model.getMoveNumber() != 0) {
                                indexCount = 0;
                                kingIndex = -1;
                                for(Piece p: model.getWhitePieces()){ // refresh white pieces
                                    if(!(p.name.equals("K"))){
                                        p.refresh(model);
                                        indexCount++;

                                        if(!(p.availableSquares.isEmpty())){ // if any piece can move, there is no stalemate
                                            stalemate = false;
                                        }
                                    } else{
                                        kingIndex = indexCount;
                                    }
                                }

                            model.getWhitePieces().get(kingIndex).refresh(model); // refresh king

                            if(!(model.getWhitePieces().get(kingIndex).availableSquares.isEmpty())){
                                stalemate = false;
                            }

                            if(stalemate){ // if no pieces can move, either checkmate or stalemate
                                if(((King) model.getWhitePieces().get(kingIndex)).getIsInCheck()){
                                    System.out.println("Black wins by checkmate");
                                    checkmate = true;
                                } else{
                                    System.out.println("Draw by stalemate");
                                }

                            }
                        }


                        if (piece != null) {
                            if (piece.colour.equals("White")) { // the piece colour must be White

                                moving = false;

                                // deselect all other buttons
                                deselectExcept(buttonSquare);

                                // System.out.println("got here" + finalRow + finalCol);

                                for (int[] square : piece.availableSquares) {
                                    if (model.hasBlackPiece(square)) {
                                        // border of the square must be made dark
                                        buttons[square[0]][square[1]].setStyle("-fx-border-color: darkgray; -fx-border-width: 3px;");
                                    } else if (model.hasNoPiece(square)) {
                                        // add circle to the square
                                        circles[square[0]][square[1]].setFill(Color.DARKGRAY);

                                    }
                                }
                            }
                        }

                        // loop through the white pieces and see which one is selected

                        if(moving) {
                            for (Piece whitePiece : model.getWhitePieces()) {
                                if (buttons[whitePiece.currentSquare[0]][whitePiece.currentSquare[1]].isSelected() && !(Arrays.equals(whitePiece.currentSquare, buttonSquare))) { // if a white piece is selected
                                    for (int[] square : whitePiece.availableSquares) {
                                        if (Arrays.equals(square, buttonSquare)) { // if the user clicked on an available square
                                            // move the piece
                                            // this block needs to cover captures, (changing images) and promotion.
                                            // captures don't need to be different, as no matter what, the image is changed

                                            // handle pawn and king separately for en passant, promotion, and castling
                                            if(whitePiece instanceof Pawn){
                                                if(square[0] == 0){
                                                    // here we promote the pawn - must first ask user what they want to promote to
                                                    showPromotionWindow("White",view,model,buttonSquare,(Pawn)whitePiece);
                                                    whitePiece.move(buttonSquare, model);
                                                } else {
                                                    view.getBoardGridPane().changeGraphic(model, whitePiece, buttonSquare); // change image
                                                    whitePiece.move(buttonSquare, model);
                                                }
                                            } else if(whitePiece instanceof King){

                                                if(whitePiece.getCurrentSquare()[1] - buttonSquare[1] > 1 || whitePiece.getCurrentSquare()[1] - buttonSquare[1] < -1){ // if the king moves 2 squares it's a castle
                                                    // place the king and place the rook

                                                    if(buttonSquare[1] == 2){ // Queenside
                                                        int[] rookNewSquare = new int[]{7,3};
                                                        int[] rookCurrSquare = new int[]{7,0};

                                                        view.getBoardGridPane().changeGraphic(model, model.getSquare(rookCurrSquare),rookNewSquare);
                                                        model.getSquare(rookCurrSquare).move(rookNewSquare, model);
                                                    } else{ // Kingside
                                                        int[] rookNewSquare = new int[]{7,5};
                                                        int[] rookCurrSquare = new int[]{7,7};

                                                        view.getBoardGridPane().changeGraphic(model, model.getSquare(rookCurrSquare),rookNewSquare);
                                                        model.getSquare(rookCurrSquare).move(rookNewSquare, model);
                                                    }
                                                }

                                                view.getBoardGridPane().changeGraphic(model, whitePiece, buttonSquare); // change image of king
                                                whitePiece.move(buttonSquare, model);
                                            } else { // any other piece

                                                view.getBoardGridPane().changeGraphic(model, whitePiece, buttonSquare); // change image
                                                whitePiece.move(buttonSquare, model);

                                            }

                                            // now we'll update the white pieces again

                                            indexCount = 0;
                                            kingIndex = -1;
                                            for(Piece p: model.getWhitePieces()){ // refresh white pieces
                                                if(!(p.name.equals("K"))){
                                                    p.refresh(model);
                                                    indexCount++;
                                                } else{
                                                    kingIndex = indexCount;
                                                }
                                            }

                                            model.getWhitePieces().get(kingIndex).refresh(model); // refresh king

                                            model.turn = "Black";

                                        }
                                    }
                                    buttons[buttonSquare[0]][buttonSquare[1]].setSelected(false); // deselect button
                                }
                            }
                        }

                    }else { // black turn

                        // first update black pieces

                        stalemate = true;

                        if (model.getMoveNumber() != 0) {
                            indexCount = 0;
                            kingIndex = -1;
                            for (Piece p : model.getBlackPieces()) {
                                if (!(p.name.equals("K"))) {
                                    p.refresh(model);
                                    indexCount++;

                                    if (!(p.availableSquares.isEmpty())) { // if any piece can move, there is no stalemate
                                        stalemate = false;
                                    }
                                } else {
                                    kingIndex = indexCount;
                                }
                            }

                            model.getBlackPieces().get(kingIndex).refresh(model); // refresh king

                            if (!(model.getBlackPieces().get(kingIndex).availableSquares.isEmpty())) {
                                stalemate = false;
                            }

                            if (stalemate) { // if no pieces can move, either checkmate or stalemate
                                if (((King) model.getBlackPieces().get(kingIndex)).getIsInCheck()) {
                                    System.out.println("White wins by checkmate");
                                    checkmate = true;
                                } else {
                                    System.out.println("Draw by stalemate");
                                }

                            }
                        }

                        if (piece != null) {
                            if (piece.colour.equals("Black")) { // the piece colour must be White

                                moving = false;

                                // deselect all other buttons
                                deselectExcept(buttonSquare);

                                // System.out.println("got here" + finalRow + finalCol);

                                for (int[] square : piece.availableSquares) {
                                    if (model.hasWhitePiece(square)) {
                                        // border of the square must be made dark
                                        buttons[square[0]][square[1]].setStyle("-fx-border-color: darkgray; -fx-border-width: 3px;");
                                    } else if (model.hasNoPiece(square)) {
                                        // System.out.println("circle test");
                                        // add circle to the square
                                        circles[square[0]][square[1]].setFill(Color.DARKGRAY);

                                    }
                                }
                            }
                        }

                        if (moving) {
                            for (Piece blackPiece : model.getBlackPieces()) {
                                if (buttons[blackPiece.currentSquare[0]][blackPiece.currentSquare[1]].isSelected() && !(Arrays.equals(blackPiece.currentSquare, buttonSquare))) { // if a black piece is selected
                                    for (int[] square : blackPiece.availableSquares) {
                                        if (Arrays.equals(square, buttonSquare)) { // if the user clicked on an available square
                                            if (blackPiece instanceof Pawn) {
                                                if (square[0] == 7) {
                                                    // promoting pawn
                                                } else {
                                                    view.getBoardGridPane().changeGraphic(model, blackPiece, buttonSquare); // change image
                                                    blackPiece.move(buttonSquare, model);
                                                }
                                            } else if (blackPiece instanceof King) {
                                                if (blackPiece.getCurrentSquare()[1] - buttonSquare[1] > 1 || blackPiece.getCurrentSquare()[1] - buttonSquare[1] < -1) { // if the king moves 2 squares it's a castle
                                                    // place and move the rook
                                                    if (buttonSquare[1] == 2) { // Queenside
                                                        int[] rookNewSquare = new int[]{0, 3};
                                                        int[] rookCurrSquare = new int[]{0, 0};

                                                        view.getBoardGridPane().changeGraphic(model, model.getSquare(rookCurrSquare), rookNewSquare);
                                                        model.getSquare(rookCurrSquare).move(rookNewSquare, model);
                                                    } else { // Kingside
                                                        int[] rookNewSquare = new int[]{0, 5};
                                                        int[] rookCurrSquare = new int[]{0, 7};
                                                        view.getBoardGridPane().changeGraphic(model, model.getSquare(rookCurrSquare), rookNewSquare);
                                                        model.getSquare(rookCurrSquare).move(rookNewSquare, model);
                                                    }
                                                }
                                                view.getBoardGridPane().changeGraphic(model, blackPiece, buttonSquare); // place and move the king
                                                blackPiece.move(buttonSquare, model);
                                            } else { // any other piece
                                                view.getBoardGridPane().changeGraphic(model, blackPiece, buttonSquare); // change image
                                                blackPiece.move(buttonSquare, model);
                                            }

                                            // now refresh all the black pieces

                                            indexCount = 0;
                                            kingIndex = -1;
                                            for (Piece p : model.getBlackPieces()) { // refresh white pieces
                                                if (!(p.name.equals("K"))) {
                                                    p.refresh(model);
                                                    indexCount++;
                                                } else {
                                                    kingIndex = indexCount;
                                                }
                                            }

                                            model.getBlackPieces().get(kingIndex).refresh(model); // refresh king

                                            model.addMoveNumber(1); // new move
                                            model.turn = "White";

                                        }
                                    }
                                    buttons[buttonSquare[0]][buttonSquare[1]].setSelected(false); // deselect button
                                }
                            }
                        }
                    }
                });
            }
        }

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aStartingPane,1350,850));
        primaryStage.show();
    }

    public void deselectExcept(int[] exceptedSquare){
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (r != exceptedSquare[0] || c != exceptedSquare[1]) {
                 buttons[r][c].setSelected(false);
              }
            }
        }
    }


    private void showPromotionWindow(String colour,GameView view,Game model,int[] square,Pawn pawn){
        Stage promotionStage = new Stage();

        Button knightButton = new Button();
        Button bishopButton = new Button();
        Button rookButton = new Button();
        Button queenButton = new Button();

        if(colour.equals("White")){
            // make the images
            Image whiteRook = new Image("whiterook.png");
            Image whiteKnight = new Image("whiteknight.png");
            Image whiteBishop = new Image("whitebishop.png");
            Image whiteQueen = new Image("whitequeen.png");

            ImageView imageViewRook = new ImageView(whiteRook);
            rookButton.setGraphic(imageViewRook);

            ImageView imageViewKnight = new ImageView(whiteKnight);
            knightButton.setGraphic(imageViewKnight);

            ImageView imageViewBishop = new ImageView(whiteBishop);
            bishopButton.setGraphic(imageViewBishop);

            ImageView imageViewQueen = new ImageView(whiteQueen);
            queenButton.setGraphic(imageViewQueen);

        } else{
            Image blackRook = new Image("blackrook.png");
            Image blackKnight = new Image("blackknight.png");
            Image blackBishop = new Image("blackbishop.png");
            Image blackQueen = new Image("blackqueen.png");

            ImageView imageViewRook = new ImageView(blackRook);
            rookButton.setGraphic(imageViewRook);

            ImageView imageViewKnight = new ImageView(blackKnight);
            knightButton.setGraphic(imageViewKnight);

            ImageView imageViewBishop = new ImageView(blackBishop);
            bishopButton.setGraphic(imageViewBishop);

            ImageView imageViewQueen = new ImageView(blackQueen);
            queenButton.setGraphic(imageViewQueen);
        }

        knightButton.setOnAction(actionEvent -> {
            // make the knight
            pawn.setPromoteNumber(3);
            System.out.println(pawn.promoteNumber);

            if(colour.equals("White")){
                Knight dummyKnight = new Knight("","White",new int[]{pawn.getCurrentSquare()[0],pawn.getCurrentSquare()[1]},new int[]{},new ArrayList<int[]>());
                view.getBoardGridPane().changeGraphic(model, dummyKnight, square);
            } else{

            }

            promotionStage.close(); // close the window at the end
        });

        bishopButton.setOnAction(actionEvent -> {
            // make the bishop
            pawn.setPromoteNumber(2);
            promotionStage.close();
        });

        rookButton.setOnAction(actionEvent -> {
            // make the rook
            pawn.setPromoteNumber(1);
            promotionStage.close();
        });

        queenButton.setOnAction(actionEvent ->{
            pawn.setPromoteNumber(0);
            // make the queen


            promotionStage.close();
        });

        HBox promotionLayout = new HBox();
        promotionLayout.getChildren().addAll(knightButton,bishopButton,rookButton,queenButton);

        promotionLayout.setAlignment(Pos.CENTER); // center the buttons

        Scene promotionScene = new Scene(promotionLayout,400,100);

        promotionStage.setTitle("Promoting Piece");
        promotionStage.setScene(promotionScene);

        promotionStage.show(); // display the window

        }


    public static void main(String[] args) {
        launch(args); // Initialize/start
    }
}
