package com.airRail.API;

// CONSUMING THE GOOGLE MAPS API
import javax.ws.rs.core.MultivaluedMap;


import org.json.JSONArray;
import org.json.JSONObject;
import com.airRail.Config;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class GoogleMapsService {

	public String findNearestCity(String to) {
		Client client = Client.create();
		
		// set the URL to retrieve data from
		WebResource webResource = client.resource("https://maps.googleapis.com/maps/api/distancematrix/json");
		
		// create a map to set the query parameters
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

		// add the API key and the country to the query params
		queryParams.add("key", Config.googleKey);
		queryParams.add("origins", "delhi|mumbai|chennai|bengaluru|kolkata");
		queryParams.add("destinations", to);
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		String output2 = apiResponse.getEntity(String.class);
        JSONObject json = new JSONObject(output2);
        
        System.out.println(output2);
        
        // array
        JSONArray rows = json.getJSONArray("rows");
        int index = -1;
        int minValue = Integer.MAX_VALUE;
        
        for(int i = 0; i < rows.length(); i++) {
        	JSONArray elements= rows.getJSONObject(i).getJSONArray("elements");
        	
        	for(int j = 0; j < elements.length(); j++) {
        		JSONObject distance = elements.getJSONObject(j).getJSONObject("distance");
	        
	        
		        int distance_value = distance.getInt("value");
		        if(distance_value < minValue) {
		        	minValue = distance_value;
		        	index = i;
		        }
	        
        	}
        }
        
        
        String city;
        if(index == 0){
        	city = "Delhi";
        }
        else if(index == 1){
        	city = "Mumbai";
        }
        else if(index == 2){
        	city = "Chennai";
        }
		else if(index == 3){
        	city = "Bengaluru";
		}
		else{
        	city = "Kolkata";
		}
        
        return city;
	}
}
