package view.insuranceSystemView.salesView.salesMan.watchActivityPlan;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.activityPlanData.ActivityPlanData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class WatchActivityPlanView extends InsuranceSystemView {
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Constructor
	public WatchActivityPlanView(ActionListener actionListener, IntDataList<ActivityPlanData> activityPlanList) {
		// add component
		this.addComponent(new BasicLabel("Ȱ�� ��ȹ ��ȸ"));
		this.addComponent(new SeparateLine(Color.black));

		DynamicGroup selectBtnGroup = new DynamicGroup();
		for (ActivityPlanData data : activityPlanList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(data.getTitle(), Integer.toString(data.getID()), actionListener));
		}
		this.addComponent(selectBtnGroup);
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
