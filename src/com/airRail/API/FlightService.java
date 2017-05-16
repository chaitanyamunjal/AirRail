package com.airRail.API;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONObject;

import com.airRail.Config;
import com.airRail.Model.CodeConvert;
import com.airRail.Model.LowFaresMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class FlightService {

	public String findFlights(String source,String destination,String date){
		
		Client client = Client.create();
		// set the URL to retrieve data from
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/flights/low-fare-search");
		
		// create a map to set the query parameters
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		
		
		// add the API key and the country to the query params
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("origin", source);
		queryParams.add("destination", destination);
		queryParams.add("departure_date", date);
		queryParams.add("nonstop","true");
		queryParams.add("number_of_results", "5");
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        // JSON to JAVA Object of POJO Class ( LowFaresMain )
        LowFaresMain flightList = new Gson().fromJson(output2,LowFaresMain.class);
        

        return output2;
	}

}
