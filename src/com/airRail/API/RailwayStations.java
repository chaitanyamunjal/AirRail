package com.airRail.API;

import org.json.JSONObject;

import com.airRail.Config;
import com.airRail.Model.LowFaresMain;
import com.airRail.Model.RailwayStationsCode;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RailwayStations {

	public String findStationsCode(String partialStation){
		// http://api.railwayapi.com/suggest_station/name/<partial station name>/apikey/<apikey>/
		
		Client client = Client.create();
		System.out.println("http://api.railwayapi.com/suggest_station/name/"+partialStation+"/apikey/"+Config.railwayKey+"/");
		WebResource webResource2 = client.resource("http://api.railwayapi.com/suggest_station/name/"+partialStation+"/apikey/"+Config.railwayKey+"/");
		ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
		if (response2.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
		}

		String output2 = response2.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        // JSON to JAVA Object of POJO Class ( LowFaresMain )
        RailwayStationsCode station_code = new Gson().fromJson(output2,RailwayStationsCode.class);
        
        System.out.println("*************************"+station_code.getStation().get(1).getCode());
        return station_code.getStation().get(1).getCode();
        
	}
}
