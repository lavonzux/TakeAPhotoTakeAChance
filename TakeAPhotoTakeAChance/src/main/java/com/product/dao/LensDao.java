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

import com.product.bean.LensBean;

public class LensDao {

	private DataSource dataSource;

	public LensDao(DataSource ds) throws NamingException {
		InitialContext cxt = new InitialContext();
		dataSource = (DataSource) cxt.lookup("java:/comp/env/jdbc/remoteServer");
	}
	
	public List<LensBean> findLensByModel(String model) throws SQLException {
	    List<LensBean> lensList = new ArrayList<>();
	    try (Connection conn = dataSource.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Lens WHERE lensModel = ?");
	    ) {
	        pstmt.setString(1, model);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                LensBean l = new LensBean();
	                l.setLensModel(rs.getString("lensModel"));
	                l.setLensBrand(rs.getString("lensBrand"));
	                l.setLensPrice(rs.getInt("lensPrice"));
	                l.setLensMount(rs.getString("lensMount"));
	                l.setLensFocalLength(rs.getString("lensFocalLength"));
	                l.setLensGroup(rs.getString("lensGroup"));
	                l.setLensOIS(rs.getString("lensOIS"));
	                l.setLensMagnification(rs.getString("lensMagnification"));
	                l.setLensMinFocusDist(rs.getString("lensMinFocusDist"));
	                l.setLensApertureMin(rs.getInt("lensApertureMin"));
	                l.setLensApertureMax(rs.getInt("lensApertureMax"));
	                l.setLensBlades(rs.getString("lensBlades"));
	                l.setLensFilterSize(rs.getString("lensFilterSize"));
	                l.setLensDims(rs.getString("lensDims"));
	                l.setLensWeight(rs.getInt("lensWeight"));
	                l.setLensFOV(rs.getString("lensFOV"));
	                l.setLensDrive(rs.getString("lensDrive"));
	                l.setLensPhoto(rs.getString("lensPhoto"));
	                lensList.add(l);
	            }
	        }
	    }
	    return lensList;
	}
	//查詢全部鏡頭
		public List<LensBean> findAllLens() throws SQLException {
			List<LensBean> lensList = new ArrayList<>();
			try (Connection conn = dataSource.getConnection();
					PreparedStatement pstmt = conn.prepareStatement("select * from Lens");
					ResultSet rs = pstmt.executeQuery()) {

				
				while (rs.next()) {
					LensBean l = new LensBean();
					l.setLensModel(rs.getString("lensModel"));
					l.setLensBrand(rs.getString("lensBrand"));
					l.setLensPrice(rs.getInt("lensPrice"));
					l.setLensMount(rs.getString("lensMount"));
					l.setLensFocalLength(rs.getString("lensFocalLength"));
					l.setLensGroup(rs.getString("lensGroup"));
					l.setLensOIS(rs.getString("lensOIS"));
					l.setLensMagnification(rs.getString("lensMagnification"));
					l.setLensMinFocusDist(rs.getString("lensMinFocusDist"));
					l.setLensApertureMin(rs.getInt("lensApertureMin"));
					l.setLensApertureMax(rs.getInt("lensApertureMax"));
					l.setLensBlades(rs.getString("lensBlades"));
					l.setLensFilterSize(rs.getString("lensFilterSize"));
					l.setLensDims(rs.getString("lensDims"));
					l.setLensWeight(rs.getInt("lensWeight"));
					l.setLensFOV(rs.getString("lensFOV"));
					l.setLensDrive(rs.getString("lensDrive"));
					l.setLensPhoto(rs.getString("lensPhoto"));
					lensList.add(l);
				}

				rs.close();
				pstmt.close();

				return lensList;

			}
		}
		
		public boolean addLens(LensBean lens) throws SQLException {
		    try (Connection conn = dataSource.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement("insert into Lens (lensModel, lensBrand, lensPrice, lensMount, lensFocalLength, lensGroup, lensOIS, lensMagnification, lensMinFocusDist, lensApertureMin, lensApertureMax, lensBlades, lensFilterSize, lensDims, lensWeight, lensFOV, lensDrive) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

		        pstmt.setString(1, lens.getLensModel());
		        pstmt.setString(2, lens.getLensBrand());
		        pstmt.setInt(3, lens.getLensPrice());
		        pstmt.setString(4, lens.getLensMount());
		        pstmt.setString(5, lens.getLensFocalLength());
		        pstmt.setString(6, lens.getLensGroup());
		        pstmt.setString(7, lens.getLensOIS());
		        pstmt.setString(8, lens.getLensMagnification());
		        pstmt.setString(9, lens.getLensMinFocusDist());
		        pstmt.setInt(10, lens.getLensApertureMin());
		        pstmt.setInt(11, lens.getLensApertureMax());
		        pstmt.setString(12, lens.getLensBlades());
		        pstmt.setString(13, lens.getLensFilterSize());
		        pstmt.setString(14, lens.getLensDims());
		        pstmt.setInt(15, lens.getLensWeight());
		        pstmt.setString(16, lens.getLensFOV());
		        pstmt.setString(17, lens.getLensDrive());
//		        pstmt.setString(18, lens.getLensPhoto());

		        int affectedRows = pstmt.executeUpdate();

		        return affectedRows > 0;
		    }
		}
		
		public boolean updateLens(LensBean lens) throws SQLException {
		    try (Connection conn = dataSource.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement("update Lens set lensBrand=?, lensPrice=?, lensMount=?, lensFocalLength=?, lensGroup=?, lensOIS=?, lensMagnification=?, lensMinFocusDist=?, lensApertureMin=?, lensApertureMax=?, lensBlades=?, lensFilterSize=?, lensDims=?, lensWeight=?, lensFOV=?, lensDrive=? where lensModel=?")) {

		        pstmt.setString(1, lens.getLensBrand());
		        pstmt.setInt(2, lens.getLensPrice());
		        pstmt.setString(3, lens.getLensMount());
		        pstmt.setString(4, lens.getLensFocalLength());
		        pstmt.setString(5, lens.getLensGroup());
		        pstmt.setString(6, lens.getLensOIS());
		        pstmt.setString(7, lens.getLensMagnification());
		        pstmt.setString(8, lens.getLensMinFocusDist());
		        pstmt.setInt(9, lens.getLensApertureMin());
		        pstmt.setInt(10, lens.getLensApertureMax());
		        pstmt.setString(11, lens.getLensBlades());
		        pstmt.setString(12, lens.getLensFilterSize());
		        pstmt.setString(13, lens.getLensDims());
		        pstmt.setInt(14, lens.getLensWeight());
		        pstmt.setString(15, lens.getLensFOV());
		        pstmt.setString(16, lens.getLensDrive());
//		        pstmt.setString(18, lens.getLensPhoto());
		        pstmt.setString(17, lens.getLensModel());

		        int affectedRows = pstmt.executeUpdate();

		        return affectedRows > 0;
		    }
		}
		public boolean deleteLens(String lensModel) throws SQLException {
		    try (Connection conn = dataSource.getConnection();
		         PreparedStatement pstmt = conn.prepareStatement("delete from Lens where lensModel=?")) {

		        pstmt.setString(1, lensModel);

		        int affectedRows = pstmt.executeUpdate();

		        return affectedRows > 0;
		    }
		}

}