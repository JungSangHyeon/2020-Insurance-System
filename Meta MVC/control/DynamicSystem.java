package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import model.data.Data;
import model.dataList.IntDataList;
import view.aConstant.ButtonConstant;
import view.panel.BasicPanel;

public abstract class DynamicSystem {
	
	// Association
	protected ActionListener actionListener;
	
	// Initialize Time Use
	public abstract void associateModel(Vector<IntDataList<? extends Data>> datas); 
	public void associateActionListener(ActionListener actionListener) {this.actionListener=actionListener;}
	
	// Any Time Use
	public abstract BasicPanel getView();
	public abstract DynamicSystem processEvent(ActionEvent e);
	public void gotoBack() {this.actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ButtonConstant.BackButtonIdentifier));}
}
	
	
