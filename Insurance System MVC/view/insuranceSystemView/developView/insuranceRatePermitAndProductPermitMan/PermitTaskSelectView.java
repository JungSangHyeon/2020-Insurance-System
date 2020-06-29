package view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.employeeData.AbsEmployeeData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.InsurancePermitTask;
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
public class PermitTaskSelectView extends InsuranceSystemView {

	// Constructor
	public PermitTaskSelectView(ActionListener actionListener, AbsEmployeeData<InsurancePermitTask> loginIRPM, IntDataList<AbsInsuranceData> insuranceList) {
		this.addComponent(new BasicLabel("보험 선택"));
		this.addComponent(new SeparateLine(Color.black));
		
		if(loginIRPM.getTaskList().getList().size()==0) {
			this.addComponent(new OutputTextArea("처리할 업무가 없습니다.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(InsurancePermitTask task : loginIRPM.getTaskList().getList()) {
				AbsInsuranceData insuranceData = insuranceList.search(task.getTargetInsuranceID());
				selectBtnGroup.addGroupComponent(new SelectButton(insuranceData.getName(), Integer.toString(task.getID()), actionListener));
			}
			this.addComponent(selectBtnGroup);
		}
		
		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null)
		);
	}
}
