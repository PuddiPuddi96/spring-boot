CREATE TABLE public."SALA"
(
    id serial NOT NULL,
    numero integer NOT NULL,
    flag_imax boolean NOT NULL DEFAULT false,
    capienza integer NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public."SALA"
    OWNER to cinemille;


INSERT INTO public."SALA" (numero, flag_imax, capienza) VALUES
(1, false, 150),
(2, false, 200),
(3, true, 250),
(4, false, 100),
(5, false, 180),
(6, false, 220),
(7, false, 130),
(8, true, 240),
(9, false, 90),
(10, false, 170),
(11, false, 50),
(12, false, 200);
