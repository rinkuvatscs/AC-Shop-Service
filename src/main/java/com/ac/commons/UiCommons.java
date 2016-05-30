package com.ac.commons;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;

public class UiCommons {

	public List<TextField> drawTextFields(int n, List<String> data) {

		TextField field;
		List<TextField> textFields = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			field = new TextField(data.get(i));
//			field = new TextField();
			textFields.add(field);
		}
		return textFields;
	}

	public static void main(String[] args) {
		UiCommons commons = new UiCommons();
		List<String> data = new ArrayList<>();
		data.add("Aviral");
		data.add("Mittal");
		commons.drawTextFields(2, data);
	}
}
