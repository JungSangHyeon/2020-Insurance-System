package main;

import java.util.Vector;

import control.StaticSystem;
import control.loginSystem.RealLoginControl;
import model.data.Data;
import model.dataList.IntDataList;
import test.TestModelCreator;
import view.frame.realFrame.MainFrame;

public class Main {

	public static void main(String[] args) {
		// Create Model
		Vector<IntDataList<? extends Data>> models = TestModelCreator.createTestModel();
		
		// Create View
		MainFrame view = new MainFrame();
		
		// Create Control
		StaticSystem system = new StaticSystem();
		
		// Associate Model to Control
		for(IntDataList<? extends Data> model : models) {system.associateModel(model);}
		
		// Associate View to Control
		system.associateMainFrame(view);
		
		// Start
		system.startNewDynamicSystem(new RealLoginControl());
		view.setVisible(true);
	}
}
