package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.util.*;
import com.db.tables.Tours;

public class Main {

	private static final String SQL = 
			"SELECT tourId, tourName, price FROM tours WHERE price <= ?";

	public static void main(String[] args) throws Exception {

		double maxPrice;
		try{
			maxPrice =InputHelper.getDoubleInput("Enter a maximum price: ");
		}catch(NumberFormatException e){
			System.err.println("Error: invalid number");
			return;
		}
		ResultSet rs = null;
		try (
				Connection conn = DBUtil.getConnection(DBType.MYSQL);
				PreparedStatement stmt = conn.prepareStatement(
						SQL,
						ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setDouble(1, maxPrice);
			rs = stmt.executeQuery();
			Tours.displayData(rs);

		} catch (SQLException e) {
			System.err.println(e);
		}
		finally {
			if (rs != null) rs.close();
		}
	}

}
