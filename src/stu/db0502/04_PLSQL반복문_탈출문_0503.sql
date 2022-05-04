--WHILE 문

DECLARE
    v_num NUMBER :=3;
    V_count NUMBER :=1;
    
BEGIN
    WHILE v_count<=10
    LOOP 
        DBMS_OUTPUT.PUT_LINE(v_num);
        V_count:=v_count + 1;
    END LOOP;
END;

--탈출문
DECLARE
    v_num NUMBER :=3;
    V_count NUMBER :=1;
    
BEGIN
    WHILE v_count<=10
    LOOP 
        DBMS_OUTPUT.PUT_LINE(v_num);
        EXIT WHEN v_count=5;
        V_count:=v_count + 1;
    END LOOP;
END;

--FOR문
DECLARE 
    v_num NUMBER :=3;
BEGIN
    FOR i IN 1..9 --.을 두개 작성해서 범위를 표현. 1<=i<=9
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_num || 'x'|| i || '=' || v_num*i);
    END LOOP;
END;

--CONTINUE문
DECLARE 
    v_num NUMBER :=3;
BEGIN
    FOR i IN 1..9 --.을 두개 작성해서 범위를 표현. 1<=i<=9
    LOOP
        CONTINUE WHEN i=5;
        DBMS_OUTPUT.PUT_LINE(v_num || 'x'|| i || '=' || v_num*i);
    END LOOP;
END;
