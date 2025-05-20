--
-- PostgreSQL database dump
--

-- Dumped from database version 17.4
-- Dumped by pg_dump version 17.4

-- Started on 2025-05-19 22:55:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5001 (class 0 OID 16390)
-- Dependencies: 218
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.persona (id_persona, nombre, apellido, email, fecha_nacimiento, version) FROM stdin;
13	Lucas Actualizado	Mamani	lucas.act@mail.com	2001-05-21	2
2	María	González	maria.gonzalez@email.com	1998-07-22	0
3	Carlos	López	carlos.lopez@email.com	1997-11-30	0
4	Ana	Martínez	ana.martinez@email.com	1996-05-18	0
5	Pedro	Sánchez	pedro.sanchez@email.com	1999-02-10	0
6	Laura	Rodríguez	laura.rodriguez@email.com	1994-09-25	0
7	Miguel	Fernández	miguel.fernandez@email.com	1993-12-05	0
8	Sofía	Díaz	sofia.diaz@email.com	1997-04-12	0
9	David	Ruiz	david.ruiz@email.com	1998-08-20	0
10	Elena	Hernández	elena.hernandez@email.com	1995-01-30	0
12	Carlos	Garcia	carlos.garcia@email.com	2001-08-15	0
1	Juan	Pérez	juan.perez@email.com	1995-03-15	2
16	Andrea	López	andrea.lopez@example.com	2000-04-15	0
\.


--
-- TOC entry 5003 (class 0 OID 16435)
-- Dependencies: 220
-- Data for Name: docente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.docente (departamento, nro_empleado, id_persona) FROM stdin;
Matematicas	EMP001	1
Fisica	EMP002	2
Informatica	EMP003	3
Matematicas	EMP004	4
Informatica	EMP005	5
Informatica	EMP006	6
\.


--
-- TOC entry 5002 (class 0 OID 16398)
-- Dependencies: 219
-- Data for Name: estudiante; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudiante (id_persona, numero_inscripcion, estado, fecha_alta, fecha_baja, fecha_modificacion, motivo_baja, usuario_baja, usuario_modificacion, usuario_alta) FROM stdin;
2	EST20230002	\N	\N	\N	\N	\N	\N	\N	\N
3	EST20230003	\N	\N	\N	\N	\N	\N	\N	\N
4	EST20230004	\N	\N	\N	\N	\N	\N	\N	\N
5	EST20230005	\N	\N	\N	\N	\N	\N	\N	\N
6	EST20230006	\N	\N	\N	\N	\N	\N	\N	\N
7	EST20230007	\N	\N	\N	\N	\N	\N	\N	\N
8	EST20230008	\N	\N	\N	\N	\N	\N	\N	\N
9	EST20230009	\N	\N	\N	\N	\N	\N	\N	\N
10	EST20230010	\N	\N	\N	\N	\N	\N	\N	\N
12	EST20230011	activo	\N	\N	\N	\N	\N	\N	\N
13	LU123456	inactivo	2025-05-18	2025-05-18	2025-05-18	\N	admin	admin	admin
1	EST20230001	inactivo	\N	2025-05-19	2025-05-18	Renuncia voluntaria	admin	admin	\N
16	EST20230012	activo	2025-05-19	\N	\N	\N	\N	\N	admin
\.


--
-- TOC entry 5006 (class 0 OID 16448)
-- Dependencies: 223
-- Data for Name: materia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materia (id_materia, codigo_unico, creditos, nombre_materia, version, docente_id) FROM stdin;
1	MAT101	4	Calculo I	0	1
3	INF101	4	Programacion Basica	0	3
4	MAT102	3	Algebra Lineal	0	4
5	INF402	4	Base de Datos	0	5
7	INF121	5	Programacion II	0	6
2	FIS301	6	Fisica I	1	2
9	ROB100	3	Robotica	0	2
\.


--
-- TOC entry 5004 (class 0 OID 16444)
-- Dependencies: 221
-- Data for Name: estudiante_materia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.estudiante_materia (id_estudiante, id_materia) FROM stdin;
1	3
1	4
1	5
1	3
1	4
1	5
12	7
12	2
\.


