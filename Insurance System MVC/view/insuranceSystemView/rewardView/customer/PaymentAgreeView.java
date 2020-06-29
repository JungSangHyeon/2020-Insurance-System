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
		this.addComponent(new BasicLabel("보험금 수령 여부를 입력해주세요."));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("지급 보험금", Integer.toString(lossCheckData.getPay())));
		this.addComponent(new OutputTextArea("판단 근거", lossCheckData.getJudgeEvidence()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("동의", EActionCommands.Permit.name(), actionListener));
		btnGroup.addGroupComponent(new ActionButton("비동의", EActionCommands.Ban.name(), actionListener));
		this.addComponent(btnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
			);
	}
}
