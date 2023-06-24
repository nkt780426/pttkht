package com.vietcombank.training.entity.ActivitySubSystem;

import com.vietcombank.training.entity.ClassSubSystem.ClassProfile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
//kieu du lieu moi de chua activity va nhan xet cua giao vien cho moi hoc sinh
//mỗi học sinh khi tham gia hoạt động sẽ có 1 nhật ký và giáo viên nhận xét vào nhật ký này
//tờ học bạ của học sinh tham gia lớp học có activity này sẽ chứa finalComment và đống nhật ký này
//la 1 entity =>co the truy xuat
public class Diary {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	//diary của activity nào?
	@ManyToOne
	@JoinColumn(name = "activityId", nullable = false)
	private Activity activity;
	
	//nhận xét của giáo viên về học sinh sau khi hoàn thành activity có thể null
	@Column(name = "teacherComment")
	private String teacherComment;
	
	//diary này thuộc tờ học bạ nào
	@ManyToOne
	@JoinColumn(name = "classProfileId")
	private ClassProfile classProfile;
}
