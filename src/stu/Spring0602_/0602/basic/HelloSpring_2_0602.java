package stu.Spring0602_;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring_2_0602 {

	public static void main(String[] args) {

		//평소에 쓰던 객체 사용 방식( 필요하면 생성해서 ,함수 사용하는 방식)
		//SpringTest_1_0602 st=new SpringTest_1_0602();
		//st.hello();

		
		
		//xml 설정 읽어오기    ::IOC 
		GenericXmlApplicationContext  ct=new GenericXmlApplicationContext("classpath:test-config_3_0602.xml");		
									// test : xml에 등록된 빈 객체의 id  , 리턴 타입.class  
		SpringTest_1_0602 st=ct.getBean("test",SpringTest_1_0602.class);
		st.hello();
		
		ct.close();
		




	}

}
