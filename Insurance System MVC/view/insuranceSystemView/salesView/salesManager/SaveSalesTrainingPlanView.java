package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.aConstant.ETrainingTargetEmployee;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SaveSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
		
	// Component
	private InputTextArea titleTTA, salesTrainingDateTTA, salesTrainingPlaceTTA, salesTrainingGoalTTA, salesTrainingContentTTA;
	private TitledRadioButtonGroup salesTrainingTargetTTA;

	// Constructor
	public SaveSalesTrainingPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("제목", "6월 정기 영업 활동 계획 세미나", 1, 120);
		this.salesTrainingDateTTA = new InputTextArea("교육날짜", "2020-06-23 11:30", 1, 120);
		this.salesTrainingPlaceTTA = new InputTextArea("장소", "대회의실", 1, 120);
		this.salesTrainingTargetTTA = new TitledRadioButtonGroup("교육대상", ETrainingTargetEmployee.class, true, 120);
		this.salesTrainingGoalTTA = new InputTextArea("교육 목표", "정기 세미나", 5, 120);
		this.salesTrainingContentTTA = new InputTextArea("교육내용", "11:30분 부터 1시간 30분 동안 영업 교육 세미나가 있을 예정이오니\r\n직원여러분들의 많은 관심 부탁 드립니다.", 15, 120);

		// add component
		this.addComponent(new BasicLabel("영업 활동 계획 입력"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] {2,1,1,1,1});
		g.addGroupComponent(titleTTA, this.salesTrainingDateTTA,
				this.salesTrainingPlaceTTA,
				this.salesTrainingTargetTTA,
				this.salesTrainingGoalTTA,
				this.salesTrainingContentTTA
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
	public InputTextArea getSalesTrainingDateTTA() {return this.salesTrainingDateTTA;}
	public void setSalesTrainingDateTTA(InputTextArea salesTrainingDateTTA) {this.salesTrainingDateTTA = salesTrainingDateTTA;}
	public InputTextArea getSalesTrainingPlaceTTA() {return this.salesTrainingPlaceTTA;}
	public void setSalesTrainingPlaceTTA(InputTextArea salesTrainingPlaceTTA) {this.salesTrainingPlaceTTA = salesTrainingPlaceTTA;}
	public InputTextArea getSalesTrainingGoalTTA() {return this.salesTrainingGoalTTA;}
	public void setSalesTrainingGoalTTA(InputTextArea salesTrainingGoalTTA) {this.salesTrainingGoalTTA = salesTrainingGoalTTA;}
	public InputTextArea getSalesTrainingContentTTA() {return this.salesTrainingContentTTA;}
	public void setSalesTrainingContentTTA(InputTextArea salesTrainingContentTTA) {this.salesTrainingContentTTA = salesTrainingContentTTA;}
	public TitledRadioButtonGroup getSalesTrainingTargetTTA() {return this.salesTrainingTargetTTA;}
	public void setSalesTrainingTargetTTA(TitledRadioButtonGroup salesTrainingTargetTTA) {this.salesTrainingTargetTTA = salesTrainingTargetTTA;}

}
