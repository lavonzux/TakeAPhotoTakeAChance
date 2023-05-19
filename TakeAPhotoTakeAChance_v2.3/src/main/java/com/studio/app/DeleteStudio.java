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

@WebServlet("/DeleteStudio")
public class DeleteStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteStudio() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studioID = request.getParameter("studioID");
		try {
			System.out.println("==================== Entering DeleteStudio.servlet ====================");
		        StudioDAO dao = new StudioDAO();
		        dao.deleteStudio(studioID);
//		        response.sendRedirect("./layout/Studio.jsp");
		        request.getRequestDispatcher("../html/studio/Studio.jsp").forward(request, response);
		    } catch (NamingException | SQLException e) {
		        e.printStackTrace();
		    }
		}
		

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
