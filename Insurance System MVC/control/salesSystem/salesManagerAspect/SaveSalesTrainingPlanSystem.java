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
				JOptionPane.showMessageDialog(this.view, "저장이 완료되었습니다.", "SaveInsuranceData",
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

	// 저장이 완료되면 true 아니면 false
	public boolean save() {
		try {
			SalesTrainingPlanData data = new SalesTrainingPlanData();

			// title 확인 및 추가
			if (this.view.getTitleTTA().getContent() != "") {
				data.setTitle(this.view.getTitleTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "제목이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
			}

			// 내용 확인 및 추가
			if (this.view.getSalesTrainingPlaceTTA().getContent() != "") {
				data.setPlace(this.view.getSalesTrainingPlaceTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "장소가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
			}
			
			// 날짜 추가 (try catch로 잡음.)
			data.setSalesTraningPlanDate(LocalDateTime.parse(this.view.getSalesTrainingDateTTA().getContent(),
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toString());

			// goal 확인 및 추가
			if (this.view.getSalesTrainingGoalTTA().getContent() != "") {
				data.setSalesTrainingGoal(this.view.getSalesTrainingGoalTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
			}

			// content 확인 및 추가
			if (this.view.getSalesTrainingContentTTA().getContent() != "") {
				data.setSalesTrainingContent(this.view.getSalesTrainingContentTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "내용이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
			}

			// 타겟 확인 및 추가
			if(this.view.getSalesTrainingTargetTTA().getSelectedOptionNames().size()!=0) {
				data.setTarget(multipleChoice(ETrainingTargetEmployee.class,
						this.view.getSalesTrainingTargetTTA().getSelectedOptionNames()));
			} else {
				JOptionPane.showMessageDialog(this.view, "타겟이 선택되지 않았습니다. 다시한번 확인해주십시오.");
				return false;
			}

			this.salesTrainigPlanList.add(data);

		} catch (DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "날짜 입력에 오류가 있습니다. 다시한번 확인해주십시오.");return false;
		}return true;
	}
	// enum을 String Vector로 저장
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
