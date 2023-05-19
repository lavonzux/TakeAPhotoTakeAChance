package com.ex2.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

@WebServlet("/GetEvent")
public class GetEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;   

    public GetEvent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String eventID = request.getParameter("eventID");
		System.out.println(eventID);
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/remoteServer");
			conn = ds.getConnection();
			String sql = "select * from Event where eventID =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, eventID);
			ResultSet rs = stmt.executeQuery();
			EventBean event = new EventBean();
			if(rs.next()) {
				event.setEventID(rs.getInt("eventID"));
				event.setMemberID(rs.getInt("memberID"));
				event.setEventType(rs.getString("eventType"));
				event.setEventTopic(rs.getString("eventTopic"));
				event.setEventInfo(rs.getString("eventInfo"));
				event.setEventDate(rs.getDate("eventDate"));
			}
			request.setAttribute("event", event);
			stmt.close();
			request.getRequestDispatcher("/html/Event/GetEvent.jsp").forward(request, response);
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