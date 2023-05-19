package com.taptac.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taptac.bean.MemberBean;
import com.taptac.dao.MembersDAO;




@WebServlet("/GetAllMemberServlet")
public class GetAllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		try {
			
			MembersDAO MembersDAO = new MembersDAO();
			
			List<MemberBean> members = MembersDAO.queryAllMembers();
			
			request.setAttribute("members", members);
			request.getRequestDispatcher("/html/Member/member.jsp").forward(request, response);
//			request.getRequestDispatcher("GetAllMembers/GetAllMembers.jsp").forward(request, response);
			

			
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
