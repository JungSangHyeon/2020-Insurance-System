package control.developSystem;

import java.util.Vector;

import control.DynamicSystem;
import model.aConstant.EDataListID;
import model.data.Data;
import model.data.employeeData.developEmployeeData.DeveloperData;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.dataList.IntDataList;

public abstract class DevelopSystem extends DynamicSystem {

	// Associate
	protected IntDataList<DeveloperData> developerList;
	protected IntDataList<InsuranceRatePermitManData> insuranceRatePermitManList;
	protected IntDataList<ProductPermitManData> productPermitManList;
	protected IntDataList<AbsInsuranceData> insuranceList;
	
	@Override @SuppressWarnings("unchecked")
	public void associateModel(Vector<IntDataList<? extends Data>> datas) {
		for(IntDataList<? extends Data> model : datas) {
			switch(EDataListID.values()[model.getID()]) {
			case DeveloperDataListID : this.developerList=(IntDataList<DeveloperData>) model; break;
			case InsuranceRatePermitManDataListID : this.insuranceRatePermitManList=(IntDataList<InsuranceRatePermitManData>) model; break;
			case ProductPermitManDataListID : this.productPermitManList=(IntDataList<ProductPermitManData>) model; break;
			case InsuranceDataListID : this.insuranceList=(IntDataList<AbsInsuranceData>) model; break;
			default : break;
			}
		}
	}
}
