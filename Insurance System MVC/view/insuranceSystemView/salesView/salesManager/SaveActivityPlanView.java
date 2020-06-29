package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.aConstant.ETargetCustomer;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SaveActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
		
	// Component
	private InputTextArea titleTTA, activityGoalTTA, dateTTA, salesGoalTTA, additionalJobOfferTTA;
	private TitledRadioButtonGroup salesTargetCustomerTTA;

	// Constructor
	public SaveActivityPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("����", "2020 - 6�� �Ǹ� Ȱ�� ��ȹ", 1, 120); 
		this.dateTTA = new InputTextArea("Ȱ���Ⱓ", "2020-06-19", 1, 120);
		this.salesGoalTTA = new InputTextArea("���� ��ǥ", "100000000", 1, 120);
		this.activityGoalTTA = new InputTextArea("Ȱ�� ��ǥ", "�ּ� �Ϸ翡 2���� ���� ��ġ�ϰ�, ���� ���� ��Ż�� ���� ���� ��ǥ�� �մϴ�. \r\n������� �ּ� 40% �̻��� �����ؾ� �ϸ�, �׷��� ���� ��� �Ǹ� ������ �̼��ؾ� �մϴ�.", 10, 120);
		this.additionalJobOfferTTA = new InputTextArea("�߰� ���η�", "10", 1, 120);
		this.salesTargetCustomerTTA = new TitledRadioButtonGroup("�ַ� �� ����", ETargetCustomer.class, false, 120);

		// add component
		this.addComponent(new BasicLabel("Ȱ�� ��ȹ �Է�"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] { 2, 2, 1, 1});
		g.addGroupComponent(
				this.titleTTA, this.dateTTA,
				this.salesGoalTTA, this.additionalJobOfferTTA,
				this.salesTargetCustomerTTA,
				this.activityGoalTTA
			);
		this.addComponent(g);
		this.addComponent(new ActionButton("����", EActionCommands.Save.name(), actionListener));
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("�Ǹ� ��ȹ", EActionCommands.SaveActivityPlan.name(), actionListener),
				new LinkButton("���� ����", EActionCommands.SaveSalesTrainingPlan.name(), actionListener)
		);

	}
	
	//get & set
	public InputTextArea getTitleTTA() {return this.titleTTA;}
	public void setTitleTTA(InputTextArea titleTTA) {this.titleTTA = titleTTA;}
	public InputTextArea getActivityGoalTTA() {return this.activityGoalTTA;}
	public void setActivityGoalTTA(InputTextArea activityGoalTTA) {this.activityGoalTTA = activityGoalTTA;}
	public InputTextArea getDateTTA() {return this.dateTTA;}
	public void setDateTTA(InputTextArea dateTTA) {this.dateTTA = dateTTA;}
	public InputTextArea getSalesGoalTTA() {return this.salesGoalTTA;}
	public void setSalesGoalTTA(InputTextArea salesGoalTTA) {this.salesGoalTTA = salesGoalTTA;}
	public InputTextArea getAdditionalJobOfferTTA() {return this.additionalJobOfferTTA;}
	public void setAdditionalJobOfferTTA(InputTextArea additionalJobOfferTTA) {this.additionalJobOfferTTA = additionalJobOfferTTA;}
	public TitledRadioButtonGroup getSalesTargetCustomerTTA() {return this.salesTargetCustomerTTA;}
	public void setSalesTargetCustomerTTA(TitledRadioButtonGroup salesTargetCustomerTTA) {this.salesTargetCustomerTTA = salesTargetCustomerTTA;}

}
