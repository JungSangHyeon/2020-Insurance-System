package model.data.rewardData;

import component.DAO;

public class AccidentInvestigationData{

	// Component
	private DAO dao;
	
	// Constructor
	public AccidentInvestigationData() {this.dao = new DAO("AccidentInvestigation", "accidentInvestigationID", new Object[] {null, "", "", "", 0});}
	
	// Getter & Setter
	public String getScenario() {return this.dao.getString("scenario");}
	public String getDamage() {return this.dao.getString("damage");}
	public String getTreatment() {return this.dao.getString("treatment");}
	public int getTreatmentCost() {return this.dao.getInt("treatmentCost");}
	public void setScenario(String scenario) {this.dao.update("scenario", scenario);}
	public void setDamage(String damage) {this.dao.update("damage", damage);}
	public void setTreatment(String treatment) {this.dao.update("treatment", treatment);}
	public void setTreatmentCost(int treatmentCost) {this.dao.update("treatmentCost", treatmentCost);}
}
