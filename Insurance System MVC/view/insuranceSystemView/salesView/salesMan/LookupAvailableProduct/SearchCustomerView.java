package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.customerData.CustomerData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SearchCustomerView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan,search}
	
	// Component
	private InputTextArea customerNameTTA;

	// Constructor
	public SearchCustomerView(ActionListener actionListener, IntDataList<CustomerData> customerDataList) {
		// add component (create component와 for문으로 합쳐져있음)
		this.addComponent(new BasicLabel("고객명 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1});
		this.customerNameTTA = new InputTextArea("고객명", "정상현", 1, 100);
		g.addGroupComponent(this.customerNameTTA);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("조회",EActionCommands.search.name(),actionListener));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	// get & set
	public InputTextArea getCustomerNameTTA() {return this.customerNameTTA;}
	public void setCustomerNameTTA(InputTextArea customerNameTTA) {this.customerNameTTA = customerNameTTA;}

}
