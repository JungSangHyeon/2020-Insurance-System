package control.rewardSystem.customerAspect.paymentAgree;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import control.rewardSystem.customerAspect.accidentProcessApply.AccidentProcessApplyControl;
import model.data.customerData.CustomerData;
import model.data.rewardData.RewardData;
import model.dataList.IntDataList;
import view.insuranceSystemView.rewardView.customer.ShowPaymentAgreeView;
import view.panel.BasicPanel;

public class ShowPaymentAgreeControl extends RewardControl {
	
	// Association
	private CustomerData user;
	private IntDataList<RewardData> rewardDataList;
	
	// Component
	private ShowPaymentAgreeView view;
	
	// Constructor
	public ShowPaymentAgreeControl(CustomerData user, IntDataList<RewardData> rewardDataList) {this.user=user; this.rewardDataList=rewardDataList;}

	@Override
	public BasicPanel getView() {return new ShowPaymentAgreeView(this.actionListener, this.user, this.rewardDataList);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {ShowPaymentAgreeView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new PaymentAgreeControl(this.user, Integer.parseInt(e.getActionCommand()));}
		
		switch (ShowPaymentAgreeView.EActionCommands.valueOf(e.getActionCommand())) {
		case AccidentProcessApply : return new AccidentProcessApplyControl(this.user);
		case isPaymentAgree : 
			if(user.getTaskList().getList().isEmpty()) {
				JOptionPane.showMessageDialog(this.view, "사고 접수 기록이 없거나 업무가 완료되지 않았습니다.", "안내", JOptionPane.WARNING_MESSAGE);
			}else {
				return new ShowPaymentAgreeControl(user, this.rewardDataList);				
			}
		}
		return null;
	}
}