package com.airRail.API;

import java.util.List;


import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.airRail.Config;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.airRail.Model.CodeConvert;

public class AirportCode {

	public String findAirportCode(String city){
		
		System.out.println(" yooooooo "+city);
		Client client = Client.create();
		WebResource webResource = client.resource("https://api.sandbox.amadeus.com/v1.2/airports/autocomplete");
		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();

		// add the API key and the country to the query params
		queryParams.add("apikey", Config.sandboxKey);
		queryParams.add("term", city);
		queryParams.add("country", "IN");
		
		// fire the request
		ClientResponse apiResponse = webResource.queryParams(queryParams).accept("application/json").get(ClientResponse.class);
		
		String output2 = apiResponse.getEntity(String.class);
		
        TypeToken<List<CodeConvert>> token = new TypeToken<List<CodeConvert>>(){};
        List<CodeConvert> personList = new Gson().fromJson(output2, token.getType());
        
        System.out.println(personList.get(0).getValue());
        return personList.get(0).getValue();
        
        
	}
}
