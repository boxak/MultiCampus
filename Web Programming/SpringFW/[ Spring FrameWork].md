# [ Spring FrameWork]
-                        1998년 EJB (Enterprise Java Bean) 라는 기술의 FrameWork의 시초
-2005년 정도부터 FrameWork 기반의 개발이 주류를 이루게 된다.
                                -------------- Struts, Spring, Mybatis(iBatis), Hibernate...
                                반제품 형태의 SW -> 이걸 채워넣는 방식으로 개발 : 즉, 이미 어느 정도 완성되어 있는 걸 썼기 때문에 개발 생산성이 좋고 프레임들이 어느 정도 만든 상태기 때문에 유지 보수가 쉽다. -> 규격화된 개발
-> 개발 생산성과 유지 보수성이 높다.
-고급 API이다.
(가져다 쓰고 입맛대로 확장하고, 추가할 수 있다.)

-Mybatis : jdbc
-Spring : Mybatis보다 더 광범위하다.(Spring IoC, Spring JDBC, Spring MVC, Spring Android,Spring Hadoop)

[Spring IoC]
프로그램에서
필요한 객체 생성을 Spring FW 에서 하고 객체를 필요로 하는 곳에 주입하 는 것과 객체를 찾을 때 제
공하는 것 모두 Spring FW 이 대신 처리한다 . Spring FW 에 의해 관리되는 Java 객체를 “bean” 이라고 부르며 이
일을 담당하는 Spring FW 의 구성요서를 IoC 컨테이너라고 한다

-Eclipse EE = Eclipse for Java Developer + WTP(플러그인:plugin) -> 브라우저가 볼 수 있는 문서의 종류를 확장시켜준것. + STS 추가 설치

(1) Spring IoC -> Java Application -> SpringIoC
(2) Spring MVC --> Web 기반 -> springedu
(3) Mybatis --> Web 기반 

-Bean 이 interface를 상속하면 의존성도 덜해지고 유지보수도 편하다.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="messageBean" class="sample1.MessageBeanImpl" > //MessageBeanImpl 객체 생성
		<constructor-arg> //arg 를 안주면 무조건 arg를 안받는 생성자를 호출해버림.
			<value>strawberry</value> //strawberry를 받을 수 있는 생성자 호출
		</constructor-arg>	
		<property name="cost">
			<value>3000</value> // cost를 3000으로 setting.
		</property>
	</bean>	
</beans>
```
```xml
<bean id="foo3" class="sample2.Foo">
	<constructor-arg index="1"  type="int"  value="50"/>
	<constructor-arg index="0"  type="java.lang.String" value="xyz"/>
	<constructor-arg index="2"  type="boolean" value="true"/>
</bean>
// index 속성을 안주면 적은 순서대로 아규먼트가 전달된다.
//type : 객체 타입, value : 객체값.
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="test" class="sample4.AbstractTest" 
                          factory-method="getInstance"/>
//factory-method 를 통해 생성자 메서드가 어떤 애인지 알려준다.
</beans>
```

-DTD : 문서 타입을 정의하는 규칙
-Schema : 문서 타입과 함께 속성도 정의해놓았다.

value : 속성에 할당된 문자열 데이터를 전달
ref : 참조값을 전달.

```xml
<bean id="messageBean" class="sample6.MessageBeanImpl"  
      c:name="Dooly"   p:outputter-ref="outputRef"  
      c:(매개변수)="..."
      p:phone="123-4567" />
<bean id="outputRef" class="sample6.FileOutput"  
      p:filePath="data.txt"/>
      c:constructor-arg, p:property
```

```xml
<bean id="myProcess1"  class="sampleanno01.UserShow"  
										autowire="byName"/>
