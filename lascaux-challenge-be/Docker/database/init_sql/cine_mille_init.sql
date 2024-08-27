--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9
-- Dumped by pg_dump version 12.10

-- Started on 2024-08-27 10:02:14 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 19652)
-- Name: film; Type: TABLE; Schema: public; Owner: cinemille
--

CREATE TABLE public.film (
    id integer NOT NULL,
    title character varying NOT NULL,
    duration integer NOT NULL,
    genre character varying NOT NULL
);


ALTER TABLE public.film OWNER TO cinemille;

--
-- TOC entry 202 (class 1259 OID 19650)
-- Name: film_id_seq; Type: SEQUENCE; Schema: public; Owner: cinemille
--

CREATE SEQUENCE public.film_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.film_id_seq OWNER TO cinemille;

--
-- TOC entry 2984 (class 0 OID 0)
-- Dependencies: 202
-- Name: film_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cinemille
--

ALTER SEQUENCE public.film_id_seq OWNED BY public.film.id;


--
-- TOC entry 206 (class 1259 OID 19684)
-- Name: map_film_room; Type: TABLE; Schema: public; Owner: cinemille
--

CREATE TABLE public.map_film_room (
    id integer NOT NULL,
    id_film integer NOT NULL,
    room_number integer NOT NULL,
    is_in_programming boolean DEFAULT true NOT NULL,
    programming_start_date timestamp without time zone NOT NULL,
    programming_end_date timestamp without time zone NOT NULL
);


ALTER TABLE public.map_film_room OWNER TO cinemille;

--
-- TOC entry 205 (class 1259 OID 19682)
-- Name: map_film_room_id_seq; Type: SEQUENCE; Schema: public; Owner: cinemille
--

CREATE SEQUENCE public.map_film_room_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.map_film_room_id_seq OWNER TO cinemille;

--
-- TOC entry 2985 (class 0 OID 0)
-- Dependencies: 205
-- Name: map_film_room_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: cinemille
--

ALTER SEQUENCE public.map_film_room_id_seq OWNED BY public.map_film_room.id;


--
-- TOC entry 204 (class 1259 OID 19661)
-- Name: room; Type: TABLE; Schema: public; Owner: cinemille
--

CREATE TABLE public.room (
    number integer NOT NULL,
    flag_imax boolean DEFAULT false NOT NULL,
    capacity integer NOT NULL,
    CONSTRAINT capacity_check CHECK (((capacity >= 50) AND (capacity <= 250)))
);


ALTER TABLE public.room OWNER TO cinemille;

--
-- TOC entry 2835 (class 2604 OID 19655)
-- Name: film id; Type: DEFAULT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.film ALTER COLUMN id SET DEFAULT nextval('public.film_id_seq'::regclass);


--
-- TOC entry 2838 (class 2604 OID 19687)
-- Name: map_film_room id; Type: DEFAULT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.map_film_room ALTER COLUMN id SET DEFAULT nextval('public.map_film_room_id_seq'::regclass);


--
-- TOC entry 2975 (class 0 OID 19652)
-- Dependencies: 203
-- Data for Name: film; Type: TABLE DATA; Schema: public; Owner: cinemille
--

COPY public.film (id, title, duration, genre) FROM stdin;
\.


--
-- TOC entry 2978 (class 0 OID 19684)
-- Dependencies: 206
-- Data for Name: map_film_room; Type: TABLE DATA; Schema: public; Owner: cinemille
--

COPY public.map_film_room (id, id_film, room_number, is_in_programming, programming_start_date, programming_end_date) FROM stdin;
\.


--
-- TOC entry 2976 (class 0 OID 19661)
-- Dependencies: 204
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: cinemille
--

COPY public.room (number, flag_imax, capacity) FROM stdin;
1	f	150
2	f	200
3	t	250
4	f	100
5	f	180
6	f	220
7	f	130
8	t	240
9	f	90
10	f	170
11	f	50
12	f	200
\.


--
-- TOC entry 2986 (class 0 OID 0)
-- Dependencies: 202
-- Name: film_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cinemille
--

SELECT pg_catalog.setval('public.film_id_seq', 1, false);


--
-- TOC entry 2987 (class 0 OID 0)
-- Dependencies: 205
-- Name: map_film_room_id_seq; Type: SEQUENCE SET; Schema: public; Owner: cinemille
--

SELECT pg_catalog.setval('public.map_film_room_id_seq', 1, false);


--
-- TOC entry 2841 (class 2606 OID 19660)
-- Name: film film_pkey; Type: CONSTRAINT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.film
    ADD CONSTRAINT film_pkey PRIMARY KEY (id);


--
-- TOC entry 2845 (class 2606 OID 19690)
-- Name: map_film_room map_film_room_pkey; Type: CONSTRAINT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.map_film_room
    ADD CONSTRAINT map_film_room_pkey PRIMARY KEY (id_film);


--
-- TOC entry 2843 (class 2606 OID 19667)
-- Name: room room_pkey; Type: CONSTRAINT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT room_pkey PRIMARY KEY (number);


--
-- TOC entry 2847 (class 2606 OID 19696)
-- Name: map_film_room fk_film; Type: FK CONSTRAINT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.map_film_room
    ADD CONSTRAINT fk_film FOREIGN KEY (id_film) REFERENCES public.film(id) ON DELETE CASCADE;


--
-- TOC entry 2846 (class 2606 OID 19691)
-- Name: map_film_room fk_room; Type: FK CONSTRAINT; Schema: public; Owner: cinemille
--

ALTER TABLE ONLY public.map_film_room
    ADD CONSTRAINT fk_room FOREIGN KEY (room_number) REFERENCES public.room(number) ON DELETE CASCADE;


-- Completed on 2024-08-27 10:02:14 UTC

--
-- PostgreSQL database dump complete
--
