package stu.Spring0602_;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		
		
																		// src/main/resources 파일 한번에 읽기
		GenericXmlApplicationContext ct=new GenericXmlApplicationContext("classpath:db-config.xml");
		
		
		stu.Spring0602_.MemberDAO dao=ct.getBean("dao", stu.Spring0602_.MemberDAO.class);
		dao.showDBInfo();
		ct.close();
		
		
		
		
	}

}
