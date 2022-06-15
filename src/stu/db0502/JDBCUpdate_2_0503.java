package stu.db0502;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcUpdate_2_0503 {

	public static void main(String[] args) {

		//ID를 입력 받으세요.
		//수정할 이름과 이메일도 입력 받으세요.
		//지목한 ID의 이름과 이메일을 새로운 값으로 수정해보세요
		//(ID는 존재하는 ID를 넣어주셔야 수정이 가능합니다.)
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("아이디 입력");
		String id=sc.next();
		
		System.out.print("수정할 이름");
		String name=sc.next();
		
		System.out.print("수정할 이메일");
		String email=sc.next();
		
		                         //괄호 쓰지 않아도 됨  ( ? ) 없이 ?만 ::그냥 알고 있는 SQL문으로 작성하고 넣을값 ? 로 채움
	    String sql="UPDATE members SET name=?, email=? WHERE id=?";
	    
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="hr";
		String upw="hr";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");//ClassNotFoundException 발생 
			
			
			conn=DriverManager.getConnection(url, uid, upw); // SQLException 발생
			
			pstmt=conn.prepareStatement(sql);                // SQLException 발생
			
			pstmt.setString(1,name);						// SQLException 발생
			pstmt.setString(2,email);						// SQLException 발생
			pstmt.setString(3, id);							// SQLException 발생
			int rn=pstmt.executeUpdate();					// SQLException 발생
			
			if(rn==1) {				
				System.out.println("업데이트 성공!");
			}else {
				System.out.println("업데이트 실패!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				pstmt.close();								// SQLException 발생
				conn.close();								// SQLException 발생
				sc.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
		
	}

}
