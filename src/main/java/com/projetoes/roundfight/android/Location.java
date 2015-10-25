package com.projetoes.roundfight.android;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {
	
	private static final String METERS = "M";
	private String info;
	private double lat, lon;
	private Calendar calendar = null;
	
	public Location() {
	}

	public Location(double lat, double lon, String info) {
		this.lat = lat;
		this.lon = lon;
		this.info = info;
	}

	public double distance(Location location) {
		return DistanceCalculator.distance(this.lat, this.lon, location.lat, location.lon, METERS);
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	

}
