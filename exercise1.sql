--1. ��� ���̺��� ����Ʈ�� ����Ͻÿ�.
select * from tab;
--2. emp ���̺�� dept ���̺��� ������ ����Ͻÿ�.
desc emp;
desc dept;
--3. ���(emp)���̺��� ��� �����͸� ����Ͻÿ�.
select * from emp;
--4. ������̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
select EMPNO,ENAME,SAL from emp;
--5. ������̺��� ���޿��� �̴µ� �ߺ��� �����Ͱ� ���� ����Ͻÿ�.
select distinct SAL from emp;
--6. ������̺��� ����̸��� ������ ����ϴµ� ������ �÷�����
-- "�� ��","�� ��"���� �ٲ㼭 ����Ͻÿ�. ��, ALIAS�� ���� �߰�
select ename as "�� ��", sal as "�� ��" from emp; 
--7. ������̺��� ����̸�, ������ �̰�, ���ް� Ŀ�̼���  ���� ����
-- ����ϴµ� �÷����� '�Ǳ޿�'�̶�� �ؼ� ����Ͻÿ�.
-- ��, NULL���� ��Ÿ���� �ʰ� �Ͻÿ�.(Ŀ�̼� �ȹ޴»������)
select ename, sal, sal+comm as "�Ǳ޿�" from emp where comm is not null;
--8. ������̺��� 'SCOTT'�̶�� ����� �����ȣ, �̸�, ������ ����Ͻÿ�.
select EMPNO,ENAME,SAL from emp where ENAME='FORD';
--9. ������̺��� ������ 'SALESMAN'�� ����� �����ȣ, �̸�, ������
-- ����Ͻÿ�.
select EMPNO,ENAME,job from emp where job='SALESMAN';
--10. ������̺��� �����ȣ�� 7499, 7521, 7654�� ����� �����ȣ, �̸�
-- ������ ����Ͻÿ�.
select EMPNO,ENAME,SAL from emp where EMPNO=7499 OR EMPNO=7521 OR EMPNO=7654;
--11. ������̺��� ������ 1500���� 3000������ ����� �����ȣ, �̸�,
-- ������ ����Ͻÿ�.
select EMPNO,ENAME,SAL from emp where SAL>=1500 AND SAL<=3000;
--12. ��� ���̺��� �Ŵ����� ���� ������ �̸��� ����Ͻÿ�.
select ENAME from emp where MGR IS NULL;
--13. ������̺��� ������ ���� ������ ��� ������ ����Ͻÿ�.
select * from emp order by SAL desc;
--14. ������̺��� ������ �̸��� �Ի����� ����ϴµ� �ֱٿ� �Ի��� ������ ����Ͻÿ�.
select ename,hiredate from emp order by hiredate desc;
--15. ��� ���̺��� 30�� �μ��� �ٹ��ϴ� �������� �̸��� ����ϴµ�
-- �Ի����� ������ ������ ����Ͻÿ�.
select ename from emp where deptno = 30 order by hiredate asc;