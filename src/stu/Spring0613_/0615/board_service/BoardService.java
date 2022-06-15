package stu.Spring0613_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.board.commons.PageVO;
import com.spring.mvc.board.commons.SearchVO;
import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.repository.IBoardMapper;

@Service
public class BoardService implements IBoardService {
	
	@Autowired
	private IBoardMapper mapper;

	@Override
	public void insert(BoardVO article) {
		mapper.insert(article);
	}

	@Override
	public List<BoardVO> getArticleList(SearchVO search) {
		
		/*2번 방법
		//매퍼에게 전달할 맵 데이터를 생성 .
		//key -> xml에서 활용할 이름, value ->실제 값 
		Map<String, Object> data=new HashMap<>();
		data.put("paging", paging);
		data.put("condition",condition);
		data.put("keyword",keyword);
		List<BoardVO> list=mapper.getArticleList(data);
		*/
		
		//1번 방법
		//List<BoardVO> list=mapper.getArticleList(paging, condition, keyword);
		
		//3번 방법
		List<BoardVO> list=mapper.getArticleList(search);
		
		
		//newMark 붙임 여부 선택을 위한 시간 계산 
		for(BoardVO article:list) {
			long now=System.currentTimeMillis();
			
			long regDate=article.getRegDate().getTime();
			
			if(now-regDate <60*60*24*1000) article.setNewMark(true);
		}
		
		
		return list;
	}

	@Override
	public BoardVO getArticle(int boardNo) {
		return mapper.getArticle(boardNo);
	}

	@Override
	public void update(BoardVO article) {
		mapper.update(article);
	}

	@Override
	public void delete(int boardNo) {
		mapper.delete(boardNo);
	}
	
	@Override
	public int countArticles(SearchVO search) {
		return mapper.countArticles(search);
	}

}







