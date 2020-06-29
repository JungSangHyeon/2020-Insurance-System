package view.insuranceSystemView.rewardView.lawyer;

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
public class WriteSueReportView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {writeSueReport, SaveLawsuitData}
	
	// Attribute
	private InputTextArea payTTA;
	
	public WriteSueReportView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("소송 결과 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.payTTA = new InputTextArea("지급 보험금", "지급 보험금을 입력하세요", 1, 100);
	
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1});
		selectBtnGroup.addGroupComponent(this.payTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("저장", EActionCommands.SaveLawsuitData.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)	
		);
	}

	// Getter & Setter
	public String getPayTTA() {return payTTA.getContent();}
	
}
