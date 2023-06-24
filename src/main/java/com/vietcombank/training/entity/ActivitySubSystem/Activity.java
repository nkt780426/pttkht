package com.vietcombank.training.entity.ActivitySubSystem;

import java.util.Set;

import com.vietcombank.training.entity.ClassSubSystem.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Table
@Entity
public class Activity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String description;
	
	//hoat dong nay thuoc lop nao?
	@ManyToOne
	@JoinColumn(name="classId", nullable = false)
	private Class class1;
	
	//các diary chứa hoạt động này
	@OneToMany(mappedBy = "activity")
	private Set<Diary> diaries;
}
