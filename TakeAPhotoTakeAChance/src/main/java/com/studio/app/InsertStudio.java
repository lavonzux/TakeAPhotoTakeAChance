package com.studio.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.studio.bean.StudioBean;


@WebServlet("/InsertStudio")
public class InsertStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public InsertStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try {
			StudioDAO dao = new StudioDAO();
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
			dao.insertStudio(studio);
			request.getRequestDispatcher("/GetAllStudio").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
