package control.salesSystem.salesManAspect.SigninCustomer;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.salesSystem.SalesSystem;
import control.salesSystem.salesManAspect.LookupAvailableProduct.SearchCustomerSystem;
import control.salesSystem.salesManAspect.WatchActivityPlan.WatchActivityPlanSystem;
import control.salesSystem.salesManAspect.WatchSalesTrainingPlan.WatchSalesTrainingPlanSystem;
import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import model.data.customerData.CustomerData;
import view.insuranceSystemView.salesView.salesMan.SigninCustomer.SinginCustomerView;
import view.panel.BasicPanel;

public class SinginCustomerSystem extends SalesSystem {
	
	// Component
	private SinginCustomerView view;
	
	@Override
	public BasicPanel getView() {this.view = new SinginCustomerView(this.actionListener);return this.view;}

	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (SinginCustomerView.EActionCommands.valueOf(e.getActionCommand())) {
		case Save :
			if (this.save()) {
				JOptionPane.showMessageDialog(this.view, "저장이 완료되었습니다.", "가입완료", JOptionPane.INFORMATION_MESSAGE);
				this.gotoBack();
			}
			return null;
		case SigninCustomer : return new SinginCustomerSystem();
		case LookupAvailableProduct : return new SearchCustomerSystem();
		case WatchActivityPlan: return new WatchActivityPlanSystem();
		case WatchSalesTrainingPlan: return new WatchSalesTrainingPlanSystem(); 
		}
		return null;
	}
	
	// true면 저장 
	private boolean save() {
		CustomerData data = new CustomerData();
		// no limit
		data.setLoginID(this.view.getLoginIDTTA().getContent());
		data.setLoginPW(this.view.getLoginPWTTA().getContent());
		data.setName(this.view.getNameTTA().getContent());
		data.setResidence(this.view.getResidenceTTA().getContent());
		data.setJob(this.view.getJobTTA().getContent());
		try {
			data.setProperty(Integer.parseInt(this.view.getPropertyTTA().getContent()));
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(this.view, "재산을 숫자로 입력해 주십시오.");return false;
		}
		data.setIllHistory(multipleChoice(EFamilyIllHistory.class, this.view.getFamilyillhistoryRBN().getSelectedOptionNames()));
		data.setAccidentHistory(multipleChoice(EAccidentHistory.class, this.view.getAccidentHistoryRBN().getSelectedOptionNames()));
		
		// limit 
		String email = this.view.getEmailTTA().getContent();
		if (email.contains("@") && email.contains(".")) {data.setEmail(email);
		} else {JOptionPane.showMessageDialog(this.view, "이메일 형식이 옳지않습니다. @와 .을 포함하였는지 다시 확인해주십시오.");return false;}
		
		String socialSecu = this.view.getSocialSecurityNumTTA().getContent();
		if (socialSecu.contains("-") && socialSecu.length() == 14) {data.setSocialSecurityNum(socialSecu);
		} else {JOptionPane.showMessageDialog(this.view, "주민번호 형식이 옳지않습니다. -를 포함하여 14자리인지 다시 확인해주십시오."); return false;}
		
		String account = this.view.getAccountNumTTA().getContent();
		if (account.contains("-") && account.length() > 12) {data.setAccountNum(account);
		} else {JOptionPane.showMessageDialog(this.view, "계좌번호 형식이 옳지않습니다. 12자리 이상 -를 포함하였는지 확인해주십시오.");return false;}
		
		String phone = this.view.getPhoneNumTTA().getContent();
		if (phone.contains("-") && phone.length() == 13) {data.setPhoneNum(phone);
		} else {JOptionPane.showMessageDialog(this.view, "전화번호 형식이 옳지않습니다. -를 포함하여 13자리인지 확인해주십시오.");return false;}
		
		int age = Integer.parseInt(this.view.getAgeTTA().getContent());
		if (age < 120 && age >= 0) {data.setAge(age);} else {JOptionPane.showMessageDialog(this.view, "나이 값이 범위를 초과하였거나 문자가 섞여있습니다. 내용을 다시한번 확인해주십시오.");return false;
		}
		
		if (this.view.getGenderRBN().getSelectedOptionNames().size() != 0) {
			data.setGender(cleaningGender(EGender.valueOf(this.view.getGenderRBN().getSelectedOptionNames().get(0))));
		} else {
			JOptionPane.showMessageDialog(this.view, "성별이 선택되지 않았습니다. 다시한번 확인해주십시오.");return false;
		}	
		
		this.customerDataList.add(data);
		return true;
	}
	
	// gender 변경 EGender --> boolean
	public boolean cleaningGender(EGender eGender) {if(EGender.male.equals(eGender)) {return true;}return false;}
	
	// vector<String> --> Vector<E>
	private <E> Vector<E> multipleChoice(Class<E> enumClass, Vector<String> selectedOptionNames) {
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
