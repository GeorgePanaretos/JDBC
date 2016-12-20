package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.tables.States;
/**
 * 
 * 1.ResultSet can be made scrollable with most databases
 * 2.select scrolling when creating the Statement object
 * 		Statement stmt=
 * 			conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
 * 								ResultSet.CONCUR_READ_ONLY);
 * 
 * 3.Methods that move the cursor to specific rows:
 * 		rs.beforeFirst();
 * 		rs.first();
 * 		rs.last();
 * 		rs.afterLast();
 * 		rs.absolute(int row);
 * 
 * 4.boolean methods that check the cursor in position:
 * 		rs.isBeforeFirst();
 * 		rs.isFirst();
 * 		rs.isLast();
 * 		rs.isAfterLast();
 * 
 * @author george156200911
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {

		try (Connection conn = DBUtil.getConnection(DBType.MYSQL);

						Statement stmt = conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(
						"SELECT stateId, stateName FROM states");   	
				) {

			States.displayData(rs);
			
			rs.last();
			System.out.println("Number of rows: "+rs.getRow());
			
			rs.first();
			System.out.println("The first state is "+rs.getString("stateName"));
			
			rs.last();
			System.out.println("The last state is "+rs.getString("stateName"));
			
			rs.absolute(10);
			System.out.println("The tenth state is "+rs.getString("stateName"));
			
			
			
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
