

/*
AFTER 트리거 - INSERT , UPDATE , DELETE 작업 이후에 동작하는 트리거를 의미합니다.

BEFORE 트리거 -INSERT , UPDATE , DELETE 작업 이전에 동작하는 트리거를 의미합니다.
 
INSTEAD OF 트리거 - INSERT , UPDATE , DELETE 작업 이전에 발생하는 트리거인데 ,
                   VIEW에만 부착할 수 있다.

:OLD   =참조 전 열의 값을 지목  (INSERT : 입력 전 자료, UPDATE : 수정 전 자료,DELETE : 삭제할 값)을 지목 할 수 있음

:NEW  =참조 후 열의 값을 지목  (INSERT :입력 할 자료,UPDATE :수정 된 자료)-DELETE는 없음

*/
CREATE TABLE tbl_user(
    id VARCHAR2(20) PRIMARY KEY,
    name VARCHAR2(20),
    address VARCHAR2(30)
);

CREATE TABLE tbl_user_backup(
    id VARCHAR2(20),
    name VARCHAR2(20),
    address VARCHAR2(30),
    update_date DATE DEFAULT sysdate, -- 변경 시간 
    m_type VARCHAR2(10), -- 변경 타입
    m_user VARCHAR2(20) -- 변경한 사용자
);

--AFTER 트리거
CREATE OR REPLACE TRIGGER trg_user_backup
    AFTER UPDATE OR DELETE
    ON tbl_user
    FOR EACH ROW -- 특정행에 하려면 WHERE 쓰면 된다
DECLARE  --사용할 변수를 선언하는 곳.
    v_type VARCHAR2(10);
BEGIN
    IF UPDATING THEN --UPDATING은 시스템 자체에서 상태에 대한 내용을 지원하는 빌트인 구문.
        v_type :='수정';
    ELSIF DELETING THEN --DELETING은 시스템 자체에서 상태에 대한 내용을 지원하는 빌트인 구문.
        v_type :='삭제';
    END IF;
    
    --실행 구문 시작 (:OLD는 테이블 DELETE,UPDATE 적용 되기 전 기존 데이터.
    --즉 변경전 데이터를 집어 넣겠다.)
    INSERT INTO tbl_user_backup
    VALUES (:OLD.id,:OLD.name,:OLD.address,sysdate,v_type,USER());
    
END;

--트리거 동작 확인
INSERT INTO tbl_user VALUES('test01','admin','서울');
INSERT INTO tbl_user VALUES('test02','멍멍이','서울');
INSERT INTO tbl_user VALUES('test03','야옹이','서울');

DESC tbl_user;
SELECT * FROM tbl_user;
SELECT * FROM tbl_user_backup;

UPDATE tbl_user SET address='인천' WHERE id='test01';

DELETE FROM tbl_user WHERE id='test03';



--BEFORE 트리거
CREATE OR REPLACE TRIGGER trg_user_insert
    BEFORE INSERT 
    ON tbl_user
    FOR EACH ROW
BEGIN
    :NEW.name :=SUBSTR(:NEW.name,1,1) || '**';
END;

INSERT INTO tbl_user VALUES('test04','홍길동','부산');

SELECT * FROM tbl_user;


/*
-트리거 활용
INSERT ->주문테이블 ->주문테이블 INSERT 트리거 실행 (물픔 테이블 update)

*/

--주문 히스토리
CREATE TABLE order_history(
    history_no NUMBER(5) PRIMARY KEY,
    order_no NUMBER(5),
    product_no NUMBER(5),
    total NUMBER(10),
    price NUMBER(10)
);

--상품
CREATE TABLE product(
  
    product_no NUMBER(5)PRIMARY KEY,
    product_name VARCHAR2(20),
    total NUMBER(5),
     price NUMBER(5)
);

CREATE SEQUENCE order_history_seq NOCACHE;
CREATE SEQUENCE product_seq NOCACHE;



INSERT INTO product VALUES(product_seq.NEXTVAL,'피자',100,10000);
INSERT INTO product VALUES(product_seq.NEXTVAL,'치킨',100,15000);
INSERT INTO product VALUES(product_seq.NEXTVAL,'햄버거',100,5000);

SELECT* FROM product;

--주문 히스토리에 데이터가 들어오면 실행 //order_history insert되는 순간트리거 발생
CREATE OR REPLACE TRIGGER trg_order_history
    AFTER INSERT 
    ON order_history
    FOR EACH ROW 
DECLARE 
    v_total NUMBER;
    v_product_no NUMBER;
BEGIN
    DBMS_OUTPUT.PUT_LINE('트리거 실행!');
    SELECT :NEW.total    --주문 총량 
    INTO v_total
    FROM dual;
    
    v_product_no:= :NEW.product_no;
    
    UPDATE product SET total=total-v_total
    WHERE product_no=v_product_no;
END;


                               --history_no , order_no ,product_no ,total , price
INSERT INTO order_history VALUES(order_history_seq.NEXTVAL,200,1,5,50000);
INSERT INTO order_history VALUES(order_history_seq.NEXTVAL,200,2,1,15000);
INSERT INTO order_history VALUES(order_history_seq.NEXTVAL,200,3,10,50000);

SELECT* FROM product;
SELECT * FROM order_history;
