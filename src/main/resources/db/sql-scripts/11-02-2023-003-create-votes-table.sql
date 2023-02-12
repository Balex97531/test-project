create sequence vote_id_seq
    start with 100
    increment by 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

create table votes(
    vote_id bigint DEFAULT nextval('vote_id_seq') PRIMARY KEY,
    vote_moment  TIMESTAMP WITH TIME ZONE NOT NULL,
    vote_type ENUM('UP_VOTE','DOWN_VOTE')  NOT NULL,
    quote_id bigint NOT NULL
);

ALTER TABLE votes  ADD CONSTRAINT quote_id_fk FOREIGN KEY (quote_id) REFERENCES quotes (quote_id);

