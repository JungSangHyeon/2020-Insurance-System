package control.developSystem.developerAspect.developInsurance;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchControl;
import view.insuranceSystemView.developView.developer.developInsurance.DevelopInsuranceSelectView;
import view.panel.BasicPanel;

public class DevelopeInsuranceSelectControl extends DevelopSystem {

	@Override
	public BasicPanel getView() {return new DevelopInsuranceSelectView(this.actionListener);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (DevelopInsuranceSelectView.EActionCommands.valueOf(e.getActionCommand())) {
		case CarInsurance : return new DevelopCarInsuranceControl();
		case DiseaseInsurance : return new DevelopDiseaseInsuranceControl();
		case FireInsurance : return new DevelopFireInsuranceControl();
		case InsuranceDesign : return new DevelopeInsuranceSelectControl();
		case WatchInsuranceData : return new SelecInsuranceToWatchControl();
		}
		return null;
	}
}
