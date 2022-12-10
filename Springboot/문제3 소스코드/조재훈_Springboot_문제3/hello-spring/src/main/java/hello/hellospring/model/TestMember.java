package hello.hellospring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class TestMember {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, name = "name")
	private String username;
	private String password;
	private String email;
	private String memo;
	@Column(name = "address")
	private String addr;
	private String role;
	
	
}
