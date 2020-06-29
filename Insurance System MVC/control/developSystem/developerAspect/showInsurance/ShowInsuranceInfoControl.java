package control.developSystem.developerAspect.showInsurance;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectControl;
import view.insuranceSystemView.developView.developer.showInsurance.ShowInsuranceInfoView;
import view.panel.BasicPanel;

public class ShowInsuranceInfoControl extends DevelopSystem {

	// Attribute
	private int insuranceID;
	
	// Constructor
	public ShowInsuranceInfoControl(int insuranceID) {this.insuranceID=insuranceID;}

	@Override
	public BasicPanel getView() {return new ShowInsuranceInfoView(this.actionListener, this.insuranceList.search(this.insuranceID));}
	
	@Override 
	public DynamicSystem processEvent(ActionEvent e) {
		switch (ShowInsuranceInfoView.EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectControl();
		case WatchInsuranceData : return new SelecInsuranceToWatchControl();
		}
		return null;
	}
}
