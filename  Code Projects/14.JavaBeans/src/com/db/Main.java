package com.db;

import java.sql.SQLException;

import com.db.tables.AdminManager;

public class Main {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
	}

}
