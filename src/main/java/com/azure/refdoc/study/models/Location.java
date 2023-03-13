package com.azure.refdoc.study.models;

import java.util.List;

public class Location {
	private String type;
	private List<Double> coordinates;

	public Location() {
	}

	public Location(String type, List<Double> coordinates) {
		this.type = type;
		this.coordinates = coordinates;
	}

	public String getType() {
		return this.type;
	}

	public List<Double> getCoordinates() {
		return this.coordinates;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}
}
