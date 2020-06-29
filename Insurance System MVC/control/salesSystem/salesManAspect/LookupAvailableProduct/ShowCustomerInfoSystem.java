package control.salesSystem.salesManAspect.LookupAvailableProduct;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.SigninCustomer.SinginCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.data.customerData.CustomerData;
import model.dataList.IntDataList;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct.ShowCustomerInfoView;
import view.panel.BasicPanel;

public class ShowCustomerInfoSystem extends SalesSystem {

	// Association
	private IntDataList<CustomerData> searchedCustomerList;
	private InputTextArea searchedNameTTA;

	// Constructor
	public ShowCustomerInfoSystem(IntDataList<CustomerData> customerList, InputTextArea customerNameTTA) {
		this.searchedCustomerList = customerList;
		this.searchedNameTTA = customerNameTTA;
	}

	@Override
	public BasicPanel getView() {return new ShowCustomerInfoView(this.actionListener, this.searchedCustomerList, this.searchedNameTTA);}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if (Character.isDigit(e.getActionCommand().charAt(0))) {
			for (CustomerData customerData : this.customerDataList.getList()) {
				if (Integer.toString(customerData.getID()).equals(e.getActionCommand())) {
					return new ShowAvailableProductSystem(customerData);
				}
			}
		}
		switch (ShowCustomerInfoView.EActionCommands.valueOf(e.getActionCommand())) {
			case SigninCustomer : return new SinginCustomerSystem();
			case LookupAvailableProduct : return new SearchCustomerSystem();
			case WatchActivityPlan: return new WatchActivityPlanSystem();
			case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
}
