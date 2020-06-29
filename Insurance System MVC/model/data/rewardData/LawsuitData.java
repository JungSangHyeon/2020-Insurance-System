package model.data.rewardData;

import component.DAO;

public class LawsuitData{

	// Component
	private DAO dao;
	
	// Constructor
	public LawsuitData() {this.dao = new DAO("Lawsuit", "lawsuitID", new Object[] {null, 0});}

	// Getter & Setter
	public int getPay() {return this.dao.getInt("pay");}
	public void setPay(int pay) {this.dao.update("pay", pay);}
}
