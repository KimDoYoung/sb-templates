package kr.co.kalpa.sbtemplates;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Configuration
public class SystemPropertyConfig {
//	@Value("${base.url}")
//	private String baseUrl;

	@Bean(name = "systemConfigProps")
	public PropertiesFactoryBean mapper() throws IOException {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("system.properties"));
	    bean.setFileEncoding("UTF-8");
	    bean.afterPropertiesSet();

	    Properties props = bean.getObject();
	    Enumeration names = props.propertyNames();

	    while (names.hasMoreElements()) {
	        String name = names.nextElement().toString();
	        String value = props.getProperty(name);
	        props.setProperty(name, value);
	    }

	    bean.setLocalOverride(true);
	    bean.setProperties(props);
	    bean.afterPropertiesSet();

	    return bean;
	}
}
