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
		this.addComponent(new BasicLabel("��/��å ��� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.payJudgeTTA = new InputTextArea("���", "��å(����簡 ������� �δ��մϴ�)", 3, 100);
		this.judgementEvidenceTTA = new InputTextArea("�ٰ�", "���� ��� ����, ������ ��� �ش����� �ƴ��ϰ� �Ϲ����� ��� �ش��ϱ� ������", 10, 100);
		this.relatedLawTTA = new InputTextArea("���� ����", "��Ż ����(���� �ǹ� ����), ���� ����� ��� ���� ��å�� �ش��ϳ� �ǰ�� �ش����� �����Ƿ� ��å�� �ش��Ѵ�.", 10, 100);

		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1, 1});
		selectBtnGroup.addGroupComponent(this.payJudgeTTA, this.judgementEvidenceTTA, this.relatedLawTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("����", EActionCommands.SavePayJudgeData.name(), actionListener));

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
