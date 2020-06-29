package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.aConstant.ETargetCustomer;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SaveActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
		
	// Component
	private InputTextArea titleTTA, activityGoalTTA, dateTTA, salesGoalTTA, additionalJobOfferTTA;
	private TitledRadioButtonGroup salesTargetCustomerTTA;

	// Constructor
	public SaveActivityPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("제목", "2020 - 6월 판매 활동 계획", 1, 120); 
		this.dateTTA = new InputTextArea("활동기간", "2020-06-19", 1, 120);
		this.salesGoalTTA = new InputTextArea("매출 목표", "100000000", 1, 120);
		this.activityGoalTTA = new InputTextArea("활동 목표", "최소 하루에 2명의 고객을 유치하고, 기존 고객의 이탈을 막는 것을 목표로 합니다. \r\n방어율은 최소 40% 이상을 유지해야 하며, 그렇지 못할 경우 판매 교육을 이수해야 합니다.", 10, 120);
		this.additionalJobOfferTTA = new InputTextArea("추가 구인량", "10", 1, 120);
		this.salesTargetCustomerTTA = new TitledRadioButtonGroup("주력 고객 선정", ETargetCustomer.class, false, 120);

		// add component
		this.addComponent(new BasicLabel("활동 계획 입력"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] { 2, 2, 1, 1});
		g.addGroupComponent(
				this.titleTTA, this.dateTTA,
				this.salesGoalTTA, this.additionalJobOfferTTA,
				this.salesTargetCustomerTTA,
				this.activityGoalTTA
			);
		this.addComponent(g);
		this.addComponent(new ActionButton("저장", EActionCommands.Save.name(), actionListener));
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("판매 계획", EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("영업 관리", EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);

	}
	
	//get & set
	public InputTextArea getTitleTTA() {return this.titleTTA;}
	public void setTitleTTA(InputTextArea titleTTA) {this.titleTTA = titleTTA;}
	public InputTextArea getActivityGoalTTA() {return this.activityGoalTTA;}
	public void setActivityGoalTTA(InputTextArea activityGoalTTA) {this.activityGoalTTA = activityGoalTTA;}
	public InputTextArea getDateTTA() {return this.dateTTA;}
	public void setDateTTA(InputTextArea dateTTA) {this.dateTTA = dateTTA;}
	public InputTextArea getSalesGoalTTA() {return this.salesGoalTTA;}
	public void setSalesGoalTTA(InputTextArea salesGoalTTA) {this.salesGoalTTA = salesGoalTTA;}
	public InputTextArea getAdditionalJobOfferTTA() {return this.additionalJobOfferTTA;}
	public void setAdditionalJobOfferTTA(InputTextArea additionalJobOfferTTA) {this.additionalJobOfferTTA = additionalJobOfferTTA;}
	public TitledRadioButtonGroup getSalesTargetCustomerTTA() {return this.salesTargetCustomerTTA;}
	public void setSalesTargetCustomerTTA(TitledRadioButtonGroup salesTargetCustomerTTA) {this.salesTargetCustomerTTA = salesTargetCustomerTTA;}

}
