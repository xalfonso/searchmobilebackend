--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2016-10-05 21:29:05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 8 (class 2615 OID 24577)
-- Name: core; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA core;


ALTER SCHEMA core OWNER TO postgres;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2147 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = core, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 184 (class 1259 OID 24609)
-- Name: privilege; Type: TABLE; Schema: core; Owner: postgres
--

CREATE TABLE privilege (
    name character varying NOT NULL,
    id integer NOT NULL
);


ALTER TABLE privilege OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 24625)
-- Name: profile; Type: TABLE; Schema: core; Owner: postgres
--

CREATE TABLE profile (
    id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE profile OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 24628)
-- Name: profile_id_seq; Type: SEQUENCE; Schema: core; Owner: postgres
--

CREATE SEQUENCE profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE profile_id_seq OWNER TO postgres;

--
-- TOC entry 2148 (class 0 OID 0)
-- Dependencies: 186
-- Name: profile_id_seq; Type: SEQUENCE OWNED BY; Schema: core; Owner: postgres
--

ALTER SEQUENCE profile_id_seq OWNED BY profile.id;


--
-- TOC entry 187 (class 1259 OID 24641)
-- Name: profileprivilege; Type: TABLE; Schema: core; Owner: postgres
--

CREATE TABLE profileprivilege (
    profile integer NOT NULL,
    privilege integer NOT NULL,
    id integer NOT NULL
);


ALTER TABLE profileprivilege OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 24644)
-- Name: profileprivilege_id_seq; Type: SEQUENCE; Schema: core; Owner: postgres
--

CREATE SEQUENCE profileprivilege_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE profileprivilege_id_seq OWNER TO postgres;

--
-- TOC entry 2149 (class 0 OID 0)
-- Dependencies: 188
-- Name: profileprivilege_id_seq; Type: SEQUENCE OWNED BY; Schema: core; Owner: postgres
--

ALTER SEQUENCE profileprivilege_id_seq OWNED BY profileprivilege.id;


--
-- TOC entry 182 (class 1259 OID 24578)
-- Name: user; Type: TABLE; Schema: core; Owner: postgres
--

CREATE TABLE "user" (
    id integer NOT NULL,
    username character varying NOT NULL,
    password character varying,
    name character varying,
    surname character varying,
    creat timestamp without time zone DEFAULT now()
);


ALTER TABLE "user" OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 24581)
-- Name: user_id_seq; Type: SEQUENCE; Schema: core; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_id_seq OWNER TO postgres;

--
-- TOC entry 2150 (class 0 OID 0)
-- Dependencies: 183
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: core; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 2003 (class 2604 OID 24630)
-- Name: id; Type: DEFAULT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profile ALTER COLUMN id SET DEFAULT nextval('profile_id_seq'::regclass);


--
-- TOC entry 2004 (class 2604 OID 24646)
-- Name: id; Type: DEFAULT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profileprivilege ALTER COLUMN id SET DEFAULT nextval('profileprivilege_id_seq'::regclass);


--
-- TOC entry 2001 (class 2604 OID 24583)
-- Name: id; Type: DEFAULT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 2135 (class 0 OID 24609)
-- Dependencies: 184
-- Data for Name: privilege; Type: TABLE DATA; Schema: core; Owner: postgres
--

COPY privilege (name, id) FROM stdin;
INIT_PRIVILEGES	1
LISTAR_PRIVILEGES	2
INSERTAR_PROFILE	3
LISTAR_PROFILE	4
EDITAR_PROFILE	5
INSERTAR_USUARIO	6
LISTAR_USUARIO	7
EDITAR_USUARIO	8
VER_USUARIO	9
VER_MY_USUARIO	10
\.


--
-- TOC entry 2136 (class 0 OID 24625)
-- Dependencies: 185
-- Data for Name: profile; Type: TABLE DATA; Schema: core; Owner: postgres
--

COPY profile (id, name) FROM stdin;
\.


--
-- TOC entry 2151 (class 0 OID 0)
-- Dependencies: 186
-- Name: profile_id_seq; Type: SEQUENCE SET; Schema: core; Owner: postgres
--

SELECT pg_catalog.setval('profile_id_seq', 1, false);


--
-- TOC entry 2138 (class 0 OID 24641)
-- Dependencies: 187
-- Data for Name: profileprivilege; Type: TABLE DATA; Schema: core; Owner: postgres
--

COPY profileprivilege (profile, privilege, id) FROM stdin;
\.


--
-- TOC entry 2152 (class 0 OID 0)
-- Dependencies: 188
-- Name: profileprivilege_id_seq; Type: SEQUENCE SET; Schema: core; Owner: postgres
--

SELECT pg_catalog.setval('profileprivilege_id_seq', 1, false);


--
-- TOC entry 2133 (class 0 OID 24578)
-- Dependencies: 182
-- Data for Name: user; Type: TABLE DATA; Schema: core; Owner: postgres
--

COPY "user" (id, username, password, name, surname, creat) FROM stdin;
11	E.ALFONSO	PASSSSSDFFG	Eduardo	Alfonso Sanchez	\N
13	E.MARTINEZ	PASSSSSDFFG	Eduardo	Alfonso Sanchez	2016-10-05 16:43:17.290019
\.


--
-- TOC entry 2153 (class 0 OID 0)
-- Dependencies: 183
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: core; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 1, true);


--
-- TOC entry 2012 (class 2606 OID 24635)
-- Name: key_profile; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT key_profile PRIMARY KEY (id);


--
-- TOC entry 2016 (class 2606 OID 24651)
-- Name: key_profileprivilege; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profileprivilege
    ADD CONSTRAINT key_profileprivilege PRIMARY KEY (id);


--
-- TOC entry 2006 (class 2606 OID 24588)
-- Name: key_user; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT key_user PRIMARY KEY (id);


--
-- TOC entry 2010 (class 2606 OID 24624)
-- Name: un_name_privilege; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY privilege
    ADD CONSTRAINT un_name_privilege UNIQUE (name);


--
-- TOC entry 2014 (class 2606 OID 24640)
-- Name: un_name_profile; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profile
    ADD CONSTRAINT un_name_profile UNIQUE (name);


--
-- TOC entry 2018 (class 2606 OID 24653)
-- Name: un_profileprevilege; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY profileprivilege
    ADD CONSTRAINT un_profileprevilege UNIQUE (profile, privilege);


--
-- TOC entry 2008 (class 2606 OID 24593)
-- Name: un_username_user; Type: CONSTRAINT; Schema: core; Owner: postgres
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT un_username_user UNIQUE (username);


--
-- TOC entry 2146 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-10-05 21:29:05

--
-- PostgreSQL database dump complete
--

