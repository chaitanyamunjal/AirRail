package com.airRail.API;

import org.json.JSONObject;

import com.airRail.Config;
import com.airRail.Model.RailwayServiceResults;
import com.airRail.Model.RailwayStationsCode;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RailwayService {

	public String findStations(String from,String to,String final_date){
		
		Client client = Client.create();
		WebResource webResource2 = client.resource("http://api.railwayapi.com/between/source/"+from+"/dest/"+to+"/date/"+final_date+"/apikey/"+Config.railwayKey+"/");
		ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
		
		if (response2.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
		}

		String output2 = response2.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        // JSON to JAVA Object of POJO Class ( LowFaresMain )
        RailwayServiceResults trains = new Gson().fromJson(output2,RailwayServiceResults.class);
        
        System.out.println("total value is = "+trains.getTotal());
        return output2;
	}
}
