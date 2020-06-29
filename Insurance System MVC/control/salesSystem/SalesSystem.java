package control.salesSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.Data;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.data.activityPlanData.ActivityPlanData;
import model.data.customerData.CustomerData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntDataList;

public abstract class SalesSystem extends DynamicSystem {

	// Associate - person
	protected IntDataList<SalesManData> salesManList;
	protected IntDataList<SalesManagerData> salesManagerList;
	protected IntDataList<ActivityPlanData> activityPlanList;
	protected IntDataList<SalesTrainingPlanData> salesTrainigPlanList;
	protected IntDataList<CustomerData> customerDataList;
	protected IntDataList<AbsInsuranceData> insuranceDataList;

	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntDataList<? extends Data>> datas) {
		for(IntDataList<? extends Data> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case SalesManDataListID : this.salesManList=(IntDataList<SalesManData>) model; break;
			case SalesManagerDataListID : this.salesManagerList=(IntDataList<SalesManagerData>) model; break;
			case ActivityPlanDataListID : this.activityPlanList = (IntDataList<ActivityPlanData>) model; break;
			case SalesTrainigPlanDataListID : this.salesTrainigPlanList = (IntDataList<SalesTrainingPlanData>) model; break;
			case CustomerDataListID : this.customerDataList = (IntDataList<CustomerData>) model; break;
			case InsuranceDataListID : this.insuranceDataList = (IntDataList<AbsInsuranceData>) model; break;
			default : break;
			}
		}
	}
}
