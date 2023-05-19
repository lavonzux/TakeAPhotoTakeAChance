package com.taptac.photoServiceServlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PhotoServiceDAO {

	private Connection conn;

	private static final String CREATE_COMMAND = "INSERT INTO PhotoService VALUES (?,?,?,?,?,?,?)";
	private static final String READ_COMMAND = "SELECT * FROM PhotoService WHERE serviceID = ?";
	private static final String READ_ALL_COMMAND = "SELECT * FROM PhotoService";
	private static final String UPDATE_COMMAND = "UPDATE PhotoService SET serviceName = ?, serviceType = ?, servicePrice = ?, serviceDuration = ?, serviceLocation = ?, serviceCreator = ? WHERE serviceID = ?";
	private static final String DELETE_COMMAND = "DELETE FROM PhotoService WHERE serviceID = ?";
	private static final String DATA_SOURCE = "java:/comp/env/jdbc/remoteServer";

	/**
	 * PhotoService table Data Access Operator
	 */
	public PhotoServiceDAO() throws NamingException, SQLException {
		super();
		this.conn = makeConnection();
	}

	
	// ==================== SQL CRUD METHODS ====================
	public boolean createEntry(PhotoServiceBean bean) {
		boolean updateResult = false;

		try {
			PreparedStatement statement = conn.prepareStatement(CREATE_COMMAND);

			String[] allFields = bean.getAllFields();
			for (int i = 0; i < allFields.length; i++)
				statement.setString(i + 1, allFields[i]);

			if (statement.executeUpdate() == 1) {
				updateResult = true;
				System.out.println("==========>>> createEntry() success <<<==========");
			}
			statement.close();

		} catch (SQLException e) {
			System.out.println("==========!!! SQL EXCEPTION THORWN BY createEntry() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! SQL EXCEPTION THORWN BY createEntry() :END !!!==========");
		}
		return updateResult;
	}
	public PhotoServiceBean readEntry(PhotoServiceBean bean) {
		PhotoServiceBean returnBean = null;

		try {
			PreparedStatement statement = conn.prepareStatement(READ_COMMAND);

			statement.setString(1, Integer.toString(bean.getServiceID()) );
			System.out.println("========== Fetching serviceID: "+bean.getServiceID()+" from DB ==========");

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				returnBean = new PhotoServiceBean();
				
				returnBean.setServiceID(Integer.parseInt(rs.getString("serviceID")));
				returnBean.setServiceName(rs.getString("serviceName"));
				returnBean.setServiceType(rs.getString("serviceType"));
				returnBean.setServicePrice(rs.getString("servicePrice"));
				returnBean.setServiceDuration(rs.getString("serviceDuration"));
				returnBean.setServiceLocation(rs.getString("serviceLocation"));
				returnBean.setServiceCreator(rs.getString("serviceCreator"));
				System.out.println("Retrieved info of serviceID: " + rs.getString("serviceID"));
			}

		} catch (SQLException e) {
			System.out.println("==========!!! SQL EXCEPTION THORWN BY ReadEntry() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! SQL EXCEPTION THORWN BY ReadEntry() :END !!!==========");
		}
		return returnBean;
	}
	public ArrayList<PhotoServiceBean> readAllEntries() {
		ArrayList<PhotoServiceBean> returnList = new ArrayList<PhotoServiceBean>();

		try {
			PreparedStatement statement = conn.prepareStatement(READ_ALL_COMMAND);

			ResultSet rs = statement.executeQuery();
			System.out.println("========== Fetching all data from DB ==========");

			PhotoServiceBean returnBean = null;
			while (rs.next()) {
				returnBean = new PhotoServiceBean();
				returnBean.setServiceID(Integer.parseInt(rs.getString("serviceID")));
				returnBean.setServiceName(rs.getString("serviceName"));
				returnBean.setServiceType(rs.getString("serviceType"));
				returnBean.setServicePrice(rs.getString("servicePrice"));
				returnBean.setServiceDuration(rs.getString("serviceDuration"));
				returnBean.setServiceLocation(rs.getString("serviceLocation"));
				returnBean.setServiceCreator(rs.getString("serviceCreator"));

				System.out.println("Retrieved info of serviceID: " + rs.getString("serviceID"));
				returnList.add(returnBean);
			}
			
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnList;
	}
	public boolean updateEntry(PhotoServiceBean bean) {
		boolean updateResult = false;

		try {
			PreparedStatement statement = conn.prepareStatement(UPDATE_COMMAND);

			statement.setString(1, bean.getServiceName());
			statement.setString(2, bean.getServiceType());
			statement.setString(3, bean.getServicePrice());
			statement.setString(4, bean.getServiceDuration());
			statement.setString(5, bean.getServiceLocation());
			statement.setString(6, bean.getServiceCreator());
			statement.setString(7, Integer.toString(bean.getServiceID()));

			updateResult = (statement.executeUpdate() == 1);
			statement.close();

		} catch (SQLException e) {
			System.out.println("==========!!! SQL EXCEPTION THORWN BY updateEntry() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! SQL EXCEPTION THORWN BY updateEntry() :END !!!==========");
		}
		return updateResult;
	}
	public boolean deleteEntry(PhotoServiceBean bean) {
		boolean updateResult = false;

		try {
			PreparedStatement statement = conn.prepareStatement(DELETE_COMMAND);

			statement.setString(1, Integer.toString(bean.getServiceID()));

			updateResult = (statement.executeUpdate() == 1);
			statement.close();

		} catch (SQLException e) {
			System.out.println("==========!!! SQL EXCEPTION THORWN BY createEntry() START: !!!==========");
			e.printStackTrace();
			System.out.println("==========!!! SQL EXCEPTION THORWN BY createEntry() :END !!!==========");
		}
		return updateResult;
	}
	
	// ==================== UTILITY ====================
	private static Connection makeConnection() throws NamingException, SQLException {
		Context context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(DATA_SOURCE);
		return ds.getConnection();
	}
	public void closeConnection() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	// ==================== DIRECT COMMAND TO SQL SERVER ====================
	// not finished yet!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public static ResultSet directCommand(String command) {

		ResultSet result = null;
		
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup(DATA_SOURCE);
			Connection conn = ds.getConnection();
			PreparedStatement statement = conn.prepareStatement(command);

			if (command.toLowerCase().indexOf("select") < 0) {
				result = statement.executeQuery();
			} else {
				statement.executeUpdate();
			}
		} catch (SQLException | NamingException e) {
			System.out.println(
					"====================!!! EXCEPTION THOWN BY directCommand() START: !!!====================");
			e.printStackTrace();
			System.out
					.println("====================!!! EXCEPTION THOWN BY directCommand() END: !!!====================");
		}

		return result;
	}

}
