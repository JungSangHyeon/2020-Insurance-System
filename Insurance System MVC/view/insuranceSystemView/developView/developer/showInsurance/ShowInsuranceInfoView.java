package view.insuranceSystemView.developView.developer.showInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class ShowInsuranceInfoView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {InsuranceDesign, WatchInsuranceData}
		
	// Constructor
	public ShowInsuranceInfoView(ActionListener actionListener, AbsInsuranceData insuranceData) {
		this.addComponent(new BasicLabel("보험 정보 확인"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("이름", insuranceData.getName()));
		this.addComponent(new OutputTextArea("손해율", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("보상 질병", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		this.addComponent(new OutputTextArea("설명", insuranceData.getContent()));
		this.addComponent(new OutputTextArea("요율 설명", insuranceData.getInsuranceRateInfo()));
		this.addComponent(new OutputTextArea("요율 검증 여부", Boolean.toString(insuranceData.isInsuranceratePermit())));
		this.addComponent(new OutputTextArea("상품 인가 여부", Boolean.toString(insuranceData.isProductPermit())));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
}
