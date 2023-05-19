package com.ex2.dao;

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

import com.ex2.bean.EventBean;

public class EventDAO {

    private DataSource dataSource;
//設定連線
    public EventDAO() throws NamingException {
        Context context = new InitialContext();
        dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/remoteServer");
    }
//取得所有event
    public List<EventBean> getAllEvents() throws SQLException {
        List<EventBean> events = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            String sql = "SELECT * FROM Event";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        EventBean event = new EventBean();
                        event.setEventID(rs.getInt("eventID"));
        				event.setMemberID(rs.getInt("memberID"));
        				event.setEventType(rs.getString("eventType"));
        				event.setEventTopic(rs.getString("eventTopic"));
        				event.setEventInfo(rs.getString("eventInfo"));
        				event.setEventDate(rs.getDate("eventDate"));
                        events.add(event);
                        
                    }
                }
            }
        }
        return events;
        
    }
//新增單筆event
    public void insertEvent(EventBean event) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "INSERT INTO Event (eventID, memberID, eventType, eventTopic, eventInfo, eventDate) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, event.getEventID());
                stmt.setInt(2, event.getMemberID());
                stmt.setString(3, event.getEventType());
                stmt.setString(4, event.getEventTopic());
                stmt.setString(5, event.getEventInfo());
                stmt.setDate(6, event.getEventDate());
                stmt.executeUpdate();
            }
        }
    }
//刪除單筆event
    public void deleteEvent(String eventID) throws SQLException, NamingException {
        try(Connection conn = dataSource.getConnection()) {
            String sql = "delete from Event where eventID= ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventID);
            int rs = stmt.executeUpdate();
            stmt.close();
 
        }
    }
//取得欲更新的event
    public EventBean getUpdateEvent(String eventID) throws SQLException, NamingException{
        EventBean event = new EventBean();
        try(Connection conn = dataSource.getConnection()){
            String sql = "select * from Event where eventID =?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, eventID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
            	event.setEventID(rs.getInt("eventID"));
            	event.setMemberID(rs.getInt("memberID"));
            	event.setEventType(rs.getString("eventType"));
            	event.setEventTopic(rs.getString("eventTopic"));
            	event.setEventInfo(rs.getString("eventInfo"));
            	event.setEventDate(rs.getDate("eventDate"));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
        }
        return event;
    } 
 //修改欲更新的event
    public void updateEvent(EventBean event) throws SQLException {
        try (Connection conn = dataSource.getConnection()) {
            String sql = "UPDATE Event SET memberID=?, eventType=?, eventTopic=?, eventInfo=?, eventDate=? WHERE eventID=?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        		stmt.setInt(1, event.getMemberID());
        		stmt.setString(2, event.getEventType());
        		stmt.setString(3, event.getEventTopic());
        		stmt.setString(4, event.getEventInfo());
        		stmt.setDate(5, event.getEventDate());
        		stmt.executeUpdate();
        		stmt.close();
        		System.out.println("update");
            }
        }
    }

}
