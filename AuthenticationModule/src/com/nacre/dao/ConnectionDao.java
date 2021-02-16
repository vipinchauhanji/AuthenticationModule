package com.nacre.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
		}catch(Exception e){System.out.println(e);}
		if (con!=null)
			System.out.print(" connection established");
		return con;
	}
}
