package com.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.db.tables.Tours;
import com.util.InputHelper;

public class Main {
	// 2 parameter stored proc
	private static final String SQL = "{call GetToursWithCountByPrice(?, ?)}";

	public static void main(String[] args) throws Exception {

		double maxPrice;
		try {
			maxPrice = InputHelper.getDoubleInput("Enter a maximum price: ");
		} catch (NumberFormatException e) {
			System.err.println("Error: invalid number");
			return;
		}
		
		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				CallableStatement stmt = conn.prepareCall(
						SQL,
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setDouble(1, maxPrice);
			//second parameter
			stmt.registerOutParameter("total", Types.INTEGER);
			rs = stmt.executeQuery();
			//call the proc
			int nRows=stmt.getInt("total");
			Tours.displayData(rs, nRows);

		} catch (SQLException e) {
			System.err.println(e);
		}
		finally {
			if (rs != null) rs.close();
		}
	}

}
