package stu.Spring0613_;


import java.sql.Time;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
  CREATE TABLE mvc_user(
    account VARCHAR2(50) PRIMARY KEY,
    password VARCHAR2(100) NOT NULL,
    name VARCHAR2(50) NOT NULL,
    reg_date DATE DEFAULT sysdate
);
*/
@Getter
@Setter
@ToString
public class UserVO {
	private String account;
	private String password;
	private String name;
	private Timestamp regDate;
	
}
