package com.db;

import java.sql.SQLException;

import com.db.beans.Admin;
import com.db.tables.AdminManager;
import com.util.InputHelper;

public class Main {

	public static void main(String[] args) throws SQLException {

		AdminManager.displayAllRows();
		
		int adminId =InputHelper.getIntegerInput("Select a row: ");
		Admin bean = AdminManager.getRow(adminId);
		
		if(bean==null){
			System.err.println("No row were found");
		}
		else {
			System.out.println("Admin id: " +bean.getAdminId());
			System.out.println("User Name: " +bean.getUserName());			
			System.out.println("Password: " +bean.getPassword());

		}
		
	}

}
