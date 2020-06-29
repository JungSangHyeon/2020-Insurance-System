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
            JOptionPane.showMessageDialog(this.view, "저장이 완료되었습니다.", "", JOptionPane.INFORMATION_MESSAGE);
            this.gotoBack(); 
			}
			return null;
		case SaveActivityPlan: return new SaveActivityPlanSystem();
		case SaveSalesTrainingPlan: return new SaveSalesTrainingPlanSystem();
		}
		return null;
	}
	
	// 저장이 완료되면 true 아니면 false
	private boolean save() {
		try {
			ActivityPlanData data = new ActivityPlanData();
			
			//title  확인 및 추가
			if (this.view.getTitleTTA().getContent() != "") {
				data.setTitle(this.view.getTitleTTA().getContent());
			} else { 
				JOptionPane.showMessageDialog(this.view, "제목이 입력되지 않았습니다. 다시한번 확인해주십시오.");return false;
			}
			
			//salesgoal 확인 및 추가
			if (this.view.getSalesGoalTTA().getContent() != "" ) {
				data.setSalesGoal(Integer.parseInt(this.view.getSalesGoalTTA().getContent()));
			} else {
				JOptionPane.showMessageDialog(this.view, "판매 목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
			}
			
			// acitivity goal  확인 및 추가
			if (this.view.getActivityGoalTTA().getContent() != "") {
				data.setActivityGoal(this.view.getActivityGoalTTA().getContent());
			} else {
				JOptionPane.showMessageDialog(this.view, "활동목표가 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
			}
			
			// target  확인 및 추가
			if(this.view.getSalesTargetCustomerTTA().getSelectedOptionNames().size()!=0) {
				data.setSalesTargetCustomer(multipleChoice(ETargetCustomer.class, this.view.getSalesTargetCustomerTTA().getSelectedOptionNames()));
			}else {
				JOptionPane.showMessageDialog(this.view, "주력 고객이 선택되지 않았습니다. 다시한번 확인해주십시오.");
			}

			// additionalJobOffer 확인 추가
			if (this.view.getAdditionalJobOfferTTA().getContent() != "" ) {
				data.setAdditionalJobOffer(Integer.parseInt(this.view.getAdditionalJobOfferTTA().getContent()));
			} else {
				JOptionPane.showMessageDialog(this.view, "추가 구인량이 입력되지않았습니다. 다시한번 확인해주십시오.");return false;
			}

			// duration 확인 추가 (Format안맞으면 알아서 try catch)
			data.setSalesDuration(LocalDate.parse(this.view.getDateTTA().getContent()).toString());
			
			this.activityPlanList.add(data);
		} catch(DateTimeParseException e) {JOptionPane.showMessageDialog(this.view, "날짜 입력에 오류가 있습니다. 다시한번 확인해주십시오.");return false;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this.view, "추가 구인량 혹은 활동목표에는 숫자만 입력해주십시오.");return false;
		} 
		return true;
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
