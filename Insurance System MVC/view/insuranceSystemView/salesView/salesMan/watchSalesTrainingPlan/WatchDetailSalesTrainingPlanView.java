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
		this.addComponent(new BasicLabel("세부 영업 교육 계획 정보"));
		this.addComponent(new SeparateLine(Color.black));

		String targetNames = "";
		for(ETrainingTargetEmployee target : watchingSalesTrainingPlanData.getTarget()) {targetNames +=(target.name()+", ");}
		this.addComponent(new JLabel("조회하신 영업 교육 계획의 세부 정보입니다."));
		this.addComponent(new OutputTextArea("제목", watchingSalesTrainingPlanData.getTitle()));
		this.addComponent(new OutputTextArea("날짜", watchingSalesTrainingPlanData.getsalesTraningPlanDate()));
		this.addComponent(new OutputTextArea("장소", watchingSalesTrainingPlanData.getPlace()));
		this.addComponent(new OutputTextArea("교육대상", targetNames));
		this.addComponent(new OutputTextArea("교육목표 ",  watchingSalesTrainingPlanData.getSalesTrainingGoal()));
		this.addComponent(new OutputTextArea("교육내용",  watchingSalesTrainingPlanData.getSalesTrainingContent()));
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
