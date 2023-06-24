package com.vietcombank.training.entity.KDL;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.Data;

@Embeddable
@Data
public class Avartar {
	@Lob// khi luu xuong db, anh sẽ là 1 file nhị phân,k nếu muốn xử lý ảnh sẽ phải tạo 1 class thuộc package riêng để xử lý
	//trong biểu đồ class của ô tên class File là 1 KDL của java cũng như nhiều ngôn ngữ lập trình khác nên t thay bằng avatar
	private byte[] avatar;
	
	//các hàm xử lý trong class File sẽ được đặt tại đây
}
