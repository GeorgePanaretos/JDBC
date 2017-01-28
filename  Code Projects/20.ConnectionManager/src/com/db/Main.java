package com.db;

import com.db.beans.Admin;
import com.db.tables.AdminManager;
import com.util.InputHelper;

public class Main {

	/*
	 * Connection Manager handles better the connection with database.
	 * Saving memory time and resources that is always the goal
	 */
	public static void main(String[] args) throws Exception {

		System.out.println("Starting application");
		
		ConnectionManager.getInstance().setDBType(DBType.MYSQL);
		
		AdminManager.displayAllRows();

		int adminId = InputHelper.getIntegerInput("Select a row to update: ");

		Admin bean = AdminManager.getRow(adminId);
		if (bean == null) {
			System.err.println("Row not found");
			return;
		}
		
		String password = InputHelper.getInput("Enter new password: ");
		bean.setPassword(password);
		
		if (AdminManager.update(bean)) {
			System.out.println("Success!");
		} else
		{
			System.err.println("whoops!");
		}
		
		ConnectionManager.getInstance().close();
		
	}
}
