package com.example.demo.model;

import lombok.Data;

@Data//lombok에서 그냥 setter getter를 싹 다 잡아준다!(킹갓 롬복)
public class User {
	private String id;
	private String userId;
	private String userName;
}
