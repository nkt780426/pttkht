package com.vietcombank.training.entity.ProfileSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ClassSubSystem.Class;
import com.vietcombank.training.entity.CourseSubSystem.Subject;
import com.vietcombank.training.entity.UserSubSystem.Teacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
//1 giao vien co 1 hoc ba khi tham gia truong
public class TeacherProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//chua thong tin giao vien
	@OneToOne
	@JoinColumn(name = "teacherId", referencedColumnName = "id")
	private Teacher teacher;
	
	//chua chuyen mon giao vien
	@ManyToMany
	@JoinTable(name = "specialize", 
		joinColumns = 
			@JoinColumn(name="teacherProfileId"),
		inverseJoinColumns = @JoinColumn(name="subjectId"))
	private Set<Subject> specialize;
	
	//chua thong tin cac lop hoc da/dang giang day
	@OneToMany(mappedBy = "teacherProfile")
	private Set<Class> classes;
}
