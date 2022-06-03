package stu.Spring0602_;

import org.springframework.beans.factory.annotation.Autowired;

public class Computer {

	//@Autowired
	private stu.Spring0602_.Keyboard keyboard;
	//@Autowired
	private stu.Spring0602_.Mouse mouse;
	//@Autowired
	private Monitor monitor;
	
	//둘다  의존성 주입 가능 
	
	@Autowired
	public Computer(stu.Spring0602_.Keyboard keyboard, stu.Spring0602_.Mouse mouse, Monitor monitor) {
		super();
		this.keyboard = keyboard;
		this.mouse = mouse;
		this.monitor = monitor;
	}



	public void computerInfo() {
		System.out.println("**** 컴퓨터의 정보 ****");
		keyboard.info();
		mouse.info();
		monitor.info();
	}
	
	
	
}
