package stu.jsp0506_;

import java.util.ArrayList;
import java.util.List;

public class UserRepository_15_0511 {

	
	//회원의 정보를 담아놓을 리스트(DB대용)
	
	
	private static List<User_14_0511> userList=new ArrayList<>();
	
	//생성된 User 객채를 리스트에 추가하는 메서드
	public static void save(User_14_0511 user) {
		userList.add(user);
	}
	//회원 정보 저장 후 리스트 내부를 보여주는 메서드.
	   public static void showUsers() {
	      System.out.println("### 회원 정보 ###");

	      for(User_14_0511 user : userList) {
	         System.out.println("아이디: " + user.getAccount());
	         System.out.println("비밀번호: " + user.getPassword());
	         System.out.println("이름: " + user.getName());
	         System.out.println("별명: " + user.getNickName());
	         System.out.println("===============================");
	      }
	   }
	   
	   
//	   //매개값으로 id를 받아서 해당 id를 가진 객체가 userList에 있는지 탐색하는 메서드
	    public static User_14_0511 getUser(String id){
	    
	    	 for(User_14_0511 user : userList) {
	    		 if(user.getAccount().equals(id)) {
	    			 return user;
	    		 }
	    	 }
	    	 return null;
	    }
}
