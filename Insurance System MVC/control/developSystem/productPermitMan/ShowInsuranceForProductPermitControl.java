package control.developSystem.productPermitMan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.InsurancePermitTask;
import model.dataList.realDataList.DataList;
import view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan.ShowInsuranceForJudgeView;
import view.panel.BasicPanel;

public class ShowInsuranceForProductPermitControl extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private DataList<InsurancePermitTask> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForProductPermitControl(DataList<InsurancePermitTask> isDataList, int taskIndex) {
		this.tasks=isDataList; this.taskIndex=taskIndex;
	}
	
	@Override
	public BasicPanel getView() {
		this.targetInsuranceID = this.tasks.search(this.taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		return new ShowInsuranceForJudgeView(this.actionListener, this.insuranceData);
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitProduct(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
		return null;
	}
}
