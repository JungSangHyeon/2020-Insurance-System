package control.rewardSystem.lawyerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import view.insuranceSystemView.rewardView.lawyer.LawsuitTaskSelectView;
import view.panel.BasicPanel;

public class LawsuitTaskSelectControl extends RewardControl {

	// Association
	private LawyerData user;

	// Constructor
	public LawsuitTaskSelectControl(LawyerData user) {this.user = user;}
	
	@Override
	public BasicPanel getView() {return new LawsuitTaskSelectView (this.user, this.actionListener, this.rewardDataList);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowRewardDataInfoForLwControl(this.user, Integer.parseInt(e.getActionCommand()));
	}

}
