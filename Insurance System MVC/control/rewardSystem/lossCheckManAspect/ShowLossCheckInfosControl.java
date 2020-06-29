package control.rewardSystem.lossCheckManAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import view.insuranceSystemView.rewardView.lossChecker.ShowLossCheckInfosView;
import view.panel.BasicPanel;

public class ShowLossCheckInfosControl extends RewardControl {

	// Attribute
	private int taskID;
	
	// Association
	private LossCheckManData user;
		
	// Constructor
	public ShowLossCheckInfosControl(LossCheckManData user, int taskID) {
		this.user=user;
		this.taskID=taskID;
		}
		
	@Override
	public BasicPanel getView() {return new ShowLossCheckInfosView(this.user, this.actionListener, this.taskID, this.rewardDataList);}

	@Override 
	public DynamicSystem processEvent(ActionEvent e) {	
		try {ShowLossCheckInfosView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new WriteLossCheckReportControl(this.user, this.taskID);}
		
		switch (ShowLossCheckInfosView.EActionCommands.valueOf(e.getActionCommand())) {
		case WriteLossCheckReport :	return new WriteLossCheckReportControl(this.user, this.taskID);
		}
		return null;
	}
}