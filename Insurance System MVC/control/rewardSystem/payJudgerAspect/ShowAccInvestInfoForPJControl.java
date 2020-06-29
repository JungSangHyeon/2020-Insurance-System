package control.rewardSystem.payJudgerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import view.insuranceSystemView.rewardView.payJudger.ShowAccInvestInfoForPJView;
import view.panel.BasicPanel;

public class ShowAccInvestInfoForPJControl extends RewardControl {

	// Attribute
	private PayJudgerData user;
	private int taskID;
	
	// Constructor
	public ShowAccInvestInfoForPJControl(PayJudgerData user, int taskID) {this.user=user; this.taskID=taskID;}
	
	@Override
	public BasicPanel getView() {return new ShowAccInvestInfoForPJView(this.user, this.actionListener, this.taskID, this.rewardDataList);}
	
	@Override 
	public DynamicSystem processEvent(ActionEvent e) {
		try {ShowAccInvestInfoForPJView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new WritePayJudgeReportControl(this.user, this.taskID);}
		
		switch (ShowAccInvestInfoForPJView.EActionCommands.valueOf(e.getActionCommand())) {
		case WritePayJudgeReport : return new WritePayJudgeReportControl(this.user, this.taskID); 
		}
		return null;
	}	
}
