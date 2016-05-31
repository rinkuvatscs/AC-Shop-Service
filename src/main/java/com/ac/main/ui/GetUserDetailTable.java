package com.ac.main.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import com.ac.commons.UiCommons;
import com.ac.pojo.TableViewPojo;

public class GetUserDetailTable extends Application {

	static ObservableList<TableViewPojo> tabObservableList =   FXCollections.observableArrayList();
	
	/*private final ObservableList<TableViewPojo> data =
            FXCollections.observableArrayList(
            new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"),
            new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"),
            new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"),
            new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"),
            new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"));*/
    final HBox hb = new HBox();
	
	public static void main(String[] args) {
		launch(args);
		
	}

	static{
		tabObservableList.add(new TableViewPojo("aviral", "Aviral", "aviral.mittal@example.com","8527701990"));
		tabObservableList.add(new TableViewPojo("rinkuvatscs", "Rinku", "rinkuvatscs@gmail.com","9759569142"));
		tabObservableList.add(new TableViewPojo("goru", "Goru", "gorusantosh@gmail.com","1234567890"));
	}
	
	@Override
	public void start(Stage stage) {
		String tableTitle = "Address Book" ;
		UiCommons.tableCreation(tableTitle, stage , tabObservableList );
	/*	Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(450);
		stage.setHeight(500);

		final Label label = new Label("Address Book");
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

		table.setItems(data);
		table.getColumns().addAll(username, name, emailCol, mobile);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();*/
	}

}
