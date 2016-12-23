package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.tables.Tours;

public class Main {

	public static void main(String[] args) throws Exception {

//		ResultSet rs=null;
//		try (
//				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
//				Statement stmt = conn.createStatement();
//				) {
//			stmt.setMaxRows(5);
//			rs = stmt.executeQuery(
//					"SELECT tourId, tourName, price FROM tours");
//			Tours.displayData(rs);
//		} catch (SQLException e) {
//			System.err.println(e);
//		}
//		finally{
//			rs.close(); 
//		}
		
		//ResultSet rs=null;
		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(
						"SELECT tourId, tourName, price FROM tours "+
						"LIMIT 0, 5");
				) {
			//stmt.setMaxRows(5);
			Tours.displayData(rs);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
