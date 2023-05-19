package com.ex2.controller;

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

import com.ex2.bean.EventBean;
import com.ex2.dao.EventDAO;


@WebServlet("/GetAllEvents")
public class GetAllEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public GetAllEvents() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    try {
	        EventDAO dao = new EventDAO();
	        List<EventBean> events = dao.getAllEvents();
	        request.setAttribute("events", events);
	        request.getRequestDispatcher("/html/Event/Event.jsp").forward(request, response);
	    } catch (SQLException | NamingException e) {
	        e.printStackTrace();
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public static List<EventBean> getAllEvents() {
		return null;
	}

}
