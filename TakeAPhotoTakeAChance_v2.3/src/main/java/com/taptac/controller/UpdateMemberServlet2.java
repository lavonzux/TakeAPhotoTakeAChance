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

@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int memberID = Integer.parseInt(request.getParameter("memberID"));

		String memberAccount = request.getParameter("memberAccount");
		String memberPassword = request.getParameter("memberPassword");
		String memberEmail = request.getParameter("memberEmail");
		String memberName = request.getParameter("memberName");
		
        
		
		try {
			
			MembersDAO MembersDAO = new MembersDAO();

			MemberBean member = new MemberBean();
			member.setMemberID(memberID);
			member.setMemberAccount(memberAccount);
			member.setMemberPassword(memberPassword);
			member.setMemberEmail(memberEmail);
			member.setMemberName(memberName);

			MembersDAO.updateMemberById(member);

			
//			request.getRequestDispatcher("GetAllMemberServlet").forward(request, response);
			response.sendRedirect("GetAllMemberServlet");

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
