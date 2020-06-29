package model.data.rewardData;

import component.DAO;

public class PayJudgeData{

	// Component
	private DAO dao;
	
	// Constructor
	public PayJudgeData() {this.dao = new DAO("Payjudge", "payjudgeID", new Object[] {null, "", "", ""});}

	// Getter & Setter
	public String getPayJudge() {return this.dao.getString("payJudge");}
	public String getJudgementEvidence() {return this.dao.getString("evidence");}
	public String getRelatedLaw() {return this.dao.getString("relatedLaw");}
	public void setPayJudge(String payJudge) {this.dao.update("payJudge", payJudge);}
	public void setJudgementEvidence(String evidence) {this.dao.update("evidence", evidence);}
	public void setRelatedLaw(String relatedLaw) {this.dao.update("relatedLaw", relatedLaw);}
}
