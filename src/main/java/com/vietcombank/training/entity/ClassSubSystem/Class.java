package com.vietcombank.training.entity.ClassSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ActivitySubSystem.Activity;
import com.vietcombank.training.entity.CourseSubSystem.Course;
import com.vietcombank.training.entity.ProfileSubSystem.TeacherProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//thuoc khoa hoc nao ?
	@ManyToOne
	@JoinColumn(name = "courseId")
	private Course course;
	
	//học bạ giáo viên
	@OneToOne
	@JoinColumn(name = "teacherProfileId", referencedColumnName = "id")
	private TeacherProfile teacherProfile;
	
	//học bạ học sinh
	@OneToMany(mappedBy = "class1")
	private Set<ClassProfile> profiles;
	
	//các hoạt động thuộc lớp học
	@OneToMany(mappedBy = "class1")
	private Set<Activity> activities;
	
	//lớp học thuộc phòng nào
	@ManyToOne
	@JoinColumn(name = "room", nullable = false)
	private Room room;
}
