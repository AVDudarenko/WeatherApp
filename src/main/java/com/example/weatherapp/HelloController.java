package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class HelloController {
	@FXML
	private Label welcomeText;

	@FXML
	protected void onHelloButtonClick() throws Exception {
		URL url = new URL(
				"https://api.openweathermap.org/data/2.5/weather?lat=39.466667&lon=-0.375000&appid=f2fc281a5441f9b579a2ef1bf390d3fb"
		);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
		String weatherInfo = bufferedReader.readLine();
		welcomeText.setText("Welcome to JavaFX Application!" + "\n" + weatherInfo);
	}
}