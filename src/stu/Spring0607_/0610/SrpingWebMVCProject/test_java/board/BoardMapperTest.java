package stu.Spring0607_;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.mvc.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class) //테스트 환경을 구축하는 클래스 |이 클래스 타입으로 테스트를 한다

//테스트환경에서 Mapper 객체 활용을 위해 빈 등록 설정이 있는 xml 파일을 로딩. @contextConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"}) //mvc-config.xml설정을 가져온다( 등럭되어 있는 빈 객체 활용하기 위함)
public class BoardMapperTest {

	@Autowired
	private IBoardMapper mapper;
	
	
	
	
	
	
}
