package control.rewardSystem.payJudgerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import view.insuranceSystemView.rewardView.payJudger.PayJudgerTaskSelectView;
import view.panel.BasicPanel;

public class PayJudgerTaskSelectControl extends RewardControl {

	// Association
	private PayJudgerData user;
	
	// Constructor
	public PayJudgerTaskSelectControl(PayJudgerData user) {this.user=user;}
	
	@Override
	public BasicPanel getView() {return new PayJudgerTaskSelectView (this.user, this.actionListener, this.rewardDataList);}	

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowAccInvestInfoForPJControl(this.user, Integer.parseInt(e.getActionCommand()));		
		}	
	}
