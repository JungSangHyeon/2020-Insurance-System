package control.developSystem.developerAspect;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectControl;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchControl;
import view.insuranceSystemView.developView.developer.DeveloperTaskSelectView;
import view.panel.BasicPanel;

public class DeveloperTaskSelectControl extends DevelopSystem {

	@Override
	public BasicPanel getView() {return new DeveloperTaskSelectView (this.actionListener);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (DeveloperTaskSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectControl();
		case WatchInsuranceData : return new SelecInsuranceToWatchControl();
		}
		return null;
	}
}
