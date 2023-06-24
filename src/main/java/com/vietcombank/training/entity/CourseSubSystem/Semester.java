package com.vietcombank.training.entity.CourseSubSystem;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table
public class Semester {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(unique = true)
	private String name;

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate")
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "endDate")
	private Date endDate;
	
	//tra cứu tất cả khóa học thuộc kỳ này nhờ vào thuộc tính này
	@OneToMany(mappedBy = "semester")
	private Set<Course> course;
}
