package banking.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import banking.model.Navigators;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application implements Initializable{
	@FXML
	private VBox menu;
	@FXML
	private StackPane contentView;

	@FXML
	public void signOut(MouseEvent event) {
		Platform.exit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		menu.getChildren().stream().filter(node -> node instanceof VBox)
		.map(node -> (VBox) node)
		.forEach(box -> {
			String id = box.getId();
			Navigators nav = Navigators.valueOf(id);
			box.setOnMouseClicked(event -> {
				switchView(nav.getViewName());
			});
		});

	}

	private void switchView(String viewName) {
		try {
			Parent view = FXMLLoader.load(getClass().getResource(viewName));
			contentView.getChildren().clear();
			contentView.getChildren().add(view);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("Main.fxml"));
			Scene scene = new Scene(root, 600, 400);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
