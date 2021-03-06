package io.xpx.main.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController extends AbstractController implements Initializable {

	@FXML
	private Pane loginPane;
	@FXML
	private TextField addressField;
	@FXML
	private PasswordField passwordField;
	private Alert alert;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void login(ActionEvent event) {
		try {
			// validate
			try {
				runMonitorTool();
			} catch (Exception e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error logging in");
				alert.setContentText("Invalid Identity combination");
				alert.show();
				e.printStackTrace();
				return;
			}

			// load
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ui/FileUploaderModal.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			// hide
			loginPane.getScene().getWindow().hide();

		} catch (IOException e) {
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Initializing..");
			alert.setContentText("Initializing Daemon... please try again..");
			alert.show();
			
		}
	}

	public void register(Event event) {
		try {
			// validate
			try {
				runMonitorTool();
			} catch (Exception e) {
				alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error logging in");
				alert.setContentText("Invalid Identity combination");
				alert.show();
				e.printStackTrace();
				return;
			}

			// load
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ui/ImageLoader.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

			// hide
			loginPane.getScene().getWindow().hide();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void runMonitorTool() throws Exception {

		// // WebSockets listener for NEM
		// WsNemTransactionMonitor.networkName(credentials.getNemNetwork().toLowerCase())
		// .host("104.128.226.60")
		// .port("7890")
		// .wsPort("7778")
		// .addressesToMonitor(UserSessionContext.getAddress())
		// .subscribe(io.nem.utils.Constants.URL_WS_TRANSACTIONS,
		// new NemTransactionHandler(UserSessionContext.getAddress()))
		// .monitor();

	}
}
