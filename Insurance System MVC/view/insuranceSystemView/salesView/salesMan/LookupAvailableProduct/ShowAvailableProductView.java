package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.DynamicGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class ShowAvailableProductView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
	
	// association
	private CustomerData customerData;
	
	// Constructor
	public ShowAvailableProductView(ActionListener actionListener, IntDataList<AbsInsuranceData> insuranceDataList, CustomerData customerData) {
		// association
		this.customerData = customerData;
		
		//create and add component
		this.addComponent(new BasicLabel("�����Ͻ� �� �ִ� ���� ��ǰ�Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));
		
		Vector<AbsInsuranceData> searchedInsuranceData = searching(insuranceDataList);
		if(searchedInsuranceData.size()==0){
			this.addComponent(new OutputTextArea("���Բ��� �����Ͻ� �� �ִ� ��ǰ�� �������� �ʽ��ϴ�.", ""));
		} else {
			DynamicGroup g = new DynamicGroup();
			for (AbsInsuranceData insuranceData : searchedInsuranceData) {
				g.addGroupComponent(new ActionButton(printline(insuranceData), Integer.toString(insuranceData.getID()), actionListener));
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

	// ���԰��� ���� ��ȸ
	public Vector<AbsInsuranceData> searching(IntDataList<AbsInsuranceData> insuranceDataList) {
//		IntDataList<AbsInsuranceData> availableInsuranceList= new DataList<AbsInsuranceData>();
		Vector<AbsInsuranceData> availableInsuranceList = new Vector<AbsInsuranceData>();
		for (AbsInsuranceData insuranceData : insuranceDataList.getList()) {
			if (!insuranceData.isCustomerSignIn(this.customerData.getID())
					&& insuranceData.getLossPercent() >= insuranceData.insuranceRateCheck(this.customerData)) {
				availableInsuranceList.add(insuranceData);
			}
		}
		return availableInsuranceList;
	}
	
	// ��ư �� ����
	public String printline(AbsInsuranceData insuranceData) {
		// Format : ����� (���� 10�ڸ� + ...)
		String content = "";
		if (insuranceData.getContent().length() > 10) {content = insuranceData.getContent().substring(0, 10);
		} else {content = insuranceData.getContent();}
		String line = insuranceData.getName() + "(" + content + ")";
		return line;
	}
}
