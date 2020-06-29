package view.insuranceSystemView.rewardView.lawyer;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.rewardData.AccidentData;
import model.data.rewardData.AccidentInvestigationData;
import model.data.rewardData.LossCheckData;
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
public class ShowRewardDataInfoForLwView extends InsuranceSystemView{

	// Static
	public enum EActionCommands {writeSueReport}
	
	public ShowRewardDataInfoForLwView(LawyerData user, ActionListener actionListener, int taskID, IntDataList<RewardData> rewardDataList) {
		RewardData rewardData = rewardDataList.search(user.getTaskList().search(taskID).getRewardDataID());
		AccidentData accidentData = rewardData.getAccidentData();
		AccidentInvestigationData accidentInvestigationData = rewardData.getAccidentInvestigationData();
		PayJudgeData payJudgeData = rewardData.getPayJudgeData();
		LossCheckData lossCheckData = rewardData.getLossData();
		
		this.addComponent(new BasicLabel("요청하신 사고 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("사고 유형", accidentData.getType()));
		this.addComponent(new OutputTextArea("사고 위치", accidentData.getLocation()));
		this.addComponent(new OutputTextArea("사고 시간", accidentData.getDate()));

		this.addComponent(new BasicLabel("요청하신 사고 조사 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("사고 시나리오", accidentInvestigationData.getScenario()));
		this.addComponent(new OutputTextArea("피해", accidentInvestigationData.getDamage()));
		this.addComponent(new OutputTextArea("사고 처리", accidentInvestigationData.getTreatment()));
		this.addComponent(new OutputTextArea("사고 처리 비용", Integer.toString(accidentInvestigationData.getTreatmentCost())));
		
		this.addComponent(new BasicLabel("요청하신 면/부책 판단 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("면/부책 결과", payJudgeData.getPayJudge()));
		this.addComponent(new OutputTextArea("면/부책 근거", payJudgeData.getJudgementEvidence()));
		this.addComponent(new OutputTextArea("관련 법률", payJudgeData.getRelatedLaw()));	

		this.addComponent(new BasicLabel("요청하신 손해사정 데이터 입니다."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("지급 보험금", Integer.toString(lossCheckData.getPay())));
		this.addComponent(new OutputTextArea("판단 근거", lossCheckData.getJudgeEvidence()));
		this.addComponent(new ActionButton("소송 결과 입력", EActionCommands.writeSueReport.name(), actionListener));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)			);
	}

}
