package com.projetoes.roundfight.android;

import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.projetoes.roundfight.android.MyResource;

public class MyResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(MyResource.class);
    }

    /**
     * Test to see that the message "Got it!" is sent in the response.
     */
    @Test
    public void testGetIt() {
        final String responseMsg = target().path("rf").request().get(String.class);
        assertEquals("{'data':'hello'}", responseMsg);
    }
    
    @Test
    public void testCurl() {
    	// test leaderboard
        final String leaderboardStart = target().path("rf/leaderboard").request().get(String.class);
        assertEquals("[{\"score\":1000.0,\"user\":\"me\"}]", leaderboardStart);
        
        // test leaderboard addition
        target().path("rf/leaderboard/gervasio/3000").request().post(null);
        final String leaderboardStart1 = target().path("rf/leaderboard").request().get(String.class);
        assertEquals("[{\"score\":3000.0,\"user\":\"gervasio\"},{\"score\":1000.0,\"user\":\"me\"}]", leaderboardStart1);
        
        // test leaderboard update
        target().path("rf/leaderboard/gervasio/4000").request().post(null);
        final String leaderboardStart2 = target().path("rf/leaderboard").request().get(String.class);
        assertEquals("[{\"score\":4000.0,\"user\":\"gervasio\"},{\"score\":1000.0,\"user\":\"me\"}]", leaderboardStart2);
        
        //final String leaderboardUpdate2 = target().path("rf/leaderboard").request().get(String.class);
        //assertEquals("[{\"score\":1000.0,\"user\":\"me\"}]", leaderboardUpdate2);
        
    }
}
