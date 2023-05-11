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

@WebServlet("/UpdateArticle")
public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String SQL = "update article set articleTitle=?,articleContent=?,hashTag=? where articleID =?";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("========== start of updateArticle.servlet ==========");
		request.setCharacterEncoding("UTF-8");
		String articleID = request.getParameter("articleID");
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String hashtag = request.getParameter("hashtag");
		System.out.println(articleID + articleTitle + articleContent + hashtag);

		try {
			articleDAO articleDAO = new articleDAO();
			ArticleBean updateBean = new ArticleBean();

			System.out.println(articleID);
			updateBean.setArticleID(articleID);
			updateBean.setArticleTitle(articleTitle);
			updateBean.setArticleContent(articleContent);
			updateBean.setHashtag(hashtag);

			boolean updateresult = articleDAO.updateArticleBean(updateBean);
			if (updateresult) {
				System.out.println("更新囉");
			}

//			boolean updateReport = (stmt.executeUpdate() == 1 );
//			System.out.println(updateReport);

//			ArticleBean getBean = new ArticleBean();
//			東東寫法 getBean.setArticleID(request.getParameter("articleID"));
			
			articleDAO.getArticleBean(updateBean);
//			ArticleBean resultBean = articleDAO.getArticleBean(getBean);

			request.setAttribute("updateBean", updateBean);
			System.out.println("========== end of updateArticle.servlet ==========");
			request.getRequestDispatcher("html/Forum/ShowArticle.jsp").forward(request, response);

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
