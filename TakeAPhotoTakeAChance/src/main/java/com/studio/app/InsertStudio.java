package com.studio.app;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.studio.bean.StudioBean;
import com.studio.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/InsertStudio")
public class InsertStudio extends HttpServlet {
	private static final long serialVersionUID = 1L; 

    public InsertStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
		    SessionFactory factory = HibernateUtil.getSessionFactory();
		    Session session = factory.getCurrentSession();
		    System.out.println("新增資料用");

		    StudioBean studio = new StudioBean();
		    studio.setStudioID(Integer.parseInt(request.getParameter("studioID")));
		    studio.setMemberID(Integer.parseInt(request.getParameter("memberID")));
		    studio.setStudioName(request.getParameter("studioName"));
		    studio.setStudioAddress(request.getParameter("studioAddress"));
		    studio.setStudioLong(Float.parseFloat(request.getParameter("studioLong")));
		    studio.setStudioLat(Float.parseFloat(request.getParameter("studioLat")));
		    studio.setStudioPhone(request.getParameter("studioPhone"));
		    studio.setStudioEmail(request.getParameter("studioEmail"));
		    studio.setStudioTime(request.getParameter("studioTime"));
		    studio.setStudioLink(request.getParameter("studioLink"));
		    studio.setStudioIntro(request.getParameter("studioIntro"));
		    studio.setStudioPicID(Integer.parseInt(request.getParameter("studioPicID")));

		    session.save(studio);

		    request.getRequestDispatcher("/GetAllStudio").forward(request, response);

		} catch (HibernateException e) {
		    e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
