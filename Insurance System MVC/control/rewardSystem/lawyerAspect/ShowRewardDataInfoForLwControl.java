package control.rewardSystem.lawyerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import view.insuranceSystemView.rewardView.lawyer.ShowRewardDataInfoForLwView;
import view.panel.BasicPanel;

public class ShowRewardDataInfoForLwControl extends RewardControl {

	// Attribute
	private int taskID;
	
	// Association
	private LawyerData user;
	
	// Constructor
	public ShowRewardDataInfoForLwControl(LawyerData user, int taskID) {this.user=user; this.taskID=taskID;}
	
	@Override
	public BasicPanel getView() {return new ShowRewardDataInfoForLwView(this.user, this.actionListener, this.taskID, this.rewardDataList);}

	@Override public DynamicSystem processEvent(ActionEvent e) {
		try {ShowRewardDataInfoForLwView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new WriteSueReportControl(this.user, this.taskID);}
		
		switch (ShowRewardDataInfoForLwView.EActionCommands.valueOf(e.getActionCommand())) {
		case writeSueReport : return new WriteSueReportControl(this.user, this.taskID);
		}
		return null;
	}
}
