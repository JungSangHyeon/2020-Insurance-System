package view.insuranceSystemView.rewardView.lossChecker;

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
public class WriteLossCheckReportView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {WriteLossCheckReport, SaveLossCheckData}
		
	// Attribute
	private InputTextArea payTTA, judgeEvidenceTTA;

	public WriteLossCheckReportView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("���ػ��� ��� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.payTTA = new InputTextArea("���� �����", "3000000", 1, 100);
		this.judgeEvidenceTTA = new InputTextArea("�Ǵ� �ٰ�", "�ڵ��� ������� ������ ���� ������ �����Ѵ�.", 5, 100);

		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1, 1});
		selectBtnGroup.addGroupComponent(this.payTTA, this.judgeEvidenceTTA);
		this.addComponent(selectBtnGroup);
		
		this.addComponent(new ActionButton("����", EActionCommands.SaveLossCheckData.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)	
		);
	}

	// Getter & Setter
	public String getPayTTA() {return payTTA.getContent();}
	public String getJudgeEvidenceTTA() {return judgeEvidenceTTA.getContent();}

}
