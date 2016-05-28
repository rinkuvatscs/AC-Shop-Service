package com.ac.main.ui;

import org.springframework.util.StringUtils;

import com.ac.main.ApplicationStartPage;
import com.ac.main.connection.SqlConnections;
import com.ac.pojo.ReadEnglishProperties;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class LoginPage extends Application {

	TextField txtUsername;
	PasswordField passwordField;
	Button btnSubmit, btnClear;
	Label lblTitle, lblUsername, lblPassword, lblLoginBy;
	RadioButton radioUser, radioAdmin;
	final ToggleGroup group = new ToggleGroup();

	@Override
	public void start(Stage primaryStage) throws Exception {
		// make the controls
		ReadEnglishProperties readEnglishProperties = new ReadEnglishProperties(ApplicationStartPage.test());

		String style = "-fx-border-color: #000; -fx-padding: 5px;";

		lblTitle = new Label(readEnglishProperties.getTitle());
		lblTitle.setAlignment(Pos.CENTER);
		lblTitle.setStyle("-fx-border-color: #000; -fx-padding: 5px; -fx-size: 15px");

		lblLoginBy = new Label(readEnglishProperties.getLoginby());
		radioUser = new RadioButton(readEnglishProperties.getUser());
		radioUser.setToggleGroup(group);
		radioAdmin = new RadioButton(readEnglishProperties.getAdmin());
		radioAdmin.setToggleGroup(group);

		txtUsername = new TextField();
		passwordField = new PasswordField();
		btnSubmit = new Button(readEnglishProperties.getSubmitbutton());
		btnSubmit.setAlignment(Pos.CENTER);
		btnSubmit.setStyle(style);

		btnClear = new Button(readEnglishProperties.getClearbutton());
		btnClear.setAlignment(Pos.CENTER);
		btnClear.setStyle(style);

		lblUsername = new Label(readEnglishProperties.getUsername());
		// center text in label
		lblUsername.setAlignment(Pos.CENTER);
		// apply ccs-like style to label (yes, you can)
		lblUsername.setStyle(style);
		lblPassword = new Label(readEnglishProperties.getPswd());
		lblPassword.setAlignment(Pos.CENTER);
		lblPassword.setStyle(style);

		// make container for app
		GridPane root = new GridPane();
		GridPane gridPane = new GridPane();
		AnchorPane anchorpane = new AnchorPane();
		TilePane tile = new TilePane();
		tile.setPrefColumns(3);
		// put container in middle of scene
		root.setAlignment(Pos.CENTER);

		// setspacing between controls in grid
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(5, 10, 0, 10));

		// add to grid, cell by cell
		gridPane.add(lblTitle, 0, 0);

		root.add(lblLoginBy, 0, 4);
		root.add(radioUser, 1, 4);
		root.add(radioAdmin, 2, 4);

		root.add(lblUsername, 0, 7);
		root.add(txtUsername, 1, 7);
		root.add(lblPassword, 0, 8);
		root.add(passwordField, 1, 8);
		// last 2 rows span across 2 columns
		// col, rol, colspan, rowspan
		root.add(btnClear, 0, 9);
		root.add(btnSubmit, 1, 9);

		anchorpane.getChildren().addAll(gridPane, root);
		// set widths of all controls in separate method
		setWidths();
		// attach buttons to code in separate method
		attachCode();
		// usual stuff
		Scene scene = new Scene(anchorpane, 300, 250);
		primaryStage.setTitle("Ac Shop 1.0");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public void setWidths() {
		// set widths of all controls
		// lblUsername.setPrefWidth(70);
		lblTitle.setPrefWidth(270);
		btnClear.setPrefWidth(75);
		btnSubmit.setPrefWidth(75);
		lblPassword.setPrefWidth(75);
		lblUsername.setPrefWidth(75);
		txtUsername.setPrefWidth(100);
		passwordField.setPrefWidth(100);
	}

	public void attachCode() {
		// have each button run BTNCODE when clicked
		btnSubmit.setOnAction(e -> btncode(e));
		btnClear.setOnAction(e -> btncode(e));
	}

	public void btncode(ActionEvent e) {
		// e tells us which button was clicked
		if (e.getSource() == btnClear) {
			txtUsername.setText("");
			passwordField.setText("");
			txtUsername.requestFocus();
			System.out.println(radioAdmin.getText());

			// return;
		}
		if (e.getSource() == btnSubmit) {
			String role = null;
			if (radioAdmin.isSelected()) {
				role = radioAdmin.getText();
			} else if (radioUser.isSelected()) {
				role = radioUser.getText();
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Please select one of the option in Login As");
				alert.showAndWait();
			}
			System.out.println(radioAdmin.getAccessibleText());
			if (!StringUtils.isEmpty(txtUsername.getText()) && !StringUtils.isEmpty(passwordField)) {

				SqlConnections sqlConnections = new SqlConnections();
				String response = sqlConnections.connections(txtUsername.getText(), passwordField.getText(), role);
				if (!StringUtils.isEmpty(response)) {
					System.out.println("Hello logged in");
				}
			}

		}
	}
}
