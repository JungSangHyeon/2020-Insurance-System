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
		// add component (create component�� for������ ����������)
		this.addComponent(new BasicLabel("���� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1});
		this.customerNameTTA = new InputTextArea("����", "������", 1, 100);
		g.addGroupComponent(this.customerNameTTA);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("��ȸ",EActionCommands.search.name(),actionListener));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("�� ����", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	// get & set
	public InputTextArea getCustomerNameTTA() {return this.customerNameTTA;}
	public void setCustomerNameTTA(InputTextArea customerNameTTA) {this.customerNameTTA = customerNameTTA;}

}
