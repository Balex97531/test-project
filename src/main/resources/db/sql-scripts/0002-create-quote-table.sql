create sequence quote_id_seq
    start with 1
    increment by 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


create table quotes(
    quoteId bigint DEFAULT nextval('quotes_id_seq') NOT NULL PRIMARY KEY,
    content  VARCHAR(100)  NOT NULL,
    creation_date  TIMESTAMP WITH TIME ZONE NOT NULL,
    last_update_date  TIMESTAMP WITH TIME ZONE NOT NULL,
    author_id bigint NOT NULL
);

ALTER TABLE quotes  ADD CONSTRAINT user_id_fk FOREIGN KEY (author_id) REFERENCES users (user_id);

