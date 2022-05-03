package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.net.aso.b;

public class JDBCInsert_0503 {

	public static void main(String[] args) {

		//자동 import : ctrl space_bar
		Scanner sc=new Scanner(System.in);
		
		System.out.println("****회원가입페이지***");
		System.out.print("아이디:");
		String id=sc.next(); //nextLine() :공백까지 포함 
							 //next() 공백미포함(공백작성시 종료)

		System.out.print("비밀번호:");
		String pw=sc.next();
		
		System.out.print("이름 :");
		String name=sc.next();
		
		System.out.print("이메일 :");
		String email=sc.next();
		
		////////////////////////////////////////////////
		
		//SQL문 작성
		//SQL문은 String 형태로 작성합니다.
		//변수가 들어갈 자리에 ? 를 채웁니다.
		String sql="INSERT INTO members VALUES(?,?,?,?)";  //, ,안찍어도 되기는 함.
		
		//DB연동 순서
		//1.DB사용자 계쩡명 ,암호, DB url 등 초기 데이터 변수 설정.
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="hr";
		String upw="hr";

		
		
		
         //사용할 객체의 변수를 미리 선언(finally)애서도 사용해야 하니까 : 전역변수로 사용하기 위함		
		Connection  conn=null;
		PreparedStatement pstmt=null;		
		
		try {
			//2. JDBC 커넥터 드라이버 호출 :클래스 강제로 깨우기 
			     //forName은 예외처리 해줘야 함  , 경로는 고정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//3.DB연동을 위한 클래스들의 객체를 생성.
			/*
			 # a. Connection 객체 : DB와의 연결(접속)을 위한 객체.
			 Connection 객체는 new 연산자를 통해 직접 생성하는거이 아니라,
			 DriverManager 클래스가 제공하는 정적 메서드인 getConnection()을 호출하여
			 객체를 받아 옵니다.
			  */
			
			
			conn=DriverManager.getConnection(url, uid, upw);
			
			/*
			 * #b. PreparedStatement객체
			 :SQL문을 실행시키기 위한 객체.
			 PreparedStatement 객체는 Connection 객체가 제공하는 메서드 prepareStatement()
			 메서드를 호출하여 객체를 받아옵니다 . 
			 메서드의 매가값으로 실행시킬 sql문을 전달합니다.
			 */
			pstmt=conn.prepareStatement(sql);
			
			/*
			  #c. - 물음표 채우기( SQL문 완성하기)
			  :PreparedStatement 객체를 생성했다면 SQL문의 ?를 채워줍니다.
			  - ? 는 첫번째 물음표부터 1번 인덱스 값을 가지며 ,순차적으로 인덱스가 1씩 증가합니다.
			  - DB테이블의 컬럼 타입에 따라 ,setString() 혹은 setInt() , setDouble()등의 메서드를 통해 ?를 채웁니다.
			   
			   		String sql="INSERT INTO members VALUES(?,?,?,?)";
			  */
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			
			
			/*
			 #d - PreparedStatement 객체를 통한 SQL문 실행
			 1.INSERT , UPDATE ,DELETE 명령일 경우 
			 executeUpdate()를 호출합니다.
			 
			 2.SELECT 명령일 경우 executeQuery()를 호출합니다.
			 
			 3.executeUpdate()는 sql문을 실행시 성공한 쿼리문의 개수를,
			 실패시 0이 리턴됩니다.
			 
			 */
			
			
			int rn=pstmt.executeUpdate();
			
			if(rn==1) { 
				System.out.println("DB에 회원정보 저장 성공!");
			}else {
				System.out.println("DB에 회원정보 저장 실패!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//예외 발생여부와 관계없이 항상 실행되는 문장 
			
			/*
			 4. DB연동 객체들 자원 반납.
			 -원활한 JDBC 프로그래밍을 위해 사용한 자원을 반납합니다
			 */
			try {   //반납 순서는 역순
				pstmt.close();
				conn.close();
				sc.close();    //scanner도 메모리 반납하는게 좋다.
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		
		
	}

}
