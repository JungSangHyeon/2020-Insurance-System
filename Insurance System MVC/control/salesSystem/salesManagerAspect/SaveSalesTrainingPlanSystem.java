package control.salesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETrainingTargetEmployee;
import model.data.SalesTrainingPlanData.SalesTrainingPlanData;
import view.insuranceSystemView.salesView.salesManager.SaveSalesTrainingPlanView;
import view.panel.BasicPanel;

public class SaveSalesTrainingPlanSystem extends SalesSystem {
		
	// Component
	private SaveSalesTrainingPlanView view;
	
	@Override
	public BasicPanel getView() {
		this.view = new SaveSalesTrainingPlanView(this.actionListener);
		return this.view;
	}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (SaveSalesTrainingPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case Save:
			if (this.save()) {
				JOptionPane.showMessageDialog(this.view, "������ �Ϸ�Ǿ����ϴ�.", "SaveInsuranceData",
						JOptionPane.INFORMATION_MESSAGE);
				this.gotoBack(); 
			}
			break;
		case SaveActivityPlan:
			return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan:
			return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}

	// ������ �Ϸ�Ǹ� true �ƴϸ� false
	public boolean save() {
		try {
			SalesTrainingPlanData data = new SalesTrainingPlanData();

			// title Ȯ�� �� �߰�
			if (this.view.getTitleTTA().getContent() != "") {
				data.setTitle(this.view.getTitleTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "������ �Էµ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}

			// ���� Ȯ�� �� �߰�
			if (this.view.getSalesTrainingPlaceTTA().getContent() != "") {
				data.setPlace(this.view.getSalesTrainingPlaceTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "��Ұ� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}
			
			// ��¥ �߰� (try catch�� ����.)
			data.setSalesTraningPlanDate(LocalDateTime.parse(this.view.getSalesTrainingDateTTA().getContent(),
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString());

			// goal Ȯ�� �� �߰�
			if (this.view.getSalesTrainingGoalTTA().getContent() != "") {
				data.setSalesTrainingGoal(this.view.getSalesTrainingGoalTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "��ǥ�� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}

			// content Ȯ�� �� �߰�
			if (this.view.getSalesTrainingContentTTA().getContent() != "") {
				data.setSalesTrainingContent(this.view.getSalesTrainingContentTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "������ �Էµ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}

			// Ÿ�� Ȯ�� �� �߰�
			if(this.view.getSalesTrainingTargetTTA().getSelectedOptionNames().size()!=0) {
				data.setTarget(multipleChoice(ETrainingTargetEmployee.class,
						this.view.getSalesTrainingTargetTTA().getSelectedOptionNames()));
			} else {
				JOptionPane.showMessageDialog(this.view, "Ÿ���� ���õ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
				return false;
			}

			this.salesTrainigPlanList.add(data);

		} catch (DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "��¥ �Է¿� ������ �ֽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		}return true;
	}
	// enum�� String Vector�� ����
	private <E> Vector<E> multipleChoice(Class<E> enumClass, Vector<String> selectedOptionNames)  {
		Vector<E> returnVect = new Vector<E>();
		for(String s : selectedOptionNames) {
			for(E e : enumClass.getEnumConstants()) {
				if(e.toString().equals(s)) {
					returnVect.add(e);
				}
			}
		}
		return returnVect;
	}
}
