package view.insuranceSystemView.rewardView.investigator;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.rewardData.AccidentData;
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
public class ShowAccidentInfoForIVView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {WriteInvestReport}
	
	public ShowAccidentInfoForIVView(AccidentInvestigatorData user, ActionListener actionListener, int taskID, IntDataList<RewardData> rewardDataList) {
	RewardData rewardData = rewardDataList.search(user.getTaskList().search(taskID).getRewardDataID());
	AccidentData accidentData = rewardData.getAccidentData();
	this.addComponent(new BasicLabel("요청하신 사고 데이터 입니다."));
	this.addComponent(new SeparateLine(Color.black));

	this.addComponent(new OutputTextArea("사고 유형", accidentData.getType()));
	this.addComponent(new OutputTextArea("사고 위치", accidentData.getLocation()));
	this.addComponent(new OutputTextArea("사고 시간", accidentData.getDate()));
	this.addComponent(new ActionButton("조사 보고서 작성", EActionCommands.WriteInvestReport.name(), actionListener));
	
	this.addToLinkPanel(
			new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)	
            	);
	}
}
