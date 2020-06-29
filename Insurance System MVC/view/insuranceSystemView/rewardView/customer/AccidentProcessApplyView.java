package view.insuranceSystemView.rewardView.customer;

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
public class AccidentProcessApplyView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {SaveAccidentData, AccidentProcessApply, isPaymentAgree}
	
	// Component
	private InputTextArea accidentTypeTTA, accidentLocationTTA, accidentDateTTA;
	
	// Constructor
	public AccidentProcessApplyView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("��� ���� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.accidentTypeTTA = new InputTextArea("��� ����", "�ڵ��� ���� ���", 2, 100);
		this.accidentLocationTTA = new InputTextArea("��� ��ġ", "���￪ �� Ⱦ�ܺ���", 5, 100);
		this.accidentDateTTA = new InputTextArea("��� �ð�", "10�� ��",  2, 100);
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1, 1});
		selectBtnGroup.addGroupComponent(this.accidentTypeTTA, this.accidentLocationTTA, this.accidentDateTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("����", EActionCommands.SaveAccidentData.name(), actionListener));
		
		this.addToLinkPanel (
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}

	// Getter & Setter
	public String getAccidentType() {return this.accidentTypeTTA.getContent();}
	public String getAccidentLocation() {return this.accidentLocationTTA.getContent();}
	public String getAccidentDate() {return this.accidentDateTTA.getContent();}
}
