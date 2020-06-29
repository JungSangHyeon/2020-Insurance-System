package view.insuranceSystemView.rewardView.customer;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.customerData.CustomerData;
import model.data.rewardData.AccidentData;
import model.data.rewardData.RewardData;
import model.data.taskData.rewardTask.PayAgreementTask;
import model.dataList.IntDataList;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class ShowPaymentAgreeView extends InsuranceSystemView {
	
	// Static
	public enum EActionCommands {AccidentProcessApply, isPaymentAgree}
		
	// Component
	private InputTextArea accidentTypeTTA, accidentLocationTTA, accidentDateTTA;		
	
	// Constructor
	public ShowPaymentAgreeView(ActionListener actionListener, CustomerData user, IntDataList<RewardData> rewardDataList) {
		this.addComponent(new BasicLabel("보험금 수령 동의 건을 선택하세요"));
		this.addComponent(new SeparateLine(Color.black));
		
		DynamicGroup selectBtnGroup = new DynamicGroup();	
		for(PayAgreementTask payAgreementData : user.getTaskList().getList()) {
			RewardData rewardData = rewardDataList.search(payAgreementData.getRewardDataID());
			AccidentData accidentData = rewardData.getAccidentData();
			selectBtnGroup.addGroupComponent(new SelectButton(accidentData.getType(), Integer.toString(payAgreementData.getID()), actionListener));
		}	
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
			);
	}
	
	// Getter & Setter
	public String getAccidentType() {return this.accidentTypeTTA.getContent();}
	public String getAccidentLocation() {return this.accidentLocationTTA.getContent();}
	public String getAccidentDate() {return this.accidentDateTTA.getContent();}
	

}
