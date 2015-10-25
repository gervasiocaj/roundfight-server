package com.projetoes.roundfight.android;

import java.util.ArrayList;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Multiplier {

	private static final double USER_LOCATION_DISTANCE_METERS = 200d, PLACE_LOCATION_DISTANCE_METERS = 5d,
			USER_BONUS_POINTS = 0.2d, PLACE_BONUS_POINTS = 1.4d;
	private static final ArrayList<Location> userLocations = new ArrayList<Location>(),
			placesLocations = new ArrayList<Location>();
	
	public static void addPlaceLocation(double lat, double lon, String description) {
		placesLocations.add(new Location(lat, lon, description));
	}
	
	public static void addUserLocation(double lat, double lon) {
		Location temp = new Location(lat, lon, null);
		temp.setCalendar(Calendar.getInstance());
		userLocations.add(temp);
	}

	public static Multiplier getMultiplier(double lat, double lon) {
		double place_mult = 1d, loc_mult = 1d;
		Location newLocation = new Location(lat, lon, null);
		Multiplier result = new Multiplier();
		
		for (Location location : userLocations)
			if (newLocation.distance(location) <= USER_LOCATION_DISTANCE_METERS)
				place_mult += USER_BONUS_POINTS;
		
		for (Location location : placesLocations)
			if (newLocation.distance(location) <= PLACE_LOCATION_DISTANCE_METERS) {
				loc_mult += PLACE_BONUS_POINTS;
				result.setLocal(location.getInfo());
			}
		
		result.setMult(place_mult * loc_mult);
		return result;
		
		// TODO 2.6d, "Subway Centro - Campina Grande"
	}
	
	private double mult = 0d;
	private String local = null;

	public Multiplier() {
	}

	public double getMult() {
		return mult;
	}

	public void setMult(double mult) {
		this.mult = mult;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
