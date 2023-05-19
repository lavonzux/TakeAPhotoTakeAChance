package com.taptac.controller;

import java.io.IOException;
import java.sql.SQLException;


import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taptac.bean.MemberBean;
import com.taptac.dao.MembersDAO;




@WebServlet("/GetMemberByIDServlet")
public class GetMemberByIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int memberID = Integer.parseInt(request.getParameter("memberID"));
		
		
		try {
			
			MembersDAO MembersDAO = new MembersDAO();
			MemberBean member = MembersDAO.queryMemberById(memberID);
			
			request.setAttribute("member", member);
			request.getRequestDispatcher("GetMemberData/GetMemberData.jsp").forward(request, response);
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
