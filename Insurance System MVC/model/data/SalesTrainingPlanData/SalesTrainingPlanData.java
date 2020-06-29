package model.data.SalesTrainingPlanData;

import java.util.Vector;

import component.DAO;
import model.aConstant.ETrainingTargetEmployee;
import model.data.Data;

public class SalesTrainingPlanData extends Data {
	
	// Component
	private DAO dao;
	private Vector<ETrainingTargetEmployee> target;
	
	// Constructor
	public SalesTrainingPlanData() {this.dao = new DAO("SalesTrainingPlan", "salesTrainingPlanID", new Object[] {null, "", "", "", "", ""});}

	// getter & setter
	public String getTitle() {return this.dao.getString("title");}
	public String getPlace() {return this.dao.getString("place");}
	public String getsalesTraningPlanDate() {return this.dao.getString("salesTraningPlanDate");}
	public String getSalesTrainingGoal() {return this.dao.getString("salesTrainingGoal");}
	public String getSalesTrainingContent() {return this.dao.getString("salesTrainingContent");}
	public Vector<ETrainingTargetEmployee> getTarget() {return target;}
	
	public void setTitle(String title) {this.dao.update("title", title);}
	public void setPlace(String place) {this.dao.update("place", place);}
	public void setSalesTraningPlanDate(String salesTraningPlanDate) {this.dao.update("salesTraningPlanDate", salesTraningPlanDate);}
	public void setSalesTrainingGoal(String salesTrainingGoal) {this.dao.update("salesTrainingGoal", salesTrainingGoal);}
	public void setSalesTrainingContent(String salesTrainingContent) {this.dao.update("salesTrainingContent", salesTrainingContent);}
	public void setTarget(Vector<ETrainingTargetEmployee> target) {this.target = target;}

//	public ETrainingTargetEmployee getTarget() {return ETrainingTargetEmployee.valueOf(this.dao.getString("salesDuration"));}
//	public void setTarget(ETrainingTargetEmployee salesDuration) {this.dao.update("salesDuration", salesDuration.ordinal()+1);}

}
