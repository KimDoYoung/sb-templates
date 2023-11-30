# sbtemplates

## 목적
log 구성

* profile에 따라서 다르게 설정
* local에서는 많은 로그를, 운영에서는 적은 로그를
* sql를 로그로 보게끔

## 방법

1. build.gradle

```
	// log4j2
	implementation group: 'org.bgee.log4jdbc-log4j2', name: 'log4jdbc-log4j2-jdbc4.1', version: '1.16'
```

2. resource밑에 logback-spring.xml을 작성

```
<?xml version="1.0" encoding="UTF-8"?>
<configuration scan="true" scanPeriod="60 seconds">
    <include resource="org/springframework/boot/logging/logback/defaults.xml"/>
    <include resource="org/springframework/boot/logging/logback/console-appender.xml" />
    <include resource="org/springframework/boot/logging/logback/file-appender.xml"/>

    <springProfile name="local">
        <root level="INFO">
            <appender-ref ref="CONSOLE" />
            <appender-ref ref="FILE" />
        </root>
    </springProfile>

    <springProfile name="default">
        <root level="WARN">
            <appender-ref ref="FILE" />
        </root>
    </springProfile>

</configuration>
```
3.application.properites에 세분화된 정보를 기술

```
# Logging
logging.file.name=C:/Users/deHong/Documents/kdy/logs/Sb-Templates.log
logging.logback.rollingpolicy.max-history=365
logging.logback.rollingpolicy.max-file-size=10MB
logging.logback.rollingpolicy.total-size-cap=5GB


# Logging
#logging.file.name=C:/Users/KOREA/Documents/log/julia.log
#logging.logback.rollingpolicy.max-history=365
#logging.logback.rollingpolicy.max-file-size=10MB
#logging.logback.rollingpolicy.total-size-cap=5GB
#logging.level.jdbc=off
#logging.level.jdbc.sqlonly=off
#logging.level.jdbc.sqltiming=info
#logging.level.jdbc.resultsettable=info
#logging.level.jdbc.audit=off
#logging.level.jdbc.resultset=off
#logging.level.jdbc.connection=off
#
#logging.level.org.springframework.web=INFO
#logging.level.com.freshandbetter.edi.julia=DEBUG 
```

