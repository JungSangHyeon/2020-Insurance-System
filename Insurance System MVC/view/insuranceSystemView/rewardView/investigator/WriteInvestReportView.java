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
		this.addComponent(new BasicLabel("��� ���� ��� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.scenarioTTA = new InputTextArea("�ó�����", "��ȣ�� ��ȸ���� �ϴ� ���� ���������ϴ� ������ �����ϰ� �Ͼ.", 7, 100);
		this.damageTTA = new InputTextArea("����", "�ڵ��� �� ���۰� �ν���", 3, 100);
		this.treatmentTTA = new InputTextArea("��� ó��", "��Ʈī�� �ֺ� ����� ī���Ϳ� ��", 2, 100);
		this.treatmentCostTTA = new InputTextArea("ó�� ���", "1500000", 1, 100);
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1, 1, 1});
		selectBtnGroup.addGroupComponent(this.scenarioTTA, this.damageTTA, this.treatmentTTA, this.treatmentCostTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("����", EActionCommands.SaveAccidentInvestigationData.name(), actionListener));

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
