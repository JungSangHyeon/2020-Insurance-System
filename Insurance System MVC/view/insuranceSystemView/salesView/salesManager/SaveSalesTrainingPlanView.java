package view.insuranceSystemView.salesView.salesManager;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.aConstant.ETrainingTargetEmployee;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SaveSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;
	
	// Static
	public enum EActionCommands {Save, SaveActivityPlan, SaveSalesTrainingPlan}
		
	// Component
	private InputTextArea titleTTA, salesTrainingDateTTA, salesTrainingPlaceTTA, salesTrainingGoalTTA, salesTrainingContentTTA;
	private TitledRadioButtonGroup salesTrainingTargetTTA;

	// Constructor
	public SaveSalesTrainingPlanView(ActionListener actionListener) {
		// create component
		this.titleTTA = new InputTextArea("����", "6�� ���� ���� Ȱ�� ��ȹ ���̳�", 1, 120);
		this.salesTrainingDateTTA = new InputTextArea("������¥", "2020-06-23 11:30", 1, 120);
		this.salesTrainingPlaceTTA = new InputTextArea("���", "��ȸ�ǽ�", 1, 120);
		this.salesTrainingTargetTTA = new TitledRadioButtonGroup("�������", ETrainingTargetEmployee.class, true, 120);
		this.salesTrainingGoalTTA = new InputTextArea("���� ��ǥ", "���� ���̳�", 5, 120);
		this.salesTrainingContentTTA = new InputTextArea("��������", "11:30�� ���� 1�ð� 30�� ���� ���� ���� ���̳��� ���� �����̿���\r\n���������е��� ���� ���� ��Ź �帳�ϴ�.", 15, 120);

		// add component
		this.addComponent(new BasicLabel("���� Ȱ�� ��ȹ �Է�"));
		this.addComponent(new SeparateLine(Color.black));

		StaticGroup g = new StaticGroup(new int[] {2,1,1,1,1});
		g.addGroupComponent(titleTTA, this.salesTrainingDateTTA,
				this.salesTrainingPlaceTTA,
				this.salesTrainingTargetTTA,
				this.salesTrainingGoalTTA,
				this.salesTrainingContentTTA
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
	public InputTextArea getSalesTrainingDateTTA() {return this.salesTrainingDateTTA;}
	public void setSalesTrainingDateTTA(InputTextArea salesTrainingDateTTA) {this.salesTrainingDateTTA = salesTrainingDateTTA;}
	public InputTextArea getSalesTrainingPlaceTTA() {return this.salesTrainingPlaceTTA;}
	public void setSalesTrainingPlaceTTA(InputTextArea salesTrainingPlaceTTA) {this.salesTrainingPlaceTTA = salesTrainingPlaceTTA;}
	public InputTextArea getSalesTrainingGoalTTA() {return this.salesTrainingGoalTTA;}
	public void setSalesTrainingGoalTTA(InputTextArea salesTrainingGoalTTA) {this.salesTrainingGoalTTA = salesTrainingGoalTTA;}
	public InputTextArea getSalesTrainingContentTTA() {return this.salesTrainingContentTTA;}
	public void setSalesTrainingContentTTA(InputTextArea salesTrainingContentTTA) {this.salesTrainingContentTTA = salesTrainingContentTTA;}
	public TitledRadioButtonGroup getSalesTrainingTargetTTA() {return this.salesTrainingTargetTTA;}
	public void setSalesTrainingTargetTTA(TitledRadioButtonGroup salesTrainingTargetTTA) {this.salesTrainingTargetTTA = salesTrainingTargetTTA;}

}
