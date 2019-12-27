SELECT * FROM COURSE1;
SELECT * FROM COURSE2;
--1.1
SELECT * FROM COURSE1
INTERSECT
SELECT * FROM COURSE2;

--1.2 -> �������� �̿�
SELECT * FROM
(
    SELECT * FROM COURSE1
    UNION
    SELECT * FROM COURSE2
)
ORDER BY AGE;

--1.3
SELECT NAME FROM COURSE1
MINUS
SELECT NAME FROM COURSE2;

--1.4
SELECT NAME,PHONE FROM(
    SELECT * FROM COURSE2
    MINUS
    SELECT * FROM COURSE1
)
ORDER BY NAME;

--2
SELECT TRUNC(AVG(SAL),2) AS "���� ���" FROM EMP;

--3
SELECT SUM(COMM) FROM EMP;

--4
SELECT JOB AS "���޸�", SUM(SAL) AS "�ѿ���"
FROM EMP
GROUP BY JOB
ORDER BY SUM(SAL);

--5
SELECT NVL2(DEPTNO,TO_CHAR(DEPTNO)||''||'�� �μ�','����') AS "�μ�����"
        , COUNT(*)||''||'��' AS "��������"
FROM EMP
GROUP BY DEPTNO
ORDER BY DEPTNO DESC;

--6 
SELECT CONCAT(TO_CHAR(HIREDATE,'YYYY'),'��') AS "�Ի�⵵"
    ,CONCAT(TO_CHAR(COUNT(*)),'��') AS "�Ի� �ο���"
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'YYYY')
ORDER BY COUNT(*) DESC;

--7
SELECT TO_CHAR(SYSDATE,'YYYY"��" MM"��" DD"�� �������� "')||''||TO_CHAR(COUNT(*),'99')||''||'���� �ٹ����Դϴ�.'
FROM EMP;

--8
SELECT JOB AS ���޸�, SUM(SAL) AS �ѿ���
FROM EMP
WHERE JOB!='MANAGER'
GROUP BY JOB
HAVING SUM(SAL)>5000;

--9
SELECT JOB AS "������", ROUND(AVG(SAL+NVL(COMM,0)),2) AS "��տ���"
FROM EMP
WHERE DEPTNO=30
GROUP BY JOB;

--10
SELECT TO_CHAR(HIREDATE,'MM"��"'), COUNT(*)
FROM EMP
GROUP BY TO_CHAR(HIREDATE,'MM"��"')
HAVING COUNT(*)>=2
ORDER BY TO_CHAR(HIREDATE,'MM"��"');