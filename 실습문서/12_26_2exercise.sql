--1.  Employees ���̺��� ������ Ȯ���ϴ� ��ɾ �ۼ��ϰ� ��� ��Ī �׸��� Ÿ���� �÷����� �ִ��� Ȯ���Ͻÿ�.
DESC Employees;
--2. employees ���̺��� ��� �࿡ ���Ͽ� ��� �÷� �����͵��� �����ϴ� Query ���� �ۼ��Ͻÿ�.
select * from employees;
-- 3. employees ���̺��� ���� ID, ���� �̸�(last_name), ������ �����ϴ� Query ���� �ۼ��Ͻÿ�.
SELECT EMPLOYEE_ID, LAST_NAME, SALARY FROM EMPLOYEES;
-- 4. employees ���̺��� ������ �̸��� �� �׸��� ������ ����ϴµ� ������ ���� ������ ����Ѵ�. 
SELECT FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC;
-- 5. employees ���̺��� job_id �÷��� ���� IT_PROG �� �������� employee_id(���), job_id(����), department_id(�μ�ID) �� �����ϴ� Query �� �ۼ��Ͻÿ�.
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID='IT_PROG';
-- 6. employees ���̺��� Ŀ�̼� ����Ʈ(commission_pct)�� ������ �������� �̸��� ����Ʈ�� ����ϴ� Query ���� �ۼ��Ͻÿ�. �̸��� ������������ ����Ѵ�.
SELECT FIRST_NAME,LAST_NAME, COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL; 
-- 7. ������ SQL ���忡�� 4���� ������ ã���ÿ�

-- 8. Employees ���̺�κ��� ������ �˻������ ������ �����͸� �����ȣ�� Emp#, ��� �̸�(��)�� Employee, ������ Job, �Ի糯¥�� Hire Date�� Column Heading�� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT EMPLOYEE_ID AS "Emp#", LAST_NAME AS "Employee",JOB_ID AS "JOB", HIRE_DATE AS "Hire Date" FROM EMPLOYEES;
-- 9. ������ �˻������ �����ϵ��� Employees ���̺��� ��� ��� �����ͷκ��� ����̸��� ������ �ϳ��� �÷� ������ ����� "Employee and Title"�� �˻� ����� �����ϴ� Query�� �ۼ��Ͻÿ�
SELECT LAST_NAME ||', '|| JOB_ID AS "Employee and Title" FROM EMPLOYEES;
-- 10. ���� �˻� ���ó�� Employees ���̺�κ��� ������ 12,000 �̻��� ����� last_name�� ������ ��ȸ�ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME,SALARY FROM EMPLOYEES WHERE SALARY>=12000;
-- 11. ���� �˻� ���ó�� Employees ���̺�κ��� ������ 5,000�̻� 12,000 ������ ����� last_name�� ������ ��ȸ�ϴ� Query���� �ۼ��Ͻÿ�.
SELECT LAST_NAME,SALARY FROM EMPLOYEES WHERE SALARY>=5000 AND SALARY<=12000;
-- 12.  Employees ���̺�κ��� last_name�÷����� Matos, Taylor�� ����� ������ �Ի糯¥�� ��ȸ�ϰ�, �Ի糯¥�� ������������ Query����� �����ϴ� Query���� �ۼ��Ͻÿ�
SELECT JOB_ID, HIRE_DATE FROM EMPLOYEES WHERE LAST_NAME='Matos' OR LAST_NAME='Taylor' ORDER BY HIRE_DATE;
-- 13. ���� �˻� ���ó�� Employees ���̺�κ��� �μ���ȣ�� 20���̰ų� 50���� ����� last_name�� �μ���ȣ �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME, DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID=20 OR DEPARTMENT_ID=50;
-- 14. ���� �˻� ���ó�� Employees ���̺�κ��� ������ 5,000�̻� 12,000������ ����߿��� �μ� ��ȣ��  20���̰ų� 50���� ����� last_name�� ������  Employee�� Monthly Salary �÷� ��� ���� �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME AS "Employee",SALARY AS "Monthly Salary" FROM EMPLOYEES WHERE (SALARY>=5000 AND SALARY<=12000) AND (DEPARTMENT_ID=20 OR DEPARTMENT_ID=50);
-- 15. ���� �˻� ���ó�� Employees ���̺�κ���  2004�⿡ �Ի��� ����� �̸��� �Ի糯¥�� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE LIKE '04%';
-- 16. ���� �˻� ���ó�� Employees ���̺�� ����  �����ڰ� ���� ����� �̸��� ������ �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME, JOB_ID FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
-- 17. ���� �˻� ���ó�� Employees ���̺�κ��� Ŀ�̼��� �޴� ������� �˻��ϰ�, ���ް� Ŀ�̼��� ������������ ���ĵ� �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME,SALARY,COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL ORDER BY SALARY+COMMISSION_PCT DESC;
-- 18. ���� �˻� ���ó�� Employees ���̺�κ��� last_name�� �� ��° ���ڰ� 'a'��  �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME FROM EMPLOYEES WHERE LAST_NAME LIKE '__a%';
-- 19. ���� �˻� ���ó�� Employees ���̺�κ��� last_name�� ���ڰ� 'a'�� 'e'�� ���Ե� ��� �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�.(��a�� �� ���� ��e�� �� �ڿ�)
SELECT LAST_NAME FROM EMPLOYEES WHERE LAST_NAME LIKE '%a%e%';
-- 20. ���� �˻� ���ó�� Employees ���̺�κ��� ������ IT_PRPG �Ǵ� SA_REP�� ����� �߿��� ������ 4800, 7500, 10000�� �ƴ� ��� �����͸� �˻��ϴ� Query���� �ۼ��Ͻÿ�
SELECT LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE (JOB_ID = 'IT_PRPG' OR JOB_ID = 'SA_REP') AND (SALARY!=4800 AND SALARY!=7500 AND SALARY!=10000);
-- 21. ���� �˻� ���ó�� Employees ���̺�κ��� ������ 5,000�̻� 12,000������ ��� �߿��� �μ� ��ȣ��  20���̰ų� 80���� ��� �߿��� Ŀ�̼� ������ 20%�� ��� ����� �̸�, �޿� �� Ŀ�̼��� ����ϴ� �ϵ��� Query���� �ۼ��Ͻÿ� (�÷� ����� Employee , Monthly Salary , Commission)
SELECT LAST_NAME AS "Employee", SALARY AS "Monthly Salary", COMMISSION_PCT AS "Commission" FROM EMPLOYEES WHERE (SALARY>=5000 AND SALARY<=12000) AND (DEPARTMENT_ID=20 OR DEPARTMENT_ID=80) AND (COMMISSION_PCT=0.2);
SELECT LAST_NAME AS "Employee", SALARY AS "Monthly Salary", COMMISSION_PCT AS "Commission" FROM EMPLOYEES WHERE (SALARY BETWEEN 5000 AND 12000) AND (DEPARTMENT_ID IN(20,80)) AND (COMMISSION_PCT=0.2); 