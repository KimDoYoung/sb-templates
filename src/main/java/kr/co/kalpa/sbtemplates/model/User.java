package kr.co.kalpa.sbtemplates.model;

import kr.co.kalpa.sbtemplates.formatter.YmdFormat;
import lombok.Data;

@Data
public class User {

	private String id;
	private String name;
	private Integer age;
	private Address address;

	@YmdFormat("-")
	private String birth;
}
