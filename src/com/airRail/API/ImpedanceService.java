package com.airRail.API;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ImpedanceService {
	
	public String getRFCI(String directFlights,String distance,String costDifference,String totalTravelTime,String superFastTrains,String scheduleAlignment){
		System.out.println("http://localhost:8080/AirRailAPI/api/sample/" + directFlights + "/" + distance + "/" + costDifference + "/" + totalTravelTime + "/" + superFastTrains + "/" + scheduleAlignment);
		Client client = Client.create();
		WebResource webResource2 = client.resource("http://localhost:8080/AirRailAPI/api/sample/" + directFlights + "/" + distance + "/" + costDifference + "/" + totalTravelTime + "/" + superFastTrains + "/" + scheduleAlignment);
		ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
		if (response2.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
		}

		String output2 = response2.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        return output2;
	}

}
