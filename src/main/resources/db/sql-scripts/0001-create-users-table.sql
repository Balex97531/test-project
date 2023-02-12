
create sequence users_id_seq
    start with 1
    increment by 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

create table users(
    user_id bigint DEFAULT nextval('users_id_seq') NOT NULL PRIMARY KEY,
    name  VARCHAR(100)  NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    creation_date  TIMESTAMP WITH TIME ZONE NOT NULL
);

