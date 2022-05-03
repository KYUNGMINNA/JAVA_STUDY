package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcSelect2_4_0503 {

	public static void main(String[] args) {

		/*
		 사용자에게 Scanner를 이용하여 job_id를 입력받습니다
		 입력받은 job_id에 해당하는 사람들의 first_name,
		 salary를 콘솔창에 출력해주세요(employees 테이블 사용)
		  조회된 내용이 없다면 조회 결과가 없다고 출력해 주세요.
		  */
		
		Scanner sc=new Scanner(System.in);
		
		System.out.print("job_id를 입력해주세요");
		String jobid=sc.next();
		
		
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="hr";
		String upw="hr";
		
		String sql="SELECT first_name,salary FROM employees WHERE job_id=?";
		
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			
	
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn=DriverManager.getConnection(url, uid,upw);
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, jobid);
			
			rs=pstmt.executeQuery(); //ReusltSet에 저장되자만, 읽으려면 한줄씩 읽어야 함
			
			//강사v
			int count=0;
			
			while(rs.next()) {
				
				String firstname=rs.getString("first_name");
				int salary=rs.getInt("salary");
				
				System.out.printf("#first_name :%s ,salary : %d \n",firstname,salary);
			
			   //강사v
				System.out.printf("이름 :%s \n",rs.getString("first_name"));
				System.out.printf("급여:%d \n",rs.getInt("salary"));
				
				count++;
			}
			
			
			if(!rs.next()) {
				System.out.println("조회 내용이 없습니다.");
			}
				
			//강사v
			if(count==0)
			{
				System.out.println("해당 job_id에 대한 조회 결과가 없습니다.");
			}else {
				System.out.println("조회된 행의 개수 :"+count+"개");
			}
			
			
			
		}catch(Exception e) {
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
