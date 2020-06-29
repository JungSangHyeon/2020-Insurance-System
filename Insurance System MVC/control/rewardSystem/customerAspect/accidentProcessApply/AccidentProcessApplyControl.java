package control.rewardSystem.customerAspect.accidentProcessApply;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.rewardSystem.RewardControl;
import control.rewardSystem.customerAspect.CustomerTaskSelectControl;
import control.rewardSystem.customerAspect.paymentAgree.ShowPaymentAgreeControl;
import model.data.customerData.CustomerData;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.rewardData.AccidentData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.AccidentInvestigationTask;
import view.insuranceSystemView.rewardView.customer.AccidentProcessApplyView;
import view.panel.BasicPanel;

public class AccidentProcessApplyControl extends RewardControl{

	// Association
	CustomerData user;
	
	// Component
	private AccidentProcessApplyView view;
	
	public AccidentProcessApplyControl(CustomerData user) {this.user=user;}

	@Override
	public BasicPanel getView() {this.view = new AccidentProcessApplyView(this.actionListener); return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (AccidentProcessApplyView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveAccidentData : this.save(); return new CustomerTaskSelectControl(user);
		case AccidentProcessApply : return new AccidentProcessApplyControl(this.user);
		case isPaymentAgree : 
			if(user.getTaskList().getList().isEmpty()) {
				JOptionPane.showMessageDialog(this.view, "사고 접수 기록이 없거나 업무가 완료되지 않았습니다.", "안내", JOptionPane.WARNING_MESSAGE);
			}else {
				return new ShowPaymentAgreeControl(user, rewardDataList);				
			}
		}
		return null;
	}
	
	private void save() {
		RewardData rewardData = new RewardData();
		AccidentData data = new AccidentData();
		data.setType(this.view.getAccidentType());
		data.setLocation(this.view.getAccidentLocation());
		data.setDate(this.view.getAccidentDate());
		rewardData.setAccidentData(data);
		this.rewardDataList.add(rewardData);
		
		for(AccidentInvestigatorData employee : this.accidentInvestigatorList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new AccidentInvestigationTask(rewardData.getID())); break;}
		}
	}

}
