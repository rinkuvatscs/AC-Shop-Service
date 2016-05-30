package com.ac.global.focus;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

import org.springframework.util.StringUtils;

public class FocusUI {

	public static void focusLost(TextField txtName) {
		if (StringUtils.isEmpty(txtName.getText())) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setContentText("Please Enter Name");
			alert.showAndWait();
			txtName.requestFocus();
		}
	}
}
