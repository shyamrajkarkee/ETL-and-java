SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;
insert overwrite table branch 
partition (BRANCH_ZIP)
select BRANCH_CODE, BRANCH_NAME ,BRANCH_STREET,BRANCH_CITY,BRANCH_STATE,
BRANCH_PHONE ,LAST_UPDATED ,BRANCH_ZIP from temp_branch




