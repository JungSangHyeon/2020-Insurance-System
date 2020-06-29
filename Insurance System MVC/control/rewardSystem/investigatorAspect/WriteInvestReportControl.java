package control.rewardSystem.investigatorAspect;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.rewardData.AccidentInvestigationData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.PayJudgeTask;
import view.insuranceSystemView.rewardView.investigator.WriteInvestReportView;
import view.panel.BasicPanel;

public class WriteInvestReportControl extends RewardControl {
			
	// Component
	private WriteInvestReportView view;
	
	// Association
	private AccidentInvestigatorData user;
	private int taskID;
	
	public WriteInvestReportControl(AccidentInvestigatorData user, int taskID) {this.user=user; this.taskID=taskID;}

	@Override
	public BasicPanel getView() {this.view = new WriteInvestReportView(this.actionListener); return this.view;}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WriteInvestReportView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveAccidentInvestigationData : if(!this.isNumRight()) {return null;} this.save(); this.gotoBack(); break;
		default: break;
		}
		this.user.deleteTask(this.taskID);
		this.gotoBack();
		return null;
	}
	
	private boolean isNumRight() {
		try {Double.parseDouble(this.view.getTreatmentCostTTA());}
		catch(NumberFormatException exc) {JOptionPane.showMessageDialog(this.view, "사고 처리 비용은 숫자로 입력해 주세요"); return false;}
		return true;
	}

	private void save() {
		RewardData rewardData = this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID());
		AccidentInvestigationData data = new AccidentInvestigationData();
		data.setScenario(this.view.getScenarioTTA());
		data.setDamage(this.view.getDamageTTA());
		data.setTreatment(this.view.getTreatmentTTA());
		data.setTreatmentCost(Integer.parseInt(this.view.getTreatmentCostTTA()));	
		rewardData.setAccidentInvestigationData(data);

		for(PayJudgerData employee : this.payJudgerList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new PayJudgeTask(rewardData.getID()));}
		}
	}	
}