package com.airRail.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MultivaluedMap;

import org.json.JSONArray;
import org.json.JSONObject;

import com.airRail.API.AttractionService;
import com.airRail.API.ImpedanceService;
import com.airRail.API.GoogleMapsService;
import com.airRail.API.RailwayService;
import com.mongodb.util.JSON;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String page = "Home";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("impedance")){
		
		String directFlights = request.getParameter("directFlights");
		String distance = request.getParameter("distance");
		String costDifference = request.getParameter("costDifference");
		String totalTravelTime = request.getParameter("totalTravelTime");
		String superFastTrains = request.getParameter("superFastTrains");
		String scheduleAlignment = request.getParameter("scheduleAlignment");

        
		// creating object of ImpedanceService CLASS and calling its function getRFCI
		ImpedanceService object = new ImpedanceService();
		String output2 = object.getRFCI(directFlights,distance,costDifference,totalTravelTime,superFastTrains,scheduleAlignment);
		
        // Sending an AJAX Response to the AJAX request received
		response.setContentType("application/json");
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(output2);
		out.flush();
		return;
		}
		
		else if(action.equals("attraction")){
			
			String PerCapitaIncome = request.getParameter("PerCapitaIncome");
			String Population = request.getParameter("Population");
			String CityType = request.getParameter("CityType");
			String CatchmentArea = request.getParameter("CatchmentArea");
			String NicheAttributes = request.getParameter("NicheAttributes");
			String defultValue = "10";
			
			// creating object of ImpedanceService CLASS and calling its function getRFCI
			AttractionService object = new AttractionService();
			String output2 = object.getRFCI(PerCapitaIncome,Population,CityType,CatchmentArea,NicheAttributes,defultValue);
			

	        // Sending an AJAX Response to the AJAX request received
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required json object to the output stream      
			PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(output2);
			out.flush();
			return;
		}
		
		else if(action.equals("railway")){
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String date = request.getParameter("date");	
			// bringing the date into the format -->  dd-mm
			String[] parts = date.split("-");
			String final_date = parts[2].concat("-"+parts[1]);
			System.out.println(final_date+" "+from+" "+to);
			
			// creating object of RailwayService CLASS and calling its function findStations
			RailwayService object = new RailwayService();
			String output2 = object.findStations(from,to,final_date);
			
			
			// Sending an AJAX Response to the AJAX request received
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required json object to the output stream      
			PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(output2);
			out.flush();
			return;

		}
		else{         // GOOGLE MAPS 
			
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			
			System.out.println(from+"  "+to);
			
			// creating object of googlemapsservice CLASS and calling its function findNearestCity
			GoogleMapsService maps = new GoogleMapsService();
	        String city = maps.findNearestCity(to);
			
			// Sending an AJAX Response to the AJAX request received
			response.setContentType("application/json");
			// Get the printwriter object from response to write the required json object to the output stream      
			PrintWriter out = response.getWriter();
			// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
			out.print(city);
			out.flush();
			return;
		}
		
		
		
	}

}
