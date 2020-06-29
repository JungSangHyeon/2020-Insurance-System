package control.rewardSystem.investigatorAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import view.insuranceSystemView.rewardView.investigator.InvestigatorTaskSelectView;
import view.panel.BasicPanel;

public class InvestigatorTaskSelectControl extends RewardControl {
	
	// Association
	private AccidentInvestigatorData user;

	// Constructor
	public InvestigatorTaskSelectControl(AccidentInvestigatorData user) {this.user=user;}

	@Override
	public BasicPanel getView() {return new InvestigatorTaskSelectView (this.user, this.actionListener, this.rewardDataList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowAccidentInfoForIVControl(this.user, Integer.parseInt(e.getActionCommand()));		
		}	
	}
