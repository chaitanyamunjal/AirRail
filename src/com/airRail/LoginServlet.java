package com.airRail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.airRail.signup;
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
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/login1.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		
		if(action.equals("login")){
			
			String username = request.getParameter("username");
			String pass = request.getParameter("pass");
			
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

					request.getSession().setAttribute("name", name);
					request.getSession().setAttribute("un",username);
					response.sendRedirect(request.getContextPath() + "/home");
				}
				else{
					response.sendRedirect(request.getContextPath() + "/login");
				}
			}
			else{
				response.sendRedirect(request.getContextPath() + "/login");
			}
			
		}
		else
		{
			DB db = (new MongoClient("localhost",27017)).getDB("AirRailConnectivity"); 
			DBCollection dbc = db.getCollection("account");
			
			
			// check if the username already exists in the database
			
			String username = request.getParameter("user");
			BasicDBObject query = new BasicDBObject();
			query.put("username",username);

			DBCursor cursor = dbc.find(query);
			int flag = 4;
			try {
			   if(cursor.hasNext()) {
			     flag = 5;
			     System.out.println(cursor.next());
			     
			   }
			} finally {
			   cursor.close();
			}
			// if username already exists
			if(flag == 5){
				
				request.getSession(false).setAttribute("flag", flag);
				System.out.println("flag is 5");
				response.sendRedirect(request.getContextPath() + "/login");
				
			}
			
			// is username does not exist already in the database
			else if(flag == 4){
				signup account = new signup();
				account.setName(request.getParameter("name"));
				account.setUsername(request.getParameter("user"));
				
				// encrypting the password
				String pass = request.getParameter("password");
				String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());
				account.setPassword(hashed);
				
				Gson gson = new Gson();
				String json = gson.toJson(account);
				
				BasicDBObject obj = (BasicDBObject) JSON.parse(json);
				dbc.insert(obj);

				System.out.println("flag is 4");
				request.getSession(false).setAttribute("flag", flag);
				response.sendRedirect(request.getContextPath() + "/login");
			}
		}
		
		
		return;

	}

}
