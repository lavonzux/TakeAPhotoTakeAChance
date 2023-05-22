package com.studio.app;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.studio.util.HibernateUtil;
import com.studio.bean.StudioBean;


@WebServlet("/GetAllStudio")
public class GetAllStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetAllStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.getCurrentSession();
		    Transaction transaction = session.beginTransaction();

			Query<StudioBean> query = session.createQuery("from StudioBean", StudioBean.class);
		    List<StudioBean> studios = query.getResultList();

		    transaction.commit();
		    request.setAttribute("studios", studios);
		    request.getRequestDispatcher("/html/studio/Studio.jsp").forward(request, response);

		} catch (HibernateException e) {
		    e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
