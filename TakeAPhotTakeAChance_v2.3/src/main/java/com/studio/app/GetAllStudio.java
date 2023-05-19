package com.studio.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
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
import com.studio.app.StudioDAO;


@WebServlet("/GetAllStudio")
public class GetAllStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public GetAllStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    try {
	        StudioDAO dao = new StudioDAO();
	        List<StudioBean> studios = dao.getAllStudios();
	        request.setAttribute("studios", studios);
	        request.getRequestDispatcher("/html/studio/Studio.jsp").forward(request, response);
	    } catch (SQLException | NamingException e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static List<StudioBean> getAllStudios() {
		// TODO Auto-generated method stub
		return null;
	}

}
