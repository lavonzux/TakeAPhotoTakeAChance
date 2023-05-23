package com.studio.app;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



import com.studio.util.HibernateUtil;
import com.studio.util.StudioDao;

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
            Transaction transaction = session.beginTransaction();

            StudioDao dao = new StudioDao(session);

            boolean deleteResult = dao.deleteStudio(studioID);

            if (deleteResult) {
                transaction.commit();
                request.getRequestDispatcher("../html/studio/Studio.jsp").forward(request, response);
            } else {
                transaction.rollback();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
	}
		

		
		

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
