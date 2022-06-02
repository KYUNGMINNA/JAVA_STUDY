package stu.Spring0602_;

public class Restaurant_5_0602 {

	
	private Chef_6_0602 chef;
	
	public Restaurant_5_0602() {
		System.out.println("레스토랑이 생성됨!");
	}
	
	
	public void setChef(Chef_6_0602 chef) {
		this.chef = chef;
	}



	public void orderDinner() {
		System.out.println("저녁 식사를 주문받습니다.");
		chef.cook();
	}
	
	
	
	
}
