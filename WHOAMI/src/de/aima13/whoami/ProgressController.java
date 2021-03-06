package de.aima13.whoami;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class ProgressController {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="runningBar"
	private ProgressBar runningBar; // Value injected by FXMLLoader

	@FXML // fx:id="mainTextArea"
	private TextArea mainTextArea; // Value injected by FXMLLoader

	@FXML
		// This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		GuiManager.pgController = this;
	}

	public synchronized void addComment(final String comment) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				mainTextArea.appendText(comment + "\n");
			}
		});
	}

	public void finishedScanningClose() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				mainTextArea.getScene().getWindow().hide();
			}
		});
	}

}
