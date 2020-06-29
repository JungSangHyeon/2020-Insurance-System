package view.insuranceSystemView.rewardView.customer;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class CustomerTaskSelectView extends InsuranceSystemView{
	
	// Static
	public enum EActionCommands {AccidentProcessApply, isPaymentAgree}

	// Constructor
	public CustomerTaskSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("���Ͻô� ���񽺸� �����ϼ���."));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("��� ����", EActionCommands.AccidentProcessApply.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("����� ���� Ȯ��", EActionCommands.isPaymentAgree.name(), actionListener));
		this.addComponent(selectBtnGroup);

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
