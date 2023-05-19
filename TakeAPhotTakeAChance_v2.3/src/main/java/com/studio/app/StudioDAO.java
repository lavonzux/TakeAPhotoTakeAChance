package com.studio.app;

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

import com.studio.bean.ShedBean;
import com.studio.bean.StudioBean;

public class StudioDAO {

    private DataSource dataSource;
//設定連線
    public StudioDAO() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
    }
//取得所有studio
    public List<StudioBean> getAllStudios() throws SQLException {
        List<StudioBean> studios = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM StudioInfo";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        StudioBean studio = new StudioBean();
                        studio.setStudioID(rs.getInt("studioID"));
                        studio.setMemberID(rs.getInt("memberID"));
                        studio.setStudioName(rs.getString("studioName"));
                        studio.setStudioAddress(rs.getString("studioAddress"));
                        studio.setStudioLong(rs.getFloat("studioLong"));
                        studio.setStudioLat(rs.getFloat("studioLat"));
                        studio.setStudioPhone(rs.getString("studioPhone"));
                        studio.setStudioEmail(rs.getString("studioEmail"));
                        studio.setStudioTime(rs.getString("studioTime"));
                        studio.setStudioLink(rs.getString("studioLink"));
                        studio.setStudioIntro(rs.getString("studioIntro"));
                        studio.setStudioPicID(rs.getInt("studioPicID"));
                        studios.add(studio);
                        
                    }
                }
            }
        }
        return studios;
        
    }
//新增單筆studio
    public void insertStudio(StudioBean studio) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO StudioInfo (studioID, memberID, studioName, studioAddress, studioLong, studioLat, studioPhone, studioEmail, studioTime, studioLink, studioIntro, studioPicID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, studio.getStudioID());
                stmt.setInt(2, studio.getMemberID());
                stmt.setString(3, studio.getStudioName());
                stmt.setString(4, studio.getStudioAddress());
                stmt.setFloat(5, studio.getStudioLong());
                stmt.setFloat(6, studio.getStudioLat());
                stmt.setString(7, studio.getStudioPhone());
                stmt.setString(8, studio.getStudioEmail());
                stmt.setString(9, studio.getStudioTime());
                stmt.setString(10, studio.getStudioLink());
                stmt.setString(11, studio.getStudioIntro());
                stmt.setInt(12, studio.getStudioPicID());
                stmt.executeUpdate();
            }
        }
    }
//刪除單筆studio
    public void deleteStudio(String studioID) throws SQLException, NamingException {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "delete from StudioInfo where studioID= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studioID);
            int rs = stmt.executeUpdate();
            stmt.close();
 
        }
    }
//取得欲更新的studio
    public StudioBean getUpdateStudio(String studioID) throws SQLException, NamingException{
        StudioBean studio = new StudioBean();
        try(Connection conn = dataSource.getConnection()){
            String sql = "select * from StudioInfo where studioID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, studioID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                studio.setStudioID(rs.getInt("studioID"));
                studio.setMemberID(rs.getInt("memberID"));
                studio.setStudioName(rs.getString("studioName"));
                studio.setStudioAddress(rs.getString("studioAddress"));
                studio.setStudioLong(rs.getFloat("studioLong"));
                studio.setStudioLat(rs.getFloat("studioLat"));
                studio.setStudioPhone(rs.getString("studioPhone"));
                studio.setStudioEmail(rs.getString("studioEmail"));
                studio.setStudioTime(rs.getString("studioTime"));
                studio.setStudioLink(rs.getString("studioLink"));
                studio.setStudioIntro(rs.getString("studioIntro"));
                studio.setStudioPicID(rs.getInt("studioPicID"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
        return studio;
    } 
 //修改欲更新的studio
    public void updateStudio(StudioBean studio) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE StudioInfo SET memberID=?, studioName=?, studioAddress=?, studioLong=?, studioLat=?, studioPhone=?, studioEmail=?, studioTime=?, studioLink=?, studioIntro=?, studioPicID=? WHERE studioID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        		stmt.setInt(1, studio.getMemberID());
        		stmt.setString(2, studio.getStudioName());
        		stmt.setString(3, studio.getStudioAddress());
        		stmt.setFloat(4, studio.getStudioLong());
        		stmt.setFloat(5, studio.getStudioLat());
        		stmt.setString(6, studio.getStudioPhone());
        		stmt.setString(7, studio.getStudioEmail());
        		stmt.setString(8, studio.getStudioTime());
        		stmt.setString(9, studio.getStudioLink());
        		stmt.setString(10, studio.getStudioIntro());
        		stmt.setInt(11, studio.getStudioPicID());
        		stmt.setInt(12, studio.getStudioID());
        		stmt.executeUpdate();
        		stmt.close();
        		System.out.println("update");
            }
        }
    }
  //取得所有shed
    public List<ShedBean> getAllShed(String studioID) throws SQLException, NamingException {
        List<ShedBean> sheds = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM StudioDetail WHERE studioID = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, studioID);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ShedBean shed = new ShedBean();
                    shed.setStudioID(rs.getInt("studioID"));
                    shed.setShedID(rs.getInt("shedID"));
                    shed.setShedName(rs.getString("shedName"));
                    shed.setShedSize(rs.getInt("shedSize"));
                    shed.setShedFee(rs.getInt("shedFee"));
                    shed.setShedFeature(rs.getString("shedFeature"));
                    shed.setShedEquip(rs.getString("shedEquip"));
                    shed.setShedType(rs.getString("shedType"));
                    shed.setShedIntro(rs.getString("shedIntro"));
                    shed.setStudioPicID(rs.getInt("studioPicID"));
                    sheds.add(shed);
                    
                }
            } 
        } 
        return sheds;
    }
    }
}
