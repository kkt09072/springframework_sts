drop table custom;

create table custom(id varchar2(20) primary key,
pw varchar2(400) not null, name varchar2(50) not null,
email varchar2(200), tel varchar2(18), addr varchar2(200),
postcode varchar2(10), resdate date default sysdate);

desc custom;

select * from member;

select * from custom;

insert into custom values ('admin', '$2a$10$KQkfO4mfgTW6/sRScc21huHhohWHo.keJEQD.uF0jKhvJdD.D75xG', '관리자', 'admin@spring1.com', '010-1004-1004', '서울 종로구 $ 1204호', '031139', default);

update custom set pw='$2a$10$sVtTU6E40Fr0sgM0TRn5g.v0Q0WLb8HTmhgs07tnBAuHObdJ6EeN2' where id='admin';

commit;


select * from board;

create table board(bno int primary key, title varchar2(200), content varchar2(1000),
author varchar2(20), vcnt int default 0, resdate date default sysdate);

create table free(no int primary key,
title varchar(200), content varchar(1000),
hits int default 0, resdate timestamp default sysdate,
id varchar(20), name varchar(100));

create sequence free_seq increment by 1;

create view ckboard as (select f.no as no, f.title as title, f.content as content, f.hits as hits,
f.resdate, m.id as id, m.name as name from free f, custom m where f.id=m.id);

select * from ckboard;


CREATE TABLE payment (
    payment_id VARCHAR2(100) PRIMARY KEY,
    user_id VARCHAR2(100) NOT NULL,
    amount NUMBER(10, 2) NOT NULL,
    status VARCHAR2(20) NOT NULL,
    imp_uid VARCHAR2(100),
    merchant_uid VARCHAR2(100),
    created_at DATE DEFAULT SYSDATE,
    updated_at DATE DEFAULT SYSDATE
);

CREATE INDEX idx_payment_user_id ON payment (user_id);


