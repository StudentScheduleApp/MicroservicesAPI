CREATE TABLE IF NOT EXISTS users
(
    id bigint NOT NULL,
    ava_url character varying(255) COLLATE pg_catalog."default",
    banned boolean NOT NULL,
    email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS user_roles
(
    user_id bigint NOT NULL,
    roles integer,
    CONSTRAINT fkhfh9dx7w3ubf1co1vdev94g3f FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS groups
(
    id bigint NOT NULL,
    ava_url character varying(255) COLLATE pg_catalog."default",
    chat_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT groups_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS custom_lessons
(
    id bigint NOT NULL,
    group_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    teacher character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT custom_lessons_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS lesson_templates
(
    id bigint NOT NULL,
    comment character varying(255) COLLATE pg_catalog."default",
    lesson_id bigint NOT NULL,
    schedule_template_id bigint NOT NULL,
    "time" bigint NOT NULL,
    CONSTRAINT lesson_templates_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS members
(
    id bigint NOT NULL,
    group_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT members_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS member_roles
(
    member_id bigint NOT NULL,
    roles integer,
    CONSTRAINT fk431yrnsn5s4omvwjvl9dre1n0 FOREIGN KEY (member_id)
        REFERENCES members (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS outline_media_comments
(
    id bigint NOT NULL,
    media_id bigint NOT NULL,
    question_comment_id bigint,
    text character varying(255) COLLATE pg_catalog."default" NOT NULL,
    "timestamp" bigint NOT NULL,
    author_id bigint NOT NULL,
    CONSTRAINT outline_media_comments_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS outline_medias
(
    id bigint NOT NULL,
    image_url character varying(255) COLLATE pg_catalog."default" NOT NULL,
    outline_id bigint NOT NULL,
    "timestamp" bigint NOT NULL,
    CONSTRAINT outline_medias_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS outlines
(
    id bigint NOT NULL,
    specific_lesson_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT outlines_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS schedule_templates
(
    id bigint NOT NULL,
    comment character varying(255) COLLATE pg_catalog."default",
    group_id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    time_start bigint NOT NULL,
    time_stop bigint NOT NULL,
    CONSTRAINT schedule_templates_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;

CREATE TABLE IF NOT EXISTS specific_lessons
(
    id bigint NOT NULL,
    canceled boolean NOT NULL,
    comment character varying(255) COLLATE pg_catalog."default",
    group_id bigint NOT NULL,
    lesson_id bigint NOT NULL,
    "time" bigint NOT NULL,
    CONSTRAINT specific_lessons_pkey PRIMARY KEY (id)
)
TABLESPACE pg_default;