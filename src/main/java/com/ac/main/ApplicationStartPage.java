package com.ac.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ac.main.ui.LoginPage;
import com.ac.pojo.ReadEnglishProperties;

import javafx.application.Application;
import javafx.stage.Stage;

public class ApplicationStartPage extends Application {

	public static void main(String a[]) throws Exception {
		launch(a);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		LoginPage login = new LoginPage();
		login.start(primaryStage);
	}

	public static ReadEnglishProperties test() {

		String confFile = "loc.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		ReadEnglishProperties readEnglishProperties = (ReadEnglishProperties) context.getBean("EnglishProperties");
		context.close();
		return readEnglishProperties;
	}
}
