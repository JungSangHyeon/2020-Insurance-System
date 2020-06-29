package view.insuranceSystemView.rewardView.payJudger;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.rewardData.AccidentInvestigationData;
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
public class ShowAccInvestInfoForPJView extends InsuranceSystemView{
	
	// Static
	public enum EActionCommands {WritePayJudgeReport}
		
	public ShowAccInvestInfoForPJView(PayJudgerData user, ActionListener actionListener, int taskID, IntDataList<RewardData> rewardDataList) {
		RewardData rewardData = rewardDataList.search(user.getTaskList().search(taskID).getRewardDataID());
		AccidentInvestigationData accidentInvestigationData = rewardData.getAccidentInvestigationData();
		this.addComponent(new BasicLabel("��û�Ͻ� ��� ���� ������ �Դϴ�."));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("��� �ó�����", accidentInvestigationData.getScenario()));
		this.addComponent(new OutputTextArea("����", accidentInvestigationData.getDamage()));
		this.addComponent(new OutputTextArea("��� ó��", accidentInvestigationData.getTreatment()));
		this.addComponent(new OutputTextArea("��� ó�� ���", Integer.toString(accidentInvestigationData.getTreatmentCost())));
		this.addComponent(new ActionButton("��/��å �Ǵ� ���� �ۼ�", EActionCommands.WritePayJudgeReport.name(), actionListener));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)			);
	}

	

}
