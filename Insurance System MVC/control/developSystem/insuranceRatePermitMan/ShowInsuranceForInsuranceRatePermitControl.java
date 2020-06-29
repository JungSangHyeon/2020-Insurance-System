package control.developSystem.insuranceRatePermitMan;

import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.InsurancePermitTask;
import model.dataList.realDataList.DataList;
import view.insuranceSystemView.developView.insuranceRatePermitAndProductPermitMan.ShowInsuranceForJudgeView;
import view.panel.BasicPanel;

public class ShowInsuranceForInsuranceRatePermitControl extends DevelopSystem {

	// Association
	private DataList<InsurancePermitTask> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForInsuranceRatePermitControl(DataList<InsurancePermitTask> tasks, int taskIndex) {
		this.tasks=tasks; this.taskIndex=taskIndex;
	}

	@Override
	public BasicPanel getView() {
		this.targetInsuranceID = this.tasks.search(this.taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		return new ShowInsuranceForJudgeView(this.actionListener, this.insuranceData);
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (ShowInsuranceForJudgeView.EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitInsuranceRate(); this.orderProductPermit(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
		return null;
	}
	
	private void orderProductPermit() {
		for(ProductPermitManData employee : this.productPermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new InsurancePermitTask(this.targetInsuranceID)); break;}
		}
	}
}
