package com.vietcombank.training.entity.UserSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.CourseSubSystem.StudentRegisterCourse;
import com.vietcombank.training.entity.ProfileSubSystem.StudentProfile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Student extends User {
	
	//1 học sinh có thể đăng ký nhiều khóa học, xem danh sách các khóa học đã đăng ký nhưng chưa phân lớp tại đây
	@OneToMany(mappedBy = "student")
	@Column(name = "registerClasses")
	private Set<StudentRegisterCourse> registerClasses;

	//1 học sinh có 1 học bạ, 1 học bạ chỉ chứa 1 học sinh
	//xem những j học sinh đã học ở trường này bằng cách xem học bạ của học tại đây
	@OneToOne(mappedBy = "student")
	private StudentProfile schoolReport;
}
