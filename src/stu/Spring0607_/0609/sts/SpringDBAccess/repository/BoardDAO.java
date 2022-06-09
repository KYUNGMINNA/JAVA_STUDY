 package stu.Spring0607_;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.db.model.BoardVO;

@Repository
public class BoardDAO implements IBoardDAO {

	
	//내부 클래스 선언 
	class BoardMapper implements RowMapper<BoardVO>{

		@Override
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			BoardVO vo=new BoardVO();
			vo.setBoardNo(rs.getInt("board_no"));
			vo.setWriter(rs.getString("writer"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			
			
			//setter 메서드를  이용하는것도 좋지만, 생성자를 이용해서 초기화 하는 방법도 괜찮다.
			/*
			  return new BoardVO( 
			  rs.getInt("board_no"), rs.getString("writer"),
			  rs.getString("title"), rs.getString("content")
			   );
			  
			 */
			return vo;
		}
	
	}
	
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void insertArticle(BoardVO vo) {
		String sql="INSERT INTO jdbc_board VALUES(bid_seq.NEXTVAL,?,?,?)";
		template.update(sql, vo.getWriter(),vo.getTitle(),vo.getContent());
	}

	@Override
	public List<BoardVO> getArticles() {
		String sql="SELECT * FROM jdbc_board ORDER BY board_no DESC";
		
		return template.query(sql, new BoardMapper()); 
	}

	@Override
	public BoardVO getAtritlce(int bId) {
		String sql="SELECT * FROM jdbc_board WHERE board_no=?";
		
		try {
			BoardVO vo=template.queryForObject(sql, new BoardMapper(),bId);
			return vo;
			
		}catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public void deleteArticle(int bId) {
		String sql="DELETE FROM jdbc_board WHERE board_no=?";
		template.update(sql,bId);
	}

	@Override
	public void updateArticle(BoardVO vo) {
		String sql="UPDATE jdbc_board SET writer=?,title=?,content=? WHERE board_no=?";
		template.update(sql,vo.getWriter(),vo.getTitle(),vo.getContent(),vo.getBoardNo());
	}


	@Override
	public List<BoardVO> searchWriter(String keyword) {
		String sql="SELECT * FROM jdbc_board WHERE writer LIKE ?";
		return template.query(sql, new BoardMapper(), "%"+keyword+"%");
		//강사는 %+keyword+% 를 service에서 보냈음 ::왜냐면 이 메서드를 재활용 하기에는 서비스 계층에서 호출하는것이 좋음 
	}

	
	


}
