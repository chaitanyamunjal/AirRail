package com.airRail.Controller;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.airRail.Helper.signup;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SignupServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String page = "Signup";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DB db = (new MongoClient("localhost",27017)).getDB("AirRailConnectivity"); 
		DBCollection dbc = db.getCollection("account");
		
		
		// check if the username already exists in the database
		
		// getting the request parameters from AJAX Request from signup.jsp via main.js
		String name = request.getParameter("name"); 
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(name+"  "+username+"  "+email+"  "+password);
		
		BasicDBObject query = new BasicDBObject();
		query.put("username",username);

		DBCursor cursor = dbc.find(query);
		int flag = 0;
		try {
		   if(cursor.hasNext()) {
		     flag = 1;
		     System.out.println(cursor.next());
		     
		   }
		} finally {
		   cursor.close();
		}
		
		
		// if username already exists
		
		if(flag == 1){
			// AJAX Response to the AJAX Request from Login.jsp -->> ERROR RESPONSE 
			response.sendError(422);
	        response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print("Invalid Username.");
			out.flush();
			return;
		}
		
		// if username does not exist already in the database
		
		else if(flag == 0){
			signup account = new signup();
			account.setName(name);
			account.setUsername(username);
			account.setEmail(email);
			account.setPic("default.png");
	
			// encrypting the password
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			account.setPassword(hashed);
			
			Gson gson = new Gson();
			String json = gson.toJson(account);
			
			BasicDBObject obj = (BasicDBObject) JSON.parse(json);
			dbc.insert(obj);
			
			// AJAX Response to the AJAX Request from Login.jsp  -->> SUCCESS RESPONSE
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.print("{ \"data\" : \"success\" }"); 
			out.flush();
		}
	}

}
