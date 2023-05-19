package com.taptac.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.taptac.bean.MemberBean;

public class MembersDAO {

	private Connection conn = null;

	// 新增單筆會員資料
	public void insertMember(MemberBean member) throws SQLException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		Connection conn = ds.getConnection();

		PreparedStatement stmt = conn.prepareStatement(
				"INSERT INTO Member (memberAccount, memberPassword, memberEmail, memberName, memberGender, memberAvatar, lastLoginTime, lastLoginIP, accountStatusId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

		stmt.setString(1, member.getMemberAccount());
		stmt.setString(2, member.getMemberPassword());
		stmt.setString(3, member.getMemberEmail());
		stmt.setString(4, member.getMemberName());
		stmt.setString(5, member.getMemberGender());
		stmt.setString(6, member.getMemberAvatar());
		stmt.setDate(7, member.getLastLoginTime());
		stmt.setString(8, member.getLastLoginIP());
		stmt.setInt(9, member.getAccountStatusId());

		stmt.executeUpdate();

		stmt.close();
		conn.close();
	}

	// 查詢所有會員資料
	public List<MemberBean> queryAllMembers() throws SQLException, NamingException {

		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		conn = ds.getConnection();

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Member ");
		ResultSet rs = stmt.executeQuery();
		List<MemberBean> members = new ArrayList<>();
		MemberBean member = null;
		while (rs.next()) {
			member = new MemberBean();
			member.setMemberID(rs.getInt("memberID"));
			member.setMemberAccount(rs.getString("memberAccount"));
			member.setMemberPassword(rs.getString("memberPassword"));
			member.setMemberEmail(rs.getString("memberEmail"));
			member.setMemberName(rs.getString("memberName"));
			member.setMemberGender(rs.getString("memberGender"));
			member.setMemberAvatar(rs.getString("memberAvatar"));
			member.setLastLoginTime(rs.getDate("lastLoginTime"));
			member.setLastLoginIP(rs.getString("lastLoginIP"));
			member.setAccountStatusId(rs.getInt("accountStatusId"));
			members.add(member);
		}

		stmt.close();
		conn.close();
		return members;

	}

	// 查詢單筆會員資料
	public MemberBean queryMemberById(int memberId) throws SQLException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		conn = ds.getConnection();

		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM Member WHERE memberID = ?");
		stmt.setInt(1, memberId);
		ResultSet rs = stmt.executeQuery();

		MemberBean member = null;
		if (rs.next()) {
			member = new MemberBean();
			member.setMemberID(rs.getInt("memberID"));
			member.setMemberAccount(rs.getString("memberAccount"));
			member.setMemberPassword(rs.getString("memberPassword"));
			member.setMemberEmail(rs.getString("memberEmail"));
			member.setMemberName(rs.getString("memberName"));
			member.setMemberGender(rs.getString("memberGender"));
			member.setMemberAvatar(rs.getString("memberAvatar"));
			member.setLastLoginTime(rs.getDate("lastLoginTime"));
			member.setLastLoginIP(rs.getString("lastLoginIP"));
			member.setAccountStatusId(rs.getInt("accountStatusId"));
		}

		stmt.close();
		conn.close();
		return member;
	}

	// 修改會員資料
	public void updateMemberById(MemberBean member) throws SQLException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		Connection conn = ds.getConnection();

		PreparedStatement stmt = conn
				.prepareStatement("UPDATE Member SET " + "memberAccount = ?, " + "memberPassword = ?, "
						+ "memberEmail = ?, " + "memberName = ?, " + "memberGender = ?, " + "memberAvatar = ?, "
						+ "lastLoginTime = ?, " + "lastLoginIP = ?, " + "accountStatusId = ? " + "WHERE memberID = ?");

		// 設定更新的會員資料
		stmt.setString(1, member.getMemberAccount());
		stmt.setString(2, member.getMemberPassword());
		stmt.setString(3, member.getMemberEmail());
		stmt.setString(4, member.getMemberName());
		stmt.setString(5, member.getMemberGender());
		stmt.setString(6, member.getMemberAvatar());
		stmt.setDate(7, member.getLastLoginTime());
		stmt.setString(8, member.getLastLoginIP());
		stmt.setInt(9, member.getAccountStatusId());
		stmt.setInt(10, member.getMemberID());

		stmt.executeUpdate();

		stmt.close();
		conn.close();

	}

	// 刪除單筆會員資料
	public MemberBean deleteMemberById(int memberId) throws SQLException, NamingException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
		Connection conn = ds.getConnection();

		PreparedStatement stmt = conn.prepareStatement("DELETE FROM Member WHERE memberID = ?");
		stmt.setInt(1, memberId);

		stmt.executeUpdate();

		stmt.close();
		conn.close();

		return null;
	}

}
