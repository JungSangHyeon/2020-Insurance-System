package control.rewardSystem.payJudgerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.rewardData.PayJudgeData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.LossCheckTask;
import view.insuranceSystemView.rewardView.payJudger.WritePayJudgeReportView;
import view.panel.BasicPanel;

public class WritePayJudgeReportControl extends RewardControl {

	// Component
	private WritePayJudgeReportView view;
		
	// Association
	private PayJudgerData user;
	private int taskID;
		
	public WritePayJudgeReportControl(PayJudgerData user, int taskID) {
		this.user=user;
		this.taskID=taskID;
	}
	
	@Override
	public BasicPanel getView() {this.view = new WritePayJudgeReportView(this.actionListener); return this.view;}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WritePayJudgeReportView.EActionCommands.valueOf(e.getActionCommand())) {
		case SavePayJudgeData : this.save(); this.gotoBack(); break;
		default:
			break;
		}
		this.user.deleteTask(this.taskID);
		this.gotoBack();
		return null;
	}
	
	private void save() {
		RewardData rewardData = this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID());
		PayJudgeData data = new PayJudgeData();
		data.setPayJudge(this.view.getPayJudgeTTA());
		data.setJudgementEvidence(this.view.getJudgementEvidenceTTA());
		data.setRelatedLaw(this.view.getRelatedLawTTA());
		rewardData.setPayJudgeData(data);
		
		for(LossCheckManData employee : this.lossCheckManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new LossCheckTask(rewardData.getID()));
			}
		}
	}


}
