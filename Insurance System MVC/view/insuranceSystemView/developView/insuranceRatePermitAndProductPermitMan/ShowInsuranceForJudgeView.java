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
		this.addComponent(new BasicLabel("보험 정보"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("이름", insuranceData.getName()));
		this.addComponent(new OutputTextArea("손해율", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("보상 질병", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		this.addComponent(new OutputTextArea("설명", insuranceData.getContent()));
		this.addComponent(new OutputTextArea("요율 설명", insuranceData.getInsuranceRateInfo()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("합격", EActionCommands.Permit.name(), actionListener));
		btnGroup.addGroupComponent(new ActionButton("불합격", EActionCommands.Ban.name(), actionListener));
		this.addComponent(btnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
