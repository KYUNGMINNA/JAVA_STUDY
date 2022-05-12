package kr.co.jsp.score.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DAO는 웹 서버의 DB연동 요청이 발생할 때 마다 
//DB CRUD(create,read,update,delete) 작업을 전담하는 클래스
public class ScoreDAO_13_0512 {

	//싱글톤 디자인 패턴(객체 생성을 단 하나로 제한하기 위한 코드 디자인 패턴) :무분별한 객체생성을 막음
	
	//1.클래스 외부에서 객체를 생성하지 못하게 생성자에 private 접근 제한자를 붙임
	private ScoreDAO_13_0512() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	//2.이제 객체를 생성할 수 있는 영역은 해당 클래스 내부 뿐이므로
	//스스로의 객체를 단 하나만 생성함. ::단 하나만 생성이라 static,
	//static 때문에 누구나 접근이 가능해서 private으로 막는것
	
	//static으로만 선언하면 외부에서 클래스로 바로 접근이 가능해서 쓸모없는 값이 들어갈 수 있어
	//private으로 접근을 제한 한다.
	private static ScoreDAO_13_0512 dao=new ScoreDAO_13_0512();
	
	//3.외부에서 객체를 요구할 시 공개된 메서드를 통해 
	//2번에서 미리 만들어 놓은 단 하나의 객체의 주소값을 리턴.
	public static ScoreDAO_13_0512 getInstance() {
		if(dao==null) { //dao가 소멸 되었을 수도 있어서 (즉 ,null받지 않기 위해)
			dao=new ScoreDAO_13_0512();
		}
		return dao;
	}
	
	////////////////////////////////////////////////////////////////
	
	//DB관련  여러가지 작업 메서드가 들어가는 공간
	
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//모든 메서드에서 공용적으로 사용할 Connection 객체를 얻을 수 있는 유틸메서드 
	private Connection getConnection() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="jsp";
		String upw="jsp";
		return DriverManager.getConnection(url, uid, upw);
	}
	
	//점수 데이터를 저장하는 메서드 
	public boolean insert(ScoreVO_10_0512 vo)  {
		boolean flag=false;
		String sql="INSERT INTO scores VALUES(id_seq.NEXTVAL,?,?,?,?,?,?)";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMath());
			pstmt.setInt(5, vo.getTotal());
			pstmt.setDouble(6, vo.getAverage());

			int rn=pstmt.executeUpdate();
			
			if(rn==1) flag=true;
				
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return flag;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
