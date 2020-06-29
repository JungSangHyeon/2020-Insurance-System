package view.insuranceSystemView.rewardView.lawyer;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.rewardData.AccidentData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.LawSuitTask;
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
public class LawsuitTaskSelectView extends InsuranceSystemView {

	public LawsuitTaskSelectView(LawyerData user, ActionListener actionListener, IntDataList<RewardData> rewardDataList) {
		this.addComponent(new BasicLabel("소송 업무 데이터 목록을 선택하세요."));
		this.addComponent(new SeparateLine(Color.black));

		if (user.getTaskList().getList().size() == 0) {
			this.addComponent(new OutputTextArea("처리할 업무가 없습니다.", ""));
		} else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for (LawSuitTask lawsuitData : user.getTaskList().getList()) {
				RewardData rewardData = rewardDataList.search(lawsuitData.getRewardDataID());
				AccidentData accidentData = rewardData.getAccidentData();
				selectBtnGroup.addGroupComponent(new SelectButton(accidentData.getType(), Integer.toString(lawsuitData.getID()), actionListener));
			}
			this.addComponent(selectBtnGroup);
		}
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}	
}
