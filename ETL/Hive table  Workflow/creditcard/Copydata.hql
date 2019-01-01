SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;
insert into creditcard 
partition (TRANSACTION_TYPE)
select TRANSACTION_ID ,TIMEID,CUST_CC_NO ,CUST_SSN,BRANCH_CODE,TRANSACTION_VALUE,TRANSACTION_TYPE
from temp_creditcard





