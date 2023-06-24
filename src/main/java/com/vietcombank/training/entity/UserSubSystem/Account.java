package com.vietcombank.training.entity.UserSubSystem;

import com.vietcombank.training.entity.KDL.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
// do ô bảo t nhúng account vào user nên thực tế account ko phải là 1 entity, tuy nhiên code nên tách ra cho rõ
@Embeddable //các thuộc tính này sẽ nhúng vào 1 entity nào đó và nó ko phải là table trong db
public class Account {
	@Column(unique = true)
	private String username;
	private String password;
	
	@Transient // Không lưu role vào db, khi lấy thông tin từ db, app sẽ dựa vào thông tin lấy được mà quyết định role, đọc get Role
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public Role getRole() {
		//nếu entity user là giáo viên thì set giáo viên, học sinh thì set học sinh
		//ko có setRole()
		return null;
	}
}
