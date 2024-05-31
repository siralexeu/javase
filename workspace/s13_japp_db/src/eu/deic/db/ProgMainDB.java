package eu.deic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class SQLiteJDBCDAO{
	private static Connection c;
	private static String cClass = "org.sqlite.JDBC";
	private static String connectivityString = "jdbc:sqlite:test.db";
	private static int var =0;
	
	public static void initConnection() throws ClassNotFoundException,SQLException {
		Class.forName(cClass);
		c = DriverManager.getConnection(connectivityString);
		c.setAutoCommit(false);
	}
	
	public static void createDBtable() throws SQLException {
		if(c == null) throw new SQLException("jdbc sql cONNECTION NULL!");
		Statement st = c.createStatement();
		String sqlDtopTable = "drop table COMPANY";
		String sqlCreateTable = "create table COMPANY(ID INT PRIMARY KEY NOT NULL,"+
							" NAME TEXT NOT NULL, AGE INT, ADDRESS CHAR(50),SALARY REAL)";
		 if( var == 1)st.executeUpdate(sqlDtopTable);
		st.executeUpdate(sqlCreateTable);
		var++;
		st.close();
		c.commit();
	}
	
	public static void insertDBdata() throws SQLException {
		if(c == null) throw new SQLException("jdbc sql cONNECTION NULL!");
		Statement st = c.createStatement();
		String sqlIns = "insert into COMPANY(ID, NAME, AGE, ADDRESS, SALARY) values(1, 'Paul',32,'Bucuresti', 21000.32)";
		st.executeUpdate(sqlIns);
		st.close();
		String sqlInsPS = "insert into COMPANY(ID, NAME, AGE, ADDRESS, SALARY) values(?,?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sqlInsPS);
		
		ps.setInt(1, 2);
		ps.setString(2, "David");
		ps.setInt(3, 21);
		ps.setString(4, "TM");
		ps.setFloat(5, 18231.23f);
		ps.executeUpdate();
		
		ps.setInt(1, 3);
		ps.setString(2, "Maria");
		ps.setInt(3, 27);
		ps.setString(4, "CJ");
		ps.setFloat(5, 16157.18f);
		ps.executeUpdate();
		
		ps.close();
		c.commit();
	}
	
	public static void selectDBdata() throws SQLException {
		if(c == null) throw new SQLException("jdbc sql cONNECTION NULL!");
		Statement st = c.createStatement();
		//String sqlSel = "select * from COMPANY";
		String sqlSel = "select * from COMPANY where AGE > 25";
		ResultSet rs = st.executeQuery(sqlSel);
		while(rs.next()) {
			int id = rs.getInt("ID");
			String n = rs.getString("NAME");
			int age = rs.getInt("AGE");
			String addr = rs.getString("ADDRESS");
			float sal = rs.getFloat("SALARY");
			
			System.out.printf("\n ID = %d, Name = %s, age = %d, address = %s, salary = %f", id,n,age,addr,sal);
						
		}
		st.close();
	
	}
	
	public static void releaseResources() throws SQLException {
		if (c != null) {
			c.close();
			c = null;
		}
	}
}

public class ProgMainDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Playground for SQL using JDBC!");
		try{
			SQLiteJDBCDAO.initConnection();
			SQLiteJDBCDAO.createDBtable();
			SQLiteJDBCDAO.insertDBdata();
			SQLiteJDBCDAO.selectDBdata();
			SQLiteJDBCDAO.releaseResources();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}