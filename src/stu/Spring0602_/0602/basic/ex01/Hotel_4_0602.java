package stu.Spring0602_;

public class Hotel_4_0602 {

	private Restaurant_5_0602 res;
	
	
	
	public Hotel_4_0602(Restaurant_5_0602 res) {
		System.out.println("호텔이 생성됨!");
		this.res=res;
		
	}
	
	public void reserveRestaurant() {
		System.out.println("레스토랑을 예약합니다.");
		res.orderDinner();
	}
}
