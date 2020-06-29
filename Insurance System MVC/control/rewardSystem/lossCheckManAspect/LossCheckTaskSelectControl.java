package control.rewardSystem.lossCheckManAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import view.insuranceSystemView.rewardView.lossChecker.LossCheckTaskSelectView;
import view.panel.BasicPanel;

public class LossCheckTaskSelectControl extends RewardControl {

	// Association
	private LossCheckManData user;
	
	// Constructor
	public LossCheckTaskSelectControl(LossCheckManData user) {this.user=user;}
	
	@Override
	public BasicPanel getView() {return new LossCheckTaskSelectView (this.user, this.actionListener, this.rewardDataList);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowLossCheckInfosControl(this.user, Integer.parseInt(e.getActionCommand()));	
	}
}
