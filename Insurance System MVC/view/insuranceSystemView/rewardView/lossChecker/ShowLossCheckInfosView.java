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
		
		this.addComponent(new BasicLabel("��û�Ͻ� ��� ���� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));
		this.addComponent(new OutputTextArea("��� �ó�����", aiData.getScenario()));
		this.addComponent(new OutputTextArea("����", aiData.getDamage()));
		this.addComponent(new OutputTextArea("��� ó��", aiData.getTreatment()));
		this.addComponent(new OutputTextArea("��� ó�� ���", Integer.toString(aiData.getTreatmentCost())));
		
		this.addComponent(new BasicLabel("��û�Ͻ� ��/��å �Ǵ� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));
		this.addComponent(new OutputTextArea("��/��å ���", pjData.getPayJudge()));
		this.addComponent(new OutputTextArea("��/��å �ٰ�", pjData.getJudgementEvidence()));
		this.addComponent(new OutputTextArea("���� ����", pjData.getRelatedLaw()));	
		this.addComponent(new ActionButton("���� ���� ���� �ۼ�", EActionCommands.WriteLossCheckReport.name(), actionListener));
	
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)			);
	}
}
