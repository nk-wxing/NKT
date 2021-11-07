-- 创建用户/管理员表
-- 用户id	是否为管理员    用户名    密码
-- drop table tb_user;
create table tb_user(
	uid int primary key auto_increment,
	isAdmin boolean not null,
	uname varchar(20) not null unique,
	upwd varchar(20) not null
);

-- 增加两个超级管理员
insert into tb_user(isAdmin,uname,upwd) values(true,'wangxing','123'),(true,'liujiakui','123');
select * from tb_user;

-- 创建主题表
create table tb_topic(
	tid int primary key auto_increment,
	tname varchar(50) not null unique
);

-- on delete cascade级联删除
-- 创建新闻表(新闻和用户的关系是多对一)
-- 新闻id	标题    作者    摘要    内容    图片   主题id   发布时间      审核状态
-- drop table tb_news;
create table tb_news(
	nid int primary key auto_increment,
	ntitle varchar(50) not null unique,
	uid int,
	foreign key (uid) references tb_user(uid),
	nsummary varchar(100) not null unique,
	ncontent text not null,
	file varchar(100),
	tid int,
	foreign key (tid) references tb_topic(tid),
	createDate timestamp default current_timestamp, -- 将系统当前时间设置为默认值
	checkStatus int not null
);

-- 创建评论表
-- drop table tb_comment;
create table tb_comment(
	cid int primary key auto_increment,
	cauthor varchar(50) not null,
	cip varchar(20) not null,
	ccontent text not null,
	publishTime timestamp default current_timestamp,
	nid int, -- 外键列
	foreign key (nid) references tb_news(nid)
);

select * from tb_news where uid = 3;

select * from tb_news where checkStatus=1 order by createDate desc;

select tname from tb_news n,tb_topic t where n.tid=t.tid and nid=1;

select n.*,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=1 order by createDate desc;

select n.*,u.uname,t.tname from tb_news n,tb_user u,tb_topic t where n.uid=u.uid and n.tid=t.tid and checkStatus=1 order by createDate desc;

select n.*,t.tname from tb_news n,tb_topic t where uid=3 and n.tid=t.tid;

select count(1) cnt from tb_news where checkStatus=1;

select n.ntitle,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=1 order by createDate desc limit 0,10;

select n.*,u.uname from tb_news n,tb_user u where n.uid=u.uid and checkStatus=1 and tid=1 order by createDate desc limit 0,10;

select n.*,u.uname from tb_news n,tb_user u where nid=3 and n.uid=u.uid;