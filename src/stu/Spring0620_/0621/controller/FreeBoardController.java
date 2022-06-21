package stu.Spring0620_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.myweb.command.FreeBoardVO;
import com.spring.myweb.freeboard.service.IFreeBoardService;
import com.spring.myweb.util.PageCreator;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/freeboard")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(PageVO vo,Model model) {
		System.out.println("/freeboard/freeList :GET");
	
		
		PageCreator pc=new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(service.getTotal(vo));
		model.addAttribute("boardList", service.getList(vo));
		model.addAttribute("pc", pc);
	}
	//글쓰기 화면 처리
	@GetMapping("/freeRegist")
	public void Regist() {
	}
	
	//글 등록 처리
	@PostMapping("/registForm")
	public String registForm(FreeBoardVO vo,RedirectAttributes ra) {
		service.regist(vo);
		ra.addFlashAttribute("msg", "정상 등록 처리 되었습니다.");
		
		return "redirect:/freeboard/freeList";
	}

	
	//글 상세보기 처리 
	@GetMapping("/freeDetail/{bno}")
	public String detail(@PathVariable int bno,
						@ModelAttribute("p") PageVO vo,
						Model model) {
		System.out.println("/freeboard/freeDetail");
		
		model.addAttribute("article",service.getContent(bno));
	
		return "freeboard/freeDetail";
	}
	
	//글 수정 페이지 이동 처리 
	@GetMapping("/freeModify")
	public void modify(int bno,Model model) {
		model.addAttribute("article", service.getContent(bno));
		
	}
	
	//글 수정 처리 
	@PostMapping("/freeUpdate")
	public String freeUpdate(FreeBoardVO vo,RedirectAttributes ra) {
		service.update(vo);
		ra.addFlashAttribute("msg", "updateSuccess");
		
		return "redirect:/freeboard/freeDetail/"+vo.getBno();
		
	}
	
	@PostMapping("/freeDelete")  //form태그 안에서 많은 값이 넘어오는데 , 필요한 파라미터 변수명만 쓰던가, 아니면 객체를 쓴다
	public String freeDelete(int bno,RedirectAttributes ra) {
		service.delete(bno);
		ra.addFlashAttribute("msg", "게시글이 정상적으로 삭제되었습니다");
		
		return "redirect:/freeboard/freeList";
		
	}
	

	
	
	
	

	
	
	
}














