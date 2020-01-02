--1. employees ���̺��� ������ �ľ��� �� �ִ� SQL ����� �ۼ��Ͻÿ�.

DESC EMPLOYEES;

--2. departments ���̺��� ������ �ľ��� �� �ִ� SQL ����� �ۼ��Ͻÿ�.

DESC DEPARTMENTS;

--3. ���� ��¥�� ����ϴ� SQL ����� �ۼ��Ͻÿ�.
--��¥�� �ۼ� ���� : 2020�� 1�� 2�� 

SELECT TO_CHAR(SYSDATE,'YYYY"��" MM"��" DD"��"') FROM DUAL;

--4. �������� �� ������� ����Ͻÿ�.
SELECT COUNT(*) AS "���� ��" FROM EMPLOYEES;

--5. ������ ũ���������� ���� �������� ����Ͻÿ�.

SELECT TO_CHAR(TO_DATE('2020-12-25'),'DY"����"') AS "ũ���������� ����" FROM DUAL;

--6. �μ� ��ġ�� ���� ���� ������ id(employee_id), �̸�(first_name), �ش� ������ ����ϴ� �Ŵ��� ID, �Ŵ����� �̸��� ��ȸ�Ͽ� 
--���� �������� ����Ͻÿ�. 

--��� ��� �̸� �Ŵ��� ��� �Ŵ��� �̸�
---------------------------------------------------------------------
--178 Kimberely 149 Eleni 

SELECT E1.EMPLOYEE_ID AS ���, E1.FIRST_NAME AS "��� �̸�" , E1.MANAGER_ID AS "�Ŵ��� ���"
,E2.FIRST_NAME AS "�Ŵ��� �̸�"
FROM EMPLOYEES E1,EMPLOYEES E2
WHERE E1.MANAGER_ID=E2.EMPLOYEE_ID(+) AND E1.DEPARTMENT_ID IS NULL;


--7. �Ի�� ���� ������ �ְ�޿��� ��ȸ�Ͽ� ����Ͻÿ�. ��, ��½� �ְ�޿� ������������ ���ĵǾ� ����ϸ� �ְ�޿��� 10000 �̻��� ������ ����մϴ�. 

--�Ի��	�ְ�޿�
--------------------------
--6�� 24,000��
--1��	17,000��
--9��	17,000��
---10��	14,000��
--:
--11�� 10,500��

SELECT TO_CHAR(HIRE_DATE,'FMMM"��"') AS "�Ի��",TO_CHAR(MAX(SALARY),'999,999') || '��' AS "�ְ�޿�"
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'FMMM"��"')
ORDER BY "�ְ�޿�" DESC;

--8. �Ի�⵵�� ���� ���� ���Ͽ� ����Ͻÿ�. ��, �޿��� 5000���� 10000 �� ���̸� ������ �׸��� �������� 7�� �̻��� ��츸 ����Ͻÿ�. ���� ����� �Ի�⵵ ������ �����Ͻÿ�.
--�Ի�⵵ ���ǿ� �´� ������
-----------------------------------------------
--05	11
--06	9
--07	8

SELECT TO_CHAR(HIRE_DATE,'RR') AS �Ի�⵵,COUNT(*) AS "���ǿ� �´� ���� ��"
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 10000
GROUP BY TO_CHAR(HIRE_DATE,'RR')
HAVING COUNT(*)>=7
ORDER BY TO_CHAR(HIRE_DATE,'RR');

--9. �Ի����� 6���� ������ �̸�(first_name), �μ��̸�(department_name) �� ����-�Ի���ޡ��� ����Ͻÿ�. 
--�����̸� ������������ �����Ͽ� ��� �մϴ�.

--�̸� �μ��̸� ���ϸ޽���
--------------------------------------------------------------
--David IT ��-�Ի����
--Donald Shipping ��-�Ի����
--   :
--William Accounting ��-�Ի���� 

SELECT E.FIRST_NAME AS �̸�, D.DEPARTMENT_NAME AS �μ��̸�, '��-�Ի����' AS "���ϸ޽���"
FROM EMPLOYEES E,DEPARTMENTS D
WHERE E.DEPARTMENT_ID=D.DEPARTMENT_ID AND TO_CHAR(E.HIRE_DATE,'FMMM')=6
ORDER BY E.FIRST_NAME;

--10. 'Den'�� ���� �μ����� �ٹ��ϴ� �������� �ִ����, �ּҿ��� �׸��� ������ ����� ���Ͻÿ�.
--��, ��հ��� ����Ҷ� ����������� ����Ͻÿ�.

--�ִ���� �ּҿ��� �������
---------------------------------------------------
--11000 2500 4150

SELECT MAX(SALARY) �ִ����,MIN(SALARY) �ּҿ���,TO_CHAR(AVG(SALARY),'999900') AS �������
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE FIRST_NAME='Den');
