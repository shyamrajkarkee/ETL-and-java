SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;
INSERT OVERWRITE TABLE customer
PARTITION (CUST_STATE, CUST_ZIP)
SELECT  CUST_F_NAME ,CUST_M_NAME ,CUST_L_NAME ,CUST_SSN,CUST_CC_NO, CUST_STREET, CUST_CITY , 
CUST_COUNTRY,  CUST_PHONE, CUST_EMAIL, LAST_UPDATED, CUST_STATE, CUST_ZIP
FROM temp_customer;



