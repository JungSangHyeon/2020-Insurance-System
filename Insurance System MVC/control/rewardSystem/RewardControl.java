package control.rewardSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.Data;
import model.data.customerData.CustomerData;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.rewardData.RewardData;
import model.dataList.IntDataList;

public abstract class RewardControl extends DynamicSystem{
	
	// Associate
	protected IntDataList<CustomerData> customerList;
	protected IntDataList<AccidentInvestigatorData> accidentInvestigatorList;
	protected IntDataList<PayJudgerData> payJudgerList;
	protected IntDataList<LossCheckManData> lossCheckManList;
	protected IntDataList<LawyerData> lawyerList;	
	protected IntDataList<RewardData> rewardDataList;

	// Initialize Time Use
	@Override @SuppressWarnings({ "unchecked" })
	public void associateModel(Vector<IntDataList<? extends Data>> datas) {
		for(IntDataList<? extends Data> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case CustomerDataListID : this.customerList=(IntDataList<CustomerData>) model; break;
			case AccidentInvestigatorDataListID : this.accidentInvestigatorList=(IntDataList<AccidentInvestigatorData>) model; break;
			case PayJudgerDataListID : this.payJudgerList=(IntDataList<PayJudgerData>) model; break;
			case LossCheckManDataListID : this.lossCheckManList=(IntDataList<LossCheckManData>) model; break;
			case LawyerDataListID : this.lawyerList=(IntDataList<LawyerData>) model; break;
			case RewardDataListID : this.rewardDataList=(IntDataList<RewardData>) model; break;
			default : break;
			}
		}
	}
}
 