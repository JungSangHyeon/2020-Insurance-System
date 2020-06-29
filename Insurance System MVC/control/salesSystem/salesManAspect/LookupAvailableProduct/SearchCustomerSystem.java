package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import model.dataList.IntDataList;
import model.dataList.realDataList.DataList;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.SearchCustomerView;
import view.panel.BasicPanel;

public class SearchCustomerSystem extends SalesSystem {
	
	// Component
	private SearchCustomerView view;

	@Override
	public BasicPanel getView() {this.view =  new SearchCustomerView(this.actionListener, this.customerDataList);return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (SearchCustomerView.EActionCommands.valueOf(e.getActionCommand())) {
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		case search : return new ShowCustomerInfoSystem(search(),this.view.getCustomerNameTTA());
		}
		return null;
	}
	
	public IntDataList<CustomerData> search() {
		IntDataList<CustomerData> searchedCustomerList=new DataList<CustomerData>();
		for(CustomerData customerData : this.customerDataList.getList()) {
			if(customerData.getName().equals(this.view.getCustomerNameTTA().getContent())) {
				searchedCustomerList.add(customerData);
			}
		}
		return searchedCustomerList;
	}
}
