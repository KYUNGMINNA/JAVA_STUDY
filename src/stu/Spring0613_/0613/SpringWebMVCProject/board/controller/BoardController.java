package stu.Spring0613_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.board.service.IBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private IBoardService service;

	
	//게시글 전체 목록 불러오기 요청
	@GetMapping("/list")
	public String list(Model model) {
		System.out.println("/board/list  :GET");
		model.addAttribute("articles", service.getArticleList());
		return "board/list";
	}
	//글쓰기 페이지로 이동 요청
	@GetMapping("/write")
	public void write() {
		System.out.println("/board/write :GET");
	}
	
	//게시글 DB 등록 요청
	@PostMapping("/write")
	public String write(BoardVO article) {
		System.out.println("/board/write : POST");
		service.insert(article);
		
		return "redirect:/board/list";
		
	}
	
	
	//게시글 상세보기 요청
	
	//@@PathVariable은 URL 경로에 변수를 포함시켜 주는 방식
	//null이나 공백이 들어갈 수 있는 파라미터라면 적용하지 않는 것을 추천 .
	//파라미터값에 .이 포함되어 있다면  .뒤에 값은 잘린다! 
	//{} 안에 변수명을 지어주시고 ,@PathVariable 괄호 안에 영역을 지목해서 값을 받아 온다.
	@GetMapping("/content/{boardNo}")   // /content/{boardNo} 의 URL로 요청이 들어온다는 의미(이름은 아무렇게나 지어도 된다)
	public String content(@PathVariable int boardNo,Model model) {
		// URL과 파라미터의 이름을 같게 쓰면 ,@@PathVariable ()의 괄호 안써도 된다. ::만약 {num} 이면 @PathVariable(num) int boardNo라 쓴다
		System.out.println("/board/content:GET");
		System.out.println("요청된 글 번호 :"+boardNo);
		model.addAttribute("article", service.getArticle(boardNo));
		return "board/content";
	}
	
	
	
	@PostMapping("/modify")
	public String update(BoardVO article) {
		System.out.println("/board/modify:POST");
		service.update(article);
		
		return "redirect:/board/content?boardNo="+article.getBoardNo();
	}
	
	
	@PostMapping("/delete")
	//@RequestParam("boardNo") int boardNo :FM방식 (파라미터명과 ,변수명이 일치하면 @requst생략가능)  
	public String delete(int boardNo,RedirectAttributes ra) {
		System.out.println("/board/delete:POST");
		System.out.println("요청된 글 번호 "+boardNo);
		service.delete(boardNo);
		
		ra.addFlashAttribute("msg", "delSuccess");
		
		return "redirect:/board/list";
	}
	
	
	
}















































