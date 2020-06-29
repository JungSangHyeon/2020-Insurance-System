package view.insuranceSystemView.salesView.salesMan.LookupAvailableProduct;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.customerData.CustomerData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class ShowInsuranceInfoToCustomerView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninProduct,SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public ShowInsuranceInfoToCustomerView(ActionListener actionListener, IntDataList<AbsInsuranceData> insuranceDataList, int insuranceID, CustomerData customerData) {
		// searched insurance�� ����
		AbsInsuranceData searchedInsuranceData = insuranceDataList.search(insuranceID);
		
		// add component
		this.addComponent(new BasicLabel("������ �����Ͻ� ������ �����Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("���̵�",  Integer.toString(searchedInsuranceData.getID())));
		this.addComponent(new OutputTextArea("�����", searchedInsuranceData.getName()));
		if(searchedInsuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)searchedInsuranceData).getDisease().name()));
		}
		this.addComponent(new OutputTextArea("����",  searchedInsuranceData.getContent()));
		this.addComponent(new OutputTextArea("�������",  searchedInsuranceData.getInsuranceRateInfo()));
		// Ŭ�ٿ� ����, �������(�����, �����, ����� ���� ������, ����� ������)�� ���ִµ� ���� ����.

		this.addComponent(new ActionButton("���� ����", EActionCommands.SigninProduct.name(), actionListener));
	
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("�� ����", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
