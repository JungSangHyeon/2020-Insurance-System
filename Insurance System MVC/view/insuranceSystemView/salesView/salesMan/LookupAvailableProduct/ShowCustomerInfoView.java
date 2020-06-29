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
		this.addComponent(new BasicLabel("고객 조회 결과"));
		this.addComponent(new SeparateLine(Color.black));

		if (searchedCustomerList.getList().isEmpty()) {
			BasicLabel bl = new BasicLabel("요청하신 "+searchedNameTTA.getContent() + " 님은 시스템에 존재하지 않습니다. 다시한번 확인해주십시오");
			bl.setLabelFont(Font.PLAIN, 15);
			this.addComponent(bl);
		} else {
			BasicLabel bl = new BasicLabel("요청하신 "+ searchedNameTTA.getContent() + "님 명단입니다.");
			bl.setLabelFont(Font.PLAIN, 15);
			this.addComponent(bl);
			// 홍길동 님 (남, 22세, 990618-1)로 출력하도록 변경
			DynamicGroup g = new DynamicGroup();
			for (CustomerData customerData : searchedCustomerList.getList()) {
				g.addGroupComponent(new SelectButton(printline(customerData),Integer.toString(customerData.getID()), actionListener));
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

	private String printline(CustomerData customerData) {
		String returnVal ="";
		String name =customerData.getName();
		String gender = customerData.isMale() ? "남": "여";
		String age = Integer.toString(customerData.getAge());
		String socialSecNum = customerData.getSocialSecurityNum().substring(0, 8);
		returnVal = name+" 님 ("+gender+", "+age+"세, "+socialSecNum+")";
		return returnVal;
	}
}
