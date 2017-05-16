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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String token = request.getParameter("google_login");
		request.setAttribute("token",token);
		System.out.println("this is the token"+token);
		if(token!=null){
			response.sendRedirect(request.getContextPath() + "/home");
		}
		String page = "login";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String username = request.getParameter("username");
			String pass = request.getParameter("password");
			
			// query to find user with entered username 
			DB db = (new MongoClient("localhost",27017)).getDB("AirRailConnectivity"); 
			DBCollection dbc = db.getCollection("account");
			
			BasicDBObject query = new BasicDBObject();
			query.put("username",username);

			DBCursor cursor = dbc.find(query);
			
			BasicDBObject object = null;
			
			int flag = 0;
			try {
			   while(cursor.hasNext()) {
			     object = (BasicDBObject) cursor.next();
			     flag = 1;
			   }
			} finally {
			   cursor.close();
			}
			
			
			if(flag == 1){
				
				String password = (String) object.get("password");    // password from the Database
				String name = (String)object.get("name");
				// password.equals(pass)
				if(BCrypt.checkpw(pass, password)){                           // pass is the password entered at the Login Form
					flag = 2;
				}
				
				if(flag == 2){
					
					// AJAX Response to the AJAX Request from Login.jsp  -->> SUCCESS RESPONSE
					response.setContentType("application/json");
					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("un",username);
					request.getSession().setAttribute("pic", (String)object.get("pic"));
					PrintWriter out = response.getWriter();
					out.print("{ \"data\" : \"success\" }"); 
					out.flush();
					
				}
				else{

					// AJAX Response to the AJAX Request from Login.jsp -->> ERROR RESPONSE 
					response.sendError(422);
			        response.setContentType("application/json");
					PrintWriter out = response.getWriter();
					out.print("Invalid Username or Password.");
					out.flush();
					return;
				}
			}
			else{

				// AJAX Response to the AJAX Request from Login.jsp -->> ERROR RESPONSE 
				response.sendError(422);
				response.setContentType("application/json");
				PrintWriter out = response.getWriter();
				out.print("Invalid Username.");
				out.flush();
				return;
			}
			return;

	}

}
