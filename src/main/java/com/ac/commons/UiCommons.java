package com.ac.commons;

import java.util.ArrayList;
import java.util.List;

import com.ac.pojo.TableViewPojo;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UiCommons {
	public List<TextField> drawTextFields(int n) {

		TextField field;
		List<TextField> textFields = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			field = new TextField();
			field.setId("textField-" + i);
			textFields.add(field);
		}
		return textFields;
	}

	public List<Label> drawLabel(int n, List<String> data) {

		Label label;
		List<Label> labels = new ArrayList<Label>();
		for (int i = 0; i < n; i++) {
			label = new Label(data.get(i));
			labels.add(label);
		}
		return labels;
	}

	public List<Button> drawButton(int n, List<String> data) {

		Button button;
		List<Button> buttons = new ArrayList<Button>();
		for (int i = 0; i < n; i++) {
			button = new Button(data.get(i));
			button.setId("button-" + data.get(i));
			buttons.add(button);
		}
		return buttons;
	}

	public void attachCode(Button btn, Stage primaryStage,
			List<TextField> textFields) {
		// have each button run BTNCODE when clicked
		btn.setOnAction(e -> btncode(btn, e, primaryStage, textFields));
	}

	public void btncode(Button btn, ActionEvent e, Stage primaryStage,
			List<TextField> textFields) {

		if (btn.getId().contains("Submit")) {
			for (TextField txt : textFields) {
				System.out.println(txt.getText());
			}
		} else {
			System.exit(0);
		}

	}
	
	public static void tableCreation(String tableTitle , Stage stage, ObservableList<TableViewPojo> tabObservableList) {
		TableView<TableViewPojo> table = new TableView<TableViewPojo>();
		Scene scene = new Scene(new Group());
		stage.setTitle(tableTitle);
		stage.setWidth(450);
		stage.setHeight(500);

		final Label label = new Label(tableTitle);
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);

		TableColumn<TableViewPojo, String> username = new TableColumn<TableViewPojo, String>("Username");
		username.setMinWidth(50);
		username.setCellValueFactory(new PropertyValueFactory<TableViewPojo, String>("username"));

		TableColumn<TableViewPojo, String> name = new TableColumn<TableViewPojo, String>("Name");
		name.setMinWidth(50);
		name.setCellValueFactory(new PropertyValueFactory<TableViewPojo, String>("name"));

		TableColumn<TableViewPojo, String> emailCol = new TableColumn<TableViewPojo, String>("Email");
		emailCol.setMinWidth(180);
		emailCol.setCellValueFactory(new PropertyValueFactory<TableViewPojo, String>("email"));
		
		TableColumn<TableViewPojo, String> mobile = new TableColumn<TableViewPojo, String>("Mobile");
		mobile.setMinWidth(50);
		mobile.setCellValueFactory(new PropertyValueFactory<TableViewPojo, String>("mobile"));
		
		table.setItems(tabObservableList);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		table.getColumns().addAll(username, name, emailCol, mobile);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
		
	}
}
