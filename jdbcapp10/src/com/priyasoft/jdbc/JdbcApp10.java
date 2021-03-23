package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp10 {

	public static void main(String[] args) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st=con.createStatement();
			int rowCount=st.executeUpdate("select * from emp1");
			System.out.println(rowCount);
			rs=st.getResultSet();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------------");
			while(rs.next())
			{
				System.out.print(rs.getInt("ENO")+"\t");
				System.out.print(rs.getString("ENAME")+"\t");
				System.out.print(rs.getFloat("ESAL")+"\t");
				System.out.println(rs.getString("EADDR")+"\t");
			}
			}catch(Exception e){
			e.printStackTrace();
			}finally{
				try{
					rs.close();
					st.close();
					con.close();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			
		}
		
	}

}
