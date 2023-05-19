package Old;

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

@WebServlet("/DeleteArticleOld")
public class DeleteArticleOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

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
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();

			PreparedStatement stmt = conn.prepareStatement("delete from article where articleID = ?");
			stmt.setString(1, articleID);
			stmt.executeUpdate();

			ArticleBean article = new ArticleBean();

//			request.setAttribute("articleID", articleID);
			request.setAttribute("article", article);
			stmt.close();
			request.getRequestDispatcher("/CRUD/DeleteArticle.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
