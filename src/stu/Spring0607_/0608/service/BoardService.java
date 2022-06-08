package stu.Spring0607_;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.basic.model.BoardVO;
import com.spring.basic.repository.IBoardDAO;

@Service
public class BoardService implements IBoardService {

	@Autowired
	IBoardDAO dao;
	
	
	@Override
	public void insertArticle(BoardVO vo) {
		dao.insertArticle(vo);
	}

	@Override
	public List<BoardVO> getArticles() {
		return dao.getArticles();
	}

	@Override
	public BoardVO getAtritlce(int bId) {
		return dao.getAtritlce(bId-1);
	}

	@Override
	public void deleteArticle(int bId) {
		dao.deleteArticle(bId-1);
	}

	@Override
	public void updateArticle(BoardVO vo, int bId) {
		dao.updateArticle(vo, bId-1);
	}

}
