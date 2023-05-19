package com.studio.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


@WebServlet("/GetUpdateStudio")
public class GetUpdateStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public GetUpdateStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String studioID = request.getParameter("studioID");
		System.out.println(studioID);
		try {
	        StudioDAO dao = new StudioDAO();
	        StudioBean studio = dao.getUpdateStudio(studioID);
			request.setAttribute("studio", studio);
			request.getRequestDispatcher("/html/studio/UpdateStudio.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}