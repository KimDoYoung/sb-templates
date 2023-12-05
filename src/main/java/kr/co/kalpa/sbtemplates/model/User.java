package kr.co.kalpa.sbtemplates.model;



import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

	@NotBlank(message="id는 비어 있을 수 없습니다")
	private String id;
	
	private String name;
	private Integer age;
	private Long asset;
	private Double score;
	private Address address;
}
