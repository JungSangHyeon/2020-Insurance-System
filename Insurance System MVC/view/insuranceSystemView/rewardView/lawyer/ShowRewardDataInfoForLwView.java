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
		
		this.addComponent(new BasicLabel("��û�Ͻ� ��� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("��� ����", accidentData.getType()));
		this.addComponent(new OutputTextArea("��� ��ġ", accidentData.getLocation()));
		this.addComponent(new OutputTextArea("��� �ð�", accidentData.getDate()));

		this.addComponent(new BasicLabel("��û�Ͻ� ��� ���� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("��� �ó�����", accidentInvestigationData.getScenario()));
		this.addComponent(new OutputTextArea("����", accidentInvestigationData.getDamage()));
		this.addComponent(new OutputTextArea("��� ó��", accidentInvestigationData.getTreatment()));
		this.addComponent(new OutputTextArea("��� ó�� ���", Integer.toString(accidentInvestigationData.getTreatmentCost())));
		
		this.addComponent(new BasicLabel("��û�Ͻ� ��/��å �Ǵ� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("��/��å ���", payJudgeData.getPayJudge()));
		this.addComponent(new OutputTextArea("��/��å �ٰ�", payJudgeData.getJudgementEvidence()));
		this.addComponent(new OutputTextArea("���� ����", payJudgeData.getRelatedLaw()));	

		this.addComponent(new BasicLabel("��û�Ͻ� ���ػ��� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));

		this.addComponent(new OutputTextArea("���� �����", Integer.toString(lossCheckData.getPay())));
		this.addComponent(new OutputTextArea("�Ǵ� �ٰ�", lossCheckData.getJudgeEvidence()));
		this.addComponent(new ActionButton("�Ҽ� ��� �Է�", EActionCommands.writeSueReport.name(), actionListener));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)			);
	}

}
