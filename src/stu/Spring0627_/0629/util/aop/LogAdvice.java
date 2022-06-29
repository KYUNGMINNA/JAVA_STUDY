package stu.Spring0627_;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect //AOP를 적용시킬 클래스
@Component  //빈 등록 - (컨트롤러도 아니고 , 서비스도 아니고 ,레퍼지토리도 아닐 때 )-- 즉 아노테이션으로 구분하는것이지 하는 역할(빈 등록)은 같다
public class LogAdvice {
	
	private static final Logger logger=LoggerFactory.getLogger(LogAdvice.class);
	
	
	
	
	/*
	 준비한 로직(Advice)을 어떤 시점(Joint Point)에서 사용하게 할 지 정해줄 수 있다. ->pointCut
	 @Before , @After , @afterThrowing   : pointCut의 종류 
	 @Around는 위의 3가지 세가지 pointCut을 한번에 처리할 수 있도록 해준다.
	 
	 메서드 실행 권한을  가지고 ,타겟 메서드랑 접목시켜서 사용 
	 규칙 - 반환타입은 Object로 , 매개변수로 메서드의 실행 시점을 결정짓는 ProceddingJointPoint를 선언한다.
	 
	 ProceedingJoinPoint는 AOP의 댓당이 되는 Target이나 파라미터 등을 파악할 뿐만 아니라,
	 직접 실행을 결정 할 수 있다.
	 
	 execution(accessModi접근제한자  package패키지명  class클래스명  method메서드  arguments인자)
	 */
	
	
	//접근제한자 상관 없음 
	//com.spring.myweb으로 시작하는 패키지  , 중간에 뭐 들어가는지 상관 없고 
	//서비스패키지안에 있는 이름이 ~~~Service로 끝나느 클래스의 모든 메서드(매개변수 개수 관계 없음)
	@Around("execution(* com.spring.myweb.*.service.*Service.*(..) )")
	public Object aroundLog(ProceedingJoinPoint jp) {
		
		long start=System.currentTimeMillis();
		
		logger.info("실향 클래스  :  "+jp.getTarget());
		logger.info("실행 메서드 :  "+jp.getSignature().toString());
		logger.info("매개값 :  "+Arrays.toString(jp.getArgs()));
		
				
		Object result=null;
		
		try {
			result=jp.proceed(); //타겟 메서드의 실행명렁 메서드
		} catch (Throwable e) {
			e.printStackTrace();
		} 
	
		
		long end=System.currentTimeMillis();

		logger.info("메서드 소요 시간 : "+ (end-start)*0.001 + "초");

		//위에 작성한 이 메서드의 실행 내용은 proxy(가상환경) 환경에서 돌아가는 중이기 때문에 
		//proceed() 메서드의 결과를 반환해야 메서드의 정상 흐름으로 돌아갑니다.
		return result;
		
	}
	
	

}



















































