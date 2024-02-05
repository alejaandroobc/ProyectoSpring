INSERT INTO surfboard (sbsize,maker,sbyear) VALUES (1.2,'NSP',3);
INSERT INTO surfboard (sbsize, maker, sbyear) VALUES (6.0, 'Channel Islands', 2022);
INSERT INTO surfboard (sbsize, maker, sbyear) VALUES (5.8, 'Firewire', 2020);
INSERT INTO surfboard (sbsize, maker, sbyear) VALUES (6.2, 'Lost Surfboards', 2021);
INSERT INTO surfboard (sbsize, maker, sbyear) VALUES (5.10, 'JS Industries', 2023);

INSERT INTO spot (name, country) VALUES ('Pipeline', 'Hawaii');
INSERT INTO spot (name, country) VALUES ('J-Bay', 'South Africa');
INSERT INTO spot (name, country) VALUES ('Teahupoʻo', 'French Polynesia');
INSERT INTO spot (name, country) VALUES ('Banzai Pipeline', 'Hawaii');
INSERT INTO spot (name, country) VALUES ('Supertubos', 'Portugal');

INSERT INTO surfer (name, age, country, score, surfboard_id) VALUES ('Kelly Slater', 49, 'USA', 95, 1);
INSERT INTO surfer (name, age, country, score, surfboard_id) VALUES ('Stephanie Gilmore', 33, 'Australia', 92, 2);
INSERT INTO surfer (name, age, country, score, surfboard_id) VALUES ('Gabriel Medina', 28, 'Brazil', 89, 3);
INSERT INTO surfer (name, age, country, score, surfboard_id) VALUES ('Carissa Moore', 29, 'USA', 94, 4);
INSERT INTO surfer (name, age, country, score, surfboard_id) VALUES ('John John Florence', 29, 'USA', 91, 5);

INSERT INTO wave (height, duration, dates, spot_id, surfer_id) VALUES (3.0, 60, '2024-02-04T12:00:00', 1, 1);
INSERT INTO wave (height, duration, dates, spot_id, surfer_id) VALUES (2.5, 45, '2024-02-04T13:30:00', 2, 2);
INSERT INTO wave (height, duration, dates, spot_id, surfer_id) VALUES (4.0, 70, '2024-02-04T15:45:00', 3, 3);
INSERT INTO wave (height, duration, dates, spot_id, surfer_id) VALUES (3.5, 55, '2024-02-04T17:15:00', 4, 4);
INSERT INTO wave (height, duration, dates, spot_id, surfer_id) VALUES (2.8, 50, '2024-02-04T19:30:00', 5, 5);



