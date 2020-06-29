package control.rewardSystem.lossCheckManAspect;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.customerData.CustomerData;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.rewardData.LossCheckData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.PayAgreementTask;
import view.insuranceSystemView.rewardView.lossChecker.WriteLossCheckReportView;
import view.panel.BasicPanel;

public class WriteLossCheckReportControl extends RewardControl {
	
	// Component
	private WriteLossCheckReportView view;
	
	// Association
	private LossCheckManData user;
	private int taskID;
	
	public WriteLossCheckReportControl(LossCheckManData user, int taskID) {
		this.user=user;
		this.taskID=taskID;
	}
	
	@Override
	public BasicPanel getView() {this.view = new WriteLossCheckReportView(this.actionListener); return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WriteLossCheckReportView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveLossCheckData : if(!this.isNumRight()) {return null;} this.save(); this.gotoBack();
		default:
			break;
		}
		this.user.deleteTask(this.taskID);
		this.gotoBack();
		return null;
	}
	
	private boolean isNumRight() {
		try {Double.parseDouble(this.view.getPayTTA());}
		catch(NumberFormatException exc) {JOptionPane.showMessageDialog(this.view, "지급 보험금은 숫자로 입력해 주세요"); return false;}
		return true;
	}

	private void save() {
		RewardData rewardData = this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID());
		LossCheckData data = new LossCheckData();
		data.setPay(Integer.parseInt(this.view.getPayTTA()));
		data.setJudgeEvidence(this.view.getJudgeEvidenceTTA());
		rewardData.setLossData(data);
		for(CustomerData customer : this.customerList.getList()) {
			customer.addTask(new PayAgreementTask(rewardData.getID()));
		}
	}
}
