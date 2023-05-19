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

import com.studio.bean.ShedBean;

@WebServlet("/DeleteShed")
public class DeleteShed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteShed() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shedID = request.getParameter("shedID");
		try {
			Connection conn = null;
			Context context = new InitialContext();
			DataSource ds = (DataSource)context.lookup("java:/comp/env/jdbc/remoteServer");
			conn = ds.getConnection();
			String sql = "delete from StudioDetail where shedID= ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, shedID);
			int rs = stmt.executeUpdate();
			ShedBean shed = new ShedBean();
//			if(rs.next()) {
//				emp.setEmpno(rs.getString("empno"));
//				emp.setEname(rs.getString("ename"));
//				emp.setHiredate(rs.getString("hiredate"));
//				emp.setSalary(rs.getString("salary"));
//				emp.setDeptno(rs.getString("deptno"));
//				emp.setTitle(rs.getString("title"));
//			}
			request.setAttribute("shed", shed);
			stmt.close();
			System.out.println("test");
			request.getRequestDispatcher("/studio/DeleteShed.jsp").forward(request, response);
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
