package com.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.product.bean.CameraBean;


public class CameraDao {

	private DataSource dataSource;

	public CameraDao(DataSource ds) throws NamingException {
		InitialContext cxt = new InitialContext();
		dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/remoteServer");
	}

	public List<CameraBean> findCameraByModel(String model) throws SQLException {
	    List<CameraBean> cameraList = new ArrayList<>();
	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Camera WHERE cameraModel = ?");
	    ) {
	        pstmt.setString(1, model);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	            	CameraBean c = new CameraBean();
	                c.setCameraModel(rs.getString("cameraModel"));
					c.setCameraBrand(rs.getString("cameraBrand"));
					c.setCameraPrice(rs.getInt("cameraPrice"));
					c.setCameraSensor(rs.getString("cameraSensor"));
					c.setCameraPx(rs.getInt("cameraPx"));
					c.setCameraRecPx(rs.getString("cameraRecPx"));
					c.setCameraMount(rs.getString("cameraMount"));
					c.setCameraIBIS(rs.getString("cameraIBIS"));
					c.setCameraEVF(rs.getString("cameraEVF"));
					c.setCameraLCD(rs.getString("cameraLCD"));
					c.setCameraFocusSys(rs.getString("cameraFocusSys"));
					c.setCameraPhotometry(rs.getString("cameraPhotometry"));
					c.setCameraISOMin(rs.getInt("cameraISOMin"));
					c.setCameraISOMax(rs.getInt("cameraISOMax"));
					c.setCameraShutter(rs.getString("cameraShutter"));
					c.setCameraBurst(rs.getString("cameraBurst"));
					c.setCameraMemCard(rs.getString("cameraMemCard"));
					c.setCameraBattery(rs.getString("cameraBattery"));
					c.setCameraDims(rs.getString("cameraDims"));
					c.setCameraWeight(rs.getInt("cameraWeight"));
//					c.setCameraPhoto(rs.getString("cameraPhoto"));
					cameraList.add(c);
	            }
	        }
	    }
	    return cameraList;
	}
	
	// 查詢全部相機
	public List<CameraBean> findAllCamera() throws SQLException {
		List<CameraBean> cameraList = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select * from Camera");
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				CameraBean c = new CameraBean();
				c.setCameraModel(rs.getString("cameraModel"));
				c.setCameraBrand(rs.getString("cameraBrand"));
				c.setCameraPrice(rs.getInt("cameraPrice"));
				c.setCameraSensor(rs.getString("cameraSensor"));
				c.setCameraPx(rs.getInt("cameraPx"));
				c.setCameraRecPx(rs.getString("cameraRecPx"));
				c.setCameraMount(rs.getString("cameraMount"));
				c.setCameraIBIS(rs.getString("cameraIBIS"));
				c.setCameraEVF(rs.getString("cameraEVF"));
				c.setCameraLCD(rs.getString("cameraLCD"));
				c.setCameraFocusSys(rs.getString("cameraFocusSys"));
				c.setCameraPhotometry(rs.getString("cameraPhotometry"));
				c.setCameraISOMin(rs.getInt("cameraISOMin"));
				c.setCameraISOMax(rs.getInt("cameraISOMax"));
				c.setCameraShutter(rs.getString("cameraShutter"));
				c.setCameraBurst(rs.getString("cameraBurst"));
				c.setCameraMemCard(rs.getString("cameraMemCard"));
				c.setCameraBattery(rs.getString("cameraBattery"));
				c.setCameraDims(rs.getString("cameraDims"));
				c.setCameraWeight(rs.getInt("cameraWeight"));
//				c.setCameraPhoto(rs.getString("cameraPhoto"));
				cameraList.add(c);
			}

			rs.close();
			pstmt.close();

			return cameraList;

		}
	}

	public void addCamera(CameraBean camera) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into Camera(cameraModel, cameraBrand, cameraPrice, cameraSensor, cameraPx, cameraRecPx, "
								+ "cameraMount, cameraIBIS, cameraEVF, cameraLCD, cameraFocusSys, cameraPhotometry, "
								+ "cameraISOMin, cameraISOMax, cameraShutter, cameraBurst, cameraMemCard, cameraBattery, "
								+ "cameraDims, cameraWeight) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)")) {
			pstmt.setString(1, camera.getCameraModel());
			pstmt.setString(2, camera.getCameraBrand());
			pstmt.setInt(3, camera.getCameraPrice());
			pstmt.setString(4, camera.getCameraSensor());
			pstmt.setInt(5, camera.getCameraPx());
			pstmt.setString(6, camera.getCameraRecPx());
			pstmt.setString(7, camera.getCameraMount());
			pstmt.setString(8, camera.getCameraIBIS());
			pstmt.setString(9, camera.getCameraEVF());
			pstmt.setString(10, camera.getCameraLCD());
			pstmt.setString(11, camera.getCameraFocusSys());
			pstmt.setString(12, camera.getCameraPhotometry());
			pstmt.setInt(13, camera.getCameraISOMin());
			pstmt.setInt(14, camera.getCameraISOMax());
			pstmt.setString(15, camera.getCameraShutter());
			pstmt.setString(16, camera.getCameraBurst());
			pstmt.setString(17, camera.getCameraMemCard());
			pstmt.setString(18, camera.getCameraBattery());
			pstmt.setString(19, camera.getCameraDims());
			pstmt.setInt(20, camera.getCameraWeight());
//			pstmt.setString(21, camera.getCameraPhoto());
			pstmt.executeUpdate();

			pstmt.close();

		}

	}

	public void updateCamera(CameraBean camera) throws SQLException {
		try (Connection conn = dataSource.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(
						"update Camera set cameraBrand=?, cameraPrice=?, cameraSensor=?, cameraPx=?, cameraRecPx=?, "
								+ "cameraMount=?, cameraIBIS=?, cameraEVF=?, cameraLCD=?, cameraFocusSys=?, cameraPhotometry=?, "
								+ "cameraISOMin=?, cameraISOMax=?, cameraShutter=?, cameraBurst=?, cameraMemCard=?, "
								+ "cameraBattery=?, cameraDims=?, cameraWeight=? where cameraModel=?")) {
			pstmt.setString(1, camera.getCameraBrand());
			pstmt.setInt(2, camera.getCameraPrice());
			pstmt.setString(3, camera.getCameraSensor());
			pstmt.setInt(4, camera.getCameraPx());
			pstmt.setString(5, camera.getCameraRecPx());
			pstmt.setString(6, camera.getCameraMount());
			pstmt.setString(7, camera.getCameraIBIS());
			pstmt.setString(8, camera.getCameraEVF());
			pstmt.setString(9, camera.getCameraLCD());
			pstmt.setString(10, camera.getCameraFocusSys());
			pstmt.setString(11, camera.getCameraPhotometry());
			pstmt.setInt(12, camera.getCameraISOMin());
			pstmt.setInt(13, camera.getCameraISOMax());
			pstmt.setString(14, camera.getCameraShutter());
			pstmt.setString(15, camera.getCameraBurst());
			pstmt.setString(16, camera.getCameraMemCard());
			pstmt.setString(17, camera.getCameraBattery());
			pstmt.setString(18, camera.getCameraDims());
			pstmt.setInt(19, camera.getCameraWeight());
//			pstmt.setString(20, camera.getCameraPhoto());
			pstmt.setString(20, camera.getCameraModel());
			pstmt.executeUpdate();
			
			pstmt.close();
		}
	}
	
	public void deleteCamera(String cameraModel) throws SQLException {
	    try (Connection conn = dataSource.getConnection();
	            PreparedStatement pstmt = conn.prepareStatement("delete from Camera where cameraModel=?")) {
	        pstmt.setString(1, cameraModel);
	        pstmt.executeUpdate();

	        pstmt.close();
	    }
	}
}