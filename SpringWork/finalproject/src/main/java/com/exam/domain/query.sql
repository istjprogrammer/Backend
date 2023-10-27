CREATE TABLE simpleBoard(
	bNo			number		not null,
	bTitle		varchar2(200) not null,
	bContent	varchar2(4000)	null,
	bWriter		varchar2(50) not null,
	bRegdate	timestamp  default sysdate not null,
	bViewcnt	number default 0,
	CONSTRAINT pk_id primary key(bNo)	
);

drop table simpleBoard;

CREATE TABLE simpleMember(
	id	number	not null,
	email varchar2(50),
	password	varchar2(50),
	name	varchar2(50),
	regdate 	date,
	CONSTRAINT pk_email	PRIMARY KEY(email)
);

CREATE SEQUENCE seq_bno;
CREATE SEQUENCE seq_id;