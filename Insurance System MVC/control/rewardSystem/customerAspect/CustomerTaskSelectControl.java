package control.rewardSystem.customerAspect;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import control.rewardSystem.customerAspect.accidentProcessApply.AccidentProcessApplyControl;
import control.rewardSystem.customerAspect.paymentAgree.ShowPaymentAgreeControl;
import model.data.customerData.CustomerData;
import view.insuranceSystemView.rewardView.customer.CustomerTaskSelectView;
import view.panel.BasicPanel;

public class CustomerTaskSelectControl extends RewardControl{
	
	// Association
	private CustomerData user;
	
	// Component
	private CustomerTaskSelectView view;
	
	// Constructor
	public CustomerTaskSelectControl(CustomerData user) {this.user=user;}

	@Override
//	public BasicPanel getPanel() {return new CustomerTaskSelectView(this.actionListener);}
	public BasicPanel getView() {this.view = new CustomerTaskSelectView(this.actionListener); return this.view;}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (CustomerTaskSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case AccidentProcessApply : return new AccidentProcessApplyControl(this.user);
		case isPaymentAgree : 
			if(user.getTaskList().getList().isEmpty()) {
				JOptionPane.showMessageDialog(this.view, "사고 접수 기록이 없거나 업무가 완료되지 않았습니다.", "안내", JOptionPane.WARNING_MESSAGE);
			}else {
				return new ShowPaymentAgreeControl(this.user, this.rewardDataList);				
			}
		}
		return null;
	}
}
