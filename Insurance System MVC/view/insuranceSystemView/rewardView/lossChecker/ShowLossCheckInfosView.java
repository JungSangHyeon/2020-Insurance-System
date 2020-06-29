package view.insuranceSystemView.rewardView.lossChecker;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.rewardData.AccidentInvestigationData;
import model.data.rewardData.PayJudgeData;
import model.data.rewardData.RewardData;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class ShowLossCheckInfosView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {WriteLossCheckReport}
	
	public ShowLossCheckInfosView(LossCheckManData user, ActionListener actionListener, int taskID, IntDataList<RewardData> rewardDataList) {
		RewardData rewardData = rewardDataList.search(user.getTaskList().search(taskID).getRewardDataID());
		AccidentInvestigationData aiData = rewardData.getAccidentInvestigationData();
		PayJudgeData pjData = rewardData.getPayJudgeData();
		
		this.addComponent(new BasicLabel("요청하신 사고 조사 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));
		this.addComponent(new OutputTextArea("사고 시나리오", aiData.getScenario()));
		this.addComponent(new OutputTextArea("피해", aiData.getDamage()));
		this.addComponent(new OutputTextArea("사고 처리", aiData.getTreatment()));
		this.addComponent(new OutputTextArea("사고 처리 비용", Integer.toString(aiData.getTreatmentCost())));
		
		this.addComponent(new BasicLabel("요청하신 면/부책 판단 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));
		this.addComponent(new OutputTextArea("면/부책 결과", pjData.getPayJudge()));
		this.addComponent(new OutputTextArea("면/부책 근거", pjData.getJudgementEvidence()));
		this.addComponent(new OutputTextArea("관련 법률", pjData.getRelatedLaw()));	
		this.addComponent(new ActionButton("손해 사정 보고서 작성", EActionCommands.WriteLossCheckReport.name(), actionListener));
	
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)			);
	}
}
