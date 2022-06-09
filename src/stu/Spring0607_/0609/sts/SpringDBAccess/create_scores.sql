CREATE TABLE scores(
                       stu_id NUMBER PRIMARY KEY ,
                       stu_name VARCHAR2(30) NOT NULL,
                       kor NUMBER DEFAULT 0,
                       eng NUMBER DEFAULT 0,
                       math NUMBER DEFAULT 0,
                       total NUMBER DEFAULT 0,
                       average NUMBER(5,2)
);

CREATE SEQUENCE id_seq
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000
    NOCACHE
    NOCYCLE;