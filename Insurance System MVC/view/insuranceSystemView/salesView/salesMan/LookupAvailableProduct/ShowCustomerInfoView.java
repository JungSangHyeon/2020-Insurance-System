package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import model.data.customerData.CustomerData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class ShowCustomerInfoView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
	
	// Constructor
	public ShowCustomerInfoView(ActionListener actionListener, IntDataList<CustomerData> searchedCustomerList, InputTextArea searchedNameTTA) {
		this.addComponent(new BasicLabel("�� ��ȸ ���"));
		this.addComponent(new SeparateLine(Color.black));

		if (searchedCustomerList.getList().isEmpty()) {
			BasicLabel bl = new BasicLabel("��û�Ͻ� "+searchedNameTTA.getContent() + " ���� �ý��ۿ� �������� �ʽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�");
			bl.setLabelFont(Font.PLAIN, 15);
			this.addComponent(bl);
		} else {
			BasicLabel bl = new BasicLabel("��û�Ͻ� "+ searchedNameTTA.getContent() + "�� ����Դϴ�.");
			bl.setLabelFont(Font.PLAIN, 15);
			this.addComponent(bl);
			// ȫ�浿 �� (��, 22��, 990618-1)�� ����ϵ��� ����
			DynamicGroup g = new DynamicGroup();
			for (CustomerData customerData : searchedCustomerList.getList()) {
				g.addGroupComponent(new SelectButton(printline(customerData),Integer.toString(customerData.getID()), actionListener));
			}
			this.addComponent(g);
		}
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("�� ����", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	private String printline(CustomerData customerData) {
		String returnVal ="";
		String name =customerData.getName();
		String gender = customerData.isMale() ? "��": "��";
		String age = Integer.toString(customerData.getAge());
		String socialSecNum = customerData.getSocialSecurityNum().substring(0, 8);
		returnVal = name+" �� ("+gender+", "+age+"��, "+socialSecNum+")";
		return returnVal;
	}
}
