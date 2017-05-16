package com.airRail.Controller;

import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airRail.Helper.contact;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ContactServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = "Contact";
		request.setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request, response);
		request.getSession().removeAttribute("submission_status");
		System.out.println("After");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DB db = (new MongoClient("localhost",27017)).getDB("AirRailConnectivity"); 
		DBCollection dbc = db.getCollection("contact");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		
		System.out.println(" my name is = "+name);
		if(name.isEmpty() || email.isEmpty() || subject.isEmpty() || message.isEmpty()){
			String value="2";
			request.getSession().setAttribute("submission_status",value);
			response.sendRedirect(request.getContextPath() + "/contact");
		}
		else{
		contact contact = new contact();
		contact.setName(name);
		contact.setEmail(email);
		contact.setSubject(subject);
		contact.setMessage(message);
		
		Gson gson = new Gson();
		String json = gson.toJson(contact);
		
		BasicDBObject obj = (BasicDBObject) JSON.parse(json);
		dbc.insert(obj);
		
		String val="1";
		request.getSession().setAttribute("submission_status",val);
		response.sendRedirect(request.getContextPath() + "/contact");
		
		}
	}

}
