package model.data.activityPlanData;

import java.util.Vector;

import component.DAO;
import model.aConstant.ETargetCustomer;
import model.data.Data;

public class ActivityPlanData extends Data {
	
	// Component
	private DAO dao;
	private Vector<ETargetCustomer> salesTargetCustomer;
	
	// Constructor
	public ActivityPlanData() {this.dao = new DAO("ActivityPlan", "activityPlanID", new Object[] {null, "", "", 0, "", 0, null});}

	// getter & setter
	public String getTitle() {return this.dao.getString("title");}
	public String getSalesDuration() {return this.dao.getString("salesDuration");}
	public String getActivityGoal() {return this.dao.getString("activityGoal");}
	public int getSalesGoal() {return this.dao.getInt("salesGoal");}
	public int getAdditionalJobOffer() {return this.dao.getInt("additionalJobOffer");}
	public Vector<ETargetCustomer> getSalesTargetCustomer() { return salesTargetCustomer; }
	
	public void setTitle(String title) {this.dao.update("title", title);}
	public void setSalesDuration(String salesDuration) {this.dao.update("salesDuration", salesDuration);}
	public void setActivityGoal(String activityGoal) {this.dao.update("activityGoal", activityGoal);}
	public void setSalesGoal(int salesGoal) {this.dao.update("salesGoal", salesGoal);}	
	public void setAdditionalJobOffer(int additionalJobOffer) {this.dao.update("additionalJobOffer", additionalJobOffer);}
	public void setSalesTargetCustomer(Vector<ETargetCustomer> salesTargetCustomer) { this.salesTargetCustomer = salesTargetCustomer;}

//	public ETargetCustomer getSalesTargetCustomer() {return ETargetCustomer.valueOf(this.dao.getString("salesTargetCustomer"));}
//	public void setSalesTargetCustomer(ETargetCustomer salesTargetCustomer) {this.dao.update("salesTargetCustomer", salesTargetCustomer.ordinal()+1);}
	
}
