package test;

import java.util.Vector;

import model.aConstant.EDataListID;
import model.data.Data;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import model.data.activityPlanData.ActivityPlanData;
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
import model.data.insuranceData.AbsInsuranceData;
import model.data.rewardData.RewardData;
import model.dataList.IntDataList;
import model.dataList.realDataList.DataList;

public class TestModelCreator {
	
	public static Vector<IntDataList<? extends Data>> createTestModel() {
		Vector<IntDataList<? extends Data>> result = new Vector<IntDataList<? extends Data>>();
		
		// Create Data
		DeveloperData developer = new DeveloperData();
		developer.setName("Developer");
		developer.setLoginID("d");
		developer.setLoginPW("123");
		
		InsuranceRatePermitManData insuranceRatePermitManData = new InsuranceRatePermitManData();
		insuranceRatePermitManData.setName("InsuranceRatePermitManData");
		insuranceRatePermitManData.setLoginID("i");
		insuranceRatePermitManData.setLoginPW("123");
		
		ProductPermitManData productPermitManData = new ProductPermitManData();
		productPermitManData.setName("ProductPermitManData");
		productPermitManData.setLoginID("p");
		productPermitManData.setLoginPW("123");
		
		SalesManData salesManData = new SalesManData();
		salesManData.setName("SalesMan");
		salesManData.setLoginID("s");
		salesManData.setLoginPW("123");
		
		SalesManagerData salesManagerData = new SalesManagerData();
		salesManagerData.setName("SalesManager");
		salesManagerData.setLoginID("ss");
		salesManagerData.setLoginPW("123");
		
		AccidentInvestigatorData accidentInvestigatorData = new AccidentInvestigatorData();
		accidentInvestigatorData.setName("AccidentInvestigatorData");
		accidentInvestigatorData.setLoginID("ai");
		accidentInvestigatorData.setLoginPW("123");
		
		PayJudgerData payJudgerData = new PayJudgerData();
		payJudgerData.setName("PayJudgerData");
		payJudgerData.setLoginID("pj");
		payJudgerData.setLoginPW("123");
		
		LossCheckManData lossCheckManData = new LossCheckManData();
		lossCheckManData.setName("LossCheckManData");
		lossCheckManData.setLoginID("lc");
		lossCheckManData.setLoginPW("123");
		
		LawyerData lawyerData = new LawyerData();
		lawyerData.setName("LawyerData");
		lawyerData.setLoginID("ld");
		lawyerData.setLoginPW("123");
		
		// Create Model
		// Develop
		DataList<DeveloperData> developerDataList = new DataList<DeveloperData>();
		developerDataList.setID(EDataListID.DeveloperDataListID.ordinal());
		developerDataList.add(developer);
		
		DataList<InsuranceRatePermitManData> insuranceRatePermitManDataList = new DataList<InsuranceRatePermitManData>();
		insuranceRatePermitManDataList.setID(EDataListID.InsuranceRatePermitManDataListID.ordinal());
		insuranceRatePermitManDataList.add(insuranceRatePermitManData);
		
		DataList<ProductPermitManData> productPermitManDataList = new DataList<ProductPermitManData>();
		productPermitManDataList.setID(EDataListID.ProductPermitManDataListID.ordinal());
		productPermitManDataList.add(productPermitManData);
		
		DataList<AbsInsuranceData> insuranceDataList = new DataList<AbsInsuranceData>();
		insuranceDataList.setID(EDataListID.InsuranceDataListID.ordinal());
		
		// Sales
		DataList<SalesManData> salesManDataList = new DataList<SalesManData>(); //영업사원 리스트 만들기
		salesManDataList.setID(EDataListID.SalesManDataListID.ordinal());
		salesManDataList.add(salesManData); //영업사원 추가하기
		
		DataList<SalesManagerData> salesManagerDataList = new DataList<SalesManagerData>(); //영업사원 리스트 만들기
		salesManagerDataList.setID(EDataListID.SalesManagerDataListID.ordinal());
		salesManagerDataList.add(salesManagerData); //영업사원 추가하기
		
		DataList<ActivityPlanData> activityPlanDataList = new DataList<ActivityPlanData>();  
		activityPlanDataList.setID(EDataListID.ActivityPlanDataListID.ordinal());
		
		DataList<SalesTrainingPlanData> salesTrainigPlanDataList = new DataList<SalesTrainingPlanData>(); 
		salesTrainigPlanDataList.setID(EDataListID.SalesTrainigPlanDataListID.ordinal());
		
		// Reward
		DataList<CustomerData> customerDataList = new DataList<CustomerData>();
		customerDataList.setID(EDataListID.CustomerDataListID.ordinal());
		
		DataList<AccidentInvestigatorData> accidentInvestigatorDataList = new DataList<AccidentInvestigatorData>();
		accidentInvestigatorDataList.setID(EDataListID.AccidentInvestigatorDataListID.ordinal());
		accidentInvestigatorDataList.add(accidentInvestigatorData);
		
		DataList<PayJudgerData> payJudgerDataList = new DataList<PayJudgerData>();
		payJudgerDataList.setID(EDataListID.PayJudgerDataListID.ordinal());
		payJudgerDataList.add(payJudgerData);
		
		DataList<LossCheckManData> lossCheckManDataList = new DataList<LossCheckManData>();
		lossCheckManDataList.setID(EDataListID.LossCheckManDataListID.ordinal());
		lossCheckManDataList.add(lossCheckManData);
		
		DataList<LawyerData> lawyerDataList = new DataList<LawyerData>();
		lawyerDataList.setID(EDataListID.LawyerDataListID.ordinal());
		lawyerDataList.add(lawyerData);
		
		DataList<RewardData> rewardDataList = new DataList<RewardData>();
		rewardDataList.setID(EDataListID.RewardDataListID.ordinal());
		
		result.add(developerDataList);
		result.add(insuranceRatePermitManDataList);
		result.add(productPermitManDataList);
		result.add(customerDataList);
		result.add(accidentInvestigatorDataList);
		result.add(payJudgerDataList);
		result.add(lossCheckManDataList);
		result.add(lawyerDataList);
		result.add(insuranceDataList);
		result.add(customerDataList);
		result.add(rewardDataList);
		result.add(salesManDataList);
		result.add(salesManagerDataList);
		result.add(activityPlanDataList);
		result.add(salesTrainigPlanDataList);
		
		return result;
	}
}
