package component;

import java.sql.ResultSet;

public class DAO extends MySQLStub {

	// Attribute
	protected String tableName, pkName;
	protected int id;
	
	// Constructor
	public DAO(String tableName, String pkName, Object[] defaultValues) { // Auto Increment ����� ����, id�� Default�� Null�� �� ��.
		// Set Attribute
		this.tableName = tableName;
		this.pkName = pkName;
		this.id = this.insert(defaultValues); // Create DB Data
	}
	
	// Create Time Use
	private int insert(Object...values) {return this.insert(this.tableName, values);}
	
	// Any Time Use 
	public void delete() {this.delete(this.tableName, this.pkName, this.id);}
	public ResultSet select() {return this.select(this.tableName, this.pkName, this.id);}
	public void update (String columnName, Object value) {this.update(this.tableName, this.pkName, this.id, columnName, value);}
	
	// Getter
	public int getInt(String columnName) {return this.getInt(this.tableName, this.pkName, this.id, columnName);}
	public String getString(String columnName) {return this.getString(this.tableName, this.pkName, this.id, columnName);}
	public double getDouble(String columnName) {return this.getDouble(this.tableName, this.pkName, this.id, columnName);}
	public boolean getBoolean(String columnName) {return this.getBoolean(this.tableName, this.pkName, this.id, columnName);}
	
}
