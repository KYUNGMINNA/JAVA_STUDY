package kr.co.jsp.score.model;

/*
 
CREATE TABLE scores(
    id NUMBER PRIMARY KEY,
    name VARCHAR2(30) NOT NULL,
    kor NUMBER(3) DEFAULT 0,
    eng NUMBER(3) DEFAULT 0,
    math NUMBER(3) DEFAULT 0,
    total NUMBER(3) DEFAULT 0,
    average NUMBER(5,2)
);

CREATE SEQUENCE id_seq 
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCACHE
    NOCYCLE;
 
*/



public class ScoreVO_10_0512 {

	//자바빈 클래스란 데이터베이스와의 반복적인 작업을 쉽게 처리하기 위해 디자인 하는 클래스
	
	//자바빈 클래스는 은닉(캡슐화)을 사용하여 설계합니다.
	
	//자바빈 클래스는 데이터베이스의 컬럼과 1:1로 매칭되는 멤버변수를 선언(개수 동일하게)
	
	//컬럼 이름과  동일하게 작성하는것이 편하다.
	private int id;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private double average;
	
	//자바빈 클래스는 일반적으로 기본 생성자(필수임 - 매가값 하나도 없는것) 와 
	//모든 필드값을 매개값으로 받는 생성자(이것은 선택사항)을 하나씩 제작해 줍니다.
	
	//항상 모든 값을 주면서 객체를 초기화 할 필요가 없을 때도 있어서
	//기본 생성자를  작성해두고 , setter로  필요한 것만 초기화 한다.
	
	//기본생성자 
	public ScoreVO_10_0512() {
	}

	public ScoreVO_10_0512(int id, String name, int kor, int eng, int math, int total, double average) {
		super();
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
		this.average = average;
	}

	//직접 객체 접근을 막게 하기 위해 get,set 메서드 작성
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public double getAverage() {
		return average;
	}

	public void setAverage(double average) {
		this.average = average;
	}
	
	
	
	
	
}
