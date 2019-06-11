package com.myRootPackage.Trying;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbccon="jdbc:mysql://localhost/hb_student_tracker?useSSL=false";
		String user="root";
		String pass="";
		try {
			Connection mycon=DriverManager.getConnection(jdbccon, user, pass);
			System.out.println("connected to the database");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
