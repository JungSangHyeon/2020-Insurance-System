package control.salesSystem.salesManagerAspect;

import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import model.aConstant.ETargetCustomer;
import model.data.activityPlanData.ActivityPlanData;
import view.insuranceSystemView.salesView.salesManager.SaveActivityPlanView;
import view.panel.BasicPanel;

public class SaveActivityPlanSystem extends SalesSystem {
	
	// Component
	private SaveActivityPlanView view;

	@Override
	public BasicPanel getView() {
		this.view = new SaveActivityPlanView(this.actionListener);
		return this.view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (SaveActivityPlanView.EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if(this.save()) { 
            JOptionPane.showMessageDialog(this.view, "������ �Ϸ�Ǿ����ϴ�.", "", JOptionPane.INFORMATION_MESSAGE);
            this.gotoBack(); 
			}
			return null;
		case SaveActivityPlan: return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan: return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}
	
	// ������ �Ϸ�Ǹ� true �ƴϸ� false
	private boolean save() {
		try {
			ActivityPlanData data = new ActivityPlanData();
			
			//title  Ȯ�� �� �߰�
			if (this.view.getTitleTTA().getContent() != "") {
				data.setTitle(this.view.getTitleTTA().getContent());
			} else { 
				JOptionPane.showMessageDialog(this.view, "������ �Էµ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}
			
			//salesgoal Ȯ�� �� �߰�
			if (this.view.getSalesGoalTTA().getContent() != "" ) {
				data.setSalesGoal(Integer.parseInt(this.view.getSalesGoalTTA().getContent()));
			} else {
				JOptionPane.showMessageDialog(this.view, "�Ǹ� ��ǥ�� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}
			
			// acitivity goal  Ȯ�� �� �߰�
			if (this.view.getActivityGoalTTA().getContent() != "") {
				data.setActivityGoal(this.view.getActivityGoalTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "Ȱ����ǥ�� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}
			
			// target  Ȯ�� �� �߰�
			if(this.view.getSalesTargetCustomerTTA().getSelectedOptionNames().size()!=0) {
				data.setSalesTargetCustomer(multipleChoice(ETargetCustomer.class, this.view.getSalesTargetCustomerTTA().getSelectedOptionNames()));
			}else {
				JOptionPane.showMessageDialog(this.view, "�ַ� ���� ���õ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");
			}

			// additionalJobOffer Ȯ�� �߰�
			if (this.view.getAdditionalJobOfferTTA().getContent() != "" ) {
				data.setAdditionalJobOffer(Integer.parseInt(this.view.getAdditionalJobOfferTTA().getContent()));
			} else {
				JOptionPane.showMessageDialog(this.view, "�߰� ���η��� �Էµ����ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
			}

			// duration Ȯ�� �߰� (Format�ȸ����� �˾Ƽ� try catch)
			data.setSalesDuration(LocalDate.parse(this.view.getDateTTA().getContent()).toString());
			
			this.activityPlanList.add(data);
		} catch(DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "��¥ �Է¿� ������ �ֽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this.view, "�߰� ���η� Ȥ�� Ȱ����ǥ���� ���ڸ� �Է����ֽʽÿ�.");return false;
		} 
		return true;
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
