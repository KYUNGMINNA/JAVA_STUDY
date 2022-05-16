package kr.co.jsp.board.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.jsp.util.JdbcUtil_10_0513;

public class BoardDAO_6_0513 implements IBoardDAO_5_0513 {

	//javax.sql 의 DataSource :커넥션 풀의 정보를 담을 변수를 선언  
	private DataSource ds;
	
	
	private BoardDAO_6_0513() {
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver");
		 * 
		 * }catch(Exception e) { e.printStackTrace(); }
		  context.xml에 커넥션풀을 설정해 두었기 때문에 더이상 사용할 필요가 없다. 
		  */
		
		//클래스에서 커넥션 풀을 구하는 방법 (설정 파일이 InitialContext 객체에 저장됨)
		try {
			InitialContext ct=new InitialContext();
			//java:comp/env/ 로 시작하는게 관례 , jdbc/myOracle 은 context.xml에 작성한 커넥션풀이름
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/myOracle");
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//BoardDAO는 메모리 효율성을 위해 싱글톤 디자인 패턴을 적용해야 한다.  서버에 사용자 몰릴때 과부하 방지를 위함 
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
	
	/*  커넥션 풀에 만들어놓고 불러오기 때문에 , 더이상 사용할 일 없다.
	 * private Connection getConnection() throws Exception { String
	 * url="jdbc:oracle:thin:@localhost:1521:xe"; String uid="jsp"; String
	 * upw="jsp"; return DriverManager.getConnection(url,uid,upw); }
	 */
	
	@Override
	public boolean insert(BoardVO_4_0513 vo) {
		boolean flag=false;
		//String sql="INSERT INTO board VALUES(bid_seq.NEXTVAL,?,?,?,sysdate)";
		
		//강사 version
		String sql="INSERT INTO board(board_id,writer,title,content) VALUES(bid_seq.NEXTVAL,?,?,?)";
		try {
//			conn=getConnection(); 기존의 방식
			
			conn=ds.getConnection();
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
			conn=ds.getConnection();
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
		
		BoardVO_4_0513	vo=null; // 미리 변수를 잡아 두고 조회가되면 변수에 객체를 넣어야 하기때문에 
		
		
		String sql="SELECT * FROM board WHERE board_id=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {  //여기서  변수 선언하면 지역변수가 됨.
				 vo=new BoardVO_4_0513(rs.getInt("board_id"),
						rs.getString("writer"),rs.getString("title"),rs.getString("content"),
						rs.getTimestamp("reg_date"));

			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil_10_0513.close(conn, pstmt, rs);
			
		}
		return vo;
		
		
	}

	@Override
	public boolean update(BoardVO_4_0513 vo) {
		boolean flag=false;
		String sql="UPDATE board SET title=? ,content=? WHERE board_id=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardId());
			
			if(pstmt.executeUpdate()==1) flag=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			JdbcUtil_10_0513.close(conn, pstmt);
		}
		
		return flag;
	}

	@Override
	public boolean delete(int bId) {
		boolean flag=false;
		
		String sql="DELETE FROM board WHERE board_id=?";
		try {
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, bId);
			if(pstmt.executeUpdate()==1) flag=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil_10_0513.close(conn, pstmt);
		}
		
		
		return flag;
	}

}
