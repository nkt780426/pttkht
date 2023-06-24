package com.vietcombank.training.entity.ProfileSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ClassSubSystem.ClassProfile;
import com.vietcombank.training.entity.UserSubSystem.Student;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
//hoc ba, moi hoc sinh tham gia truong co 1 hoc ba luu tru toan bo thong tin tham gia cac khoa hoc
//tra cuu khoa hoc da tham gia tai day
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//thong tin hoc sinh
	@OneToOne
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;
	
	//cac tờ hoc ba, mỗi tờ chứa diem, nhan xet,... cua 1 lop học đã/đang tham gia tham gia
	//tạo thời khóa biểu lớp học đã/đang tham gia tham gia tại đây (dựa vào CourseStatus của khóa học)
	@OneToMany(mappedBy = "schoolReport")
	private Set<ClassProfile> profiles;
	
}
