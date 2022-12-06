package com.example.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.TextField;
import org.json.*;

public class HelloController {
	@FXML
	private Label welcomeText;

	@FXML
	private TextField inputTextField;

	@FXML
	protected void onHelloButtonClick() throws Exception {

		String cityName = inputTextField.getText();
		String latitude = "", longitude = "";
		List<City> cityList = init();

		for (City city : cityList) {
			if (city.getCityName().equals(cityName)) {
				latitude = city.getLatitude();
				longitude = city.getLongitude();
				break;
			} else {
				welcomeText.setText("No information about this city");
			}
		}

		URL url = new URL(
				"https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=f2fc281a5441f9b579a2ef1bf390d3fb"
		);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
		String weatherInfo = bufferedReader.readLine();

		JSONObject jsonObject = new JSONObject(weatherInfo);
		JSONObject jsonObject1 = (JSONObject) jsonObject.get("main");
		String tempTag = String.valueOf(jsonObject1.get("temp"));
		String feelsLikeTeg = String.valueOf(jsonObject1.get("feels_like"));
		String tempMinTag = String.valueOf(jsonObject1.get("temp_min"));
		String tempMaxTag = String.valueOf(jsonObject1.get("temp_max"));

		String temperatureInformation = "Current temperature: " + Math.round(Double.parseDouble(tempTag) - 273) + "\n"
				+ "Temperature feels like: " + Math.round(Double.parseDouble(feelsLikeTeg) - 273)
				+ "\n" + "Temperature min: " + Math.round(Double.parseDouble(tempMinTag) - 273)
				+ "\n" + "Temperature max: " + Math.round(Double.parseDouble(tempMaxTag) - 273) + "\n";

		welcomeText.setText(temperatureInformation);
	}

	private List<City> init() {
		List<City> cityList = new ArrayList<>();
		cityList.add(new City("Madrid", "40.416775", "-3.703790"));
		cityList.add(new City("Valencia", "39.466667", "-0.375000"));
		cityList.add(new City("Toledo", "39.856667", "-4.024444"));
		cityList.add(new City("Granada", "37.178055", "-3.600833"));
		cityList.add(new City("Malaga", "36.719444", "-4.420000"));
		cityList.add(new City("Zaragoza", "41.649693", "-0.887712"));
		cityList.add(new City("Bilbao", "43.262985", "-2.935013"));
		cityList.add(new City("Barcelona", "41.390205", "2.154007"));
		cityList.add(new City("Seville", "37.392529", "-5.994072"));
		cityList.add(new City("Torrent", "39.432236", "-0.472373"));

		return cityList;
	}
}