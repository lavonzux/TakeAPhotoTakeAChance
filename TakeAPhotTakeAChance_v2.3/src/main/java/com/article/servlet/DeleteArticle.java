package com.article.servlet;

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

import com.article.bean.ArticleBean;
import com.article.dao.articleDAO;

@WebServlet("/DeleteArticle")
public class DeleteArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleID = request.getParameter("articleID");
//		String memberId = request.getParameter("memberId");
//		String memberName = request.getParameter("memberName");
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String hashtag = request.getParameter("hashtag");
//		String postDate = request.getParameter("postDate");

		try {
			articleDAO articleDAO = new articleDAO();
			ArticleBean deleteBean = new ArticleBean();

			deleteBean.setArticleID(articleID);

			boolean deleteResult = articleDAO.deleteArticleBean(deleteBean);
			if (deleteResult) {
				System.out.println("刪掉");
			}
			request.getRequestDispatcher("html/Forum/DeleteArticle.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
