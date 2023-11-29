package kr.co.kalpa.sbtemplates;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

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
