package model.data.insuranceData;

import java.util.Vector;

import component.DAO;
import model.data.Data;
import model.data.customerData.CustomerData;

public abstract class AbsInsuranceData extends Data {
	
	// Attribute
	// public enum EInsuranceType {Car, Disease, Fire};
	
	// Component
	private DAO dao;
	private Vector<Integer> customerIDs;
	
	// Constructor
	public AbsInsuranceData() {
		// Create Component
		this.dao = new DAO("Insurance", "insuranceID", new Object[] {null, "", "", false, false, 0.0, null, ""});
		this.customerIDs = new Vector<Integer>(); 
	}

	// Any Time Use
	public abstract double insuranceRateCheck(CustomerData data);
	public void addCustomerID(int id) {this.customerIDs.add(id);}
	public void deleteCustomerID(int id) {this.customerIDs.remove(Integer.valueOf(id));}
	public boolean isCustomerSignIn(int id) {return this.customerIDs.contains(Integer.valueOf(id));}
	
	// Getter & Setter
	public String getName() {return this.dao.getString("insuranceName");}
	public String getContent() {return this.dao.getString("content");}
	public String getInsuranceRateInfo() {return this.dao.getString("insuranceRateInfo");}
	public double getLossPercent() {return this.dao.getDouble("lossPercent");}
	
	public void setName(String name) {this.dao.update("insuranceName", name);}
	public void setContent(String content) {this.dao.update("content", content);}
	public void setInsuranceRateInfo(String insuranceRateInfo) {this.dao.update("insuranceRateInfo", insuranceRateInfo);}
	public void setLossPercent(double lossPercent) {this.dao.update("lossPercent", lossPercent);}

//	public EInsuranceType getInsuranceType() {return EInsuranceType.valueOf(this.dao.getString("insuranceType"));}
//	public void setDisease(EInsuranceType insuranceType) {this.dao.update("insuranceType", insuranceType.ordinal()+1);}

	
	public boolean isInsuranceratePermit() {return this.dao.getBoolean("insuranceRatePermit");}
	public boolean isProductPermit() {return this.dao.getBoolean("productPermit");}
	public void permitInsuranceRate() {this.dao.update("insuranceRatePermit", true);}
	public void permitProduct() {this.dao.update("productPermit", true);}
	public void setPermitInsuranceRate(boolean insuranceRatePermit) {this.dao.update("insuranceRatePermit", insuranceRatePermit);}
	public void setPermitProduct(boolean productPermit) {this.dao.update("productPermit", productPermit);}
	
}
