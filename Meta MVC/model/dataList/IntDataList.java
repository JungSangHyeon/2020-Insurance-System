package model.dataList;

import java.util.Vector;

import model.data.Data;

public interface IntDataList<T extends Data> {
	
	// Any Time Use
	public void add(T data);
	public void delete(int iD);
	public T search(int iD);
	
	// Getter & Setter
	public Vector<T> getList();
	public int getID();
	public void setID(int id);
}
