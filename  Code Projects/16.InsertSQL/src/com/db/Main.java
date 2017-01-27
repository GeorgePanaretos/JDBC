package com.db;

import com.db.beans.Admin;
import com.db.tables.AdminManager;
import com.util.InputHelper;

public class Main {

	public static void main(String[] args) throws Exception {

		AdminManager.displayAllRows();
		
		Admin bean= new Admin();
		bean.setUserName(InputHelper.getInput("User Name: "));
		bean.setPassword(InputHelper.getInput("Password: "));
		
		boolean result=AdminManager.insert(bean);
		if(result){
			System.out.println("New row with primary key "+bean.getAdminId()+" was inserted!");
		}
					
	}

}
