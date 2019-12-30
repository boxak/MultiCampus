-- 1. DALLAS���� �ٹ��ϴ� ������ �̸�, ����, �μ��̸��� ����Ͻÿ�.
--�̸�         ����         	�μ��̸�          
---------- --------- ------------------
--SCOTT	    ANALYST	RESEARCH
--SMITH	    CLERK		RESEARCH
--JONES	    MANAGER	RESEARCH
--FORD	    ANALYST	RESEARCH      

SELECT E.ENAME "�̸�", E.JOB "����", D.DNAME "�μ��̸�"
FROM EMP E JOIN DEPT D USING(DEPTNO) 
WHERE D.LOC='DALLAS';

-- 2. �̸��� 'A'�� ���� �������� �̸��� �μ��̸��� ����Ͻÿ�.
--�̸�        �μ��̸�          
--------    --------------
--ALLEN	   SALES
--WARD	   SALES
--MARTIN   SALES
--BLAKE	   SALES
--CLARK	   ACCOUNTING
--JAMES	   SALES        

SELECT E.ENAME "�̸�", D.DNAME "�μ��̸�"
FROM EMP E JOIN DEPT D ON(E.DEPTNO=D.DEPTNO)
WHERE E.ENAME LIKE '%A%';

-- 3. �����̸��� �� ������ ���� �μ��� �μ���, �׸��� ������ 
--����ϴµ� ������ 3000�̻��� ������ ����Ͻÿ�. 
--�����̸�   �μ���               ����
---------- -------------- ----------
--SCOTT	   RESEARCH	3,000��
--KING	   ACCOUNTING	5,000��
--FORD	   RESEARCH	3,000��

SELECT E.ENAME "�����̸�", D.DNAME "�μ���", TO_CHAR(E.SAL,'999,999') "����"
FROM EMP E NATURAL JOIN DEPT D
WHERE E.SAL>=3000;

-- 4. ������ 'SALESMAN'�� �������� ������ �� �����̸�, �׸���
-- �� ������ ���� �μ� �̸��� ����Ͻÿ�. 
--����          �����̸�       �μ��̸�          
--------- ---------- --------------
--SALESMAN  TURNER     SALES         
--SALESMAN  MARTIN     SALES         
--SALESMAN  WARD       SALES         
--SALESMAN  ALLEN      SALES       

SELECT E.JOB "����", E.ENAME "�����̸�", D.DNAME "�μ��̸�"
FROM EMP E JOIN DEPT D ON(E.DEPTNO=D.DEPTNO)
WHERE E.JOB='SALESMAN';

-- 5. Ŀ�̼��� å���� �������� ������ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '������ȣ', '�����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����Ͻÿ�. 
--  ������ȣ �����̸�      ����           �Ǳ޿�       �޿����
---------- ---------- ---------- ---------- ----------
--  7521 WARD             15000         15200          2
--  7654 MARTIN          15000         15300          2
--  7844 TURNER          18000         18000          3
--  7499	ALLEN	       19200         19500	   3

