package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConfirmUpdatePhotoServiceServlet")
public class ConfirmUpdatePhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ConfirmUpdatePhotoServiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8"); 

		System.out.println("==========>>> STARTING OF ConfirmUpdatePSServlet.doGet() <<<==========");
		try {

			PhotoServiceBean queryBean = new PhotoServiceBean();
			PhotoServiceBean resultBean = new PhotoServiceBean();
			PhotoServiceDAO psDAO = new PhotoServiceDAO();

			queryBean.setServiceID(Integer.parseInt(request.getParameter("serviceID")));
			queryBean.setServiceName(request.getParameter("serviceName"));
			queryBean.setServiceType(request.getParameter("serviceType"));
			queryBean.setServicePrice(request.getParameter("servicePrice"));
			queryBean.setServiceDuration(request.getParameter("serviceDuration"));
			queryBean.setServiceLocation(request.getParameter("serviceLocation"));
			queryBean.setServiceCreator(request.getParameter("serviceCreator"));
			

			boolean updateResult = psDAO.updateEntry(queryBean);
			if (updateResult) {
				System.out.println("==========>>> updateEntry() success <<<==========");
			}
			
			resultBean = psDAO.readEntry(queryBean);
			request.setAttribute("resultBean", resultBean);

			psDAO.closeConnection();
			System.out.println("Updated, goto ConfirmUpdatePhotoService");
			
			System.out.println("==========>>> ENDING OF ConfirmUpdatePSServlet.doGet() <<<==========");
			request.getRequestDispatcher("/html/PhotoService/ConfirmUpdatePhotoService.jsp").forward(request, response);

		} catch (NamingException | SQLException e) {
			System.out.println("==========!!! EXEPTION THORWN BY doGet() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! EXEPTION THORWN BY doGet() END: !!!==========");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
