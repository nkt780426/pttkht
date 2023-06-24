package com.vietcombank.training.entity.CourseSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ProfileSubSystem.TeacherProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	//1 mon hoc co the co nhieu khoa hoc, 1 khoa học có thể có nhiều môn học, tra cứu các khóa học thuộc môn học tại đây
	@ManyToMany(mappedBy = "subject")
	private Set<Course> courses;
	
	//1 môn học có thể có nhiều giáo viên dạy đc, 1 giáo viên có thể có nhiều chuyên môn
	//tra cứu các giáo viên có thể dạy được môn học này tại đây
	@ManyToMany(mappedBy = "specialize") 
	private Set<TeacherProfile> profiles;
}
