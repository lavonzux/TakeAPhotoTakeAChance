package com.studio.app;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.studio.util.HibernateUtil;
import com.studio.util.StudioDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudio")
public class DeleteStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteStudio() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studioIDString = request.getParameter("studioID");
		int studioID = Integer.parseInt(studioIDString);
        try {
            SessionFactory factory = HibernateUtil.getSessionFactory();
            Session session = factory.getCurrentSession();

            StudioDao dao = new StudioDao(session);
            System.out.println(studioID);
            boolean deleteResult = dao.deleteStudio(studioID);

                request.getRequestDispatcher("/html/studio/Studio.jsp").forward(request, response);


        } catch (HibernateException e) {
            e.printStackTrace();
        }
	}
		

		
		

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
