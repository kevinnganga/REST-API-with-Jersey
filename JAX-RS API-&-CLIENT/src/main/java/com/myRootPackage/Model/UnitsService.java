package com.myRootPackage.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.myRootPackage.ExceptionsHandling.DataNotFoundException;
import com.myRootPackage.Trying.Units;

public class UnitsService {
	
	Connection con=null;
	
	public UnitsService() {
		String jdbccon="jdbc:mysql://localhost/rest?useSSL=false";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(jdbccon, user, pass);
			System.out.println("connected to the database");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Units> AllUnits(){
		List<Units> un=new ArrayList<>();
		String sql="select * from units";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
				Units units=new Units(); 
				units.setName(rs.getString(1));
				units.setCode(rs.getInt(2));
				
				units.setDepartment(rs.getString(3));
				
				System.out.println(un);	
				un.add(units);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return un;
	}
	
	
	
	
	public Units OneUnit(String id){
		//List<Units> un=new ArrayList<>();
		String sql="select * from units where name='"+id+"'";
		Units units=new Units();
		  
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			 if(rs.next()) {
//				Units units=new Units();
				units.setName(rs.getString(1));
				
				units.setCode(rs.getInt(2));
				
				units.setDepartment(rs.getString(3));
				
				System.out.println(rs.getString(3));	
				
			}
		
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
	
		return units;
		
		//return units;
	}
	
	
	public Units AddUnit(Units unt){
		
		try {
			String sql="INSERT INTO units (name,code,department) VALUES(?,?,?)";
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1, unt.getName());
			st.setInt(2, unt.getCode());
			st.setString(3, unt.getDepartment());
			st.execute();
		System.out.println(st);
		} catch (Exception e) {
				e.printStackTrace();		
				}
		return unt;
		
		
		//return units;
	}
	
	public Units UpdateUnit(Units unt) {
		String sql="UPDATE  units  SET code=?,department=? where name=?";
		try {

			PreparedStatement st=con.prepareStatement(sql);

			st.setInt(1, unt.getCode());
			st.setString(2, unt.getDepartment());
			st.setString(3, unt.getName());
			st.executeUpdate();
			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return unt;

	}
	
	
	
	public Units deleteUnit(String id) {
		
		Units uni=new Units();
		String sql="DELETE FROM units WHERE name='"+id+"'";
		try {

			Statement st=con.createStatement();
			st.executeUpdate(sql);


			System.out.println(st);
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return uni;

	}

}
