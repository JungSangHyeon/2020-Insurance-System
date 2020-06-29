package control.loginSystem;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.developerAspect.DeveloperTaskSelectControl;
import control.developSystem.insuranceRatePermitMan.InsuranceRatePermitTaskSelectControl;
import control.developSystem.productPermitMan.ProductPermitTaskSelectControl;
import control.rewardSystem.customerAspect.CustomerTaskSelectControl;
import control.rewardSystem.investigatorAspect.InvestigatorTaskSelectControl;
import control.rewardSystem.lawyerAspect.LawsuitTaskSelectControl;
import control.rewardSystem.lossCheckManAspect.LossCheckTaskSelectControl;
import control.rewardSystem.payJudgerAspect.PayJudgerTaskSelectControl;
import control.salesSystem.salesManAspect.SalesManTaskSelectSystem;
import control.salesSystem.salesManagerAspect.SalesManagerTaskSelectSystem;
import model.data.customerData.CustomerData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.systemUserData.SystemUserData;
import view.insuranceSystemView.loginView.LoginView;
import view.panel.BasicPanel;

public class RealLoginControl extends LoginSystem {

	// Component
	private LoginView view;
	
	@Override
	public BasicPanel getView() {this.view = new LoginView(this.actionListener); return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		// Develop Aspect
		SystemUserData<?> user;
		user = this.login(this.developerList.getList());
		if(user != null) {return new DeveloperTaskSelectControl();}
		user = this.login(this.insuranceRatePermitManList.getList());
		if(user != null) {return new InsuranceRatePermitTaskSelectControl((InsuranceRatePermitManData) user);}
		user = this.login(this.productPermitManList.getList());
		if(user != null) {return new ProductPermitTaskSelectControl((ProductPermitManData) user);}
		
		// Sales Aspect
		user = this.login(this.salesManList.getList());
		if(user != null) {return new SalesManTaskSelectSystem();}
		user = this.login(this.salesManagerList.getList());
		if(user != null) {return new SalesManagerTaskSelectSystem();}
		
//		// Reward Aspect
		user = this.login(this.customerList.getList());
		if(user != null) {return new CustomerTaskSelectControl((CustomerData) user);}
		user = this.login(this.accidentInvestigatorList.getList());
		if(user != null) {return new InvestigatorTaskSelectControl((AccidentInvestigatorData) user);}
		user = this.login(this.payJudgerList.getList());
		if(user != null) {return new PayJudgerTaskSelectControl((PayJudgerData) user);}
		user = this.login(this.lossCheckManList.getList());
		if(user != null) {return new LossCheckTaskSelectControl((LossCheckManData) user);}
		user = this.login(this.lawyerList.getList());
		if(user != null) {return new LawsuitTaskSelectControl((LawyerData) user);}
		
		// No User
		JOptionPane.showMessageDialog(this.view, "계정이 없습니다."); return null;
	}
	private SystemUserData<?> login(Vector<? extends SystemUserData<?>> list) {
		String id = this.view.getID(), pw = this.view.getPW();
		for(SystemUserData<?> data : list) {if(data.getLoginID().equals(id) && data.getLoginPW().equals(pw)) {return data;}}
		return null;
	}
}
