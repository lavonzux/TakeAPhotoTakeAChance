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


@WebServlet("/GetStudio")
public class GetStudio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection conn;   

    public GetStudio() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String studioName = request.getParameter("studioName");
		System.out.println(studioName);
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/remoteServer");
			conn = ds.getConnection();
			String sql = "select * from StudioInfo where studioName LIKE ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + studioName + "%");
			ResultSet rs = stmt.executeQuery();
			StudioBean studio = new StudioBean();
			if(rs.next()) {
				studio.setStudioID(rs.getInt("studioID"));
				studio.setMemberID(rs.getInt("memberID"));
				studio.setStudioName(rs.getString("studioName"));
				studio.setStudioAddress(rs.getString("studioAddress"));
				studio.setStudioLong(rs.getFloat("studioLong"));
				studio.setStudioLat(rs.getFloat("studioLat"));
				studio.setStudioPhone(rs.getString("studioPhone"));
				studio.setStudioEmail(rs.getString("studioEmail"));
				studio.setStudioTime(rs.getString("studioTime"));
				studio.setStudioLink(rs.getString("studioLink"));
				studio.setStudioIntro(rs.getString("studioIntro"));
				studio.setStudioPicID(rs.getInt("studioPicID"));
			}
			request.setAttribute("studio", studio);
			stmt.close();
			request.getRequestDispatcher("/studio/GetStudio.jsp").forward(request, response);
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