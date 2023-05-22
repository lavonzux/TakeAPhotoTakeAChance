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


@WebServlet("/GetStudio")
public class GetStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
		    SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.getCurrentSession();
		    Transaction transaction = session.beginTransaction();

		    String studioName = request.getParameter("studioName");
		    String queryString = "FROM StudioBean WHERE studioName LIKE :studioName";
		    Query<StudioBean> query = session.createQuery(queryString, StudioBean.class);
		    query.setParameter("studioName", "%" + studioName + "%");
		    StudioBean studio = query.uniqueResult();

		    transaction.commit();
		    request.setAttribute("studio", studio);
		    request.getRequestDispatcher("/studio/GetStudio.jsp").forward(request, response);

		} catch (HibernateException e) {
		    e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}