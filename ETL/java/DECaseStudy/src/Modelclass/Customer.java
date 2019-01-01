package Modelclass;

import java.sql.Timestamp;

public class Customer {
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getMIDDLE_NAME() {
		return MIDDLE_NAME;
	}
	public void setMIDDLE_NAME(String mIDDLE_NAME) {
		MIDDLE_NAME = mIDDLE_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public String getCREDIT_CARD_NUMBER() {
		return CREDIT_CARD_NUMBER;
	}
	public void setCREDIT_CARD_NUMBER(String cREDIT_CARD_NUMBER) {
		CREDIT_CARD_NUMBER = cREDIT_CARD_NUMBER;
	}
	public String getAPT_NO() {
		return APT_NO;
	}
	public void setAPT_NO(String aPT_NO) {
		APT_NO = aPT_NO;
	}
	public String getSTREET_NAME() {
		return STREET_NAME;
	}
	public void setSTREET_NAME(String sTREET_NAME) {
		STREET_NAME = sTREET_NAME;
	}
	public String getCUST_CITY() {
		return CUST_CITY;
	}
	public void setCUST_CITY(String cUST_CITY) {
		CUST_CITY = cUST_CITY;
	}
	public String getCUST_COUNTRY() {
		return CUST_COUNTRY;
	}
	public void setCUST_COUNTRY(String cUST_COUNTRY) {
		CUST_COUNTRY = cUST_COUNTRY;
	}
	public String getCUST_ZIP() {
		return CUST_ZIP;
	}
	public void setCUST_ZIP(String cUST_ZIP) {
		CUST_ZIP = cUST_ZIP;
	}
	public int getCUST_PHONE() {
		return CUST_PHONE;
	}
	public void setCUST_PHONE(int cUST_PHONE) {
		CUST_PHONE = cUST_PHONE;
	}
	public String getCUST_EMAIL() {
		return CUST_EMAIL;
	}
	public void setCUST_EMAIL(String cUST_EMAIL) {
		CUST_EMAIL = cUST_EMAIL;
	}
	public Timestamp getLAST_UPDATED() {
		return LAST_UPDATED;
	}
	public void setLAST_UPDATED(Timestamp lAST_UPDATED) {
		LAST_UPDATED = lAST_UPDATED;
	}
	private String FIRST_NAME;
	private String MIDDLE_NAME;
	private String LAST_NAME;
	private int SSN;
	private String CREDIT_CARD_NUMBER;
	private String APT_NO;
	private String STREET_NAME;
	private String CUST_CITY;
	private String CUST_COUNTRY;
	private String CUST_ZIP;
	private int CUST_PHONE;
	private String CUST_EMAIL;
	private Timestamp LAST_UPDATED;
	

}
