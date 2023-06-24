package com.vietcombank.training.entity.ClassSubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ActivitySubSystem.Diary;
import com.vietcombank.training.entity.ProfileSubSystem.SchoolReport;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
//là 1 tờ học bạ của học sinh
public class ClassProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//tờ học bạ thuộc học bạ nào
	@ManyToOne
	@JoinColumn(name = "schooReportId")
	private SchoolReport schoolReport;
	
	//thông tin tờ học bạ
	//Thuộc lớp nào?
	@ManyToOne
	@JoinColumn(name = "classId", nullable = false)
	private Class class1;
	
	//các hoạt động đã tham gia và nhận xét của giáo viên mỗi hoạt động đó
	@OneToMany(mappedBy = "classProfile")
	private Set<Diary> diaries;
	
	@Column(name = "finalComment")
	private String finalComment;
}
