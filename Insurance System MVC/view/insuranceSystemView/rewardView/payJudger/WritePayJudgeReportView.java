package view.insuranceSystemView.rewardView.payJudger;

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
public class WritePayJudgeReportView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {WritePayJudgeReport, SavePayJudgeData}
	
	// Attribute
	private InputTextArea payJudgeTTA, judgementEvidenceTTA, relatedLawTTA;

	public WritePayJudgeReportView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("면/부책 결과 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.payJudgeTTA = new InputTextArea("결과", "부책(보험사가 보험금을 부담합니다)", 3, 100);
		this.judgementEvidenceTTA = new InputTextArea("근거", "조사 결과 음주, 무면허 사고에 해당하지 아니하고 일반적인 사고에 해당하기 때문임", 10, 100);
		this.relatedLawTTA = new InputTextArea("관련 법률", "면탈 행위(고지 의무 위반), 고의 사고인 경우 전부 면책에 해당하나 피고는 해당하지 않으므로 부책에 해당한다.", 10, 100);

		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1, 1});
		selectBtnGroup.addGroupComponent(this.payJudgeTTA, this.judgementEvidenceTTA, this.relatedLawTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("저장", EActionCommands.SavePayJudgeData.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
	    );
	}

	// Getter & Setter
	public String getPayJudgeTTA() {return payJudgeTTA.getContent();}
	public String getJudgementEvidenceTTA() {return judgementEvidenceTTA.getContent();}
	public String getRelatedLawTTA() {return relatedLawTTA.getContent();}
	
}
