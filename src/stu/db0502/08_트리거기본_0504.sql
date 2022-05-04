

/*
trigger는 테이블에 부착한 형태로써 ,INSERT , UPDATE ,DELETE 작업이 수행될 때
특정 코드가 작동되도록 하는 구문입니다.


*/

CREATE TABLE tbl_test(
    id NUMBER(10),
    text VARCHAR(20)
);

CREATE OR REPLACE TRIGGER trg_test
    AFTER DELETE OR UPDATE --삭제 ,수정 이후에 동작
    ON tbl_test  --부착할 테이블 이름 작성
    FOR EACH ROW  --각 행에 모두 적용
BEGIN
    DBMS_OUTPUT.PUT_LINE('트리거가 동작함!');  --트리거가 실행되는 코드를 
                                            --BEGIN ~END에 넣음.
END;


INSERT INTO tbl_test VALUES(1,'홍길동');  --트리거 조건에 의해 동작 안함.
UPDATE tbl_test SET text='홍길동2' WHERE id=1;  -- 트리거가 조건에 의해 동작함!
DELETE FROM tbl_test WHERE id=1; -- 트리거가 조건에 의해 동작함!!
