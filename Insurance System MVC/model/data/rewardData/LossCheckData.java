package model.data.rewardData;

import component.DAO;

public class LossCheckData{
	
	// Component
	private DAO dao;
	
	// Constructor
	public LossCheckData() {this.dao = new DAO("LossData", "lossDataID", new Object[] {null, 0, ""});}

	// Getter & Setter
	public String getJudgeEvidence() {return this.dao.getString("judgeEvidence");}
	public int getPay() {return this.dao.getInt("pay");}
	public void setJudgeEvidence(String judgeEvidence) {this.dao.update("judgeEvidence", judgeEvidence);}
	public void setPay(int pay) {this.dao.update("pay", pay);}
}
