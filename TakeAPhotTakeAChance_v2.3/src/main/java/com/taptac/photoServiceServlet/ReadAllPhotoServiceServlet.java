package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * PhotoServiceDAO, in charge of accessing data for PhotoService table
 */
@WebServlet("/ReadAllPhotoServiceServlet")
public class ReadAllPhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public ReadAllPhotoServiceServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			System.out.println("==========>>> STARTING OF PSServlet.doGet() <<<==========");

			PhotoServiceDAO psDAO = new PhotoServiceDAO();
			ArrayList<PhotoServiceBean> resultList = psDAO.readAllEntries();
			
			request.setAttribute("resultList", resultList);
			
			
			psDAO.closeConnection();
			
			System.out.println("==========>>> ENDING OF PSServlet.doGet() <<<==========");

//			request.getRequestDispatcher("/html/PhotoService/ReadAllPhotoService.jsp").forward(request, response);
			request.getRequestDispatcher("/html/PhotoService/PhotoServiceManager.jsp").forward(request, response);
			
			
		} catch (NamingException | SQLException e) {
			System.out.println("==========!!! EXEPTION THORWN BY doGet() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! EXEPTION THORWN BY doGet() END: !!!==========");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
