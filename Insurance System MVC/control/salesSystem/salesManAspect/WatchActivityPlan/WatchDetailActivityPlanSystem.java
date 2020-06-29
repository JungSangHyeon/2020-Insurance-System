package control.salesSystem.salesManAspect.WatchActivityPlan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import view.insuranceSystemView.salesView.salesMan.watchActivityPlan.WatchDetailActivityPlanView;
import view.panel.BasicPanel;

public class WatchDetailActivityPlanSystem extends SalesSystem {
	
	// Association
	private int activityPlanID;

	// Constructor
	public WatchDetailActivityPlanSystem(int ID) {this.activityPlanID = ID;}
	
	@Override
	public BasicPanel getView() {return new WatchDetailActivityPlanView(this.actionListener, this.activityPlanID,this.activityPlanList);}
	
	// no use
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (WatchDetailActivityPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
