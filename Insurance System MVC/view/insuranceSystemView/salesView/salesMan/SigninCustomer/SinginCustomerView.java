package view.insuranceSystemView.salesView.salesMan.SigninCustomer;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.aConstant.EAccidentHistory;
import model.aConstant.EFamilyIllHistory;
import model.aConstant.EGender;
import view.aConstant.InsuranceSystemViewConstant;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.ActionButton;
import view.component.button.LinkButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.absInsuranceSystemView.InsuranceSystemView;

public class SinginCustomerView extends InsuranceSystemView{
	private static final long serialVersionUID = 1L;

	// Static
	public enum EActionCommands {Save, SigninCustomer,LookupAvailableProduct,WatchActivityPlan, WatchSalesTrainingPlan}
		
	// Component
	private InputTextArea nameTTA, residenceTTA,phoneNumTTA,emailTTA,socialSecurityNumTTA,jobTTA,propertyTTA,ageTTA,accountNumTTA,loginIDTTA,loginPWTTA;
	private TitledRadioButtonGroup familyillhistoryRBN,genderRBN,accidentHistoryRBN;
	
	// Constructor
	public SinginCustomerView(ActionListener actionListener) {
		//create component
		this.nameTTA = new InputTextArea("이름", "정상현", 1, 100);
		this.residenceTTA = new InputTextArea("거주지", "서대문구 65-2", 1, 100);
		this.phoneNumTTA = new InputTextArea("전화번호", "010-3333-4664", 1, 100);
		this.emailTTA = new InputTextArea("이메일", "cosla@gmail.com", 1, 100);
		this.familyillhistoryRBN = new TitledRadioButtonGroup("가족력", EFamilyIllHistory.class, true,100);
		this.socialSecurityNumTTA = new InputTextArea("주민번호", "900922-1248150", 1, 100);
		this.genderRBN = new TitledRadioButtonGroup("성별", EGender.class, false,100);
		this.jobTTA = new InputTextArea("직업", "학생", 1, 100);
		this.propertyTTA = new InputTextArea("재산", "10000000", 1, 100);
		this.accidentHistoryRBN = new TitledRadioButtonGroup("사고 이력", EAccidentHistory.class, true,100);
		this.ageTTA = new InputTextArea("나이", "30", 1, 100);
		this.accountNumTTA = new InputTextArea("계좌번호", "123-456-789012", 1, 100);
		this.loginIDTTA = new InputTextArea("아이디", "asd", 1, 100);
		this.loginPWTTA = new InputTextArea("비밀번호", "123", 1, 100);

		//add component
		this.addComponent(new BasicLabel("고객 정보 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup g =  new StaticGroup(new int[] {2,2,1,1,2,1,1,2,2});
		g.addGroupComponent(
				this.nameTTA,this.socialSecurityNumTTA,
				this.ageTTA,this.jobTTA,
				this.genderRBN,
				this.residenceTTA,
				this.phoneNumTTA,this.emailTTA, 
				this.familyillhistoryRBN,
				this.accidentHistoryRBN,
				this.propertyTTA,this.accountNumTTA,
				this.loginIDTTA,this.loginPWTTA
				);
		this.addComponent(g);
		
		this.addComponent(new ActionButton("저장", EActionCommands.Save.name(), actionListener));

		this.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", null),
	            new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", null),
				new LinkButton("고객 가입", EActionCommands.SigninCustomer.name(), actionListener),
				new LinkButton("가능 보험 조회", EActionCommands.LookupAvailableProduct.name(), actionListener),
				new LinkButton("판매 활동 조회", EActionCommands.WatchActivityPlan.name(), actionListener),
				new LinkButton("영업 활동 조회", EActionCommands.WatchSalesTrainingPlan.name(), actionListener)
		);
	}

	//get & set
	public InputTextArea getNameTTA() {return this.nameTTA;}
	public void setNameTTA(InputTextArea nameTTA) {	this.nameTTA = nameTTA;}
	public InputTextArea getResidenceTTA() {return this.residenceTTA;}
	public void setResidenceTTA(InputTextArea residenceTTA) {this.residenceTTA = residenceTTA;}
	public InputTextArea getPhoneNumTTA() {return this.phoneNumTTA;}
	public void setPhoneNumTTA(InputTextArea phoneNumTTA) {this.phoneNumTTA = phoneNumTTA;}
	public InputTextArea getEmailTTA() {return this.emailTTA;}
	public void setEmailTTA(InputTextArea emailTTA) {this.emailTTA = emailTTA;}
	public InputTextArea getSocialSecurityNumTTA() {return this.socialSecurityNumTTA;}
	public void setSocialSecurityNumTTA(InputTextArea socialSecurityNumTTA) {this.socialSecurityNumTTA = socialSecurityNumTTA;}
	public InputTextArea getJobTTA() {return this.jobTTA;}
	public void setJobTTA(InputTextArea jobTTA) {this.jobTTA = jobTTA;}
	public InputTextArea getPropertyTTA() {return this.propertyTTA;}
	public void setPropertyTTA(InputTextArea propertyTTA) {this.propertyTTA = propertyTTA;}
	public InputTextArea getAgeTTA() {return this.ageTTA;}
	public void setAgeTTA(InputTextArea ageTTA) {this.ageTTA = ageTTA;}
	public InputTextArea getAccountNumTTA() {return this.accountNumTTA;}
	public void setAccountNumTTA(InputTextArea accountNumTTA) {this.accountNumTTA = accountNumTTA;}
	public InputTextArea getLoginIDTTA() {return this.loginIDTTA;}
	public void setLoginIDTTA(InputTextArea loginIDTTA) {this.loginIDTTA = loginIDTTA;}
	public InputTextArea getLoginPWTTA() {return this.loginPWTTA;}
	public void setLoginPWTTA(InputTextArea loginPWTTA) {this.loginPWTTA = loginPWTTA;}
	public TitledRadioButtonGroup getFamilyillhistoryRBN() {return this.familyillhistoryRBN;}
	public void setFamilyillhistoryRBN(TitledRadioButtonGroup familyillhistoryRBN) {this.familyillhistoryRBN = familyillhistoryRBN;}
	public TitledRadioButtonGroup getGenderRBN() {return this.genderRBN;}
	public void setGenderRBN(TitledRadioButtonGroup genderRBN) {this.genderRBN = genderRBN;	}
	public TitledRadioButtonGroup getAccidentHistoryRBN() {return this.accidentHistoryRBN;}
	public void setAccidentHistoryRBN(TitledRadioButtonGroup accidentHistoryRBN) {this.accidentHistoryRBN = accidentHistoryRBN;}
}
