package hello.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tbl_hotel")
public class Hotel {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;
	private String name;
	@Enumerated(EnumType.STRING)
	private Grade grade;
	@Embedded
	private Address address;
	@OneToMany(mappedBy="hotel")
	private List<Review> reviews;
}
