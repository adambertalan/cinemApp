-- Mozitermek (5 db)
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (1, 36, 1, 6, 6); -- 6 sor 6 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (2, 55, 2, 5, 11); -- 5 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (3, 88, 3, 8, 11); -- 8 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (4, 55, 4, 5, 11); -- 5 sor 11 oszlop
INSERT INTO public.theatre(id, capacity, theatrenumber, rownumber, colnumber) VALUES (5, 84, 5, 7, 12); -- 7 sor 12 oszlop

-- Ülőhelyek

-- 1. terem

-- 1. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (1, 1, 1, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (2, 2, 1, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (3, 3, 1, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (4, 4, 1, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (5, 5, 1, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (6, 6, 1, 1);

-- 2. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (7, 1, 2, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (8, 2, 2, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (9, 3, 2, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (10, 4, 2, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (11, 5, 2, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (12, 6, 2, 1);

-- 3. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (13, 1, 3, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (14, 2, 3, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (15, 3, 3, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (16, 4, 3, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (17, 5, 3, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (18, 6, 3, 1);

-- 4. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (19, 1, 4, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (20, 2, 4, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (21, 3, 4, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (22, 4, 4, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (23, 5, 4, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (24, 6, 4, 1);

-- 5. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (25, 1, 5, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (26, 2, 5, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (27, 3, 5, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (28, 4, 5, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (29, 5, 5, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (30, 6, 5, 1);

-- 6. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (31, 1, 6, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (32, 2, 6, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (33, 3, 6, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (34, 4, 6, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (35, 5, 6, 1);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (36, 6, 6, 1);

-- 2. terem

-- 1. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (37, 1, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (38, 2, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (39, 3, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (40, 4, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (41, 5, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (42, 6, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (43, 7, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (44, 8, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (45, 9, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (46, 10, 1, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (47, 11, 1, 2);

-- 2. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (48, 1, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (49, 2, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (50, 3, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (51, 4, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (52, 5, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (53, 6, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (54, 7, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (55, 8, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (56, 9, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (57, 10, 2, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (58, 11, 2, 2);

-- 3. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (59, 1, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (60, 2, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (61, 3, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (62, 4, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (63, 5, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (64, 6, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (65, 7, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (66, 8, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (67, 9, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (68, 10, 3, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (69, 11, 3, 2);

-- 4. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (70, 1, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (71, 2, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (72, 3, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (73, 4, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (74, 5, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (75, 6, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (76, 7, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (77, 8, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (78, 9, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (79, 10, 4, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (80, 11, 4, 2);

-- 5. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (81, 1, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (82, 2, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (83, 3, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (84, 4, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (85, 5, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (86, 6, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (87, 7, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (88, 8, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (89, 9, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (90, 10, 5, 2);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (91, 11, 5, 2);

-- 3. terem

-- 1. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (92, 1, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (93, 2, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (94, 3, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (95, 4, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (96, 5, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (97, 6, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (98, 7, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (99, 8, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (100, 9, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (101, 10, 1, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (102, 11, 1, 3);

-- 2. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (103, 1, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (104, 2, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (105, 3, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (106, 4, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (107, 5, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (108, 6, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (109, 7, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (110, 8, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (111, 9, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (112, 10, 2, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (113, 11, 2, 3);

-- 3. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (114, 1, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (115, 2, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (116, 3, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (117, 4, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (118, 5, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (119, 6, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (120, 7, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (121, 8, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (122, 9, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (123, 10, 3, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (124, 11, 3, 3);

-- 4. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (125, 1, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (126, 2, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (127, 3, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (128, 4, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (129, 5, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (130, 6, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (131, 7, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (132, 8, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (133, 9, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (134, 10, 4, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (135, 11, 4, 3);

-- 5. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (136, 1, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (137, 2, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (138, 3, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (139, 4, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (140, 5, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (141, 6, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (142, 7, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (143, 8, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (144, 9, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (145, 10, 5, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (146, 11, 5, 3);

-- 6. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (147, 1, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (148, 2, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (149, 3, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (150, 4, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (151, 5, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (152, 6, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (153, 7, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (154, 8, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (155, 9, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (156, 10, 6, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (157, 11, 6, 3);

-- 7. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (158, 1, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (159, 2, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (160, 3, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (161, 4, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (162, 5, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (163, 6, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (164, 7, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (165, 8, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (166, 9, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (167, 10, 7, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (168, 11, 7, 3);

-- 8. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (169, 1, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (170, 2, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (171, 3, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (172, 4, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (173, 5, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (174, 6, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (175, 7, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (176, 8, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (177, 9, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (178, 10, 8, 3);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (179, 11, 8, 3);

-- 4. terem

-- 1. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (180, 1, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (181, 2, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (182, 3, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (183, 4, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (184, 5, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (185, 6, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (186, 7, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (187, 8, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (188, 9, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (189, 10, 1, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (190, 11, 1, 4);

-- 2. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (191, 1, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (192, 2, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (193, 3, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (194, 4, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (195, 5, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (196, 6, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (197, 7, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (198, 8, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (199, 9, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (200, 10, 2, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (201, 11, 2, 4);

-- 3. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (202, 1, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (203, 2, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (204, 3, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (205, 4, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (206, 5, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (207, 6, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (208, 7, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (209, 8, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (210, 9, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (211, 10, 3, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (212, 11, 3, 4);

-- 4. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (213, 1, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (214, 2, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (215, 3, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (216, 4, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (217, 5, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (218, 6, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (219, 7, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (220, 8, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (221, 9, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (222, 10, 4, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (223, 11, 4, 4);

-- 5. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (224, 1, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (225, 2, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (226, 3, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (227, 4, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (228, 5, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (229, 6, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (230, 7, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (231, 8, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (232, 9, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (233, 10, 5, 4);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (234, 11, 5, 4);

-- 5. terem

-- 1. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (235, 1, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (236, 2, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (237, 3, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (238, 4, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (239, 5, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (240, 6, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (241, 7, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (242, 8, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (243, 9, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (244, 10, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (245, 11, 1, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (246, 12, 1, 5);

-- 2. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (247, 1, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (248, 2, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (249, 3, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (250, 4, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (251, 5, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (252, 6, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (253, 7, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (254, 8, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (255, 9, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (256, 10, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (257, 11, 2, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (258, 12, 2, 5);

-- 3. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (259, 1, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (260, 2, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (261, 3, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (262, 4, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (263, 5, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (264, 6, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (265, 7, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (266, 8, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (267, 9, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (268, 10, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (269, 11, 3, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (270, 12, 3, 5);

-- 4. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (271, 1, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (272, 2, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (273, 3, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (274, 4, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (275, 5, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (276, 6, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (277, 7, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (278, 8, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (279, 9, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (280, 10, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (281, 11, 4, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (282, 12, 4, 5);

-- 5. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (283, 1, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (284, 2, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (285, 3, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (286, 4, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (287, 5, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (288, 6, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (289, 7, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (290, 8, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (291, 9, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (292, 10, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (293, 11, 5, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (294, 12, 5, 5);

-- 6. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (295, 1, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (296, 2, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (297, 3, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (298, 4, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (299, 5, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (300, 6, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (301, 7, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (302, 8, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (303, 9, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (304, 10, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (305, 11, 6, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (306, 12, 6, 5);

-- 7. sor
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (307, 1, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (308, 2, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (309, 3, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (310, 4, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (311, 5, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (312, 6, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (313, 7, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (314, 8, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (315, 9, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (316, 10, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (317, 11, 7, 5);
INSERT INTO public.seat(id, seatcolumn, seatrow, theatre_id) VALUES (318, 12, 7, 5);

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

-- Adminok
INSERT INTO public.admin(id, name, password, username) VALUES (1, 'Adam', 'adamtakeow', 'adamtakeow');
INSERT INTO public.admin(id, name, password, username) VALUES (2, 'Nándi', 'dandy', 'dandy');
INSERT INTO public.admin(id, name, password, username) VALUES (3, 'Levi', 'szanicsl', 'szanicsl');


-- Filmek 

INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (1, 'Legendás állatok és megfigyelésük', 13, pg_read_binary_file('legend.jpg'), 'Göthe Salmander (Eddie Redmayne) professzor, a bűvös fenevadak és bestiák szakembere New Yorkba érkezik. A muglik között bujkáló varázslók és boszorkányok közösségének segítségével keresi a városban élő szörnyeket. És talán meg is találja őket... A Harry Potter-világ feltámad, a történet jó 70 évvel Potter születése előtt játszódik: a nézők a varázslatos kalandok közben a varázsvilág múltját is megismerhetik.', 133, 'LEGENALLMEGF', 0.0, 0, 5); 
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (2, 'The Edge of Seventeen', 16, pg_read_binary_file('edgeofseventeen.jpg'), 'Nadine (Steinfeld) a gimisek szokásos életét éli, azaz ő is úgy érzi, hogy az élet nagyon kemény és kicseszik vele. Mindezt csak tetézi, amikor a mindenki által kedvelt bátyja (Jenner) randizni kezd legjobb barátnőjével (Richardson). Nadine egyre szerencsétlenebbnek és nagyon magányosnak érzi magát, mígnem megismerkedik egy sráccal és életszemlélete is megváltozik.', 104, 'EDGEOFSEVENTEEN', 0.0, 0, 6);
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (3, 'Éjszakai ragadozók', 16, pg_read_binary_file('nocturnal.jpg'), 'Susan Morrow, Los Angeles-i műkereskedő hihetetlen jómódban él férjével, Hutton Morrowval, ám mégsem érzi teljesnek az életét. Az egyik hétvégén Hutton elutazik az egyik szokásos és túlzottan gyakorta esedékes üzleti útjára, Susan pedig egy csomagot talál a postaládájában. A csomagban egy regényt van, melyet a volt férje, Edward Sheffield írt, akivel már évek óta nem beszélt. A küldeményhez Edward egy levélkét is mellékelt, melyben arra bíztatja Susant, hogy olvassa el az írást, aztán keresse meg, amíg ő a városban tartózkodik. Este, egyedül az ágyban Susan olvasni kezd. A könyvet neki ajánlották...de a tartalma erőszakos és pusztító erejű. Susant olvasás közben mélyen megindítja Edward írása, és akarva-akaratlanul is felidézi a szerzővel közös szerelmi történetük legintimebb pillanatait. Megpróbál magába tekinteni, életének és karrierjének csillogó felszíne alá, és egyre inkább egyfajta  bosszúként értelmezi a könyvet, melynek története arra kényszeríti, hogy átértékelje a döntéseit. Újraéled a szerelem, melyet elveszettnek hitt, és ahogy a történet halad, olyan felismerésre készteti, amely újraértelmezi a regény hősét és saját magát is. ', 117, 'NOCANIM', 0.0, 0, 8);
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (4, 'Inferno', 16, pg_read_binary_file('inferno.jpg'), 'Langdon professzor (Tom Hanks) felébred. A Harvard veszélyes kalandoktól sem visszariadó szimbólumkutatója számára ez kivételesen nem hétköznapi eset. Ugyanis egy firenzei kórházban van, és nem tudja, hogyan került oda. Lőtt sebbel ápolják, és azt a különös tárgyat sem tudja megmagyarázni, amit nála találnak. A prof. - mint eddigi kalandjai során mindig - ismét egyszerre kénytelen menekülni és nyomozni. Egy fiatal orvosnő (Felicity Jones) segítségével próbálja keresztülvágni magát az őt körülvevő rejtélyek hálóján. Csupán Dante legendás műve, a Pokol néhány sora segíti - és úgy érzi, egyre mélyebbre kerül az életre kelő, rejtélyekkel és fenyegetésekkel teli pokolban. ', 121, 'INFERNO', 0.0, 0, 3);
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (5, 'Trollok', 6, pg_read_binary_file('trolls.jpg'), 'Nagy szemű, borzas hajú, színes kis figurák ők, akik saját világukban élnek. Ám két troll kénytelen vándorútra indulni: olyan tájakra jutnak el, és olyan kalandokba keverednek, amikről troll korábban nem is álmodott - és amitől biztosan az égnek áll a haja. ', 92, 'TROLLOK', 0.0, 0, 9);
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (6, 'Snowden', 12, pg_read_binary_file('snowden.jpg'), 'Edward Snowden a hazáját akarta szolgálni. Bár egészségi állapota katonai karrierjének hamar véget vet, informatikusként azonban helyet kap a titkosszolgálatnál. Itt aztán megdöbbentő felfedezést tesz: az amerikai kormány a világon bárkit képes megfigyelni, telefonokat hallgat le, e-maileket olvas el, még a laptopunk kameráin keresztül is képes megfigyelni saját otthonunkban. Snowden, aki szentül hisz a szabadságban és az Amerikai Egyesült Államokban, válaszút elé kerül: vagy ő is asszisztál a kormány illegálisnak vélt és etikátlan cselekedeteihez, vagy nyilvánosságra hozza mindazt, amit megtudott és menekülni  kényszerül... ', 134, 'SNOWDEN', 0.0, 0, 6);
INSERT INTO public.movie(id, name, agelimit, image, description, length, moviecode, rating, ratecounter, genre_id) VALUES (7, 'Vaksötét', 18, pg_read_binary_file('vaksotet.jpg'), 'Két fiatal srác és egy lány a környékbeli házak fosztogatásával egészíti ki a zsebpénzét. Ügyesek, gyorsak, gátlástalanok, így aztán egyre sikeresebbek. Amikor kinéznek maguknak egy a világtól visszavonultan élő vak férfit (Stephen Lang), akiről az a hír járja, hogy milliókat rejteget otthon, azt hiszik, még az eddigieknél is könnyebb dolguk lesz. Tévednek: az eddigieknél sokkal nehezebb feladattal találják szembe magukat: életben kell maradniuk. A férfi ugyanis őrült. Kegyetlen, gátlástalan pszichopata, és a három betörő fogollyá válik a házában. Attól kezdve a túlélésért küzdenek. A vak férfi azonban mintha olvasna a gondolataikban, mintha látna a sötétben, mindig előttük jár, és mindig okosabbnak bizonyul náluk. Játszik a támadóival. Méghozzá egy nagyon kegyetlen játékot.', 88, 'VAKSOTET', 0.0, 0, 2);

-- Vendégek

INSERT INTO public.guest( id, name, email, phonenumber, zip, cupon_id) VALUES (1, 'Teszt Elek', 'teszt.elek@TSTmail.com', '06204342543', '4440', null);
INSERT INTO public.guest( id, name, email, phonenumber, zip, cupon_id) VALUES (2, 'Lenovo Laptop', 'laptop.lenov@TST.hu', '06204332143', '4210', null);
INSERT INTO public.guest( id, name, email, phonenumber, zip, cupon_id) VALUES (3, 'Kiss Béla', 'belavagyok@TSTmail.com', '06304344543', '1240', null);
INSERT INTO public.guest( id, name, email, phonenumber, zip, cupon_id) VALUES (4, 'Joó Evelin', 'evelin121@TSTmail.hu', '06704242546', '3240', null);
INSERT INTO public.guest( id, name, email, phonenumber, zip, cupon_id) VALUES (5, 'Hack Klára', 'tenminuteemail@TSTmail.net', '06203432432', '1130', null);

-- Kuponok

INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (1, 'Ingyen kóla', '2017-12-12', '2016-01-02', 'FREE_ITEM', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (2, 'Ajándék Popcorn', '2017-12-12', '2016-01-02', 'GIFT', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (3, '3 jegy esetén 1 ingyenes', '2017-12-12', '2016-01-02', 'OFFER', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (4, 'Ajándék karkötő', '2017-12-12', '2016-01-02', 'GIFT', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (5, 'Ingyen előadás', '2017-12-12', '2016-01-02', 'OFFER', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (6, '500 Ft kedvezmény', '2017-12-12', '2016-01-02', 'DISCOUNT', false);
INSERT INTO public.cupon(id, name, endofvalidity, startofvalidity, type, used) VALUES (7, '1000 Ft kedvezmény', '2017-12-12', '2016-01-02', 'DISCOUNT', false);

-- Vetítések

INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (1, to_timestamp(current_date || ' 15:57:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 14:00:00','YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (2, to_timestamp(current_date || ' 20:13:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 18:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (3, to_timestamp(current_date || ' 11:32:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 10:00:00','YYYY-MM-DD HH24:MI:SS'), 4, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (4, to_timestamp(current_date || ' 21:28:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 20:00:00','YYYY-MM-DD HH24:MI:SS'), 6, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (5, to_timestamp(current_date || ' 18:14:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 16:00:00','YYYY-MM-DD HH24:MI:SS'), 5, 3);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (6, to_timestamp(current_date || ' 10:44:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date || ' 9:00:00','YYYY-MM-DD HH24:MI:SS'), 2, 5);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (7, to_timestamp(current_date + 1 || ' 15:57:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 14:00:00','YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (8, to_timestamp(current_date + 1 || ' 20:13:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 18:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (9, to_timestamp(current_date + 1 || ' 11:32:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 10:00:00','YYYY-MM-DD HH24:MI:SS'), 4, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (10, to_timestamp(current_date + 1 || ' 21:28:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 20:00:00','YYYY-MM-DD HH24:MI:SS'), 6, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (11, to_timestamp(current_date + 1 || ' 18:14:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 16:00:00','YYYY-MM-DD HH24:MI:SS'), 5, 3);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (12, to_timestamp(current_date + 1 || ' 10:44:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 1 || ' 9:00:00','YYYY-MM-DD HH24:MI:SS'), 2, 5);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (13, to_timestamp(current_date + 2 || ' 15:57:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 14:00:00','YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (14, to_timestamp(current_date + 2 || ' 20:13:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 18:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (15, to_timestamp(current_date + 2 || ' 11:32:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 10:00:00','YYYY-MM-DD HH24:MI:SS'), 4, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (16, to_timestamp(current_date + 2 || ' 21:28:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 20:00:00','YYYY-MM-DD HH24:MI:SS'), 6, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (17, to_timestamp(current_date + 2 || ' 18:14:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 16:00:00','YYYY-MM-DD HH24:MI:SS'), 5, 3);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (18, to_timestamp(current_date + 2 || ' 10:44:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 2 || ' 9:00:00','YYYY-MM-DD HH24:MI:SS'), 2, 5);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (19, to_timestamp(current_date + 3 || ' 15:57:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 14:00:00','YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (20, to_timestamp(current_date + 3 || ' 20:13:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 18:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (21, to_timestamp(current_date + 3 || ' 11:32:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 10:00:00','YYYY-MM-DD HH24:MI:SS'), 4, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (22, to_timestamp(current_date + 3 || ' 21:28:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 20:00:00','YYYY-MM-DD HH24:MI:SS'), 6, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (23, to_timestamp(current_date + 3 || ' 18:14:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 16:00:00','YYYY-MM-DD HH24:MI:SS'), 5, 3);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (24, to_timestamp(current_date + 3 || ' 10:44:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 3 || ' 9:00:00','YYYY-MM-DD HH24:MI:SS'), 2, 5);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (25, to_timestamp(current_date + 4 || ' 15:57:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 14:00:00','YYYY-MM-DD HH24:MI:SS'), 3, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (26, to_timestamp(current_date + 4 || ' 20:13:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 18:00:00','YYYY-MM-DD HH24:MI:SS'), 1, 1);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (27, to_timestamp(current_date + 4 || ' 11:32:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 10:00:00','YYYY-MM-DD HH24:MI:SS'), 4, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (28, to_timestamp(current_date + 4 || ' 21:28:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 20:00:00','YYYY-MM-DD HH24:MI:SS'), 6, 2);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (29, to_timestamp(current_date + 4 || ' 18:14:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 16:00:00','YYYY-MM-DD HH24:MI:SS'), 5, 3);
INSERT INTO public.movieshow(id, endtime, starttime, movie_id, theatre_id) VALUES (30, to_timestamp(current_date + 4 || ' 10:44:00','YYYY-MM-DD HH24:MI:SS'), to_timestamp(current_date + 4 || ' 9:00:00','YYYY-MM-DD HH24:MI:SS'), 2, 5);

-- Foglalások

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (1, false, 1, 3);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (1, 38);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (2, false, 2, 6);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (2, 290);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (3, false, 3, 9);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (3, 80);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (4, false, 4, 13);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (4, 20);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (5, false, 5, 16);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (5, 51);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (6, false, 1, 15);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (6, 55);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (7, false, 2, 25);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (7, 4);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (8, false, 3, 22);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (8, 90);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (9, false, 4, 29);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (9, 154);

INSERT INTO public.appointment(id, deprecated, guest_id, movieshow_id) VALUES (10, false, 5, 7);
INSERT INTO public.appointment_seat(appointment_id, seats_id) VALUES (10, 39);