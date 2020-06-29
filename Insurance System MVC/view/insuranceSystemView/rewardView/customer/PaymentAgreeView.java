package view.insuranceSystemView.rewardView.customer;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.rewardData.LossCheckData;
import model.data.rewardData.RewardData;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class PaymentAgreeView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {AccidentProcessApply, isPaymentAgree, Permit, Ban}		
		
	// Constructor
	public PaymentAgreeView(ActionListener actionListener, RewardData reward) {
		RewardData rewardData = reward;
		LossCheckData lossCheckData = rewardData.getLossData();
		this.addComponent(new BasicLabel("����� ���� ���θ� �Է����ּ���."));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("���� �����", Integer.toString(lossCheckData.getPay())));
		this.addComponent(new OutputTextArea("�Ǵ� �ٰ�", lossCheckData.getJudgeEvidence()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("����", EActionCommands.Permit.name(), actionListener));
		btnGroup.addGroupComponent(new ActionButton("����", EActionCommands.Ban.name(), actionListener));
		this.addComponent(btnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
			);
	}
}
