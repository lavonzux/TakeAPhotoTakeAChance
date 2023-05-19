package Old;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

@WebServlet("/InsertArticleOld")
public class InsertArticleOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
//		String articleID = request.getParameter("articleID");
//		String memberId = request.getParameter("memberId");
//		String memberName = request.getParameter("memberName");
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String hashtag = request.getParameter("hashtag");
//		String postDate = request.getParameter("postDate");
		
		String SQL = "insert into article (articleTitle,articleContent,hashtag) values(?,?,?)";

		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SQL);

//			stmt.setString(1, memberId);
//			stmt.setString(2, memberName);
			stmt.setString(1, articleTitle);
			stmt.setString(2, articleContent);
			stmt.setString(3, hashtag);
//			stmt.setString(4, postDate);
			stmt.executeUpdate();

			ArticleBean article = new ArticleBean();
//			article.setMemberId(memberId);
//			article.setMemberName(memberName);
			article.setArticleTitle(articleTitle);
			article.setArticleContent(articleContent);
			article.setHashtag(hashtag);
//			article.setPostDate(postDate);

			request.setAttribute("article", article);

			stmt.close();
			request.getRequestDispatcher("/CRUD/InsertArticle.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
