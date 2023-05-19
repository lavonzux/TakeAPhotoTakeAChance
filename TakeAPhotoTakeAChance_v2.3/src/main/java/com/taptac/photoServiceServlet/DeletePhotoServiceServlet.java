package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeletePhotoServiceServlet")
public class DeletePhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
    public DeletePhotoServiceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("==========>>> STARTING OF DeletePSServlet.doGet() <<<==========");
		try {

			PhotoServiceBean queryBean = new PhotoServiceBean();
			PhotoServiceDAO psDAO = new PhotoServiceDAO();
			
			
			queryBean.setServiceID(Integer.parseInt(request.getParameter("serviceID")));
			PhotoServiceBean resultBean = psDAO.readEntry(queryBean);
			
			request.setAttribute("resultBean", resultBean);
			
			
			for (String string : resultBean.getAllFields()) System.out.print(string+"::");
			System.out.println();

			
			
			
			
			String confirmParam = request.getParameter("confirmed");
			boolean confirmedDelete = false;
			
			if (confirmParam != null) {
				confirmedDelete = confirmParam.equalsIgnoreCase("YES") || confirmParam.equalsIgnoreCase("Y");
			}
			
			if (confirmedDelete) {
				boolean deleteResult = psDAO.deleteEntry(queryBean);
				if (deleteResult) {
					System.out.println("==========>>> deleteEntry() success <<<==========");
				}
			}
			
			
			
			
			psDAO.closeConnection();
			System.out.println("==========>>> ENDING OF DeletePSServlet.doGet() <<<==========");

			if (confirmedDelete) {
				System.out.println("Confirmed delete, goto ConfirmDeletedPhotoService");
				request.getRequestDispatcher("/html/PhotoService/ConfirmDeletedPhotoService.jsp").forward(request, response);
			}else {
				System.out.println("Not confirmed yet, goto DeletePhotoService for confimation");
				request.getRequestDispatcher("/html/PhotoService/DeletePhotoService.jsp").forward(request, response);
				
			}
			
			
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
