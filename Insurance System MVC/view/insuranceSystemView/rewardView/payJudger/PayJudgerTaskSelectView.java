package view.insuranceSystemView.rewardView.payJudger;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.rewardData.AccidentInvestigationData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.PayJudgeTask;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class PayJudgerTaskSelectView extends InsuranceSystemView {

	public PayJudgerTaskSelectView(PayJudgerData user, ActionListener actionListener, IntDataList<RewardData> rewardDataList) {
		this.addComponent(new BasicLabel("��/��å �Ǵ��� ������ ���� ����� �����ϼ���"));
		this.addComponent(new SeparateLine(Color.black));
		
		if(user.getTaskList().getList().size()==0) {
			this.addComponent(new OutputTextArea("ó���� ������ �����ϴ�.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(PayJudgeTask payJudgeData : user.getTaskList().getList()) {
				RewardData rewardData = rewardDataList.search(payJudgeData.getRewardDataID());
				AccidentInvestigationData accidentInvestigationData = rewardData.getAccidentInvestigationData();
				selectBtnGroup.addGroupComponent(new SelectButton(accidentInvestigationData.getScenario(), Integer.toString(payJudgeData.getID()), actionListener));
			}
			this.addComponent(selectBtnGroup);
		}
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
