package view.insuranceSystemView.developView.developer.developInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData.EDisease;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class DevelopInsuranceView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {SaveInsuranceData, InsuranceDesign, WatchInsuranceData}
		
	// Component
	private InputTextArea nameTTA, contentTTA, insuranceRateInfoTTA, lossPercentTTA;
	private TitledRadioButtonGroup diseaseTRBG;
		
	// Constructor
	public DevelopInsuranceView(ActionListener actionListener, boolean isDisease) {
		this.addComponent(new BasicLabel("보험 정보 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.nameTTA = new InputTextArea("이름", "자동차 보험", 1,100);
		this.lossPercentTTA = new InputTextArea("손해율", "10.0", 1, 100);
		this.contentTTA = new InputTextArea("설명", "기본 자동차 보험. (단, 인원수에 따라 보험료가 높아질 수 있습니다.) \r\n블랙박스 특약, 3년 무사고 특약 포함", 10, 100);
		String content = "완파 사고 기록이 있으면 요율 1.3배\r\n"
				+ "남의 차를 파손시킨 기록이 있으면 요율 1.2배\r\n"
				+ "내 차를 파손 기록이 있으면 요율 1.1배\r\n"
				+ "30세 이하면 1.1배\r\n"
				+ "남자면 1.1배";
		this.insuranceRateInfoTTA = new InputTextArea("요율 설명", content, 10, 100);
		if(isDisease) {
			this.diseaseTRBG = new TitledRadioButtonGroup("보상 질병", EDisease.class, false, 100);
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.diseaseTRBG, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}else {
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}
		
		this.addComponent(new ActionButton("저장", EActionCommands.SaveInsuranceData.name(), actionListener));
		
		this.addToLinkPanel (
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
	
	// Getter & Setter
	public String getName() {return this.nameTTA.getContent();}
	public String getContent() {return this.contentTTA.getContent();}
	public String getInsuranceRateInfo() {return this.insuranceRateInfoTTA.getContent();}
	public String getLossPercent() {return this.lossPercentTTA.getContent();}
	public String getDisease() {return this.diseaseTRBG.getSelectedOptionNames().get(0);}
}
