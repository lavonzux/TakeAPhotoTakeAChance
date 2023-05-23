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

import com.studio.bean.StudioBean;
import com.studio.util.HibernateUtil;


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

            int studioID = Integer.parseInt(request.getParameter("studioID"));
            System.out.println(studioID);
            String queryString = "FROM StudioBean WHERE studioID = :studioID";
            Query<StudioBean> query = session.createQuery(queryString, StudioBean.class);
            query.setParameter("studioID", studioID);
            StudioBean studio = query.uniqueResult();

            request.setAttribute("studio", studio);
            request.getRequestDispatcher("/html/studio/UpdateStudio.jsp").forward(request, response);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}