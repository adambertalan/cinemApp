-- Mozitermek
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (1, 36, 1, 6, 6); -- 6 sor 6 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (2, 55, 2, 5, 11); -- 5 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (3, 88, 3, 8, 11); -- 8 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (4, 55, 4, 5, 11); -- 5 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (5, 84, 5, 7, 12); -- 7 sor 12 oszlop

-- Ülőhelyek ( az első moziteremé )
-- 1. sor 
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (1, false, 1, 1, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (2, false, 2, 1, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (3, false, 3, 1, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (4, false, 4, 1, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (5, false, 5, 1, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (6, false, 6, 1, 1);

-- 2. sor
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (7, false, 1, 2, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (8, false, 2, 2, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (9, false, 3, 2, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (10, false, 4, 2, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (11, false, 5, 2, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (12, false, 6, 2, 1);

-- 3. sor
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (13, false, 1, 3, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (14, false, 2, 3, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (15, false, 3, 3, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (16, false, 4, 3, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (17, false, 5, 3, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (18, false, 6, 3, 1);

-- 4. sor
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (19, false, 1, 4, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (20, false, 2, 4, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (21, false, 3, 4, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (22, false, 4, 4, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (23, false, 5, 4, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (24, false, 6, 4, 1);

-- 5. sor
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (25, false, 1, 5, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (26, false, 2, 5, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (27, false, 3, 5, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (28, false, 4, 5, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (29, false, 5, 5, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (30, false, 6, 5, 1);

-- 6. sor
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (31, false, 1, 6, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (32, false, 2, 6, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (33, false, 3, 6, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (34, false, 4, 6, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (35, false, 5, 6, 1);
INSERT INTO public.seat(id, occupied, seatcolumn, seatrow, theatre_id) VALUES (36, false, 6, 6, 1);

-- Műfajok
INSERT INTO public.genre(id, name) VALUES (1, 'Musical');
INSERT INTO public.genre(id, name) VALUES (2, 'Horror');
INSERT INTO public.genre(id, name) VALUES (3, 'Akció');
INSERT INTO public.genre(id, name) VALUES (4, 'Sci-fi');
INSERT INTO public.genre(id, name) VALUES (5, 'Fantasy');
INSERT INTO public.genre(id, name) VALUES (6, 'Dráma');
INSERT INTO public.genre(id, name) VALUES (7, 'Dokumentum');
INSERT INTO public.genre(id, name) VALUES (8, 'Thriller');
INSERT INTO public.genre(id, name) VALUES (9, 'Vígjáték');