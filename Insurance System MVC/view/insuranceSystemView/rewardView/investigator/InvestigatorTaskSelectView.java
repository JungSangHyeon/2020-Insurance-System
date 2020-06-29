package view.insuranceSystemView.rewardView.investigator;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.rewardData.AccidentData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.AccidentInvestigationTask;
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
public class InvestigatorTaskSelectView extends InsuranceSystemView {

	public InvestigatorTaskSelectView(AccidentInvestigatorData user, ActionListener actionListener, IntDataList<RewardData> rewardDataList) {
		this.addComponent(new BasicLabel("��� ���� ��� ����"));
		this.addComponent(new SeparateLine(Color.black));
		
		if(user.getTaskList().getList().size()==0) {
			this.addComponent(new OutputTextArea("ó���� ������ �����ϴ�.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(AccidentInvestigationTask task : user.getTaskList().getList()) {
				RewardData rewardData = rewardDataList.search(task.getRewardDataID());
				AccidentData accidentData = rewardData.getAccidentData();
				selectBtnGroup.addGroupComponent(new SelectButton(accidentData.getType(), Integer.toString(task.getID()), actionListener));
			}
			this.addComponent(selectBtnGroup);
		}	
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
