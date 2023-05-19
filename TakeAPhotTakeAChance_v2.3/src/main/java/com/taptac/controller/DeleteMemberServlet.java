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




@WebServlet("/DeleteMemberServlet")
public class DeleteMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String str = request.getParameter("memberID");

		
		if ( str != null && !str.isEmpty()) {
			int memberID = Integer.parseInt(str);
			
			try {
				
				MembersDAO MembersDAO = new MembersDAO();
				
				MemberBean member = MembersDAO.deleteMemberById(memberID);
				
				request.setAttribute("member", member);
//				request.getRequestDispatcher("GetAllMemberServlet").forward(request, response);

				response.sendRedirect("GetAllMemberServlet");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else {
			System.out.println("memberID 是空值或是空字串");
		}
		
		
		
		
			

			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
