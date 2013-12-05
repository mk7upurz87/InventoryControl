# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table PART (
  id                        bigint not null,
  label                     varchar(255),
  brand                     varchar(255),
  quantity                  bigint,
  constraint uq_PART_1 unique (ID),
  constraint pk_PART primary key (id))
;

create table PURCHASEORDER (
  id                        bigint not null,
  company_name              varchar(255),
  contact_person            varchar(255),
  user_id                   bigint,
  part_id                   bigint,
  constraint uq_PURCHASEORDER_1 unique (ID),
  constraint pk_PURCHASEORDER primary key (id))
;

create table USER (
  id                        bigint not null,
  username                  varchar(255),
  constraint uq_USER_1 unique (ID),
  constraint pk_USER primary key (id))
;

create sequence PART_seq;

create sequence PURCHASEORDER_seq;

create sequence USER_seq;

alter table PURCHASEORDER add constraint fk_PURCHASEORDER_user_1 foreign key (user_id) references USER (id) on delete restrict on update restrict;
create index ix_PURCHASEORDER_user_1 on PURCHASEORDER (user_id);
alter table PURCHASEORDER add constraint fk_PURCHASEORDER_part_2 foreign key (part_id) references PART (id) on delete restrict on update restrict;
create index ix_PURCHASEORDER_part_2 on PURCHASEORDER (part_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists PART;

drop table if exists PURCHASEORDER;

drop table if exists USER;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists PART_seq;

drop sequence if exists PURCHASEORDER_seq;

drop sequence if exists USER_seq;

