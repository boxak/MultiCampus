--Question 1.
SELECT INITCAP(ENAME) FROM EMP;

--Question 2.
SELECT ENAME, SUBSTR(ENAME,2,3) FROM EMP;

--Question 3.
SELECT LENGTH(ENAME) FROM EMP;

--Question 4.
SELECT LOWER(SUBSTR(ENAME,1,1)), LOWER(SUBSTR(ENAME,LENGTH(ENAME))) FROM EMP;

--Question 5.
SELECT ROUND(3456.78,1) FROM DUAL;

--Question 6.
SELECT TO_CHAR(TRUNC(SAL*50,-2),'999,999') ||''|| '��' FROM EMP;

--Question 7.
SELECT ENAME,NVL2(COMM,'����','����'),COMM FROM EMP;
SELECT * FROM EMP;
--Question 8.
SELECT ENAME, DEPTNO,DECODE(DEPTNO,
                            10,' A �μ�',
                            20,' B �μ�',
                            30,' C �μ�',
                            ' ����') AS �μ���
FROM EMP;

--Question 9.
SELECT ENAME, SAL 
FROM EMP 
WHERE JOB='SALESMAN' 
        AND SAL>=1000;
        
--Quesion 10.
SELECT SYSDATE,SYSDATE+10 FROM DUAL;

--Quesition 11.
SELECT TO_CHAR(SYSDATE,'YYYY"��" MM"��" DD"��" HH24"��" MI"��"') FROM DUAL;

--Question 12.
SELECT ENAME AS "�̸�", 
       SAL AS "���޿�", 
      (200+SAL)*12 AS "����"
    FROM EMP;
    
--Question 13.
SELECT ENAME "�̸�", SAL "����",
       CASE
        WHEN SAL<1000 THEN '  A'
        WHEN SAL>=1000 AND SAL<2000 THEN '  B'
        WHEN SAL>=2000 AND SAL<3000 THEN '  C'
        WHEN SAL>=3000 AND SAL<4000 THEN '  D'
        ELSE '  E'
    END AS �ڵ�
FROM EMP;
        
--Question 14.
SELECT ENAME AS "�̸�"
    ,DEPTNO AS "�μ���ȣ"
    ,DECODE(DEPTNO,10,'A',20,'B',30,'C',40,'E','F')
FROM EMP;

--Question 15.
SELECT ENAME FROM EMP WHERE ENAME LIKE '_A%';

--Question 16.
SELECT ENAME,
       ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE)) AS "MONTHS WORKED"
FROM EMP
ORDER BY "MONTHS WORKED";

--Question 17.
SELECT ENAME AS "����̸�",
       TO_CHAR(TRUNC(SYSDATE-HIREDATE))||''||'��' AS "�ٹ��ϼ�"
FROM EMP;

--Question 18.
SELECT ENAME, JOB, TO_DATE(HIREDATE,'YYYY/MM/DD')
FROM EMP
WHERE HIREDATE>=TO_DATE('1981-01-01','YYYY/MM/DD') AND HIREDATE<=TO_DATE('1981-12-31','YYYY/MM/DD')
ORDER BY HIREDATE;

SELECT ENAME, JOB, HIREDATE
FROM EMP
WHERE TO_CHAR(HIREDATE,'YYYY')='1981'
ORDER BY HIREDATE;

--Question 19.
SELECT TO_CHAR(TO_DATE('1995 02 04','YYYY/MM/DD'),'DY') FROM DUAL;

--Question 20.
SELECT TRUNC(MONTHS_BETWEEN(SYSDATE,TO_DATE('1995-02-04','YYYY/MM/DD'))) AS MYLIFEMONTH FROM DUAL;

--Question 21.
SELECT ENAME, SAL, NVL(TO_CHAR(COMM),'����') FROM EMP;

--Question 22.
SELECT ENAME FROM EMP WHERE ENAME LIKE 'A%' AND ENAME NOT LIKE '%N';
SELECT ENAME FROM EMP WHERE SUBSTR(ENAME,1,1)='A' AND SUBSTR(ENAME,-1,1)!='N';
--Question 23.
SELECT ENAME, HIREDATE, ROUND(HIREDATE,'YYYY') FROM EMP;