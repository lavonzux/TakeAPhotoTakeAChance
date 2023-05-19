package com.taptac.photoServiceServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePhotoServiceServlet")
public class UpdatePhotoServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdatePhotoServiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8"); 
		System.out.println("==========>>> STARTING OF UpdatePSServlet.doGet() <<<==========");
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
			
			
			String confirmParam = request.getParameter("confirmed");
			System.out.println(confirmParam);
			boolean confirmedUpdate = false;

			if (confirmParam != null) {
				confirmedUpdate = confirmParam.equalsIgnoreCase("YES") || confirmParam.equalsIgnoreCase("Y");
			}
			if (confirmedUpdate) {
				boolean updateResult = psDAO.updateEntry(queryBean);
				if (updateResult) {
					System.out.println("==========>>> updateEntry() success <<<==========");
				}
			}

			resultBean = psDAO.readEntry(queryBean);
			
			psDAO.closeConnection();
			request.setAttribute("resultBean", resultBean);
			psDAO.closeConnection();
			
			System.out.println("==========>>> ENDING OF UpdatePSServlet.doGet() <<<==========");
			if (confirmedUpdate) {
				System.out.println("Updated, goto ConfirmUpdatePhotoService");
				request.getRequestDispatcher("/html/PhotoService/ConfirmUpdatePhotoService.jsp").forward(request, response);
			}else {
				System.out.println("Not confirmed yet, goto UpdatePhotoService for confimation");
				request.getRequestDispatcher("/html/PhotoService/UpdatePhotoService.jsp").forward(request, response);
			}
			

		} catch (NamingException | SQLException e) {
			System.out.println("==========!!! EXEPTION THORWN BY UpdatePSServlet() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! EXEPTION THORWN BY UpdatePSServlet() END: !!!==========");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
