package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.tables.Tours;

public class Main {

	public static void main(String[] args) throws Exception {

		try (
				Connection conn = DBUtil.getConnection(DBType.HSQLDB);
				Statement stmt = conn.createStatement();
				stmt.setMaxRows(5);
				ResultSet rs = stmt.executeQuery(
						"SELECT tourId, tourName, price FROM tours");
				) {
			Tours.displayData(rs);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
