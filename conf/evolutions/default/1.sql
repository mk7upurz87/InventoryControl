# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table part (
  id                        bigint not null,
  label                     varchar(255),
  brand                     varchar(255),
  quantity                  bigint,
  constraint pk_part primary key (id))
;

create table user (
  id                        bigint not null,
  username                  varchar(255),
  constraint pk_user primary key (id))
;

create sequence part_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists part;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists part_seq;

drop sequence if exists user_seq;

