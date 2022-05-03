package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcSelect_3_0503 {

	//main ctrl space enter = psvm 자동완성
	
	public static void main(String[] args) {
		
		String sql="SELECT * FROM members";

		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="hr";
		String upw="hr";
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;  // SELECT 문에서만 사용하는 객체.
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url, uid, upw);
			pstmt=conn.prepareStatement(sql);
			
			//SELECT문은 executeQuery()를 통해 ResultSet 타입의 객체를 받아옵니다.
			//ResultSet은 SELECT문의 쿼리 샐힝 결과 전체를 들고 있습니다.
			rs=pstmt.executeQuery();
			
			/*
			 -SELECT 쿼리문의 실행 결과 , 조회할 데이터가 단 한줄 이라도 존재 한다면 
			 ResultSet 객체의 next()라는 메서드는 true라는 값을 리턴하면서 해당 행을 지목합니다.  :: 한 행씩 조회 하게됨 //데이터 없으면 false
			 그렇기 때문에 ,ResultSet에게 데이터를 읽어올 때는 반드시 next()라는 메서드를 먼저 호출해서 
			 데이터의 존재 유무 부터 물어봐야 한다.
			 next()메서드를 호출을 하셔야만 행 하나가 지목되면서 데이터를 불러들일 수 있습니다.
			
			  쿼리결과가 한줄이라도 반드시 next를 불러야 한다 .
			 */
			
			int cnt=0; //조회된 행의 개수 파악을 위한 변수 선언
			//rs.next()가 true면 동작, next의 결과가  종료 ,혹은  데이터가 없으면 false를 리턴하며 false면  반복문 종료
			while(rs.next()) {//데이터 존재의 유무 확인 하여 있으면 첫번째 행을 지목 
			/*

			 -SELECT의 실행 결과 컬럼을 읽어 오려면
			 ResultSet의 getString(),getInt(),getDouble()...
			 의 메서드를 사용해서 리턴받습니다(컬럼의 타입에 따라 메서드의 종류가 달라짐)
			 */
				
			//지목한 첫번째의 행의 값을 가져 옴 .	               
			String id=rs.getString("id"); // ( ) 괄호 안에는컬럼명
			String pw=rs.getString("pw");
			String name=rs.getString("name");
			String email=rs.getString("email");
			
			
			//System.out.printf("# 아이디는 : %s \n # 비밀번호 : %s \n # 이름 : %s \n # 이메일 : %s \n",id,pw,name,email);
			//인데  #  ___ 이름 에서 엔터 치니 자동으로 +연산으로 연결해 줌  
			System.out.printf("# 아이디는 : %s \n # 비밀번호 : %s \n #"
					+ " 이름 : %s \n # 이메일 : %s \n",id,pw,name,email);
			System.out.println("--------------------------------------");	
			
			cnt++; //조회된 행의 개수 파악 
			
			}
			System.out.println("조회된 행의 개수 "+cnt+"개");
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
				
			}
			
		}
		
	}

}
