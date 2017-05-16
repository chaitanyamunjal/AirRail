package com.airRail.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String page = "Edit";
		request.getSession().setAttribute("page", page);
		request.getRequestDispatcher("WEB-INF/Layout.jsp").forward(request,
				response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		// getting the Hidden Input type " ACTION " value
		String action = request.getParameter("action");
		// connecting to the database
		DB db = (new MongoClient("localhost", 27017)).getDB("AirRailConnectivity");
		DBCollection dbc = db.getCollection("account");
		
		// to check that the image or multipart type file is uploaded
		String contentType = request.getContentType();
		if ((contentType.indexOf("multipart/form-data") >= 0)) {
			
			// getting the username of the logged in user in a string named profilephoto
			String profilePhoto = (String) request.getSession().getAttribute("un");
			try {
				List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				
				String name = "";
				for (FileItem item : multiparts) {
					if (!item.isFormField()) {
						
						// renaming the image file uploaded and adding a " TIMESTAMP " in its name followed by the " username "
						name = new java.util.Date().getTime() + profilePhoto + ".jpg";
						System.out.println(name);
						
						// getting the PATH Dynamically -> where the image file is to be stored
						String relativeWebPath = "\\images";
						String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
						System.out.println(absoluteDiskPath);
						
						// writing the Renamed Image file into the dynamically obtained Location
						item.write(new File(absoluteDiskPath, name));
					}
				}
				
				// Updating the database with the new Name of the Image file
				BasicDBObject updateQuery = new BasicDBObject();
				updateQuery.append("$set",new BasicDBObject().append("pic", name));
	
				BasicDBObject searchQuery3 = new BasicDBObject();
				searchQuery3.append("username",request.getSession().getAttribute("un"));
	
				dbc.updateMulti(searchQuery3, updateQuery);
				request.getSession().setAttribute("pic", name);
		
	
				// File uploaded successfully
				// setting message attribute to be displayed on the front end
				request.setAttribute("message", "File Uploaded Successfully");
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				request.setAttribute("message", "File Upload Failed due to "
						+ ex);
			}
		} 
		
		else {
			// updating the name of the user in the database
			if(action.equals("name")){
				BasicDBObject updateQuery = new BasicDBObject();
				updateQuery.append("$set",new BasicDBObject().append("name",request.getParameter("name")));
	
				BasicDBObject searchQuery3 = new BasicDBObject();
				searchQuery3.append("username",request.getSession().getAttribute("un"));
	
				dbc.updateMulti(searchQuery3, updateQuery);
				request.getSession().setAttribute("name",request.getParameter("name"));

				// setting message attribute to be displayed on the front end
				request.setAttribute("message", "Name Updated Successfully");
			}

			// updating the password of the user in the database
			else if(action.equals("password")){

				// encrypting the password before updating to DB
				String pass = request.getParameter("new_password");
				String hashed = BCrypt.hashpw(pass, BCrypt.gensalt());
				
				
				BasicDBObject updateQuery = new BasicDBObject();
				updateQuery.append("$set",new BasicDBObject().append("password",hashed));

				BasicDBObject searchQuery3 = new BasicDBObject();
				searchQuery3.append("username",request.getSession().getAttribute("un"));
				
				dbc.updateMulti(searchQuery3, updateQuery);
				
				// setting message attribute to be displayed on the front end 
				request.setAttribute("message", "Name Updated Successfully");
			}
		}

		response.sendRedirect(request.getContextPath() + "/account");
	}

}
