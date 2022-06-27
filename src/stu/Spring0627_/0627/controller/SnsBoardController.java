package stu.Spring0627_;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.myweb.command.SnsBoardVO;
import com.spring.myweb.command.UserVO;
import com.spring.myweb.snsboard.service.ISnsBoardService;
import com.spring.myweb.util.PageVO;

@Controller
@RequestMapping("/snsBoard")
public class SnsBoardController {

	
	@Autowired
	ISnsBoardService service;
	
	
	@GetMapping("/snsList")
	public void snsList() {
		
	}
	
	@PostMapping("/upload")
	@ResponseBody
	public String upload(MultipartFile file,String content,HttpSession session) {
		
		String writer=((UserVO)session.getAttribute("login")).getUserId();
		
		//날짜별로폴더를 생성해서 파일을 관리
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		Date data=new Date();
		String fileloca=sdf.format(data);
		
		
		//저장할 폴더 경로
		String uploadPath= "C:\\Users\\kyungmin\\Desktop\\upload\\"+fileloca;
		
		File folder=new File(uploadPath);
		if(!folder.exists()) {
			folder.mkdirs(); //폴더가 존재하지 않는다면 생성해라 
		}
		//원본파일명
		String fileRealName=file.getOriginalFilename();
		
		//파일명을 고유한 랜덤 문자로 생성
		UUID uuid=UUID.randomUUID();
		String uuids=uuid.toString().replaceAll("-","");
		
		//확장자를 추출합니다
		String fileExtension=fileRealName.substring(fileRealName.lastIndexOf("."),fileRealName.length());
		
		System.out.println("저장할 폴더 경로 : "+uploadPath);
		System.out.println("실제 파일 명:"+fileRealName);
		System.out.println("폴더 명:"+fileloca);
		System.out.println("확장자:"+fileExtension);
		System.out.println("고유 랜덤 문자:"+uuids);
		
		String fileName=uuids+fileExtension;
		System.out.println("변경해서 저장할 파일 명 : "+fileName);
		
		//업로드 한 파일을 서버 컴퓨터 내의 지정한 경로에 실제로 저장
		
		File saveFile=new File(uploadPath+"\\"+fileName);
		try {
			file.transferTo(saveFile);
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//DB에 insert 작업을 실행
		SnsBoardVO snsVO=new SnsBoardVO(0, writer, uploadPath, fileloca, fileName, fileRealName, content, null);
		service.insert(snsVO);
		
		return "success";
		
		
		
	}
	
	//비동기 통신 후 가져올 글 목록 
	@GetMapping("/getList")
	@ResponseBody
	public List<SnsBoardVO> getList(PageVO paging){
		paging.setCpp(3);
		return service.getList(paging);
	}
	
	
	//게시글의 이미지 파일 전송 요청
	//이 요청은 img태그에 의해서요청이 들어오고 있습니다.
	//snsList.jsp 페이지가 로딩되면서 글 목록을 가져오고 있고 ,JS를 이용해서 
	//화면을 꿈릴때 img 태그에 src에 작성된 요청 url 을 통해 자동으로 요청이 들어옴
	//요청을 받아서 경로에 지정된 파일을 보낼 예정입니다
	@GetMapping("/display")
	public ResponseEntity<byte[]> getFile(String fileLoca ,String fileName){ //url에 포함되어 넘어오는 파라미터이름

		//byte[] 만 리턴으로해도 , 파일 전달에는 문제가 없지만
		//권장사항은  ResponseEntity 
		
		System.out.println("fileName  :"+fileName);
		System.out.println("filelLoca  :"+fileLoca);
		
		File file=new File("C:\\Users\\kyungmin\\Desktop\\upload\\"+fileLoca+"\\"+fileName);
		System.out.println(file);
		
		ResponseEntity<byte[]> result=null;
		
		HttpHeaders headers=new HttpHeaders(); //필수는 아님 
		//응답 헤더파일에 여러가지 정보를 담아서 전송하는 것도 가능 
		try {
			//probeContentType : 파라미터로 전달받은 파일의 타입을 문자열로 변환해 주는 메서드 
			//사용자에게 보여주고자 하는 데이터가 어떤 파일인지를 검사해서 응답상태 코드를 다르게 리턴 할 수 있다.
			headers.add("Content-Type", Files.probeContentType(file.toPath()));
			//headers.add("merong","hello"); 이런식으로도 보낼 수 있다.
			
			//ResponseEntity<> (응답객체에 담을 내용 , 응답헤더파일에 담을 내용 , 상태메시지) 전송 가능
			//FileCopyUtils :파일 및 스트림 데이터 복사를 위한 간단한 유틸리티 메서드의 집합체.
			//file객체 안에 있는 내용을 복사해서 byte배열로 변환해서 바디에 담아 화면에 전달
			result=new ResponseEntity<byte[]>(FileCopyUtils.copyToByteArray(file),headers,HttpStatus.OK);
		} 
		catch (IOException e) {
			e.printStackTrace();
		} //
		
		
		return result;
	
		
		
	}
	
	//상세보기 처리 
	@GetMapping("/getDetail/{bno}")
	@ResponseBody
	public SnsBoardVO getDetail(@PathVariable int bno) {
		System.out.println(bno);
		
		return service.getDetail(bno);
	}
	
	//삭제 처리 
	@PostMapping("/delete")
	@ResponseBody
	public String delete(@RequestBody int bno,HttpSession session) {
		System.out.println("삭제 글 번호 :"+bno);
		
		SnsBoardVO vo=service.getDetail(bno);
		UserVO user=(UserVO)session.getAttribute("login");
		
		if(user ==null || !user.getUserId().equals(vo.getWriter())) {
			return "noAuth";
		}
		
		service.delete(bno);
	
		//글이 삭제되었다면  더 이상 이미지도 존재할 필요가 없으므로  로컬 경로의 이미지도 
		//함께 지목해서 삭제.
		File file=new File(vo.getUploadpath() + "\\"+vo.getFilename());
		System.out.println("파일 삭제 완료 !");
		
		return file.delete()? "Success":"fail";  //파일 삭제 메서드
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
