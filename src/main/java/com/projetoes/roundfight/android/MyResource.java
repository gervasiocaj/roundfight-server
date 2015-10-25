package com.projetoes.roundfight.android;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/rf")
public class MyResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getIt() {
    	//Multiplier.addPlaceLocation(lat, lon, "LCC2 - UFCG");
        return "{'data':'hello'}";
    }
    
    @GET
    @Path("/leaderboard")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LeaderboardEntry> getTopLeaderboard() {
    	LeaderboardDAO.getInstance().updateTopScore("me", 1000); // XXX
    	return LeaderboardDAO.getInstance().getTopEntries();
    }
    
    @GET
    @Path("/leaderboard/{user}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LeaderboardEntry> getLeaderboard(@PathParam("user") String user) {
    	return LeaderboardDAO.getInstance().getEntries(user);
    }
    
    @POST
    @Path("/leaderboard/{user}/{points}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateTopScore(@PathParam("user") String user, @PathParam("points") double points) {
    	LeaderboardDAO.getInstance().updateTopScore(user, points);
    	// curl -X POST localhost:8080/RESTful-Server/rf/leaderboard/gervasio/3000
    }
    
    @GET
    @Path("/multiplier/{lat}/{lon}")
    @Produces(MediaType.APPLICATION_JSON)
    public Multiplier getMultiplier(@PathParam("lat") double lat, @PathParam("lon") double lon) {
    	Multiplier result = Multiplier.getMultiplier(lat, lon);
    	Multiplier.addUserLocation(lat, lon);
		return result;
    }
}
