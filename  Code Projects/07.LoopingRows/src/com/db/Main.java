package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.tables.Tours;
/**
 * 1.each instance of ResultSet has an in-memory cursor
 * 2.the starting cursor position is before the first row of data
 * 3.the most common operation is to move forward row to row
 * ResultSet rs=stmt.executeQuery("SELECT * FROM states");
 * while (rs.next()){
 * 	String columnValue =rs.getString("columnName");
 * 	OR
 * 	String columnValue =rs.getString(column position);
 * 	System.out.println(columnValue);
 *  }
 *  
 * @author george156200911
 *
 */
public class Main {
/**
 * 
 * @param args
 * @throws SQLException
 */
	public static void main(String[] args) throws SQLException {

		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery("SELECT * FROM tours");
				) {
			
			Tours.displayData(rs);
			
		} catch (SQLException e) {
			DBUtil.processException(e);
		} 

	}

}