SELECT E.EMPNO "������ȣ", E.ENAME "�����̸�", 12*E.SAL "����", 12*E.SAL+E.COMM "�Ǳ޿�"
, S.GRADE "�޿����"
FROM EMP E JOIN SALGRADE S ON(E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE E.COMM IS NOT NULL;

-- 6. �μ���ȣ�� 10���� �������� �μ���ȣ, �μ��̸�, �����̸�,
-- ����, �޿������ ����Ͻÿ�. 
--   �μ���ȣ �μ��̸�           �����̸�      ����           �޿����
---------- -------------- ---------- ---------- ----------
--      10 ACCOUNTING     CLARK            2450          4
--      10 ACCOUNTING     KING              5000          5
--      10 ACCOUNTING     MILLER           1300           2 

SELECT DEPTNO "�μ���ȣ", D.DNAME "�μ��̸�", E.ENAME "�����̸�", E.SAL "����", S.GRADE "�޿����"
FROM EMP E JOIN DEPT D USING(DEPTNO)
JOIN SALGRADE S ON(E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE DEPTNO=10;

-- 7. �μ���ȣ�� 10��, 20���� �������� �μ���ȣ, �μ��̸�, 
-- �����̸�, ����, �޿������ ����Ͻÿ�. �׸��� �� ��µ� 
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������ �����Ͻÿ�. (7�� ��)
--   �μ���ȣ �μ��̸�              �����̸�               ����       �޿����
---------- -------------- ---------- ---------- ----------
--    10 ACCOUNTING              KING                   5000          5
--    10 ACCOUNTING              CLARK                 2450          4

SELECT DEPTNO "�μ���ȣ",D.DNAME "�μ��̸�",E.ENAME "�����̸�",E.SAL "����",S.GRADE "�޿����"
FROM EMP E JOIN DEPT D USING(DEPTNO)
JOIN SALGRADE S ON(E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE DEPTNO IN (10,20)
ORDER BY DEPTNO,E.SAL DESC;

-- 8. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� �̸��� '����'�̶��
-- ����Ѵ�. (14��)       
--�̸�               �μ���ȣ �μ��̸�          
---------- ---------- --------------
--SCOTT             20 RESEARCH
--SMITH              20 RESEARCH      
--ALLEN              30 SALES         
--WARD               30 SALES         
      
SELECT NVL(E.ENAME,'����') "�̸�",D.DEPTNO "�μ���ȣ",D.DNAME "�μ��̸�"
FROM EMP E RIGHT OUTER JOIN DEPT D ON(E.DEPTNO=D.DEPTNO);

-- 9. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ���� �μ� ��ġ�� ������ ������  ����ϸ� �̰�� �μ���ȣ��  0 ����
-- ����Ѵ�. 

SELECT E.ENAME "�̸�", NVL(D.DEPTNO,0) "�μ���ȣ", D.DNAME "�μ��̸�"
FROM EMP E LEFT OUTER JOIN DEPT D ON(E.DEPTNO=D.DEPTNO);

--�̸�               �μ���ȣ     �μ��̸�          
---------- ---------- --------------
--MILLER		10	ACCOUNTING
--KING		10	ACCOUNTING
--CLARK		10	ACCOUNTING
--FORD		20	RESEARCH
--JONES		20	RESEARCH
--SMITH		20	RESEARCH
--SCOTT		20	RESEARCH
--JAMES		30	SALES
--TURNER	30	SALES
--BLAKE		30	SALES
--MARTIN	30	SALES
--WARD		30	SALES
--ALLEN		30	SALES
--ADAMS		0	(null)     

--10. Ŀ�̼��� ������ ��� ������ �̸�, Ŀ�̼�, �μ��̸�, ��ġ�� ��ȸ�ϴ� sql�� �ۼ��Ͻÿ�.

--ENAME           COMM        DNAME         	LOC
----------------------------------------------------
--TURNER	0	SALES		CHICAGO
--MARTIN	1400	SALES		CHICAGO
--WARD		500	SALES		CHICAGO
--ALLEN		300	SALES		CHICAGO         

SELECT E.ENAME, E.COMM, D.DNAME, D.LOC
FROM EMP E JOIN DEPT D ON(E.DEPTNO=D.DEPTNO)
WHERE E.COMM IS NOT NULL;

-- 11. DALLAS���� �ٹ��ϴ� ����� �̸�,  ����, ����� ����Ͻÿ�.
--�̸�         ����             ���          
---------- --------- --------------
--SMITH      800            1      
--JONES      2975          4   
--SCOTT	     3000	        4
--FORD       3000          4      

SELECT E.ENAME "�̸�", E.SAL "����", S.GRADE "���"
FROM EMP E JOIN DEPT D USING(DEPTNO)
JOIN SALGRADE S ON(E.SAL BETWEEN S.LOSAL AND S.HISAL)
WHERE D.LOC='DALLAS';

-- 12. ������� �̸�, �μ���ȣ, �μ��̸��� ����Ͻÿ�. 
-- ��, ������ ���� �μ��� ����ϸ� �̰�� ���� �̸��� '����?'���
-- ����Ѵ�. ���� �μ� ��ġ�� ������ ������  ����ϸ� �μ� ��ȣ�� �μ� �̸���
-- '���?' �̶�� ����Ѵ�.

SELECT NVL(E.ENAME,'����?') "�̸�",NVL(TO_CHAR(D.DEPTNO),'���?') "�μ���ȣ",NVL(D.DNAME,'���?') "�μ��̸�"
FROM EMP E FULL OUTER JOIN DEPT D ON(E.DEPTNO=D.DEPTNO);

--�̸�               �μ���ȣ �μ��̸�          
---------- ---------- --------------
--ADAMS	���?	���?
--ALLEN	30	SALES
--BLAKE	30	SALES
--CLARK	10	ACCOUNTING
--FORD	20	RESEARCH
--JAMES	30	SALES
--JONES	20	RESEARCH
--KING	10	ACCOUNTING
--MARTIN	30	SALES
--MILLER	10	ACCOUNTING
--SCOTT	20	RESEARCH
--SMITH	20	RESEARCH
--TURNER	30	SALES
--WARD	30	SALES
--����?	40	OPERATIONS  


--13. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� �������� 
--   �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
--   '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����Ͻÿ�. 
--      �����ڰ� ������ '����'�� ��� ����Ѵ�.

SELECT E1.EMPNO "�����ȣ",E1.ENAME "����̸�",NVL(TO_CHAR(E1.MGR),'����') "�����ڹ�ȣ",NVL(E2.ENAME,'����') "�������̸�"
FROM EMP E1 LEFT OUTER JOIN EMP E2 ON(E1.MGR=E2.EMPNO);

--    �����ȣ ����̸�            �����ڹ�ȣ �������̸�     
---------- ---------- ---------- ----------
--7876	ADAMS	7788	SCOTT
--7902	FORD	7566	JONES
--7788	SCOTT	7566	JONES
--7900	JAMES	7698	BLAKE
--7844	TURNER	7698	BLAKE
--7654	MARTIN	7698	BLAKE
--7521	WARD	7698	BLAKE
--7499	ALLEN	7698	BLAKE
--7934	MILLER	7782	CLARK
--7782	CLARK	7839	KING
--7698	BLAKE	7839	KING
--7566	JONES	7839	KING
--7369	SMITH	7902	FORD
--7839	KING	����	����