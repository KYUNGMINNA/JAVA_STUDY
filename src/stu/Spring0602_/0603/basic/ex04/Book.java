package stu.Spring0602_;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Book {

	/*
	 #@Resource
	 -빈을 자동으로 주입하는 아노테이션.
	 -필드 , 메서드에만  적용이 가능하며 , 생성자에는 적용이 불가능.
	 -(name=" " ) 속성을 통해 특정 bean의 id를 지목할 수 있습니다. 
	 */
	
	
	
	
	//@Autowired
	//@Qualifier("paper1")
	
	@Resource(name="paper1")  //스프링이 아니고 ,자바에서 제공하는 아노테이션  -자바8까지만 지원 
	private Paper paper;
	
	public void setPaper(Paper paper) {
		this.paper = paper;
	}
	public Paper getPaper() {
		return paper;
	}
}
