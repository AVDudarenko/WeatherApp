package com.example.weatherapp;

public class City {

	private final String cityName;
	private final String latitude;
	private final String longitude;

	public City(String cityName, String latitude, String longitude) {
		this.cityName = cityName;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getCityName() {
		return cityName;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}
}
