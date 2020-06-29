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
	this.addComponent(new BasicLabel("��û�Ͻ� ��� ������ �Դϴ�."));
	this.addComponent(new SeparateLine(Color.black));

	this.addComponent(new OutputTextArea("��� ����", accidentData.getType()));
	this.addComponent(new OutputTextArea("��� ��ġ", accidentData.getLocation()));
	this.addComponent(new OutputTextArea("��� �ð�", accidentData.getDate()));
	this.addComponent(new ActionButton("���� ���� �ۼ�", EActionCommands.WriteInvestReport.name(), actionListener));
	
	this.addToLinkPanel(
			new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)	
            	);
	}
}
