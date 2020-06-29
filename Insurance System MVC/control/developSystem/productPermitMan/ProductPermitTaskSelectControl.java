package control.developSystem.productPermitMan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan.PermitTaskSelectView;
import view.panel.BasicPanel;

public class ProductPermitTaskSelectControl extends DevelopSystem {

	// Attribute
	private ProductPermitManData loginPPM;
		
	// Constructor
	public ProductPermitTaskSelectControl(ProductPermitManData user) {this.loginPPM=user;}

	@Override
	public BasicPanel getView() {return new PermitTaskSelectView(this.actionListener, this.loginPPM, this.insuranceList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceForProductPermitControl(this.loginPPM.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
