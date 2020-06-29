package control.developSystem.developerAspect.showInsurance;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectControl;
import view.insuranceSystemView.developView.developer.showInsurance.SelectInsuranceToWatchView;
import view.panel.BasicPanel;

public class SelecInsuranceToWatchControl extends DevelopSystem {

	@Override
	public BasicPanel getView() {return new SelectInsuranceToWatchView(this.actionListener, this.insuranceList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {SelectInsuranceToWatchView.EActionCommands.valueOf(e.getActionCommand());}
		catch(IllegalArgumentException ee) {return new ShowInsuranceInfoControl(Integer.parseInt(e.getActionCommand()));}
		
		switch (SelectInsuranceToWatchView.EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectControl();
		case WatchInsuranceData : return new SelecInsuranceToWatchControl();
		}
		return null;
	}
}
