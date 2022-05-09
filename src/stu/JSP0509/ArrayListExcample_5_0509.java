package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListExample_5_0509 {

	public static void main(String[] args) {

		/*
		 #ArrayList
		 -배열과 다르게 크기가 자동으로 조절되는 자료구조 클래스
		 -배열과 유사한 형태이기 때문에 순차적으로 데이터에 접근하기 좋다
		 -인덱스를 활용하며 ,객체의 중복 저장을 허용 
		 */
		//인터페이스 타입으로 객체 생성하는 경우가 많다.
	
			
		List<String> nick=new ArrayList<>();
		
		/*
		 배열 -> 인덱스로 해당 영역에 바로 접근 가능
		 리스트 -> 메서드로 접근(물론 인덱스를 쓰기는 하지만)
		 */
		 
		String str="야옹이";
		//add(객체) :리스트에 객체를 추가하는 메서드
		nick.add("멍멍이");
		nick.add(str);
		nick.add(new String("개구리"));
		nick.add("쨱쨲이");
//		nick.add(50); //XX String타입만 삽입 가능 
		nick.add("야옹이"); //리스트는 객체 중복 삽입을 허용한다.
		System.out.println(nick);
		
		
		//add (인덱스,객체): 특정 인덱스에 객체를 삽입하는 메서드.
		nick.add(3,"어흥이");
		System.out.println(nick);
		
		
		//get(인덱스) : 리스트 내부의 객체를 참조하는 메서드
//		String name=nick[3]; // XXX배열의 접근 방식으로 리스트는 이런 방식으로 사용하면안된다.
		String name=nick.get(3); //리스트는 이 방식으로 사용해야 한다.
		System.out.println("3번 인덱스의 값:"+name);
		
		//size() :리스트의 크기를 반환
		System.out.println("nick의 크기는"+nick.size());
		
		//set(인덱스,수정할 객체) :리스트 내부의 객체를 수정
		nick.set(2, "삐약이");
		System.out.println(nick);
		
		//remove(인덱스),remove(객체)
		nick.remove(5);
		System.out.println(nick);
		
		nick.remove(str);
		System.out.println(nick);
		
	
		//리스트의 반복문 처리  i<nick.size() 와 같음 ||특정 범위 커스텀 가능,인덱스 사용가능
		for(int i=0;i<=nick.size()-1;i++) {
			System.out.println(nick.get(i));
			
		}
		
		System.out.println("----------------------------");
		
		//향상된 for문 (=forEach) || 항상  전체의 범위  (인덱스를 알 수 없음)
		//  리스트안의 요소들을 받아들일 수 있는 요소  :배열이나 리스트의 이름
		for(String n :nick ) {
			System.out.println(n);
			
		}
		
		//contains(객체) : 리스트 내의 객체의 존재 유무룰  파악하는 메서드 : t/f
		//if 문과 함께 사용 된다 .
		System.out.println(nick.contains("삐약이"));
		System.out.println(nick.contains("메뚜기"));
	
		
		
		//clear() :리스트 내부 요소 전체 삭제 메서드
		nick.clear();
		System.out.println(nick);
		
		//isEmpty() :리스트가 비어있는지의 여부 확인 || t,f 
		System.out.println(nick.isEmpty());
		
		
		/*
		 # 컬렉션 객체들은 Collections의 기능을 사용할 수 있습니다.
		 # Collections는 컬렉션 객체들의 부가 기능들을 지원합니다.
		 */
		
		//래퍼 클래스 Byte,Short,Interger,Long,Float,Double,Boolean,Character
		List<Integer> score=new ArrayList<>();
		
		//한번에 객체 많이 추가하기
		Collections.addAll(score, 78,100,88,97,100,21,56,100);
		System.out.println(score);
		
		//컬랙션 내에서 등장 횟수 구하기
		System.out.println("100점 학생 수 : "+Collections.frequency(score,100));
		
		
		//최대값,최소값 구하기
		System.out.println("최대값:"+Collections.max(score));
		System.out.println("최소값:"+Collections.min(score));
		
		//오름차 정렬(작은값부터 순서대로 커지는 정렬)
//		Collections.sort(score);
//		System.out.println(score);
		
		//내림차 정렬(큰값부터 순서대로 작아지는 정렬)
//		Collections.reverse(score); // sort한 다음에 역순 배치 
//		System.out.println(score);
	
		
		//처음부터 내림차 정렬
		Collections.sort(score,Collections.reverseOrder());
		System.out.println(score);
		
	
		//두 요소의 위치를 교체 -swap(리시트 , i , j) 
		Collections.swap(score, 3, 7);
		System.out.println(score);
		
		
		//리스트 내부 요소를 무작위로 섞기
		Collections.shuffle(score);
		System.out.println(score);
		
		//원하는 값으로 컬렉션 초기화 ::요소의 개수는 동일하고 값을 초기화
		Collections.fill(score, 100);
		System.out.println(score);
	
	
	
	
	}
	

}
