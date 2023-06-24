package com.vietcombank.training.entity.ClassSubSystem;

import com.vietcombank.training.entity.KDL.DayOfWeek;
import com.vietcombank.training.entity.KDL.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class TimeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;
	
	@Enumerated(EnumType.STRING)
	private Period period;
	
	//1 timetable chi co 1 lop hoc
	//kiem tra trung lich hoc, lap thoi kho bieu dua vao thuoc tinh nay vs ClassProfile
	@ManyToOne
	@JoinColumn(name = "classId")
	private Class class1;
}
