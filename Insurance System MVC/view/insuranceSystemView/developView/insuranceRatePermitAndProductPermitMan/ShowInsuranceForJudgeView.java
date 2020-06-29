package view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class ShowInsuranceForJudgeView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {Permit, Ban}
		
	// Constructor
	public ShowInsuranceForJudgeView(ActionListener actionListener, AbsInsuranceData insuranceData) {
		this.addComponent(new BasicLabel("���� ����"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("�̸�", insuranceData.getName()));
		this.addComponent(new OutputTextArea("������", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		this.addComponent(new OutputTextArea("����", insuranceData.getContent()));
		this.addComponent(new OutputTextArea("���� ����", insuranceData.getInsuranceRateInfo()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("�հ�", EActionCommands.Permit.name(), actionListener));
		btnGroup.addGroupComponent(new ActionButton("���հ�", EActionCommands.Ban.name(), actionListener));
		this.addComponent(btnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
