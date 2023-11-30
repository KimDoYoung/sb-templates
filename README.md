# sbtemplates - system-variables

## 내용

- application.properties에 있는 것을 class로 받을 수 있다.
- 값에 한글이 있는 경우 잘 안된다.
- PropertiesFactoryBean을 만들어서 encoding을 바꾸어서 한글을 제대로 받아들일 수 있는데,
- 이것을 클래스로 로딩하는 것은 안되고(방법을 모르고)
- 값을 받아들이거나
- Property로 받아서 사용 할 수 있다.


## 코드들

* application.properties에서 문자,정수,배열,객체 등으로 받아서 쓸 수 있다.
```
@ConfigurationProperties(prefix = "kr.co.kalpa.sbtemplates")
@Component
@Data
@Validated
@PropertySource(value = "classpath:application.properties", encoding = "UTF-8")
public class SystemConfigVariables {

	private Integer NumVariable;
	private String  StrVariable;
	
	private String[] emails;
	private Map<String, Object> map;
	
	private User user;
}

* PropertiesFactoryBean 을 만들고 a.properties를 만들고 UTF-8로 읽어들인다. 

```java	
	
	@Resource(name = "systemConfigProps")
	private Properties prop;
	@Value("#{systemConfigProps['address']})")
	private String address;	
	
	@Resource(name = "systemConfigProps")
	private Properties prop;

```
