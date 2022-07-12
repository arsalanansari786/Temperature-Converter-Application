package Arsalan;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public Button convertButton;
	@FXML
	public TextField userInputField;
	boolean isC_To_F=true;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		convertButton.setOnAction(event -> convert());
		choiceBox.getItems().add("Celsius to Fahrenhiet");
		choiceBox.getItems().add("Fahrenhiet to Celsius");
		choiceBox.setValue("Celsius to Fahrenhiet");
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> { if(newValue.equals("Celsius to Fahrenhiet")){ isC_To_F = true;} else{isC_To_F=false;} });

		convertButton.setOnAction(event -> {
			System.out.println("Button Clicked");
			convert();
		});
	}

	private void convert() {
		String input =userInputField.getText();
		float enteredTemperature=0.0f;
		float newTemperature=0.0f;
		try{
			enteredTemperature=Float.parseFloat(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Format is entered by user");
			System.out.println(input);
			warnuser();
			return;
		}
		if(isC_To_F){
			 newTemperature = (enteredTemperature * 9 / 5) + 32;
		}
		else { newTemperature=(enteredTemperature-32)*5/9;}
		display(newTemperature);
	}

	private void display(float newTemperature) {
		String unit=(isC_To_F)?"F":"C";
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is: "+newTemperature+unit);
		alert.show();
	}

	private void warnuser() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("ERROR OCCURED");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();
	}
}
