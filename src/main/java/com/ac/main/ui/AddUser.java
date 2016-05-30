package com.ac.main.ui;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port.Info;

import org.springframework.util.StringUtils;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.ac.commons.UiCommons;
import com.ac.global.focus.FocusUI;
import com.ac.main.ApplicationStartPage;
import com.ac.pojo.LoginPagePojo;

public class AddUser extends Application {

	Label addUser, lblName, lblMobile, lblEmail, lblUsername, lblPasswrd,
			lblConfirmPswd;
	TextField txtName, txtMobile, txtEmail, txtUsername;
	PasswordField txtPassword, txtConfirmPswd;
	Button btnSubmit, btnCancel;

	@Override
	public void start(Stage primaryStage) throws Exception {

		LoginPagePojo readEnglishProperties = new LoginPagePojo(
				ApplicationStartPage.test());

		addUser = new Label(readEnglishProperties.getAddUser());
		lblName = new Label(readEnglishProperties.getName());
		lblMobile = new Label(readEnglishProperties.getMobile());
		lblEmail = new Label(readEnglishProperties.getEmail());
		lblUsername = new Label(readEnglishProperties.getUsername());
		lblPasswrd = new Label(readEnglishProperties.getPswd());
		lblConfirmPswd = new Label(readEnglishProperties.getConfirmPswd());

		txtName = new TextField();
		txtMobile = new TextField();
		txtEmail = new TextField();
		txtUsername = new TextField();
		txtPassword = new PasswordField();
		txtConfirmPswd = new PasswordField();

		btnSubmit = new Button(readEnglishProperties.getSubmitbutton());
		btnCancel = new Button(readEnglishProperties.getCancel());

		GridPane setTitle = new GridPane();
		setTitle.add(addUser, 0, 0);

		GridPane setComponents = new GridPane();
		setComponents.setHgap(10);
		setComponents.setVgap(10);
		setComponents.setPadding(new Insets(5, 10, 0, 10));

		setComponents.add(lblName, 0, 3);
		setComponents.add(txtName, 1, 3);
		setComponents.add(lblEmail, 0, 4);
		setComponents.add(txtEmail, 1, 4);
		setComponents.add(lblMobile, 0, 5);
		setComponents.add(txtMobile, 1, 5);
		setComponents.add(lblUsername, 0, 6);
		setComponents.add(txtUsername, 1, 6);
		setComponents.add(lblPasswrd, 0, 7);
		setComponents.add(txtPassword, 1, 7);
		setComponents.add(lblConfirmPswd, 0, 8);
		setComponents.add(txtConfirmPswd, 1, 8);
		setComponents.add(btnSubmit, 0, 9);
		setComponents.add(btnCancel, 1, 9);
		
		
		/*UiCommons commons = new UiCommons();
		List<String> data = new ArrayList<>();
		data.add("Aviral");
		data.add("Mittal");
		List<TextField> res = commons.drawTextFields(2, data);
		
		setComponents.add(res.get(0), 0, 10);*/

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.getChildren().addAll(setTitle, setComponents);

		txtName.focusedProperty().addListener(new ChangeListener<Boolean>() {
			
			
			public void changed(ObservableValue<? extends Boolean> observable,
					Boolean oldValue, Boolean newValue) {
				if (oldValue.booleanValue()) {
					FocusUI.focusLost(txtName);
				}
			}

			
		});

		attachCode(primaryStage);

		Scene scene = new Scene(anchorPane, 350, 350);
		scene.getStylesheets().add("css/UI.css");
		primaryStage.setTitle("Welcome Admin");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	


	public void attachCode(Stage primaryStage) {
		// have each button run BTNCODE when clicked
		btnSubmit.setOnAction(e -> btncode(e, primaryStage));
		btnCancel.setOnAction(e -> btncode(e, primaryStage));
	}

	public void btncode(ActionEvent e, Stage primaryStage) {

	}

	public static void main(String[] args) {
		launch(args);
	}

}
