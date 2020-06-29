package view.insuranceSystemView.salesView.salesMan.watchSalesTrainingPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import model.aConstant.ETrainingTargetEmployee;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class WatchDetailSalesTrainingPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public WatchDetailSalesTrainingPlanView(ActionListener actionListener , int salesTrainingPlanID, IntDataList<SalesTrainingPlanData> salesTrainigPlanList) {
		SalesTrainingPlanData watchingSalesTrainingPlanData = salesTrainigPlanList.search(salesTrainingPlanID);
		// add component
		this.addComponent(new BasicLabel("���� ���� ���� ��ȹ ����"));
		this.addComponent(new SeparateLine(Color.black));

		String targetNames = "";
		for(ETrainingTargetEmployee target : watchingSalesTrainingPlanData.getTarget()) {targetNames +=(target.name()+", ");}
		this.addComponent(new JLabel("��ȸ�Ͻ� ���� ���� ��ȹ�� ���� �����Դϴ�."));
		this.addComponent(new OutputTextArea("����", watchingSalesTrainingPlanData.getTitle()));
		this.addComponent(new OutputTextArea("��¥", watchingSalesTrainingPlanData.getsalesTraningPlanDate()));
		this.addComponent(new OutputTextArea("���", watchingSalesTrainingPlanData.getPlace()));
		this.addComponent(new OutputTextArea("�������", targetNames));
		this.addComponent(new OutputTextArea("������ǥ ",  watchingSalesTrainingPlanData.getSalesTrainingGoal()));
		this.addComponent(new OutputTextArea("��������",  watchingSalesTrainingPlanData.getSalesTrainingContent()));
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("�� ����", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("���� ���� ��ȸ", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("�Ǹ� Ȱ�� ��ȸ", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("���� Ȱ�� ��ȸ", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
		
	}
}
