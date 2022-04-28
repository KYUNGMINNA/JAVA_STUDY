
--사용자 계정 확인
SELECT* FROM all_users;

--계정 생성 명령  ::system 관리자 계정으로 접속하여 계정을 생성하였음 
          --아이디              --비밀번호 
CREATE USER user1 IDENTIFIED BY user1;

--DCL : GRANT(권한 부여),REVOKE(권한 회수)

/*
CREATE USER -> 데이터베이스 유저 생성 권한
CREATE SESSION ->데이터베이스 접속 권한 
CREATE TABLE ->테이블 생성 권한
CREATE VIEW ->뷰 생성 권한
CREATE SEQUENCE ->시퀀스 생성 권한

ALTER ANY TABLE ->어떠한 테이블도 수정할 수 있는 권한
INSERT ANY TABLE ->어떠한 테이블에도 데이터를 삽입하는 권한
SELECT ANY TABLE...

SELECT ON [테이블 이름 ] TO [유저 이름] ->특정 테이블만 조회할 수 있는 권한
INSERT ON ...
UPDATE ON ...

--관리자에 준하는 권한을 부여하는 구문 
RESOURCE, CONNECT , DBA TO [유저 이름] --모든 권한 부여 
*/
--DB접속 권한 주기
GRANT CREATE SESSION TO user1;

GRANT SELECT ON hr.employees TO user1;

--관리자에 준하는 권한 획득
GRANT CONNECT,RESOURCE TO user1; 

CREATE TABLE t_test(
    bno NUMBER(3)
);

CREATE SEQUENCE t_test_seq;

INSERT INTO t_test VALUES(t_test_seq.NEXTVAL);

SELECT * FROM t_test;


--권한 뺏기
REVOKE CONNECT,RESOURCE FROM user1;


--사용자 계정 삭제 
--DROP USER [유저 이름] CASCADE;
--CASCADE 없을 시 --> 테이블 시퀀스 존재한다면(즉 데이터있으면) 계정 삭제 안됨.
DROP USER user1 CASCADE;


/*
테이블 스페이스는 데이터베이스 객체 내 실제 데이터가 저장되는 공간입니다.
테이블 스페이스를 생성하면 지정된 경로에 실제 파일로 정의한 용량만큼의 
파일이 생성이 되고,데이터가 물리적으로 저장됩니다.
당연히 테이블 스페이스의 용량을 초과한다면 프로그램이 비정상적으로 동작합니다.

*/

SELECT * FROM dba_tablespaces;

--USERS 테이블 스페이스를 기본 사용 공간으로 지정 
ALTER USER user1 DEFAULT TABLESPACE users
QUOTA UNLIMITED ON users;

