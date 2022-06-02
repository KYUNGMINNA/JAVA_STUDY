package stu.Spring0602_;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass_7_0602 {

	public static void main(String[] args) {

		
		//기존의 자바 방식
		/*
		 * Chef_6_0602 chef=new Chef_6_0602(); Restaurant_5_0602 res=new
		 * Restaurant_5_0602();
		 * 
		 * res.setChef(chef);
		 * 
		 * Hotel_4_0602 hotel=new Hotel_4_0602(res);
		 * 
		 * hotel.reserveRestaurant();
		 */
		
		
		//객체 안에 객체를 넣어 있는 의존성 주입 상태이기 때문에 , 가장 큰 객체인 Hotel객체만 호출하면 , 내부 객체들도  바로 사용이 가능 .
		GenericXmlApplicationContext ct=new GenericXmlApplicationContext("classpath:test-config_3_0602.xml");
		Hotel_4_0602 hotel=ct.getBean("hotel",Hotel_4_0602.class); // ( 이름 , 타입)
		hotel.reserveRestaurant();
		
		
		
		ct.close();
		
		
		
		
		
	}

}
