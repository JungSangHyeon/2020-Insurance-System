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
				JOptionPane.showMessageDialog(this.view, "������ �Ϸ�Ǿ����ϴ�.", "���ԿϷ�", JOptionPane.INFORMATION_MESSAGE);
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
	
	// true�� ���� 
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
			JOptionPane.showMessageDialog(this.view, "����� ���ڷ� �Է��� �ֽʽÿ�.");return false;
		}
		data.setIllHistory(multipleChoice(EFamilyIllHistory.class, this.view.getFamilyillhistoryRBN().getSelectedOptionNames()));
		data.setAccidentHistory(multipleChoice(EAccidentHistory.class, this.view.getAccidentHistoryRBN().getSelectedOptionNames()));
		
		// limit 
		String email = this.view.getEmailTTA().getContent();
		if (email.contains("@") && email.contains(".")) {data.setEmail(email);
		} else {JOptionPane.showMessageDialog(this.view, "�̸��� ������ �����ʽ��ϴ�. @�� .�� �����Ͽ����� �ٽ� Ȯ�����ֽʽÿ�.");return false;}
		
		String socialSecu = this.view.getSocialSecurityNumTTA().getContent();
		if (socialSecu.contains("-") && socialSecu.length() == 14) {data.setSocialSecurityNum(socialSecu);
		} else {JOptionPane.showMessageDialog(this.view, "�ֹι�ȣ ������ �����ʽ��ϴ�. -�� �����Ͽ� 14�ڸ����� �ٽ� Ȯ�����ֽʽÿ�."); return false;}
		
		String account = this.view.getAccountNumTTA().getContent();
		if (account.contains("-") && account.length() > 12) {data.setAccountNum(account);
		} else {JOptionPane.showMessageDialog(this.view, "���¹�ȣ ������ �����ʽ��ϴ�. 12�ڸ� �̻� -�� �����Ͽ����� Ȯ�����ֽʽÿ�.");return false;}
		
		String phone = this.view.getPhoneNumTTA().getContent();
		if (phone.contains("-") && phone.length() == 13) {data.setPhoneNum(phone);
		} else {JOptionPane.showMessageDialog(this.view, "��ȭ��ȣ ������ �����ʽ��ϴ�. -�� �����Ͽ� 13�ڸ����� Ȯ�����ֽʽÿ�.");return false;}
		
		int age = Integer.parseInt(this.view.getAgeTTA().getContent());
		if (age < 120 && age >= 0) {data.setAge(age);} else {JOptionPane.showMessageDialog(this.view, "���� ���� ������ �ʰ��Ͽ��ų� ���ڰ� �����ֽ��ϴ�. ������ �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		}
		
		if (this.view.getGenderRBN().getSelectedOptionNames().size() != 0) {
			data.setGender(cleaningGender(EGender.valueOf(this.view.getGenderRBN().getSelectedOptionNames().get(0))));
		} else {
			JOptionPane.showMessageDialog(this.view, "������ ���õ��� �ʾҽ��ϴ�. �ٽ��ѹ� Ȯ�����ֽʽÿ�.");return false;
		}	
		
		this.customerDataList.add(data);
		return true;
	}
	
	// gender ���� EGender --> boolean
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
