package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ReadPhotoServiceServlet")
public class ReadPhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public ReadPhotoServiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("==========>>> START OF ReadPSServlet.doGet() >>>==========");
		try {

			PhotoServiceBean queryBean = new PhotoServiceBean();
			PhotoServiceDAO psDAO = new PhotoServiceDAO();
			
			queryBean.setServiceID(Integer.parseInt(request.getParameter("serviceID")));
			PhotoServiceBean resultBean = psDAO.readEntry(queryBean);
			
			request.setAttribute("resultBean", resultBean);
			System.out.printf("========== result of serviceID: %s has been added ==========%n",resultBean.getServiceID());
			
			psDAO.closeConnection();
			
			System.out.println("==========<<< END OF ReadPSServlet.doGet() <<<==========");
			request.getRequestDispatcher("/html/PhotoService/ReadPhotoService.jsp").forward(request, response);
			
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
