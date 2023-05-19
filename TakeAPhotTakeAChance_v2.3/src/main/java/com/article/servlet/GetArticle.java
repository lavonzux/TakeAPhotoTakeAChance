package com.article.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.article.bean.ArticleBean;
import com.article.dao.articleDAO;

@WebServlet("/GetArticle")
public class GetArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String articleID = request.getParameter("articleID");

		try {
			articleDAO articleDAO = new articleDAO();
			ArticleBean getBean = new ArticleBean();
//			東東寫法 getBean.setArticleID(request.getParameter("articleID"));
			getBean.setArticleID(articleID);
			ArticleBean resultBean = articleDAO.getArticleBean(getBean);

			request.setAttribute("resultBean", resultBean);
			request.getRequestDispatcher("html/Forum/GetArticle.jsp").forward(request, response);

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
