package com.ac.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ac.main.ui.LoginPage;
import com.ac.pojo.LoginPagePojo;

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

	public static LoginPagePojo test() {

		String confFile = "ReadPropertiesFile.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(confFile);
		LoginPagePojo readEnglishProperties = (LoginPagePojo) context.getBean("EnglishProperties");
		context.close();
		return readEnglishProperties;
	}
}
