package control.salesSystem.salesManAspect.WatchSalesTrainingPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan.WatchSalesTrainingPlanView;
import view.panel.BasicPanel;

public class WatchSalesTrainingPlanSystem extends SalesSystem {
	
	@Override
	public BasicPanel getView() {return new WatchSalesTrainingPlanView(this.actionListener, this.salesTrainigPlanList);}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(Character.isDigit(e.getActionCommand().charAt(0)))return new WatchDetailSalesTrainingPlanSystem(Integer.parseInt(e.getActionCommand()));
		switch (WatchSalesTrainingPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
