package model.data.rewardData;

import model.data.Data;

public class RewardData extends Data {

	// Association
	private AccidentData accidentData;
	private AccidentInvestigationData accidentInvestigationData;
	private PayJudgeData payJudgeData;
	private LossCheckData lossData;
	private LawsuitData lawsuitData;

	public AccidentData getAccidentData() {return accidentData;}
	public AccidentInvestigationData getAccidentInvestigationData() {return accidentInvestigationData;}
	public PayJudgeData getPayJudgeData() {return payJudgeData;}
	public LossCheckData getLossData() {return lossData;}
	public LawsuitData getLawsuitData() {return lawsuitData;}

	public void setAccidentData(AccidentData accidentData) {this.accidentData=accidentData;}
	public void setAccidentInvestigationData(AccidentInvestigationData accidentInvestigationData) {this.accidentInvestigationData=accidentInvestigationData;}
	public void setPayJudgeData(PayJudgeData payJudgeData) {this.payJudgeData=payJudgeData;}
	public void setLossData(LossCheckData lossData) {this.lossData=lossData;}
	public void setLawsuitData(LawsuitData lawsuitData) {this.lawsuitData=lawsuitData;}
//	// Component
//	private DAO dao;
//	
//	// Constructor
//	public RewardData() {this.dao = new DAO("RewardData", "rewardDataID", new Object[] {null, 0, 0, 0, 0, 0});}
//	
//	// Attribute
//	private int customerID;
//	
//	// Association
//	private AccidentData accidentData;
//	private AccidentInvestigationData accidentInvestigationData;
//	private PayJudgeData payJudgeData;
//	private LossCheckData lossData;
//	private LawsuitData lawsuitData;
//	
//	// Getter & Setter
//	// customer rewardData¿¡ ¾øÀ½
//	public int getCustomerID() {return customerID;}
//	public void setCustomerID(int customerID) {this.customerID = customerID;}
//	
//	public AccidentData getAccidentData() {return accidentData;}
//	public AccidentInvestigationData getAccidentInvestigationData() {return accidentInvestigationData;}
//	public PayJudgeData getPayJudgeData() {return payJudgeData;}
//	public LossCheckData getLossData() {return lossData;}
//	public LawsuitData getLawsuitData() {return lawsuitData;}
//	
//	public void setAccidentData(AccidentData accidentData) {this.dao.update("reAccidentDataID", accidentData);}
//	public void setAccidentInvestigationData(AccidentInvestigationData accidentInvestigationData) {this.dao.update("reAccidentDataID", accidentData);}
//	public void setPayJudgeData(PayJudgeData payJudgeData) {this.dao.update("reAccidentDataID", accidentData);}
//	public void setLossData(LossCheckData lossData) {this.dao.update("reAccidentDataID", accidentData);}
//	public void setLawsuitData(LawsuitData lawsuitData) {this.dao.update("reAccidentDataID", accidentData);}
}
