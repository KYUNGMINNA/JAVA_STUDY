package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.jsp.util.JdbcUtil_10_0513;

public class BoardDAO_6_0513 implements IBoardDAO_5_0513 {

	//BoardDAO는 메모리 효율성을 위해 싱글톤 디자인 패턴을 적용해야 한다.
	
	private BoardDAO_6_0513() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BoardDAO_6_0513 dao=new BoardDAO_6_0513();
	
	//객체 생성없이 주소를 전달해야하기 때문에 , static
	public static BoardDAO_6_0513 getInstance() {
		if(dao ==null) {
			dao=new BoardDAO_6_0513();
		}
		return dao;
	}
	
	
	
	
	/////////////////////////////////////////////////////
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private Connection getConnection() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uid="jsp";
		String upw="jsp";
		return DriverManager.getConnection(url,uid,upw);
	}
	
	@Override
	public boolean insert(BoardVO_4_0513 vo) {
		boolean flag=false;
		//String sql="INSERT INTO board VALUES(bid_seq.NEXTVAL,?,?,?,sysdate)";
		
		//강사 version
		String sql="INSERT INTO board(board_id,writer,title,content) VALUES(bid_seq.NEXTVAL,?,?,?)";
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			
			/*
			int rn=pstmt.executeUpdate();
			if(rn ==1) flag=true;
			*/ 
			//위의 두줄과 밑의 한줄은 같다.
			if(pstmt.executeUpdate() ==1 ) flag=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil_10_0513.close(conn, pstmt);
		}
		
		return flag;
	}

	@Override
	public List<BoardVO_4_0513> selectAll() {
		List<BoardVO_4_0513> boardList=new ArrayList<>();
		String sql="SELECT * FROM board ORDER BY board_id DESC";
		
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) { 
				
				//실제 컬럼 이름작성
				BoardVO_4_0513 vo=new BoardVO_4_0513(rs.getInt("board_id"),
						rs.getString("writer"),rs.getString("title"),rs.getString("content"),
						rs.getTimestamp("reg_date"));
				boardList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil_10_0513.close(conn, pstmt, rs);
		}
		
		
		return boardList;
	}

	@Override
	public BoardVO_4_0513 selectOne(int bId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(BoardVO_4_0513 vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String bId) {
		// TODO Auto-generated method stub
		return false;
	}

}
