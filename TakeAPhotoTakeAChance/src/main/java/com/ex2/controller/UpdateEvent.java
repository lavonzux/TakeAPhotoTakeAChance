package com.ex2.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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

import com.ex2.bean.EventBean;
import com.ex2.dao.EventDAO;


@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public UpdateEvent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		try {
			EventDAO dao = new EventDAO();
			EventBean event = new EventBean();
			event.setEventID(Integer.parseInt(request.getParameter("eventID")));
			event.setMemberID(Integer.parseInt(request.getParameter("memberID")));
			event.setEventType(request.getParameter("eventType"));
			event.setEventTopic(request.getParameter("eventTopic"));
			event.setEventInfo(request.getParameter("eventInfo"));
			event.setEventDate(Date.valueOf(request.getParameter("eventDate")));
			dao.updateEvent(event);
			request.getRequestDispatcher("/GetAllEvents").forward(request, response);
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
