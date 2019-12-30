-- 1. 'DALLAS'���� �ٹ��ϴ� ������ �̸�, ����, �μ���ȣ�� ����Ͻÿ�.
--�̸�         ����         �μ���ȣ              
---------- --------- ----------
--SCOTT	   ANALYST	20
--SMITH	   CLERK		20
--JONES	   MANAGER	20
--FORD	   ANALYST	20
SELECT * FROM DEPT;

SELECT ENAME �̸�, JOB ����, DEPTNO �μ���ȣ
FROM EMP
WHERE DEPTNO=(SELECT DEPTNO FROM DEPT WHERE LOC='DALLAS');

--2. 'SMITH'���� ������ ���� �޴� �������� �̸��� ���� �׸��� �μ����� ����Ѵ�.

SELECT ENAME ������, SAL �޿�, DNAME �μ���
FROM EMP,DEPT
WHERE EMP.DEPTNO=DEPT.DEPTNO AND SAL>(SELECT SAL FROM EMP WHERE ENAME='SMITH');

--������               �޿�             �μ���         
---------- ---------- ------------
--SCOTT		3000	RESEARCH
--ALLEN		1600	SALES
--WARD		1250	SALES
--JONES		2975	RESEARCH
--MARTIN	1250	SALES
--BLAKE		2850	SALES
--CLARK		2450	ACCOUNTING
--KING		5000	ACCOUNTING
--TURNER	1500	SALES
--JAMES		950	SALES
--FORD		3000	RESEARCH
--MILLER		1300	ACCOUNTING


--3. 30�� �μ��� ������� ������ �ؿ� �Ի��� �������� �̸�, ����, 
--   �μ���ȣ �׸��� �Ի�⵵�� ����Ѵ�.(30���μ� �����ϰ�)
--Ename        Sal            DeptNo         HireYear
---------- ---------- ---------- ----------
--FORD	   3000	       20		1981
--KING	   5000	       10		1981
--CLARK	   2450	       10		1981
--JONES	   2975	       20		1981

SELECT ENAME,SAL,DEPTNO,TO_CHAR(HIREDATE,'  YYYY') AS "HireYear"
FROM EMP
WHERE DEPTNO!=30 AND
TO_CHAR(HIREDATE,'YYYY') IN(SELECT TO_CHAR(HIREDATE,'YYYY') FROM EMP WHERE DEPTNO=30);

--4. 'BLAKE'�� ���� �μ��� �ִ� �������� �̸��� �Ի����� �̴µ� 'BLAKE'�� ���� ����Ѵ�. 
--ENAME      HIREDATE
---------- --------
--JAMES	     81/12/03
--TURNER     81/09/08
--BLAKE	     81/05/01
--MARTIN     81/09/28
--WARD	     81/02/22
--ALLEN	     81/02/20

SELECT ENAME,HIREDATE 
FROM EMP
WHERE ENAME!='BLAKE'
AND DEPTNO=(SELECT DEPTNO FROM EMP WHERE ENAME='BLAKE');

--5. ��ձ޿����� ���� �޿��� �޴� �������� ������ȣ, �̸�, ������
-- ����ϵ�, ������ ���� ��� ������ ����Ѵ�.
--  EMPNO ENAME    SAL
---------- ------ ----------
--7839	KING	5,000��
--7788	SCOTT	3,000��
--7902	FORD	3,000��
--7566	JONES	2,975��
--7698	BLAKE	2,850��
--7782	CLARK	2,450��

SELECT EMPNO, ENAME, CONCAT(TO_CHAR(SAL,'999,999'),'��') AS "SAL"
FROM EMP
WHERE SAL>(SELECT AVG(SAL) FROM EMP);

--6. �̸��� 'T'�� �����ϰ� �ִ� ������� ���� �μ����� �ٹ��ϰ�
--   �ִ� ������ ������ȣ�� �̸��� ����Ѵ�.

SELECT EMPNO, ENAME
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE ENAME LIKE '%T%');

--EMPNO ENAME     
---------- ----------
--7902	FORD
--7566	JONES
--7369	SMITH
--7788	SCOTT
--7900	JAMES
--7844	TURNER
--7698	BLAKE
--7654	MARTIN
--7521	WARD
--7499	ALLEN  

--7 �޿��� ��ձ޿����� ����,�̸��� S�ڰ� ���� ������ ������
--  �μ����� �ٹ��ϴ� ��� ������ ������ȣ,�̸� �� �޿��� ����Ͻÿ�.
--EMPNO      ENAME      SAL
----------  --------  -------
--7902	     FORD	      3000
--7566	     JONES      2975
--7788	     SCOTT      3000
--7698	     BLAKE      2850

SELECT EMPNO, ENAME, SAL
FROM EMP
WHERE DEPTNO IN(SELECT DEPTNO FROM EMP WHERE SAL>AVG(SAL) AND ENAME LIKE '%S');

--8. 30�� �μ��� �ִ� ������ �߿��� ���� ���� ������ �޴� ��������
--   ���� ������ �޴� �������� �̸�, �μ���ȣ, ������ ����Ѵ�. 
--   (��, ALL �Ǵ� ANY �����ڸ� ����� ��)
--  �̸�    �μ���ȣ   ����
--------------------------------
--JONES	20	2975
--SCOTT	20	3000
--FORD	20	3000
--KING	10	5000

--9. SALES �μ����� ���ϴ� �������� �μ���ȣ, �̸�, ������ ����Ѵ�.
--DEPTNO    ENAME       JOB      
---------- ---------- ---------
--30�� �μ�  ALLEN	       SALESMAN
--30�� �μ�  WARD	       SALESMAN
--30�� �μ�  MARTIN      SALESMAN
--30�� �μ�  BLAKE	       MANAGER
--30�� �μ�  TURNER      SALESMAN
--30�� �μ�  JAMES	       CLERK
 

--10. 'KING'���� �����ϴ� ��� ������ �̸��� �޿��� ����Ѵ�. 
--     (KING���� �����ϴ� �����̶� mgr�� KING�� ������ �ǹ���) 
--�̸�         �Ի糯¥
---------- ----------
--JONES	   1981�� 04�� 02��
--BLAKE	   1981�� 05�� 01��
--CLARK	   1981�� 06�� 09��