--1.  Employees 테이블의 구조를 확인하는 명령어를 작성하고 어떠한 명칭 그리고 타입의 컬럼들이 있는지 확인하시오.
DESC Employees;
--2. employees 테이블의 모든 행에 대하여 모든 컬럼 데이터들을 추출하는 Query 문을 작성하시오.
select * from employees;
-- 3. employees 테이블에서 직원 ID, 직원 이름(last_name), 월급을 추출하는 Query 문을 작성하시오.
SELECT EMPLOYEE_ID, LAST_NAME, SALARY FROM EMPLOYEES;
-- 4. employees 테이블에서 직원의 이름과 성 그리고 월급을 출력하는데 월급이 많은 순으로 출력한다. 
SELECT FIRST_NAME, LAST_NAME, SALARY FROM EMPLOYEES ORDER BY SALARY DESC;
-- 5. employees 테이블에서 job_id 컬럼의 값이 IT_PROG 인 직원들의 employee_id(사번), job_id(직무), department_id(부서ID) 를 추출하는 Query 를 작성하시오.
SELECT EMPLOYEE_ID, JOB_ID, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID='IT_PROG';
-- 6. employees 테이블에서 커미션 포인트(commission_pct)가 정해진 직원들의 이름과 포인트를 출력하는 Query 문을 작성하시오. 이름의 오름차순으로 출력한다.
SELECT FIRST_NAME,LAST_NAME, COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL; 
-- 7. 다음은 SQL 문장에서 4개의 에러를 찾으시오

-- 8. Employees 테이블로부터 다음의 검색결과와 동일한 데이터를 사원번호는 Emp#, 사원 이름(성)는 Employee, 직무는 Job, 입사날짜는 Hire Date로 Column Heading을 검색하는 Query문을 작성하시오
SELECT EMPLOYEE_ID AS "Emp#", LAST_NAME AS "Employee",JOB_ID AS "JOB", HIRE_DATE AS "Hire Date" FROM EMPLOYEES;
-- 9. 다음의 검색결과와 동일하도록 Employees 테이블의 모든 사원 데이터로부터 사원이름과 직무를 하나의 컬럼 값으로 헤딩은 "Employee and Title"로 검색 결과를 생성하는 Query를 작성하시오
SELECT LAST_NAME ||', '|| JOB_ID AS "Employee and Title" FROM EMPLOYEES;
-- 10. 다음 검색 결과처럼 Employees 테이블로부터 월급이 12,000 이상인 사원의 last_name과 월급을 조회하는 Query문을 작성하시오
SELECT LAST_NAME,SALARY FROM EMPLOYEES WHERE SALARY>=12000;
-- 11. 다음 검색 결과처럼 Employees 테이블로부터 월급이 5,000이상 12,000 이하인 사원의 last_name과 월급을 조회하는 Query문을 작성하시오.
SELECT LAST_NAME,SALARY FROM EMPLOYEES WHERE SALARY>=5000 AND SALARY<=12000;
-- 12.  Employees 테이블로부터 last_name컬럼값이 Matos, Taylor인 사원의 직무와 입사날짜를 조회하고, 입사날짜의 오름차순으로 Query결과를 생성하는 Query문을 작성하시오
SELECT JOB_ID, HIRE_DATE FROM EMPLOYEES WHERE LAST_NAME='Matos' OR LAST_NAME='Taylor' ORDER BY HIRE_DATE;
-- 13. 다음 검색 결과처럼 Employees 테이블로부터 부서번호가 20번이거나 50번인 사원의 last_name과 부서번호 데이터를 검색하는 Query문을 작성하시오
SELECT LAST_NAME, DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID=20 OR DEPARTMENT_ID=50;
-- 14. 다음 검색 결과처럼 Employees 테이블로부터 월급이 5,000이상 12,000이하인 사원중에서 부서 번호가  20번이거나 50번인 사원의 last_name과 월급을  Employee와 Monthly Salary 컬럼 헤딩 으로 데이터를 검색하는 Query문을 작성하시오
SELECT LAST_NAME AS "Employee",SALARY AS "Monthly Salary" FROM EMPLOYEES WHERE (SALARY>=5000 AND SALARY<=12000) AND (DEPARTMENT_ID=20 OR DEPARTMENT_ID=50);
-- 15. 다음 검색 결과처럼 Employees 테이블로부터  2004년에 입사한 사원의 이름과 입사날짜를 검색하는 Query문을 작성하시오
SELECT LAST_NAME, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE LIKE '04%';
-- 16. 다음 검색 결과처럼 Employees 테이블로 부터  관리자가 없는 사원의 이름과 직무를 검색하는 Query문을 작성하시오
SELECT LAST_NAME, JOB_ID FROM EMPLOYEES WHERE MANAGER_ID IS NULL;
-- 17. 다음 검색 결과처럼 Employees 테이블로부터 커미션을 받는 사원들을 검색하고, 월급과 커미션의 내림차순으로 정렬된 데이터를 검색하는 Query문을 작성하시오
SELECT LAST_NAME,SALARY,COMMISSION_PCT FROM EMPLOYEES WHERE COMMISSION_PCT IS NOT NULL ORDER BY SALARY+COMMISSION_PCT DESC;
-- 18. 다음 검색 결과처럼 Employees 테이블로부터 last_name의 세 번째 문자가 'a'인  데이터를 검색하는 Query문을 작성하시오
SELECT LAST_NAME FROM EMPLOYEES WHERE LAST_NAME LIKE '__a%';
-- 19. 다음 검색 결과처럼 Employees 테이블로부터 last_name의 문자가 'a'와 'e'가 포함된 사원 데이터를 검색하는 Query문을 작성하시오.(‘a’ 가 먼저 ‘e’ 가 뒤에)
SELECT LAST_NAME FROM EMPLOYEES WHERE LAST_NAME LIKE '%a%e%';
-- 20. 다음 검색 결과처럼 Employees 테이블로부터 직무가 IT_PRPG 또는 SA_REP인 사원들 중에서 월급이 4800, 7500, 10000이 아닌 사원 데이터를 검색하는 Query문을 작성하시오
SELECT LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE (JOB_ID = 'IT_PRPG' OR JOB_ID = 'SA_REP') AND (SALARY!=4800 AND SALARY!=7500 AND SALARY!=10000);
-- 21. 다음 검색 결과처럼 Employees 테이블로부터 월급이 5,000이상 12,000이하인 사원 중에서 부서 번호가  20번이거나 80번인 사원 중에서 커미션 비율이 20%인 모든 사원의 이름, 급여 및 커미션을 출력하는 하도록 Query문을 작성하시오 (컬럼 헤딩은 Employee , Monthly Salary , Commission)
SELECT LAST_NAME AS "Employee", SALARY AS "Monthly Salary", COMMISSION_PCT AS "Commission" FROM EMPLOYEES WHERE (SALARY>=5000 AND SALARY<=12000) AND (DEPARTMENT_ID=20 OR DEPARTMENT_ID=80) AND (COMMISSION_PCT=0.2);
SELECT LAST_NAME AS "Employee", SALARY AS "Monthly Salary", COMMISSION_PCT AS "Commission" FROM EMPLOYEES WHERE (SALARY BETWEEN 5000 AND 12000) AND (DEPARTMENT_ID IN(20,80)) AND (COMMISSION_PCT=0.2); 