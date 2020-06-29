package component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConstant.DBConstant;

public class MySQLStub {
	
	// Attribute
	private java.sql.Statement statement;
	
	// Constructor
	public MySQLStub() {this.login(DBConstant.URL, DBConstant.USER, DBConstant.PW); this.useDB(DBConstant.DB);}
	
	// Any Time Use
	public void login(String url, String user, String pw) {
		try { // Set Attribute
			Connection connect = DriverManager.getConnection(url, user, pw);
			this.statement = connect.createStatement();
		} catch (SQLException e) {e.printStackTrace();}
	}
	public void useDB(String dbName) {try {this.statement.executeQuery("use "+dbName+";");} catch (SQLException e) {e.printStackTrace();}}
	
	public int insert(String tableName, Object...values) {
		String instruction = "insert into "+tableName+ " values(";	
		for(Object value : values) {instruction += (this.objectToString(value)+", ");}
		instruction = instruction.substring(0, instruction.length() - 2) + ");"; // 마지막 ", "를 제거
		try {this.statement.execute(instruction);} catch (SQLException e) {e.printStackTrace();}
		try {
			ResultSet rs = this.statement.executeQuery("select last_insert_id() as last_id from "+tableName);
			if(rs.next()) {return Integer.parseInt(rs.getString("last_id"));}
		} catch (SQLException e) {e.printStackTrace();}
		System.err.println("MySQLStub - insert err");
		return 0;
	}
	public ResultSet select(String tableName, String pkName, int id) {
		String instruction = "select * from " + tableName + " where "+ pkName+" = "+id+";";
		try {return this.statement.executeQuery(instruction);} catch (SQLException e) {e.printStackTrace(); return null;}
	}
	public void update (String tableName, String pkName, int id, String name, Object value) {
		String instruction = "update " + tableName + " set " + name + " = " + this.objectToString(value) + " where "+pkName+" = " + id + ";";
		try {this.statement.execute(instruction);} catch (SQLException e) {e.printStackTrace();}
	}
	public void delete(String tableName, String pkName, int id) {
		String instruction = "delete from " + tableName + " where "+ pkName+" = "+id+";";
		try {this.statement.execute(instruction);} catch (SQLException e) {e.printStackTrace();}
	}
	public String objectToString(Object value) {
		if(value instanceof Integer) {return (Integer.toString((Integer)value));}
		else if(value instanceof Double) {return (Double.toString((Double)value));}
		else if(value instanceof Boolean) {if((boolean) value) {return "TRUE";}else {return "FALSE";}}
		else if(value instanceof String) {return ("\""+value+"\" ");} // 고정적이라 "" 달아놓음
		else {return null;}
	}
	public String getString(String tableName, String pkName, int id, String columName) {
		try {ResultSet rs = this.select(tableName, pkName, id); if(rs.next()) {return rs.getString(columName);}}catch (SQLException e) {e.printStackTrace();}
		System.err.println("MySQL Stub - Get String ERR");
		return null;
	}
	public int getInt(String tableName, String pkName, int id, String columName) {
		try {ResultSet rs = this.select(tableName, pkName, id); if(rs.next()) {return rs.getInt(columName);}}catch (SQLException e) {e.printStackTrace();}
		System.err.println("MySQL Stub - Get Int ERR");
		return -1;
	}
	public double getDouble(String tableName, String pkName, int id, String columName) {
		try {ResultSet rs = this.select(tableName, pkName, id); if(rs.next()) {return rs.getDouble(columName);}}catch (SQLException e) {e.printStackTrace();}
		System.err.println("MySQL Stub - Get Double ERR");
		return -1; 
	}
	public boolean getBoolean(String tableName, String pkName, int id, String columName) {
		try {ResultSet rs = this.select(tableName, pkName, id); if(rs.next()) {return rs.getBoolean(columName);}}catch (SQLException e) {e.printStackTrace();}
		System.err.println("MySQL Stub - Get Boolean ERR");
		return false;
	}
}
