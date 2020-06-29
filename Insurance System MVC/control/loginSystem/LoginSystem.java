package control.loginSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.Data;
import model.data.customerData.CustomerData;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.employeeData.rewardEmployeeData.AccidentInvestigatorData;
import model.data.employeeData.rewardEmployeeData.LawyerData;
import model.data.employeeData.rewardEmployeeData.LossCheckManData;
import model.data.employeeData.rewardEmployeeData.PayJudgerData;
import model.data.employeeData.salesEmployeeData.SalesManData;
import model.data.employeeData.salesEmployeeData.SalesManagerData;
import model.dataList.IntDataList;

public abstract class LoginSystem extends DynamicSystem {

	// Associate
	protected IntDataList<DeveloperData> developerList;
	protected IntDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntDataList<ProductPermitManData> productPermitManList;
	protected IntDataList<CustomerData> customerList;
	protected IntDataList<SalesManData> salesManList;
	protected IntDataList<SalesManagerData> salesManagerList;
	protected IntDataList<AccidentInvestigatorData> accidentInvestigatorList;
	protected IntDataList<PayJudgerData> payJudgerList;
	protected IntDataList<LossCheckManData> lossCheckManList;
	protected IntDataList<LawyerData> lawyerList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntDataList<? extends Data>> datas) {
		for(IntDataList<? extends Data> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			// Develop Aspect
			case DeveloperDataListID : this.developerList=(IntDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntDataList<ProductPermitManData>) model; break;
			case CustomerDataListID : this.customerList=(IntDataList<CustomerData>) model; break;					
			// Sales Aspect
			case SalesManDataListID : this.salesManList=(IntDataList<SalesManData>) model; break;
			case SalesManagerDataListID : this.salesManagerList=(IntDataList<SalesManagerData>) model; break;
			// Reward Aspect
			case AccidentInvestigatorDataListID : this.accidentInvestigatorList=(IntDataList<AccidentInvestigatorData>) model; break;
			case PayJudgerDataListID : this.payJudgerList=(IntDataList<PayJudgerData>) model; break;
			case LossCheckManDataListID : this.lossCheckManList=(IntDataList<LossCheckManData>) model; break;
			case LawyerDataListID : this.lawyerList=(IntDataList<LawyerData>) model; break;		
			default : break;
			}
		}
	}
}
