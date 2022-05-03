
--1.모든 구구단을 출력하는 익명 블록을 만드세요.(2단~9단)

DECLARE 
BEGIN
    FOR i IN 2..9
    LOOP
        FOR j IN 1..9
        LOOP
            DBMS_OUTPUT.PUT_LINE( i || 'x' || j || '=' || i*j);
        END LOOP;
    END LOOp;
END;


-- 2. INSERT를 300번 실행하는 익명 블록을 처리하세요.
-- board라는 이름의 테이블을 만드세요. (bno writer title 컬럼이 존재한다.)
-- bno는 SEQUENCE로 올려 주시고, writer와 title에 번호를 붙여서 INSERT 진행해 주세요.
-- ex) 1, test1, title1 -> 2 test2 title2 -> 3 test3 title3...
-- bno 시퀀스로 올리고 , INSERT 300번 진행 

CREATE TABLE board(
    bno NUMBER,
    writer VARCHAR2(30),
    title VARCHAR2(30)
);

CREATE SEQUENCE board_seq
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;
    
DROP SEQUENCE board_seq;

DECLARE
BEGIN
    FOR i in 1..300
    LOOP 
        INSERT INTO board VALUES(board_seq.nextval,'test'||i,'title'||i);
    END LOOP;
END;

SELECT * FROM board;
