package com.airRail.API;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class AttractionService {
	
public String getRFCI(String PerCapitaIncome,String Population,String CityType,String CatchmentArea,String NicheAttributes,String defultValue){
	Client client = Client.create();
	WebResource webResource2 = client.resource("http://localhost:8080/AirRailAPI/api/sample/" + PerCapitaIncome + "/" + Population + "/" + CityType + "/" + CatchmentArea + "/" + NicheAttributes+"/" + defultValue);
	ClientResponse response2 = webResource2.accept("application/json").get(ClientResponse.class);
	if (response2.getStatus() != 200) {
		throw new RuntimeException("Failed : HTTP error code : " + response2.getStatus());
	}

	String output2 = response2.getEntity(String.class);
    JSONObject json = new JSONObject(output2);
    
    return output2;
}
}
