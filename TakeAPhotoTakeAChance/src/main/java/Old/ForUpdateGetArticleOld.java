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

@WebServlet("/ForUpdateGetArticleOld")
public class ForUpdateGetArticleOld extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	String SQL="select * from article where articleID = ?";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String articleID = request.getParameter("articleID");
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/servdb");
			conn = ds.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, articleID);
			ResultSet rs = stmt.executeQuery();
			ArticleBean article = new ArticleBean();
			if (rs.next()) {
				article.setArticleID(rs.getString("articleID"));
				article.setArticleTitle(rs.getString("articleTitle"));
				article.setArticleContent(rs.getString("articleContent"));
				article.setPostDate(rs.getString("postDate"));
				article.setMemberId(rs.getString("memberID"));
				article.setMemberName(rs.getString("memberName"));
				article.setHashtag(rs.getString("hashtag"));
			}
			request.setAttribute("article", article);
			stmt.close();
			request.getRequestDispatcher("CRUD/UpdateArticle.jsp").forward(request, response);

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
