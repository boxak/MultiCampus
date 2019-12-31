/*���� ���ϸ� : exercise8.sql
 jdbctest ��� ����ڷ� �����ؼ� �� ���̺���� �����Ѵ�.
/*
1. ���̺�� : visitor
    �÷� ��� : name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
                   writedate - ��¥�� �ð��� ������ �� �ְ� 
                   memo - �ѱ� �������� �ִ� 60�ڸ� ������ �� �ְ�
                   [visitor ���̺� �����͸� 3�� ���� �Է�]
	      ��¥ ������ : 1�� : ����ð�,  
                                      1�� : 2017�� 12�� 25��, 
                                      1�� : 1999�� 8�� 11��
                                      
*/

CREATE TABLE VISITOR(
    NAME VARCHAR2(18) NOT NULL,
    WRITEDATE DATE DEFAULT SYSDATE,
    MEMO VARCHAR2(180)
);

INSERT INTO VISITOR(NAME,MEMO)
    VALUES('Ȳ����','�Դ� ��.');
INSERT INTO VISITOR(NAME,WRITEDATE,MEMO)
    VALUES ('�����',TO_DATE('171225','RRMMDD'),'�ٶ�ó�� ���İ���');
INSERT INTO VISITOR(NAME,WRITEDATE,MEMO)
    VALUES ('ȣ����',TO_DATE('990811','RRMMDD'),'ȣ�����̾�');

SELECT * FROM VISITOR;
COMMIT;
/*
 2. ���̺�� : member
    �÷� ��� : m_id -  ���� �������� �ִ� 12�ڸ� ������ �� �ְ� - primary key
	     m_pwd - ���� �������� �ִ� 12�ڸ� ������ �� �ְ� - not null
                   name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�  - not null
                   joindate - ��¥�� �ð��� ������ �� �ְ�  - �⺻�� sysdate
*/
CREATE TABLE MEMBER(
    
    M_ID VARCHAR2(24) PRIMARY KEY,
    M_PWD VARCHAR2(24) NOT NULL,
    NAME VARCHAR2(18) NOT NULL,
    JOINDATE DATE DEFAULT SYSDATE
    
);

DESC MEMBER;

/* 
 3. ���̺�� : news
     �÷���� : id - ���̰� 8�� ���� Ÿ�� - primary key
                    writer - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
	      title - �ѱ� �������� �ִ� 40�ڸ� ������ �� �ְ�
	      content - �ѱ� �������� �ִ� 300�ڸ� ������ �� �ְ�
                     writedate - ��¥�� �ð��� ������ �� �ְ�
                     cnt - ���̰� 8�� ���� Ÿ��
*/

CREATE TABLE NEWS(
    ID NUMBER(8) PRIMARY KEY,
    WRITER VARCHAR2(18) DEFAULT '�͸�',
    TITLE VARCHAR2(120) DEFAULT '�̸�����',
    CONTENT VARCHAR2(900),
    WRITEDATE DATE DEFAULT SYSDATE,
    CNT NUMBER(8)
);

DESC NEWS;
--     ������ ���� : news_seq - 1���� ����, 1�� ����
/*
 4. ���̺�� : meeting
     �÷���� : id - ���̰� 8�� ���� Ÿ�� - primary key
                   name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ�
 	      title - �ѱ� �������� �ִ� 40�ڸ� ������ �� �ְ� 
	      meetingdate - ��¥�� �ð��� ������ �� �ְ�
*/

CREATE TABLE MEETING(
    ID NUMBER(8) PRIMARY KEY,
    NAME VARCHAR2(18) NOT NULL,
    TITLE VARCHAR2(120) DEFAULT '�������',
    MEETINGDATE DATE DEFAULT SYSDATE
);

DESC MEETING;
--     ������ ���� : meeting_seq - 1���� ����, 1�� ����
/*
5. ���̺�� : imgtest
     �÷���� : name - �ѱ� �������� �ִ� 6�ڸ� ������ �� �ְ� - primary key
                   imgcontent - �̹����� �����ͷ� ������ �� �ְ� (blobŸ������)

*/

CREATE TABLE IMGTEST(
    NAME VARCHAR2(18) PRIMARY KEY,
    IMGCONTENT BLOB
);

DESC IMGTEST;








