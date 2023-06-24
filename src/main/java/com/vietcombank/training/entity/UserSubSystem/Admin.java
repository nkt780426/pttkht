package com.vietcombank.training.entity.UserSubSystem;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin extends User{
	//có thể chứa các quyền của 1 admin, mỗi admin có 1 quyền khác nhau,...
	//profile của quản trị viên, trong profile đó chứa cái j t ko bt nên ko code
}
