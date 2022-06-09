package stu.Spring0607_;

interface Calculator{
	int add(int n1,int n2);
	
}




public class MainClass {

	public static void main(String[] args) {

		Car s1=new Sonata();
		s1.run();
		Car s2=new Sonata();
		s2.run();
		
		Car tesla=new Car() {
			
			//이름이 없는 익명 클래스로 , 선언한 클래스에서만 존재한다
			// 선언한 클래스 파일에서는 중복 호출 가능
			@Override
			public void run() {
				System.out.println("테슬라가 슝슝 달립니다.");
			}
		};
		tesla.run();
			
		
		
		//진짜 딱 한번만 사용할 시 , 선언한 클래스파일에서도 중복 호출 불가능
		new Car() {
			
			@Override
			public void run() {
				System.out.println("포르쉐가 쌩쌩 달립니다.");
			}
		}.run();
		
		
		Car ferrari=()->{
			System.out.println("페라리가 씽씽 달립니다.");
		};
		
		ferrari.run();
		System.out.println("--------------------------------------------------");
		
		
		//계산기 인터페이스와 람다식  
		Calculator sharp=new Calculator() {
			
			@Override
			public int add(int n1, int n2) {
				System.out.println("샤프 계산기 덧셈");
				return n1+n2;
			}
		};
		
		
		System.out.println(sharp.add(10, 15));
		
		//인터페이스이 추상메서드가 한개일 때만 이렇게 익명으로 사용 가
		Calculator casio=(x,y)->{
			System.out.println("카시오 계산기 덧셈!");
			return x+y;
		};
		casio.add(100, 200);
		
		
		//만약 오버라이딩 하는 추상메서드에 작성할 코드가 한줄 이라면 
		//retun과 괄호가 생략이 가능합니다
		Calculator xiaomi=(x,y) ->x+y;
		System.out.println(xiaomi.add(30, 50));
	}

}








