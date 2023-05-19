package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.naming.NamingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * PhotoServiceDAO, in charge of accessing data for PhotoService table
 */
@WebServlet("/CreatePhotoServiceServlet")
public class CreatePhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public CreatePhotoServiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		
		try {
			System.out.println("==========>>> STARTING OF PSServlet.doGet() <<<==========");

			PhotoServiceBean createBean = new PhotoServiceBean();
			PhotoServiceDAO psDAO = new PhotoServiceDAO();
			
			
			System.out.println(request.getParameter("serviceID"));
			System.out.println(request.getParameter("serviceName"));
			System.out.println(request.getParameter("serviceType"));
			System.out.println(request.getParameter("servicePrice"));
			System.out.println(request.getParameter("serviceDuration"));
			System.out.println(request.getParameter("serviceLocation"));
			System.out.println(request.getParameter("serviceCreator"));
			
			createBean.setAll(
					Integer.parseInt(request.getParameter("serviceID")), 
					request.getParameter("serviceName"), 
					request.getParameter("serviceType"), 
					request.getParameter("servicePrice"), 
					request.getParameter("serviceDuration"), 
					request.getParameter("serviceLocation"), 
					request.getParameter("serviceCreator")
					);
			
			boolean createResult = psDAO.createEntry(createBean);
			
			PhotoServiceBean resultBean = psDAO.readEntry(createBean);
			
			request.setAttribute("resultBean", resultBean);
			
			
			
			if (createResult) {
				System.out.println("==========>>> Below Entry Inserted <<<==========");
				String[] attrs = resultBean.getAllFields();
				for (String string : attrs) {
					System.out.println(string);
				}
			}
			
			psDAO.closeConnection();
			System.out.println("==========>>> ENDING OF PSServlet.doGet() <<<==========");
			request.getRequestDispatcher("/html/PhotoService/CreatePhotoService.jsp").forward(request, response);
			
			
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
