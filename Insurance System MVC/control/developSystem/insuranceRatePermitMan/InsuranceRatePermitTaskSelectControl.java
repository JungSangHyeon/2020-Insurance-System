package control.developSystem.insuranceRatePermitMan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan.PermitTaskSelectView;
import view.panel.BasicPanel;

public class InsuranceRatePermitTaskSelectControl extends DevelopSystem {

	// Attribute
	private InsuranceRatePermitManData loginIRPM;
		
	// Constructor
	public InsuranceRatePermitTaskSelectControl(InsuranceRatePermitManData loginIRPM) {this.loginIRPM=loginIRPM;}

	@Override
	public BasicPanel getView() {return new PermitTaskSelectView(this.actionListener, this.loginIRPM, this.insuranceList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceForInsuranceRatePermitControl(this.loginIRPM.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