autowired="byType"  : setter
(1) 타입으로 찾아서 1개이면 해당 객체 주입
(2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생
(3) 없으면 null 주입

autowired="byName"  : setter
(1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입(타입으로 찾아서 1개 이상이면 name으로 찾는다.)
(2) 없으면 null 주입

autowired="constructor"  : constructor
(1) 타입으로 찾아서 1개이면 해당 객체 주입
(2) 타입으로 찾아서 2개 이상이면 매개변수명과 동일한 id 값을 갖는 객체 주입
(3) 없으면 null 주입
```

- Servlet에서 상속하는 부모 클래스가 누구인지?
- 쿼리문자열 추출하는 메서드가 무엇인지?
- get 과 post방식의 차이점
- http session의 역할과 보관되는 기본 시간 : 30분

			객체로 만들어서 서버에 보관한다.
			상태 정보가 유지되는 최대 시간은 요청을 보내온 브라우저가 기동되어 있는 동안이다.
			((Inactive Interval Time : 기본 30 분 ))
- getAttribute과 setAttribute의 역할

			-session.setAttribute( xxx ””, new Data()) : 보관하려 는 정보를 객체로 만들어 HttpSession
				객체에 저장한다 xxx 라는 이름으로 객체의 참조 값을 보관한다
			-session.getAttribute( xxx ) : xxx 라는 이름으로 보관된 객체의 참조 값을 리턴한다
- 3가지 스코프

			Page Scope, Request Scope, Session Scope 그리고 Application Scope
- jsp의 선언문, 표현식, 주석 태그

			<%! %> : 선언문,<%= %>:표현식,<% %>:수행문
- EL의 내장 객체 변수, param, requestScope....
- session 객체 삭제하는 메서드

			session.invalidate() : HttpSession객체를 강제로 삭제한다
- 서블릿의 수행상의 특징
- jsp에서 서블릿에서 보관한 객체 꺼내서 getter 메서드 호출하는 것, el, 수행문

			변수명 .xxx -> 변수의 참조 대상이 일반 Java 객체이면 getXxx() 를 호출한 결과가 된다

- 요청해온 클라이언트의 ip 주소 알아내는 방법

- spring IoC에 대한 문제
- setter Injection 처리할 때 사용하는 태그
property
- filter 1문제 
- page, request, application 스코프에서 객체가 언제까지 유지되는지?

			page : **page 영역은 이 때 **하나의 JSP 페이지 내에서만 객체를 공유하는 영역**을 의미**
			request : 요청이 끝나면 사라짐.
			application : ServletContext 객체에 객체를 보관하면 서버 종료시까지 이 객체를 꺼내서 사용할 수 있다. 				   이 객체는 모든 클라이언트에 의해 공유된다.
- statement preparedstatement 객체 사용할 때 어떤 것으로 해야 하는지?
- 요청되는 방식이 안맞을 때 : 405
- POM.xml
- JUnit 기술로 테스트.


### [애노테이션 구문]
-> 애노테이션 만으로 안되는 것도 있다. -> 빈으로 해야함.
```xml
<context:component-scan base-package="sampleanno03"/>
해당 패키지에 있는 모든 클래스를 스캐닝해달라는 의미.
```

필드에 설정된 @Autowired  - Spring FW 전용
(1) 타입으로 찾아서 1개이면 해당 객체 주입
(2) 타입으로 찾아서 2개 이상이면 변수명과 동일한 id 값을 갖는 객체 주입
(3) 없으면 NoSuchBeanDefinitionException 발생
     (required = false 속성을 사용하여 없으면 null 이 되게 지정 가능)
(4) @Qualifier(value="xxx")를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

필드에 설정된 @Resource  - Java
(1) 변수명과 동일한 id 값을 갖는 빈을 찾아서 해당 객체 주입
(2) 타입으로 찾아서 1개이면 객체 주입
(3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
(4) 없으면 NoSuchBeanDefinitionException 발생


### [Spring MVC]
my,.spring. ~~~ 가 controller가 된다.
src/main/webapp/resources에 html 파일을들 넣어놔야 인식한다.



![image-20200207144154420](C:\Users\student\AppData\Roaming\Typora\typora-user-images\image-20200207144154420.png)



```xml
<filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
```

```
이 내용을 넣어야 utf-8 인코딩이 이루어진다.
```

