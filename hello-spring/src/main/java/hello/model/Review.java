package hello.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_hotel_review")
public class Review {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String comment;
	private Date ratingDate;
	@JoinColumn(name = "hotel_id")
	@ManyToOne // foreign key
	private Hotel hotel;
}
