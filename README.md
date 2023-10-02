| SQL                                                                                                   |            Oracle            |      MySQL      |     MSSQL      |
|:------------------------------------------------------------------------------------------------------|:----------------------------:|:---------------:|:--------------:|
| SELECT KEY, VALUE from PROPERTIES where APPLICATION=? and PROFILE=? and LABEL=?                       |         	Compatible          |  	Incompatible  | 	Incompatible  |
| SELECT `KEY`, `VALUE` from PROPERTIES where APPLICATION=? and PROFILE=? and LABEL=?                   |        	Incompatible         |   	Compatible   | 	Incompatible  |
| SELECT PROPERTIES.KEY, PROPERTIES.VALUE from PROPERTIES where APPLICATION=? and PROFILE=? and LABEL=? |         	Compatible          |   	Compatible   | 	Incompatible  |
| SELECT [KEY], [VALUE] from PROPERTIES where APPLICATION=? and PROFILE=? and LABEL=?                   |        	Incompatible         |  	Incompatible  |  	Compatible   |



### application.yml spring.cloud.config.server.jdbc.sql Grammar
https://github.com/spring-cloud/spring-cloud-config/issues/1420#issue-465132749

### Sample Database `PROPERTIES` Table Create Query
```sql
CREATE TABLE `PROPERTIES` (
    `APPLICATION` VARCHAR(50) NOT NULL DEFAULT 'application',
    `PROFILE` VARCHAR(50) NOT NULL DEFAULT 'default',
    `LABEL` VARCHAR(50) NOT NULL DEFAULT 'master',
    `KEY` VARCHAR(256) NOT NULL,
    `VALUE` VARCHAR(1024) NOT NULL,
    INDEX `UIX_PROPERTIES` (`APPLICATION`, `PROFILE`, `LABEL`, `KEY`) USING BTREE
);
```