CREATE TABLE simpleBoard(
 	bNo	number	not null,
 	bTitle varchar2(200) not null,
 	bContent varchar2(200) null,
 	bWriter varchar2(50) not null,
 	bRegdate timestamp default sysdate not null, 	
 	bViewcnt number default 0,
 	CONSTRAINT pk_id primary key(bNo)
 );