package com.nacre.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	
	public static String validate(String name,String pass){
		String type=null;
		try{
			Connection con=ConnectionDao.getConnection();	
			PreparedStatement ps=con.prepareStatement(QueryConstants.Login_Select_Query);
			ps.setString(1,name);
			ps.setString(2,pass);
			
			ResultSet rs=ps.executeQuery();
			type=rs.getString(1);
			
			
		}catch(Exception e){System.out.println(e);}
		return type;
		}
}
