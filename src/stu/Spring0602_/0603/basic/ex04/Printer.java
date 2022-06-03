package stu.Spring0602_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {

	/*
	  # @Autowired
	  -객체를 자동 주입할 때 사용하는 아노테이션입니다.
	  -스캔 명령(< context ...>) 을 통해 객체를 찾아 주입하는데 , 타입 이름(변수명이 아니라 Paper 이런 타입 -xml파일에서 class=" " - 클래스로 검색 )으로 검색합니다.
	  -타입을 찾아내지 못하면 이름( id 속성값)을 통해 검색합니다.
	  -생성자 , 메서드 ,필드(변수)에 적용 가능 
	  */
	
	/*@Qualifier("bean id 기입 ")
	-Autowired를 사용 할 때 동일 타입의 빈이 여러개 있는 경우 ,
	 어떤 빈을 주입해야 하는지 선택해 주는 추가 아노테이션   (단독적으로 사용하지 않고 , autowired와 함께 사용됨)
	
	*/
	
	
	@Autowired
	@Qualifier("paper2")     //@Qualifier ()  :자동 주입을 하는데 , xml에  class="paper"타입이 여러개면 ,하나를 지목 
	private Paper paper;
	
	
	//@Autowired 붙이면 , 변수 타입(메서드의 매개변수도 동일)을 확인하여 xml파일에 등록되어 있는지 확인한 뒤,  자동으로 Autowired써있는곳에 연결 
	//xml 접근해서 , <bean class="Paper"> 인것 검색 :
	
	 //생성자
	/*
	 * @Autowired public Printer(Paper paper) { this.paper=paper; }
	 */
	
	
	
	//set메서드 
	/*
	 * @Autowired public void setPaper(Paper paper) { this.paper = paper; }
	 */	
	
	
	public void showPaperInfo() {
		for(String info:paper.data) {
			System.out.println(info);
		}
	}
	
	
}
