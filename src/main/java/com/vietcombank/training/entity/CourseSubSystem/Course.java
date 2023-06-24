package com.vietcombank.training.entity.CourseSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ClassSubSystem.Class;
import com.vietcombank.training.entity.KDL.CourseStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	//khóa học thuộc môn học nào ?
	@ManyToOne
	@JoinColumn(name = "subjectId", nullable = false)
	private Subject subject;

	//1 khoa hoc thuoc 1 ky hoc
	@ManyToOne
	@JoinColumn(name="semesterId", nullable = false)
	private Semester semester;

	@Enumerated(EnumType.STRING)
	private CourseStatus status;
	
	//Các lớp học thuộc khóa học
	@OneToMany(mappedBy = "course")
	private Set<Class> classes;
	
	//các đơn đăng ký khóa học của học sinh
	@OneToMany(mappedBy = "course")
	private Set<StudentRegisterCourse> registerCourses;
}
