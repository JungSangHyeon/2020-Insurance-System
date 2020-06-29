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
		this.addComponent(new BasicLabel("가입하실 수 있는 보험 상품입니다."));
		this.addComponent(new SeparateLine(Color.black));
		
		Vector<AbsInsuranceData> searchedInsuranceData = searching(insuranceDataList);
		if(searchedInsuranceData.size()==0){
			this.addComponent(new OutputTextArea("고객님께서 가입하실 수 있는 상품이 존재하지 않습니다.", ""));
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
				new LinkButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	// 가입가능 보험 조회
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
	
	// 버튼 값 가공
	public String printline(AbsInsuranceData insuranceData) {
		// Format : 보험명 (내용 10자리 + ...)
		String content = "";
		if (insuranceData.getContent().length() > 10) {content = insuranceData.getContent().substring(0, 10);
		} else {content = insuranceData.getContent();}
		String line = insuranceData.getName() + "(" + content + ")";
		return line;
	}
}
