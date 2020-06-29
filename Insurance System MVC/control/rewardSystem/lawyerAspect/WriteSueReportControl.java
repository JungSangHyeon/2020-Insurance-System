package control.rewardSystem.lawyerAspect;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.rewardData.LawsuitData;
import model.data.rewardData.RewardData;
import view.insuranceSystemView.rewardView.lawyer.WriteSueReportView;
import view.panel.BasicPanel;

public class WriteSueReportControl extends RewardControl {
	
	// Component
	private WriteSueReportView view;

	// Association
	private LawyerData user;
	private int taskID;

	public WriteSueReportControl(LawyerData user, int taskID) {
		this.user=user;
		this.taskID=taskID;
	}

	@Override
	public BasicPanel getView() {this.view = new WriteSueReportView(this.actionListener); return this.view;}
	

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WriteSueReportView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveLawsuitData : if(!this.isNumRight()) {return null;} this.save(); this.gotoBack(); break;
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
		LawsuitData data = new LawsuitData();
		data.setPay(Integer.parseInt(this.view.getPayTTA()));
		rewardData.setLawsuitData(data);
		
		JOptionPane.showMessageDialog(this.view, "보험금 지급이 완료되었습니다.");
	}

	

}
