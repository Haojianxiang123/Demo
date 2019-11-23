/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019-11-18  17:42:37                         */
/*==============================================================*/


drop table if exists sys_reply;

drop table if exists sys_topic;

/*==============================================================*/
/* Table: sys_reply                                             */
/*==============================================================*/
create table sys_reply
(
   replyid              int(10) auto_increment,
   topicid              int(10) not null,
   author               varchar(32) not null,
   content              varchar(1028) not null,
   createdate           datetime not null default now(),
   primary key (replyid)
);

/*==============================================================*/
/* Table: sys_topic                                             */
/*==============================================================*/
create table sys_topic
(
   topicid              int(10) auto_increment,
   title                varchar(128) not null,
   content              varchar(2056) not null,
   author               varchar(32) not null,
   createdate           datetime not null default now(),
   clickamount          int(10) default 0,
   primary key (topicid)
);

alter table sys_reply add constraint FK_Reference_1 foreign key (topicid)
      references sys_topic (topicid) on delete restrict on update restrict;

