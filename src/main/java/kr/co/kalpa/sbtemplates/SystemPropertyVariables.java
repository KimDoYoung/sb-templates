package kr.co.kalpa.sbtemplates;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

//import jakarta.annotation.Resource;
import lombok.Data;

@Component
@Data
@Validated
public class SystemPropertyVariables {
	private String address;
}
