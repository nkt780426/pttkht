package com.vietcombank.training.entity.UserSubSystem;

import java.sql.Date;

import com.vietcombank.training.entity.KDL.Avartar;
import com.vietcombank.training.entity.KDL.Gender;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor

//chứa thông tin cá nhân của 1 user không liên quan j đến trường học
//các thông tin của user liên quan đến trường học sẽ đc tách riêng vào các học bạ (package ProfileSubSystem)
public abstract class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Embedded //tức là 3 thuộc tính của class account sẽ đc bên vào đây, như kết tập
	private Account account;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Enumerated(EnumType.STRING)
	private	Gender gender;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Transient//ko luu xuong db, dựa vào ngày sinh lay dc tu db ma tinh ra đọc hàm get
	private Integer age;
	
	@Column(name = "contactNumber")
	private String contactNumber;
	
	private String email;
	private String address;
	
	@Embedded
	private Avartar avartar;
		
	public Date getAge() {
		//xu ly: ngày hiện tại-ngày sinh và return về
		//ko có hàm setAge()
		return null;
	}
}
