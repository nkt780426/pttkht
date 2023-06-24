package com.vietcombank.training.entity.UserSubSystem;

import com.vietcombank.training.entity.ProfileSubSystem.TeacherProfile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Teacher extends User{
	//1 giáo viên có 1 học bạ, 1 học bạ chỉ chứa 1 giáo viên
	//xem những j giáo viên đã dạy trong trường tại đây
	@OneToOne(mappedBy = "teacher")
	private TeacherProfile profile;
}
