package com.airRail.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AccountServlet() {
        super();
    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("account servlet working fine");
	
	DB db = (new MongoClient("localhost",27017)).getDB("AirRailConnectivity"); 
	DBCollection dbc = db.getCollection("account");
	
	
	BasicDBObject query = new BasicDBObject();
	query.put("username",request.getSession().getAttribute("un"));

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
	
	String email = null;
	if(flag == 1){
		email = (String)object.get("email");
	}

	request.getSession().setAttribute("email",email);
	
	String page = "Account";
	request.getSession().setAttribute("page", page);
	request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
