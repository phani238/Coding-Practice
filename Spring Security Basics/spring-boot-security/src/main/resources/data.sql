create table users(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(50) not null,
    enabled boolean not null
);

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users (username, password, enabled)
 values ('user','pass',true);
 
INSERT INTO users (username, password, enabled)
 values ('admin','pass',true);
 
INSERT INTO authorities (username, authority)
 values ('user','ROLE_USER');
 
INSERT INTO authorities (username, authority)
 values ('admin','ROLE_ADMIN');