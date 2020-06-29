package view.insuranceSystemView.salesView.salesMan;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class SalesManTaskSelectView extends InsuranceSystemView {
		
	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public SalesManTaskSelectView(ActionListener actionListener) {
		// add component
		this.addComponent(new BasicLabel("원하시는 업무를 선택하세요."));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g = new StaticGroup(new int[] {1,1,1,1});
		g.addGroupComponent(new SelectButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener));
		g.addGroupComponent(new SelectButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener));
		g.addGroupComponent(new SelectButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener));
		g.addGroupComponent(new SelectButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener));
		this.addComponent(g);
		
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
