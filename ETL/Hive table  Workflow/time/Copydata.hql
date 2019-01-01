SET hive.exec.dynamic.partition = true;
SET hive.exec.dynamic.partition.mode = nonstrict;
insert overwrite table time 
partition (quarter)
select TRANSACTION_ID,TIMEID,DAY ,MONTH ,YEAR,QUARTER from temp_time




