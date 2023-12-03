package kr.co.kalpa.sbtemplates.formatter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FormatterConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
    	 registry.addFormatterForFieldAnnotation(new YmdAnnotationFormatterFactory()); 
    }
}
