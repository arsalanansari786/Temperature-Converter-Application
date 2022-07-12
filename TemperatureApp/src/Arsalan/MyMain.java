package Arsalan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

public class MyMain extends Application {
	public static void main(String[] args){
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("Start");
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Arsalan/app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();
	}
	private MenuBar createMenu(){
		Menu filemenu=new Menu("File");
		MenuItem newMenuItem=new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked!"));
		SeparatorMenuItem separatorMenuItem=new SeparatorMenuItem();
		MenuItem quitMenuItem=new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			System.out.println("Quit Menu Item Clicked!");
			Platform.exit();
			System.exit(0);
		});
		filemenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);
		Menu helpmenu=new Menu("Help");
		MenuItem aboutApp=new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpmenu.getItems().addAll(aboutApp);
		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(filemenu,helpmenu);
		return menuBar;
	}

	private static void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("MY first Desktop App");
		alertDialog.setHeaderText("Learnng Java FX");
		alertDialog.setContentText("I am just a beginner but soon I will be pro and start developing awesome Java Games.");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alertDialog.getButtonTypes().setAll(yesBtn, noBtn);
		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn)
			System.out.println("Yes Button is Clicked !");
		else
		{System.out.println("No button is Clicked !");}
	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
		super.stop();
	}
}