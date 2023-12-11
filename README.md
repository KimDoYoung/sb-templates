# sb-templates

## 
-JDK 17로 설정
-mustache를 view로 설정
-spring security를 포함함.

## build.gradle
```
// spring-boot-starter-mustache
implementation group: 'org.springframework.boot', name: 'spring-boot-starter-mustache', version: '3.2.0'
	
// spring-boot-starter-security
implementation group: 'org.springframework.boot', name: 'spring-boot-starter-security', version: '3.2.0'

implementation 'org.springframework.boot:spring-boot-starter-mustache'	
```	

## application.properties

```
# security
spring.security.user.name=admin
spring.security.user.password=1111

spring.mustache.suffix:.html

spring.mustache.prefix=classpath:/templates/
spring.mustache.suffix=.mustache
```