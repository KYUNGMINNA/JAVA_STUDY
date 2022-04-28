
--테이블 생성과 제약조건

-- 테이블 열레벨 제약 조건 ( PRIMARY KEY ,UNIQUE ,NOT NULL ,FOREIGN KEY )
-- CHECK는  테이블 열레벨 제약 조건 XXXX

-- PRIMARY KEY:테이블의 고유 식별 컬럼입니다(=주요 키) :(UNIQUE + NOT NULL) 기능 유사
-- UNIQUE : 유일한 값을 갖게 하는 컬럼 (중복값 방지)
-- NOT NULL : null을 허용하지 않음.
-- FOREIGN KEY : 참조하는 테이블의 PRIMARY KEY를 저장하는 컬럼 (테이블 간 관계를 맺어줌)
-- CHECK : 정의된 형식만 저장되도록 허용.=제약조건을 커스텀

DROP TABLE dept2;

--테이블 열레벨 제약 조건 
--NOT NULL은 이름 지정 하지 않는게 관례 
CREATE TABLE dept2(    --제약조건   제약조건이름      제약조건종류
    dept_no NUMBER(2) CONSTRAINT dept2_deptno_pk PRIMARY KEY,
    dept_name VARCHAR2(14) NOT NULL CONSTRAINT dept2_deptname_uk UNIQUE,
                                        
                            --REFERENCES 테이블(컬럼명) =참조한다
                            --참조하는 대상 컬럼의 제약조건이 FOREIGN KEY다. = 
                         --참조하는 테이블과  dept2테이블이 관계를 갖게됨(수정,삭제 제한)
    loca NUMBER(4) CONSTRAINT dept2_loca_locid_fk REFERENCES locations(location_id),
    dept_bonus NUMBER(10),
    dept_gender VARCHAR2(1) CONSTRAINT dept2_deptgender_ck CHECK(dept_gender IN ('M','F'))
);

--테이블레벨 제약조건(모든 열 선언 후 제약조건을 취하는 방식)
CREATE TABLE dept2(
    dept_no NUMBER(2),
    dept_name VARCHAR(14) NOT NULL,
    loca NUMBER(4),
    dept_date DATE,
    dept_bonus NUMBER(10),
    dept_gender VARCHAR(1),
    
    CONSTRAINT dept2_deptno_pk PRIMARY KEY(dept_no),
    CONSTRAINT dept2_deptname_uk UNIQUE(dept_name),
    CONSTRAINT dept2_loca_locid_fk FOREIGN KEY(loca) REFERENCES locations(location_id),
    CONSTRAINT dept2_deptedate_uk UNIQUE(dept_date),
    CONSTRAINT dept2_gender_ck CHECK(dept_gender IN ('M','F'))
);

--외래키(FOREIGN KEY)가 부모테이블에  없다면 INSERT가 불가능
INSERT INTO dept2 VALUES(10,'gg',4000,sysdate,100000,'M'); -- 에러 

--외래키가 부모테이블에 있다면 INSERT 가능
INSERT INTO dept2 VALUES(30,'hh',1800,sysdate,100000,'M'); --OK

--외래키(FOREIGN KEY)가 부모테이블에  없다면 UPDATE 불가능
UPDATE dept2 SET loca=4000 WHERE loca=1800;--에러

SELECT * FROM dept2;

--외래키 제약 조건 위반 : dept2가 참조하고 있는 테이블이의 컬럼이라서 수정 불가능
UPDATE locations SET location_id=4000 WHERE location_id=1800;--에러


--제약조건 변경
--제약 조건은 추가,삭제가 가능합니다. 변경은 안됩니다.
--변경하려면 삭제하고 새로운 내용으로 추가 해야 한다.
DROP TABLE dept2;

CREATE TABLE dept2(
    dept_no NUMBER(2),
    dept_name VARCHAR(14) NOT NULL,
    loca NUMBER(4),
    dept_date DATE,
    dept_bonus NUMBER(10),
    dept_gender VARCHAR(1)
); 
--PK 추가
ALTER TABLE dept2 ADD CONSTRAINT dept_no_pk PRIMARY KEY(dept_no);
--FK 추가
ALTER TABLE dept2 ADD
CONSTRAINT dept_loca_fk FOREIGN KEY(loca) REFERENCES locations(location_id);
--CHECK 추가
ALTER TABLE dept2 ADD 
CONSTRAINT dept2_gender_ck CHECK(dept_gender IN ('M','F'));
--UNIQUE 추가
ALTER TABLE dept2 ADD CONSTRAINT dept2_deptedate_uk UNIQUE(dept_date);

--NOT NULL추가 : NOT NULL은 열 수정형태로 변경합니다.
ALTER TABLE dept2 MODIFY dept_date DATE NOT NULL;

--제약 조건 삭제(제약 조건 이름으로)
ALTER TABLE dept2 DROP CONSTRAINT dept_no_pk;

--제약 조건 확인
SELECT * FROM user_constraints
WHERE table_name='DEPT2';

-----------------------
--문제1
CREATE TABLE members(
    m_name VARCHAR2(4000) NOT NULL,
    m_num NUMBER(1) CONSTRAINT mem_memnum_pk PRIMARY KEY,
    reg_date DATE NOT NULL CONSTRAINT mem_regdate_uk UNIQUE,
    gender VARCHAR2(1),
    loca NUMBER(4) CONSTRAINT mem_loca_loc_locid_fk REFERENCES locations(location_id)    
);

SELECT * FROM user_constraints
WHERE table_name='MEMBERS';


INSERT INTO members VALUES('AAA',1,'2018-07-01','M',1800);
INSERT INTO members VALUES('BBB',2,'2018-07-02','F',1900);
INSERT INTO members VALUES('CCC',3,'2018-07-03','M',2000);
INSERT INTO members VALUES('DDD',4,sysdate,'M',2000);

select * FROM members;
commit;

select * from locations;

--문제2
SELECT 
    m.m_name,m.m_num,
    loc.street_address,loc.location_id
FROM members m
JOIN locations loc
ON  m.loca=loc.location_id
ORDER BY m_num ASC;
