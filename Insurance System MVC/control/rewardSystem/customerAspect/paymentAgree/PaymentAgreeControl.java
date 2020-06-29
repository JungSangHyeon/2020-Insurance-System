package control.rewardSystem.customerAspect.paymentAgree;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import control.rewardSystem.customerAspect.accidentProcessApply.AccidentProcessApplyControl;
import model.data.customerData.CustomerData;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.LawSuitTask;
import view.insuranceSystemView.rewardView.customer.PaymentAgreeView;
import view.panel.BasicPanel;

public class PaymentAgreeControl extends RewardControl {
	
	// Attribute
	private int taskID;
	
	// Association
	private CustomerData user;
	
	// Component
	private PaymentAgreeView view;
	
	// Constructor
	public PaymentAgreeControl(CustomerData user, int taskID) {this.user=user; this.taskID=taskID;}
	
	@Override
//	public BasicPanel getPanel() {return new PaymentAgreeView(this.actionListener, this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID()));}
	public BasicPanel getView() {this.view = new PaymentAgreeView(this.actionListener, this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID())); return this.view;}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (PaymentAgreeView.EActionCommands.valueOf(e.getActionCommand())) {
		case AccidentProcessApply : return new AccidentProcessApplyControl(this.user);
		case isPaymentAgree : 
			if(user.getTaskList().getList().isEmpty()) {
				JOptionPane.showMessageDialog(this.view, "사고 접수 기록이 없거나 업무가 완료되지 않았습니다.", "안내", JOptionPane.WARNING_MESSAGE);
			}else {
				return new ShowPaymentAgreeControl(user, this.rewardDataList);				
			}
		case Permit : JOptionPane.showMessageDialog(this.view, "보험금 지급이 완료되었습니다.", "보험금 지급 안내", JOptionPane.INFORMATION_MESSAGE); break;
		case Ban : this.orderLawsuit(); JOptionPane.showMessageDialog(this.view, "소송 절차를 시작합니다. 소송 결과에 따라 보험금이 지급됩니다."); break;
		default: break; 	
		}
		this.user.deleteTask(this.taskID);
		this.gotoBack();
		return null;
	}
	
	private void orderLawsuit() {
		RewardData rewardData = this.rewardDataList.search(this.user.getTaskList().search(this.taskID).getRewardDataID());	
		for(LawyerData employee : this.lawyerList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new LawSuitTask(rewardData.getID()));
			}
		}
	}	
}
