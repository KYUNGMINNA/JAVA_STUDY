DROP TABLE members;

CREATE TABLE members(
    id VARCHAR2(30) PRIMARY KEY,
    pw VARCHAR2(30) NOT NULL,
    name VARCHAR2(30),
    email VARCHAR2(80)
);

SELECT * FROM members;
