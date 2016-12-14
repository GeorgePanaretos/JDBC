package com.lynda.javatraining.db;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) throws Exception {

		Connection conn = ConnectionManager.getInstance().getConnection();
		
		try  {

		} catch (Exception e) {
			System.err.println(e);
		}
		finally {
		}
		
		ConnectionManager.getInstance().close();
		
	}

}