--
-- TOC entry 5008 (class 0 OID 16789)
-- Dependencies: 225
-- Data for Name: evaluacion_docente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.evaluacion_docente (id, comentario, fecha, puntuacion, docente_id, fecha_evaluacion, puntaje) FROM stdin;
3	Excelente claridad y dominio del contenido.	\N	\N	2	2025-05-20	9
4	Excelente claridad y dominio del contenido.	\N	\N	2	2025-05-20	9
5	Excelente claridad y dominio del contenido.	\N	\N	2	2025-05-20	9
\.


--
-- TOC entry 5020 (class 0 OID 17902)
-- Dependencies: 237
-- Data for Name: inscripcion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inscripcion (id, estado, fecha_inscripcion, estudiante_id, materia_id) FROM stdin;
4	Inscrito	2025-05-19	7	5
\.


--
-- TOC entry 5009 (class 0 OID 16794)
-- Dependencies: 226
-- Data for Name: materia_prerequisito; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materia_prerequisito (id_materia, id_prerequisito) FROM stdin;
\.


--
-- TOC entry 5013 (class 0 OID 17842)
-- Dependencies: 230
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, nombre) FROM stdin;
1	ROL_ADMIN
2	ROL_DOCENTE
3	ROL_ESTUDIANTE
\.


--
-- TOC entry 5017 (class 0 OID 17876)
-- Dependencies: 234
-- Data for Name: spring_session; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spring_session (primary_id, session_id, creation_time, last_access_time, max_inactive_interval, expiry_time, principal_name) FROM stdin;
\.


--
-- TOC entry 5018 (class 0 OID 17884)
-- Dependencies: 235
-- Data for Name: spring_session_attributes; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spring_session_attributes (session_primary_id, attribute_name, attribute_bytes) FROM stdin;
\.


--
-- TOC entry 5011 (class 0 OID 16826)
-- Dependencies: 228
-- Data for Name: unidad_tematica; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.unidad_tematica (id, titulo, descripcion, materia_id) FROM stdin;
1	Introducción a la programación	Conceptos básicos de lógica y algoritmos	1
2	Estructuras de datos	Listas, pilas, colas y árboles	1
\.


--
-- TOC entry 5016 (class 0 OID 17854)
-- Dependencies: 233
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id, activo, apellido, email, nombre, password, username) FROM stdin;
1	t	Sistema	admin@universidad.com	Administrador	$2a$10$N4aRu0WgUfwr4W/0sM7xtuAwPZDLvRkCdNiH.NFscjMqt7Hh4VC4.	admin
2	t	Pérez	juan@mail.com	Juan	$2a$10$J6F0aoa3uTzr0lbFT3y5KeYr5lQiSj7Hc/por1c42Vhl5RZN94CBC	juan1234
\.


--
-- TOC entry 5014 (class 0 OID 17848)
-- Dependencies: 231
-- Data for Name: usuario_roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario_roles (usuario_id, rol_id) FROM stdin;
1	1
2	3
\.


--
-- TOC entry 5026 (class 0 OID 0)
-- Dependencies: 224
-- Name: evaluacion_docente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.evaluacion_docente_id_seq', 5, true);


--
-- TOC entry 5027 (class 0 OID 0)
-- Dependencies: 236
-- Name: inscripcion_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.inscripcion_id_seq', 4, true);


--
-- TOC entry 5028 (class 0 OID 0)
-- Dependencies: 222
-- Name: materia_id_materia_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.materia_id_materia_seq', 9, true);


--
-- TOC entry 5029 (class 0 OID 0)
-- Dependencies: 217
-- Name: persona_id_persona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.persona_id_persona_seq', 16, true);


--
-- TOC entry 5030 (class 0 OID 0)
-- Dependencies: 229
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.roles_id_seq', 3, true);


--
-- TOC entry 5031 (class 0 OID 0)
-- Dependencies: 227
-- Name: unidad_tematica_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.unidad_tematica_id_seq', 2, true);


--
-- TOC entry 5032 (class 0 OID 0)
-- Dependencies: 232
-- Name: usuarios_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_id_seq', 2, true);


-- Completed on 2025-05-19 22:55:04

--
-- PostgreSQL database dump complete
--

