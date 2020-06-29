package model.data.systemUserData;

import component.DAO;
import model.data.Data;
import model.data.taskData.AbsTask;
import model.dataList.realDataList.DataList;

public class SystemUserData<TaskType extends AbsTask> extends Data {
	
	// Component
	private DAO dao;

	// Attribute
	public String loginID, loginPW;
			
	// Component
	private DataList<TaskType> taskList;
	
	// Constructor
	public SystemUserData() {
		// Create Component
		this.dao = new DAO("SystemUserData", "systemUserDataID", new Object[] {null, "", ""});
		this.taskList = new DataList<TaskType>();
	}
	
	// Any Time Use
	public void addTask(TaskType task) {this.taskList.add(task);}
	public void deleteTask(int iD) {this.taskList.delete(iD);}
	public TaskType searchTask(int iD) {return this.taskList.search(iD);}
		
	// Getter & Setter
	public DataList<TaskType> getTaskList() {return this.taskList;}
	
	public String getLoginID() {return this.dao.getString("loginID");}
	public void setLoginID(String loginID) {this.dao.update("loginID", loginID);}
	public String getLoginPW() {return this.dao.getString("loginPW");}
	public void setLoginPW(String loginPW) {this.dao.update("loginPW", loginPW);}

}
