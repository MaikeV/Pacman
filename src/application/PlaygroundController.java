package application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PlaygroundController extends Application {

	public static Stage stage;
	double posX;
	double posY;

	@FXML
	MenuItem mi_close;

	@FXML
	GridPane grd_map;

	@FXML
	ImageView frodo;

	@FXML
	Pane map;

	@FXML
	Button btn_start;

	@Override
	public void start(Stage stage) throws Exception {
		PlaygroundController.stage = stage;
		Parent root = (Pane) FXMLLoader.load(getClass().getResource("PlaygroundNew.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Pacman");
		stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	@FXML
	public void startGame() {
		setStartPosition();

		frodo.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {

				if (event.getCode().equals(KeyCode.UP)) {
					moveUp(getPositionY());
				} else if (event.getCode().equals(KeyCode.DOWN)) {
					moveDown(getPositionY());
				} else if (event.getCode().equals(KeyCode.RIGHT)) {
					moveRight(getPositionX());
				} else if (event.getCode().equals(KeyCode.LEFT)) {
					moveLeft(getPositionX());
				}

			}
		});
		frodo.setFocusTraversable(true);
	}

	public void setStartPosition() {
		frodo.setLayoutX(10);
		frodo.setLayoutY(340);
	}

	public double getPositionX() {
		posX = frodo.getTranslateX();

		return posX;
	}

	public double getPositionY() {
		posY = frodo.getTranslateY();

		return posY;
	}

	public void moveLeft(double posX) {
		double newPosX = posX - 10.0;

		frodo.setTranslateX(newPosX);

	}

	public void moveRight(double posX) {
		double newPosX = posX + 10.0;

		frodo.setTranslateX(newPosX);

	}

	public void moveUp(double posY) {
		double newPosY = posY - 10.0;

		frodo.setTranslateY(newPosY);

	}

	public void moveDown(double posY) {
		double newPosY = posY + 10.0;

		frodo.setTranslateY(newPosY);

	}

	public void collectRing() {

	}

	@FXML
	public void close() {
		Stage thisStage = (Stage) grd_map.getScene().getWindow();
		thisStage.close();
	}

}
