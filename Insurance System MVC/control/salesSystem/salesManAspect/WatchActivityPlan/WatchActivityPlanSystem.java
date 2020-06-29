package control.salesSystem.salesManAspect.WatchActivityPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchActivityPlan.WatchActivityPlanView;
import view.panel.BasicPanel;

public class WatchActivityPlanSystem extends SalesSystem {

	@Override
	public BasicPanel getView() {return new WatchActivityPlanView(this.actionListener, this.activityPlanList);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(Character.isDigit(e.getActionCommand().charAt(0)))return new WatchDetailActivityPlanSystem(Integer.parseInt(e.getActionCommand()));
		switch (WatchActivityPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
