package stu.Spring0613_;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {

	//아이디 중복 체크 기능
	int checkId(String account);
		
	//회원 가입 기능 
	void register(UserVO user);
	
	//회원 정보 조회 기능
	UserVO selectOne(String account);
	
	//회원 탈퇴 기능
	void delete(String account);
	
	
	//자동 로그인 쿠키값 DB 저장 처리 :회원가입한 컬럼에 업데이트 
	//SQL : UPDATE 
	void keepLogin(Map<String, Object> data);
	
	//세션 ID를 통한 회원 정보 조회 기능 
	
	/*
	 자동 로그인 하고 싶다는 사람한테  쿠키를 만들어줬다(쿠키 값은 세션 ID로 만듦)
	 그리고 나중에 다시 방문시 , 서버에 요청을 보낼거고 요청과 함께 쿠키 같이 전달
	 우리는 쿠키 안에 들어있는 세션id로 회원정보를 조회해서 마치 이 사람이 로그인 중인것 처럼 
	 세션 데이터를 만들어 준다.(login이라는 세션데이터가 로그인 중이라는 징표이기 때문)
	 */
	UserVO getUserWithSessionId(String sessionId);
	
	
	
	
	
	
	
	
	
	
}
