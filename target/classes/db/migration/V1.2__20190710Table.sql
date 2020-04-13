create table t_role(
  id bigserial primary key,
  role_name varchar(255),
  create_by varchar(255),
  creation_date timestamp,
  last_update_by varchar(255),
  last_update_date timestamp,
  status varchar(255)
);
create table t_user(
  id bigserial primary key,
  user_name varchar(255),
  email varchar(255),
  password varchar(255),
  create_by varchar(255),
  creation_date timestamp,
  last_update_by varchar(255),
  last_update_date timestamp,
  status varchar(255)
);