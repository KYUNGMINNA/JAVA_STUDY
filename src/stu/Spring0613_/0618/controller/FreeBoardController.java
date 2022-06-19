package stu.Spring0613_;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.myweb.freeboard.service.IFreeBoardService;
import com.spring.myweb.util.PageCreator;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/freeBoard")
public class FreeBoardController {
	
	@Autowired
	private IFreeBoardService service;
	
	//목록 화면
	@GetMapping("/freeList")
	public void freeList(PageVO vo,Model model) {
		System.out.println("/freeBoard/freeList :GET");
	
		
		PageCreator pc=new PageCreator();
		pc.setPaging(vo);
		pc.setArticleTotalCount(service.getTotal(vo));
		model.addAttribute("boardList", service.getList(vo));
		model.addAttribute("pc", pc);
	}

	@GetMapping("/freeRegist")
	public void Regist() {
		
	}
	
	
	
	
}














