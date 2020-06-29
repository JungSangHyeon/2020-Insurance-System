package control.rewardSystem.investigatorAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import view.insuranceSystemView.rewardView.investigator.ShowAccidentInfoForIVView;
import view.panel.BasicPanel;

public class ShowAccidentInfoForIVControl extends RewardControl {

	// Attribute
	private AccidentInvestigatorData user;
	private int taskID;
	
	// Constructor
	public ShowAccidentInfoForIVControl(AccidentInvestigatorData user, int taskID) {this.user=user; this.taskID=taskID;}
	
	@Override
	public BasicPanel getView() {return new ShowAccidentInfoForIVView(this.user, this.actionListener, this.taskID, this.rewardDataList);}

	@Override 
	public DynamicSystem processEvent(ActionEvent e) {
		try {ShowAccidentInfoForIVView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new WriteInvestReportControl(this.user, this.taskID);}
		
		switch (ShowAccidentInfoForIVView.EActionCommands.valueOf(e.getActionCommand())) {
		case WriteInvestReport : return new WriteInvestReportControl(this.user, this.taskID);
		}
		return null;
	}	
}