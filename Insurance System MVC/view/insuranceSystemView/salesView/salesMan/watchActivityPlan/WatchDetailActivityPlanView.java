package view.insuranceSystemView.salesView.salesMan.watchActivityPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import model.data.activityPlanData.ActivityPlanData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class WatchDetailActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public WatchDetailActivityPlanView(ActionListener actionListener, int activityPlanID, IntDataList<ActivityPlanData> activityPlanList) {
		ActivityPlanData watchingActivityPlanData = activityPlanList.search(activityPlanID);

		// add component
		this.addComponent(new BasicLabel("���� Ȱ�� ��ȹ ����"));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new JLabel("��ȸ�Ͻ� Ȱ�� ��ȹ�� ���� �����Դϴ�."));
		this.addComponent(new OutputTextArea("����",  watchingActivityPlanData.getTitle()));
		this.addComponent(new OutputTextArea("��¥",  watchingActivityPlanData.getSalesDuration()));
		this.addComponent(new OutputTextArea("��ü ���� ��ǥ",  Integer.toString(watchingActivityPlanData.getSalesGoal())));
		this.addComponent(new OutputTextArea("��ü Ȱ����ǥ",  watchingActivityPlanData.getActivityGoal()));
		this.addComponent(new OutputTextArea("�߰� ���� �ʿ䷮ ", Integer.toString(watchingActivityPlanData.getAdditionalJobOffer())));
		this.addComponent(new OutputTextArea("�ַ� �� ���� ", watchingActivityPlanData.getSalesTargetCustomer().toString()));

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
