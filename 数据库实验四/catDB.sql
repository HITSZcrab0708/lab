/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/12/24 17:08:57                          */
/*==============================================================*/


drop trigger arecord_after_delete;

drop trigger arecord_after_insert;

drop trigger frecord_after_delete;

drop trigger frecord_after_insert;

drop 
table if exists catInfoView;

drop index cat_name_index on cat;

drop index index_category_name on category;

/*==============================================================*/
/* Table: appearance_record                                     */
/*==============================================================*/
create table appearance_record
(
   record_id            int auto_increment,
   cat_id               int not null,
   username             varchar(16) not null,
   location_id          int not null,
   record_time          char(16) not null,
   last_update          datetime,
   primary key (record_id)
);

/*==============================================================*/
/* Table: cat                                                   */
/*==============================================================*/
create table cat
(
   cat_id               int auto_increment,
   cat_name             varchar(15) not null,
   category_id          int not null,
   color_id             int not null,
   character_id         int not null,
   location_id          int,
   record_count         int,
   primary key (cat_id)
);

/*==============================================================*/
/* Index: cat_name_index                                        */
/*==============================================================*/
create unique index cat_name_index on cat
(
   cat_name
);

/*==============================================================*/
/* Table: cat_character                                         */
/*==============================================================*/
create table cat_character
(
   character_id         int auto_increment,
   `character`          varchar(15) not null,
   primary key (character_id)
);

/*==============================================================*/
/* Table: category                                              */
/*==============================================================*/
create table category
(
   category_id          int auto_increment,
   category             varchar(15) not null,
   primary key (category_id)
);

/*==============================================================*/
/* Index: index_category_name                                   */
/*==============================================================*/
create unique index index_category_name on category
(
   category
);

/*==============================================================*/
/* Table: color                                                 */
/*==============================================================*/
create table color
(
   color_id             int auto_increment,
   color                varchar(15) not null,
   primary key (color_id)
);

/*==============================================================*/
/* Table: feeding_record                                        */
/*==============================================================*/
create table feeding_record
(
   record_id            int auto_increment,
   cat_id               int not null,
   username             varchar(16) not null,
   location_id          int not null,
   record_time          char(16) not null,
   remarks              varchar(50),
   last_update          datetime,
   primary key (record_id)
);

/*==============================================================*/
/* Table: location                                              */
/*==============================================================*/
create table location
(
   location_id          int auto_increment,
   location             varchar(20) not null,
   primary key (location_id)
);

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
create table user_info
(
   username             varchar(16) not null,
   password             varchar(16) not null,
   status               smallint not null,
   primary key (username)
);

/*==============================================================*/
/* View: catInfoView                                            */
/*==============================================================*/
create VIEW  catInfoView
 as
select cat.cat_id, cat.cat_name, 
cat.category_id, category.category, 
cat.color_id, color.color, 
cat.character_id, cat_character.`character`, 
cat.location_id, location.location,
cat.record_count
from cat, category, color, cat_character, location
where cat.category_id = category.category_id
and cat.color_id = color.color_id
and cat.character_id = cat_character.character_id
and cat.location_id = location.location_id;

alter table appearance_record add constraint FK_arecord_location foreign key (location_id)
      references location (location_id) on delete restrict on update restrict;

alter table appearance_record add constraint FK_cat_arecord foreign key (cat_id)
      references cat (cat_id) on delete restrict on update restrict;

alter table appearance_record add constraint FK_user_arecord foreign key (username)
      references user_info (username) on delete restrict on update restrict;

alter table cat add constraint FK_cat_category foreign key (category_id)
      references category (category_id) on delete restrict on update restrict;

alter table cat add constraint FK_cat_character foreign key (character_id)
      references cat_character (character_id) on delete restrict on update restrict;

alter table cat add constraint FK_cat_color foreign key (color_id)
      references color (color_id) on delete restrict on update restrict;

alter table cat add constraint FK_cat_location foreign key (location_id)
      references location (location_id) on delete restrict on update restrict;

alter table feeding_record add constraint FK_cat_frecord foreign key (cat_id)
      references cat (cat_id) on delete restrict on update restrict;

alter table feeding_record add constraint FK_frecord_location foreign key (location_id)
      references location (location_id) on delete restrict on update restrict;

alter table feeding_record add constraint FK_user_frecord foreign key (username)
      references user_info (username) on delete restrict on update restrict;


create trigger arecord_after_delete
after delete on appearance_record for each row begin
    update cat set record_count = record_count - 1 where cat.cat_id = OLD.cat_id;
end;


create trigger arecord_after_insert
after insert on appearance_record for each row begin
    update cat set record_count = record_count + 1 where cat.cat_id = NEW.cat_id;
end;


create trigger frecord_after_delete
after delete on feeding_record for each row begin
    update cat set record_count = record_count - 1 where cat.cat_id = OLD.cat_id;
end;


create trigger frecord_after_insert
after insert on feeding_record for each row begin
    update cat set record_count = record_count + 1 where cat.cat_id = NEW.cat_id;
end;

