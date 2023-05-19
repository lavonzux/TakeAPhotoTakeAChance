package com.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;

import com.article.bean.ArticleBean;

public class articleDAO {

	// 在這裡宣告
	Connection conn;

//東東寫法	private static final String DATA_SOURCE ="java:/comp/env/jdbc/servdb";
	private static final String GET = "select * from article where articleID = ?";
	private static final String GETINSERT = "select * from article where articleTitle = ? AND articleContent=? AND hashtag=? ORDER BY articleID DESC";
	private static final String GETALL = "select * from article";
	private static final String INSERTDATA = "insert into article (articleTitle,articleContent,hashtag) values(?,?,?)";
	private static final String DELETE = "delete from article where articleID = ?";
	private static final String UPDATE = "update article set articleTitle=?,articleContent=?,hashTag=? where articleID =?";

	
	public articleDAO() throws SQLException, NamingException {
		super();
		this.conn = getConnection();
	}

	// =====查單筆=====
	public ArticleBean getArticleBean(ArticleBean bean) throws NamingException, SQLException {

		PreparedStatement stmt = conn.prepareStatement(GET);
		stmt.setString(1, bean.getArticleID());
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
		stmt.close();
		return article;
	}
	
	// =====查新增的那筆=====
	public ArticleBean getInsertArticleBean(ArticleBean bean) throws NamingException, SQLException {

			PreparedStatement stmt = conn.prepareStatement(GETINSERT);
			stmt.setString(1, bean.getArticleTitle());
			stmt.setString(2, bean.getArticleContent());
			stmt.setString(3, bean.getHashtag());
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
			stmt.close();
			return article;
		}

	// =====查全部=====
	public List<ArticleBean> getArticleBeans() throws NamingException, SQLException {

		PreparedStatement stmt = conn.prepareStatement(GETALL);
		ResultSet rs = stmt.executeQuery();
		List<ArticleBean> articleListBean = new ArrayList<>();

//		while (rs.next()) {
//			articleListBean.setArticleID(rs.getString("articleID"));
//			articleListBean.setArticleTitle(rs.getString("articleTitle"));
//			articleListBean.setArticleContent(rs.getString("articleContent"));
//			articleListBean.setPostDate(rs.getString("postDate"));
//			articleListBean.setMemberId(rs.getString("memberID"));
//			articleListBean.setMemberName(rs.getString("memberName"));
//			articleListBean.setHashtag(rs.getString("hashtag"));
//			articleListBean.add(articleBean);
//		}
//		stmt.close();
		return articleListBean;
	}

	// =====新增=====
	public boolean addArticleBean(ArticleBean bean) throws NamingException, SQLException {
		boolean addResult = false;

		PreparedStatement stmt = conn.prepareStatement(INSERTDATA);
		stmt.setString(1, bean.getArticleTitle());
		stmt.setString(2, bean.getArticleContent());
		stmt.setString(3, bean.getHashtag());
		
//		if裡面也會執行一次		
		if (stmt.executeUpdate() == 1) {
			addResult = true;
		};
		stmt.close();
		return addResult;
	}

	// =====刪除=====
	public boolean deleteArticleBean(ArticleBean bean) throws NamingException, SQLException {
		boolean deleteResult = false;

		PreparedStatement stmt = conn.prepareStatement(DELETE);
		stmt.setString(1, bean.getArticleID());
		
		if (stmt.executeUpdate() == 1) {
			deleteResult = true;
		};
		stmt.close();
		return deleteResult;
	}
	// =====更新=====
	public boolean updateArticleBean(ArticleBean bean) throws NamingException, SQLException {
		boolean updateResult = false;
		
		PreparedStatement stmt = conn.prepareStatement(UPDATE);
		stmt.setString(1, bean.getArticleTitle());
		stmt.setString(2, bean.getArticleContent());
		stmt.setString(3, bean.getHashtag());
		stmt.setString(4, bean.getArticleID());
		
		if (stmt.executeUpdate() == 1) {
			updateResult = true;
		};
		stmt.close();
		return updateResult;
	}
	
	// =====連線方法=====
	private static Connection getConnection() throws SQLException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		return ds.getConnection();
	}
}