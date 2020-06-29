package view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class WatchSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public WatchSalesTrainingPlanView(ActionListener actionListener, IntDataList<SalesTrainingPlanData> salesTrainingPlanList) {
		// add component
		this.addComponent(new BasicLabel("영업 교육 계획 조회"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (SalesTrainingPlanData data : salesTrainingPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
