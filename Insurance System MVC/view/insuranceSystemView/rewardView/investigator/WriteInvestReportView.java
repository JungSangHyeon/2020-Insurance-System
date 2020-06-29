package view.insuranceSystemView.rewardView.investigator;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class WriteInvestReportView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {WriteInvestReport, SaveAccidentInvestigationData}
	
	// Component
	private InputTextArea scenarioTTA, damageTTA, treatmentTTA, treatmentCostTTA;

	public WriteInvestReportView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("사고 조사 결과 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.scenarioTTA = new InputTextArea("시나리오", "비보호에 좌회전을 하는 도중 꼬리물기하는 차량과 접촉하고가 일어남.", 7, 100);
		this.damageTTA = new InputTextArea("피해", "자동차 앞 범퍼가 부숴짐", 3, 100);
		this.treatmentTTA = new InputTextArea("사고 처리", "렌트카로 주변 가까운 카센터에 감", 2, 100);
		this.treatmentCostTTA = new InputTextArea("처리 비용", "1500000", 1, 100);
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1, 1, 1});
		selectBtnGroup.addGroupComponent(this.scenarioTTA, this.damageTTA, this.treatmentTTA, this.treatmentCostTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("저장", EActionCommands.SaveAccidentInvestigationData.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
	            );
	}

	// Getter & Setter
	public String getScenarioTTA() {return scenarioTTA.getContent();}
	public String getDamageTTA() {return damageTTA.getContent();}
	public String getTreatmentTTA() {return treatmentTTA.getContent();}
	public String getTreatmentCostTTA() {return treatmentCostTTA.getContent();}

}
