package com.vietcombank.training.entity.CourseSubSystem;

import com.vietcombank.training.entity.UserSubSystem.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="StudentRegisterClass")
//đơn đăng ký tham gia khóa học của học sinh, trong đơn gồm có
public class StudentRegisterCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//thông tin học sinh đăng ký
	@ManyToOne
	@JoinColumn(name = "studentId")
	private Student student;
	
	//khóa học học sinh đăng ký
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
}
