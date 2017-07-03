package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MenuController extends Application {

	public static Stage stage;

	@FXML
	Button btn_newGame;

	@FXML
	Button btn_exit;

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("GUIPacman.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setWidth(800.0);
		stage.setHeight(850.0);
		stage.setResizable(false);
		stage.show();
		stage.setTitle("Pacman");

	}

	public void getStyles() {
		btn_newGame.getStyleClass().add("btnStart");
		btn_exit.getStyleClass().add("btnExit");
	}

	public static void main(String[] args) {
		launch(args);
	}

	@FXML
	public void startGame() throws Exception {

		PlaygroundController playground = new PlaygroundController();
		btn_newGame.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				try {
					Stage stage = new Stage();
					playground.start(stage);
					stage.setTitle("Pacman");
					stage.show();
					Stage thisStage = (Stage) btn_exit.getScene().getWindow();
					thisStage.close();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@FXML
	public void close() throws Exception {
		Stage thisStage = (Stage) btn_exit.getScene().getWindow();
		thisStage.close();
	}

}
