--1. employees 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.

DESC EMPLOYEES;

--2. departments 테이블의 구조를 파악할 수 있는 SQL 명령을 작성하시오.

DESC DEPARTMENTS;

--3. 오늘 날짜를 출력하는 SQL 명령을 작성하시오.
--날짜의 작성 형식 : 2020년 1월 2일 

SELECT TO_CHAR(SYSDATE,'YYYY"년" MM"월" DD"일"') FROM DUAL;

--4. 직원들이 총 몇명인지 출력하시오.
SELECT COUNT(*) AS "직원 수" FROM EMPLOYEES;

--5. 올해의 크리스마스가 무슨 요일인지 출력하시오.

SELECT TO_CHAR(TO_DATE('2020-12-25'),'DY"요일"') AS "크리스마스의 요일" FROM DUAL;

--6. 부서 배치가 되지 않은 직원의 id(employee_id), 이름(first_name), 해당 직원을 담당하는 매니저 ID, 매니저의 이름을 조회하여 
--다음 형식으로 출력하시오. 

--사번 사원 이름 매니저 사번 매니저 이름
---------------------------------------------------------------------
--178 Kimberely 149 Eleni 

SELECT E1.EMPLOYEE_ID AS 사번, E1.FIRST_NAME AS "사원 이름" , E1.MANAGER_ID AS "매니저 사번"
,E2.FIRST_NAME AS "매니저 이름"
FROM EMPLOYEES E1,EMPLOYEES E2
WHERE E1.MANAGER_ID=E2.EMPLOYEE_ID(+) AND E1.DEPARTMENT_ID IS NULL;


--7. 입사월 별로 직원의 최고급여를 조회하여 출력하시오. 단, 출력시 최고급여 내림차순으로 정렬되어 출력하며 최고급여가 10000 이상인 직원만 출력합니다. 

--입사월	최고급여
--------------------------
--6월 24,000원
--1월	17,000원
--9월	17,000원
---10월	14,000원
--:
--11월 10,500원

SELECT TO_CHAR(HIRE_DATE,'FMMM"월"') AS "입사월",TO_CHAR(MAX(SALARY),'999,999') || '원' AS "최고급여"
FROM EMPLOYEES
GROUP BY TO_CHAR(HIRE_DATE,'FMMM"월"')
ORDER BY "최고급여" DESC;

--8. 입사년도별 직원 수를 구하여 출력하시오. 단, 급여가 5000에서 10000 인 사이만 직원만 그리고 직원수가 7명 이상인 경우만 출력하시오. 또한 출력은 입사년도 순으로 정렬하시오.
--입사년도 조건에 맞는 직원수
-----------------------------------------------
--05	11
--06	9
--07	8

SELECT TO_CHAR(HIRE_DATE,'RR') AS 입사년도,COUNT(*) AS "조건에 맞는 직원 수"
FROM EMPLOYEES
WHERE SALARY BETWEEN 5000 AND 10000
GROUP BY TO_CHAR(HIRE_DATE,'RR')
HAVING COUNT(*)>=7
ORDER BY TO_CHAR(HIRE_DATE,'RR');

--9. 입사일이 6월인 직원의 이름(first_name), 부서이름(department_name) 및 ‘축-입사기념달’을 출력하시오. 
--직원이름 오름차순으로 정렬하여 출력 합니다.

--이름 부서이름 축하메시지
--------------------------------------------------------------
--David IT 축-입사기념달
--Donald Shipping 축-입사기념달
--   :
--William Accounting 축-입사기념달 

SELECT E.FIRST_NAME AS 이름, D.DEPARTMENT_NAME AS 부서이름, '축-입사기념달' AS "축하메시지"
FROM EMPLOYEES E,DEPARTMENTS D
WHERE E.DEPARTMENT_ID=D.DEPARTMENT_ID AND TO_CHAR(E.HIRE_DATE,'FMMM')=6
ORDER BY E.FIRST_NAME;

--10. 'Den'과 동일 부서에서 근무하는 직원들의 최대월급, 최소월급 그리고 월급의 평균을 구하시오.
--단, 평균값을 출력할때 백단위까지만 출력하시오.

--최대월급 최소월급 월급평균
---------------------------------------------------
--11000 2500 4150

SELECT MAX(SALARY) 최대월급,MIN(SALARY) 최소월급,TO_CHAR(AVG(SALARY),'999900') AS 월급평균
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE FIRST_NAME='Den');
