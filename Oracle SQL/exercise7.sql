-- ��� �ǽ������� EMP�� DEPT ���̺��� ������ ������ ���� ����� �����ϰ�
-- ����� ���� Ȯ���� ���� ROLLBACK ����� �����Ѵ�.

-- [ �׽�Ʈ ���� : ��!! ]
-- ������ Ȯ��
-- �������� �䱸�Ǵ� DML �� ����
-- ������ Ȯ��
-- rollback

-- 1. EMP ���̺��� ������ȣ�� 7499���� ������ ������ 5000�޷��� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
    SET SAL=5000
    WHERE EMPNO=7499;
SELECT * FROM EMP;
ROLLBACK;

-- 2. EMP���̺��� �μ���ȣ�� 20���� �������� ������ ���� ���޿��� 10% �λ��� �ݾ����� �����Ѵ�.

SELECT * FROM EMP;
UPDATE EMP
    SET SAL=SAL+SAL*0.1
    WHERE DEPTNO=20;
SELECT * FROM EMP;
ROLLBACK;

-- 3. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 50, �μ���ġ: BOSTON,  �μ���: RESERCH

SELECT * FROM EMP;
INSERT INTO DEPT(DEPTNO,LOC,DNAME)
    VALUES(50,'BOSTON','RESERCH');
SELECT * FROM DEPT;
ROLLBACK;
-- 4. EMP ���̺� �Ʒ��� ���� �����͸� �����Ѵ�.
-- ������ȣ: 9900, �����̸�: JACKSON, ����: SALESMAN, �μ���ȣ: 10, ���� : 800

SELECT * FROM EMP;
INSERT INTO EMP(EMPNO,ENAME,JOB,DEPTNO,SAL)
    VALUES (9900,'JACKSON','SALESMAN',10,800);
SELECT * FROM EMP;
ROLLBACK;
-- 5. DEPT ���̺� �Ʒ��� �������� �����͸� �Է��Ѵ�.
-- �μ���ȣ: 60, �μ���ġ: NULL,  �μ���: MARKETING

SELECT * FROM DEPT;
INSERT INTO DEPT (DEPTNO,DNAME)
    VALUES (60,'MARKETING');
SELECT * FROM DEPT;
ROLLBACK;
-- 6. ������ȣ�� 7698���� ������ �μ���ȣ�� 7369�� ������ 
-- �μ���ȣ�� �����Ѵ�.
SELECT * FROM EMP;
UPDATE EMP
    SET DEPTNO=(SELECT DEPTNO FROM EMP WHERE EMPNO=7369)
    WHERE EMPNO=7698;
SELECT * FROM EMP;
ROLLBACK;
-- 7. 20�� �μ��� �������� ��� �����Ѵ�.

SELECT * FROM EMP;

DELETE FROM EMP
    WHERE DEPTNO=20;

SELECT * FROM EMP;
ROLLBACK;
-- 8. ������ 1000 ������ �������� �����Ѵ�.

SELECT * FROM EMP;
DELETE FROM EMP
    WHERE SAL<=1000;
SELECT * FROM EMP;
ROLLBACK;

-- 9. ������ȣ�� 7900 �� ������ ������ ���� ���޿��� 5% ������Ű��
--         �μ���ȣ�� 40���� �����Ѵ�.

SELECT * FROM EMP;
UPDATE EMP
    SET SAL=SAL+SAL*0.05,DEPTNO=40
    WHERE EMPNO=7900;
    
SELECT * FROM EMP;
ROLLBACK;

-- 10. ���縦 �������� �Ի����� 38�� �̻��� �����鿡 ���Ͽ� 
   --       ������ 2��� �����ϰ� Ŀ�̼ǵ� 3000���� �����Ѵ�.
   --      (�Ի����� �⵵�� �������� �ݿø��Ͽ� ����Ѵ�.)

SELECT * FROM EMP;
UPDATE EMP
    SET SAL=2*SAL,COMM=3000
    WHERE MONTHS_BETWEEN(SYSDATE,ROUND(HIREDATE,'YYYY'))>=38*12;
    
SELECT * FROM EMP;
ROLLBACK;
         
        