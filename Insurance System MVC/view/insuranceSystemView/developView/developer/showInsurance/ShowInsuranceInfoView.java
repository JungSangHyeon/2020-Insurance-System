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
		this.addComponent(new BasicLabel("���� ���� Ȯ��"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.addComponent(new OutputTextArea("�̸�", insuranceData.getName()));
		this.addComponent(new OutputTextArea("������", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			this.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		this.addComponent(new OutputTextArea("����", insuranceData.getContent()));
		this.addComponent(new OutputTextArea("���� ����", insuranceData.getInsuranceRateInfo()));
		this.addComponent(new OutputTextArea("���� ���� ����", Boolean.toString(insuranceData.isInsuranceratePermit())));
		this.addComponent(new OutputTextArea("��ǰ �ΰ� ����", Boolean.toString(insuranceData.isProductPermit())));
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("���� ����", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
}
