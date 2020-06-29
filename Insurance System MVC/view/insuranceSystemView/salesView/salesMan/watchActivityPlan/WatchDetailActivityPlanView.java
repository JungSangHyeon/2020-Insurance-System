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
		this.addComponent(new BasicLabel("세부 활동 계획 정보"));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new JLabel("조회하신 활동 계획의 세부 정보입니다."));
		this.addComponent(new OutputTextArea("제목",  watchingActivityPlanData.getTitle()));
		this.addComponent(new OutputTextArea("날짜",  watchingActivityPlanData.getSalesDuration()));
		this.addComponent(new OutputTextArea("전체 매출 목표",  Integer.toString(watchingActivityPlanData.getSalesGoal())));
		this.addComponent(new OutputTextArea("전체 활동목표",  watchingActivityPlanData.getActivityGoal()));
		this.addComponent(new OutputTextArea("추가 구인 필요량 ", Integer.toString(watchingActivityPlanData.getAdditionalJobOffer())));
		this.addComponent(new OutputTextArea("주력 고객 선정 ", watchingActivityPlanData.getSalesTargetCustomer().toString()));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}
}
