package stu.Spring0613_;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.apache.ibatis.javassist.ClassPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.model.BoardVO;
import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.repository.IUserMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	//IUserMapper 타입의 객체를 자동 주입하세요
	
	@Autowired
	private IUserMapper mapper;
	
	//회원 가입을 아무 아이디로 진행해 보세요
	@Test
	public void registerTest() {
		UserVO user=new UserVO();
		user.setAccount("김");
		user.setPassword("kim");
		user.setName("금");
		mapper.register(user);
		
	}
	
	//위에서 회우너 가입한 아이디를 중복 확인 해서 
	//COUNT(*)를 이용해서 1이 리턴 되는지 확인하세요
	@Test
	public void checkedIdTest() {
		int result=mapper.checkId("김");
		System.out.println(result);
	}
	
	//가입한 회원의 모든 정보를 얻어내서 출력해 보세요
	@Test
	public void selectOneTest() {
		UserVO user=mapper.selectOne("김");
		System.out.println(user);
	}
	
	
	//위에서 강비한 계정의 탈퇴를 진행해 보세요
	//탈퇴가 성공했는지의 여부를 정보를 얻어오는 메서드를 통해서
	//확인해보세요 ( null 체크)
	@Test
	public void deleteTest() {
		mapper.delete("김");
		
		if(mapper.selectOne("김")==null) {
			System.out.println("회원 탈퇴 성공!");
		}else {
			System.out.println("회원 탈퇴 실패!");
		}
	}
	

}
