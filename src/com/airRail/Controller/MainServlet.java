package com.airRail.Controller;

import java.io.IOException;


import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airRail.API.AirportCode;
import com.airRail.API.FlightService;
import com.airRail.API.GoogleMapsService;
import com.airRail.API.RailwayService;
import com.airRail.API.RailwayStations;
import com.airRail.Helper.AirportContainer;
import com.airRail.Helper.Airport;
import com.airRail.Model.LowFaresMain;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MainServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
	    String page = "Main";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
		
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	// STEP 1 -> Finding the Nearest Tier 1 city using google Maps
    	// take from and to value from the Form via AJAX
    	String from = request.getParameter("from");
		String to = request.getParameter("to");
		// Date in yyyy-mm-dd format for Flights API
		String date = request.getParameter("date");
		// date in mm-dd format for railway API
		String date1 = request.getParameter("date1");
		
		System.out.println(from+" "+to+" "+date1);
		// creating object of googlemapsservice CLASS and calling its function findNearestCity to find the Tier 1 City
		GoogleMapsService maps = new GoogleMapsService();
        String city = maps.findNearestCity(to);
		String json_city = "{ \"data\" : \"" + city + "\" }";
        System.out.println(city);
        
        // STEP 2 -> FINDING THE AIRPORT CODE OF " FROM " AND " CITY" Found
        // creating object of AirportCode CLASS and calling its function findAirportCode
        AirportCode code = new AirportCode();
        String source = code.findAirportCode(from);               // to get the airport code of from
        String destination = code.findAirportCode(city);          //  to get the airport code of nearest TIER 1 city found  
		
        // STEP 3 -> FINDING ALL THE FLIGHTS FROM SOURCE TO DESTINATION
        /*---- Pass the " source " and  " destination " -->> which are the airport codes found and pass them as an argument to another function 
          ---  of another API Class to find the flights  ----- */
        FlightService obj = new FlightService();
        String flights = obj.findFlights(source,destination,date);
        
        
        
        // STEP 4 -> Getting the Railway Staion Code
        RailwayStations rail = new RailwayStations();
        String  train_source = rail.findStationsCode(city);
        String  train_destination = rail.findStationsCode(to);
        
        // STEP 5 -> GETTING THE LIST OF TRAINS 
        RailwayService train = new RailwayService();
        String trains = train.findStations(train_source,train_destination,date1);
        
        
        // STEP 6 - COMBINE THE LIST OF FLIGHTS AND LIST OF TRAINS INTO 1 JSON OBJECT
        String bothJson = "["+flights+","+trains+"]";
        
        /* send the list of flights & Trains obtained through AJAX
          Sending an AJAX Response to the AJAX request received */
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(bothJson);
		out.flush();
		return;

	}

}
