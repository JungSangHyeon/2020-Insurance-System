package model.data.rewardData;

import component.DAO;

public class AccidentData {

	// Component
	private DAO dao;
	
	// Constructor
	public AccidentData() {this.dao = new DAO("AccidentData", "accidentDataID", new Object[] {null, "", "", ""});}
	
	// Getter & Setter
	public String getType() {return this.dao.getString("accidentType");}
	public String getLocation() {return this.dao.getString("location");}
	public String getDate() {return this.dao.getString("date");}
	public void setType(String type) {this.dao.update("accidentType", type);}
	public void setLocation(String location) {this.dao.update("location", location);}
	public void setDate(String date) {this.dao.update("date", date);}
	
//	// Attributes
//	private String type, date, location;
//	
//	// Getter & Setter
//	public String getType() {return type;}
//	public void setType(String type) {this.type = type;}
//	public String getLocation() {return location;}
//	public void setLocation(String location) {this.location = location;}
//	public String getDate() {return date;}
//	public void setDate(String date) {this.date = date;}
}
