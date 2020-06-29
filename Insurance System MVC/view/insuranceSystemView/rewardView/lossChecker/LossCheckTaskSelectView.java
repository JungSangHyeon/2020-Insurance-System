package view.insuranceSystemView.rewardView.lossChecker;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.rewardData.PayJudgeData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.LossCheckTask;
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
public class LossCheckTaskSelectView extends InsuranceSystemView {

	public LossCheckTaskSelectView(LossCheckManData user, ActionListener actionListener, IntDataList<RewardData> rewardDataList) {
		this.addComponent(new BasicLabel("손해사정을 시행할 업무 목록을 선택하세요"));
		this.addComponent(new SeparateLine(Color.black));
		
		if(user.getTaskList().getList().size()==0) {
			this.addComponent(new OutputTextArea("처리할 업무가 없습니다.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(LossCheckTask lossCheckData : user.getTaskList().getList()) {
				RewardData rewardData = rewardDataList.search(lossCheckData.getRewardDataID());
				PayJudgeData payJudgeData = rewardData.getPayJudgeData();
				selectBtnGroup.addGroupComponent(new SelectButton(payJudgeData.getPayJudge(), Integer.toString(lossCheckData.getID()), actionListener));
			}
			this.addComponent(selectBtnGroup);
		}
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
