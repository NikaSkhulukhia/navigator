USE navigatordb;

-- Car --
SELECT * FROM car;
INSERT INTO car VALUES(1, 60, "BMW", "X5", 2009, "SUV");

-- City --
SELECT * FROM city;
INSERT INTO city VALUES(1, "Batumi");
INSERT INTO city VALUES(2, "Tbilisi");
INSERT INTO city VALUES(3, "Kutaisi");

-- Directions --
SELECT * FROM directions;
INSERT INTO directions VALUES(1, 1, 1, False);
INSERT INTO directions VALUES(2, 1, 2, False);
INSERT INTO directions VALUES(3, 1, 3, False);
INSERT INTO directions VALUES(4, 1, 4, False);

INSERT INTO directions VALUES(5, 2, 2, False);
INSERT INTO directions VALUES(6, 2, 1, False);
INSERT INTO directions VALUES(8, 2, 5, False);

INSERT INTO directions VALUES(9, 3, 3, False);
INSERT INTO directions VALUES(10, 3, 1, False);
INSERT INTO directions VALUES(11, 3, 4, False);
INSERT INTO directions VALUES(12, 3, 5, False); 

INSERT INTO directions VALUES(13, 4, 4, False);
INSERT INTO directions VALUES(14, 4, 1, False);
INSERT INTO directions VALUES(15, 4, 3, False);
INSERT INTO directions VALUES(16, 4, 6, False);

INSERT INTO directions VALUES(17, 5, 5, False);
INSERT INTO directions VALUES(18, 5, 2, False);
INSERT INTO directions VALUES(19, 5, 3, False);
INSERT INTO directions VALUES(20, 5, 6, False);

INSERT INTO directions VALUES(21, 6, 6, False);
INSERT INTO directions VALUES(22, 6, 5, False);
INSERT INTO directions VALUES(23, 6, 4, False);

INSERT INTO directions VALUES(24, 7, 7, False);
INSERT INTO directions VALUES(25, 7, 2, False);
INSERT INTO directions VALUES(26, 7, 3, False);
INSERT INTO directions VALUES(27, 7, 5, False);
INSERT INTO directions VALUES(28, 7, 6, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 19, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(7, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 4, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 6, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(8, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(9, 19, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 4, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(10, 17, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 5, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(11, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 4, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 5, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(12, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 6, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(13, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 5, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 6, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 19, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(14, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(15, 19, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 4, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 8, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(16, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 1, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 19, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(17, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 10, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 11, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 14, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 15, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 19, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(18, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 19, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 3, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 7, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 12, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 16, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 17, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(19, 20, False);

INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 20, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 2, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 6, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 9, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 13, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 18, False);
INSERT INTO directions (idStreetLocation1, idStreetLocation2, trafficLight) VALUES(20, 19, False);





-- Public Transport --
SELECT * FROM publictransport;
INSERT INTO publictransport VALUES(1, 1, 40);
INSERT INTO publictransport VALUES(2, 4, 40);
INSERT INTO publictransport VALUES(3, 5, 40);
INSERT INTO publictransport VALUES(4, 7, 40);
INSERT INTO publictransport VALUES(5, 8, 40);
INSERT INTO publictransport VALUES(6, 11, 40);
INSERT INTO publictransport VALUES(7, 13, 40);
INSERT INTO publictransport VALUES(8, 17, 40);
INSERT INTO publictransport VALUES(9, 18, 40);
INSERT INTO publictransport VALUES(10, 20, 40);

-- Public Transport Directions -- 
SELECT * FROM publictransportdirections;
#Batumi Chavchavadze Street
INSERT INTO publictransportdirections VALUES(1, 1, 1);
#Batumi Ninoshvili Street
INSERT INTO publictransportdirections VALUES(2, 2, 5);
#Batumi Rustaveli Street
INSERT INTO publictransportdirections VALUES(3, 3, 7);
#Batumi Bagrationi Street
INSERT INTO publictransportdirections VALUES(4, 4, 10);
#Batumi Leonidze Street
INSERT INTO publictransportdirections VALUES(5, 5, 13);
#Batumi Vakhtang Gorgasali Street
INSERT INTO publictransportdirections VALUES(6, 6, 17);
# generated statements
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (7, 11);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (2, 7);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (8, 14);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (3, 3);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (5, 10);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (10, 4);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (9, 11);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (8, 16);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (7, 14);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (5, 13);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (8, 6);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (3, 2);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (10, 16);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (1, 2);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (9, 15);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (4, 7);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (5, 8);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (8, 15);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (1, 16);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (3, 10);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (6, 12);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (4, 7);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (10, 1);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (7, 8);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (9, 6);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (2, 12);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (3, 17);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (6, 9);
INSERT INTO PublicTransportDirections (idPublicTransport, idStreetLocation) VALUES (10, 7);



-- Street --
SELECT * FROM street;
#BATUMI
INSERT INTO street VALUES(1, "Ilia Chavchavadze Street", 1);
INSERT INTO street VALUES(2, "Ninoshvili Street", 1);
INSERT INTO street VALUES(3, "Rustaveli Street", 1);
INSERT INTO street VALUES(4, "Bagrationi Street", 1);
INSERT INTO street VALUES(5, "Leonidze Street", 1);
INSERT INTO street VALUES(6, "Pushkin Street", 1);
INSERT INTO street VALUES(7, "Vakhtang Gorgasali Street", 1);
#TBILISI
INSERT INTO street VALUES(8, "David Agmashenebeli Avenue", 2);
INSERT INTO street VALUES(9, "Pekini Street", 2);
INSERT INTO street VALUES(10, "Alexander Kazbegi Avenue", 2);
INSERT INTO street VALUES(11, "Erekle Tatishvili Street", 2);
INSERT INTO street VALUES(12, "Ilia Chavchavadze Street", 2);
INSERT INTO street VALUES(13, "Tsotne Dadiani Street", 2);
INSERT INTO street VALUES(14, "Ksani Street", 2);
#KUTAISI
INSERT INTO street VALUES(15,"Bagrati Street",3);
INSERT INTO street VALUES(16,"Grishashvili Street",3);
INSERT INTO street VALUES(17,"Gogebashvili Street",3);
INSERT INTO street VALUES(18,"David Agmashenebeli Street",3);
INSERT INTO street VALUES(19,"Nikea Street",3);
INSERT INTO street VALUES(20,"Sulkhan Saba Avenue",3);

-- Street Location --
SELECT * FROM streetlocation;
#Batumi Chavchavadze Street
INSERT INTO streetlocation VALUES(1, 7, 41.64719, 41.64357, 1);
INSERT INTO streetlocation VALUES(2, 15, 41.64682, 41.64240, 1);
INSERT INTO streetlocation VALUES(3, 49, 41.64431, 41.63499, 1);
INSERT INTO streetlocation VALUES(4, 131, 41.64142, 41.62584, 1);
#Batumi Ninoshvili Street
INSERT INTO streetlocation VALUES(5, 5, 41.65045, 41.62727, 2);
INSERT INTO streetlocation VALUES(6, 2, 41.65358, 41.63612, 2);
#Batumi Rustaveli Street
INSERT INTO streetlocation VALUES(7, 1, 41.65289, 41.63817, 3);
INSERT INTO streetlocation VALUES(8, 57, 41.64618, 41.61992, 3);
INSERT INTO streetlocation VALUES(9, 61, 41.64512, 41.62010, 3);
#Batumi Bagrationi Street
INSERT INTO streetlocation VALUES(10, 79, 41.63738, 41.64323, 4);
INSERT INTO streetlocation VALUES(11, 125, 41.63384, 41.62534, 4);
#Batumi Leonidze Street
INSERT INTO streetlocation VALUES(12, 12, 41.62115, 41.62425, 5);
#Batumi Pushkin Street
INSERT INTO streetlocation VALUES(13, 1, 41.64288, 41.64797, 6);
INSERT INTO streetlocation VALUES(14, 19, 41.64322, 41.64614, 6);
INSERT INTO streetlocation VALUES(15, 23, 41.64389, 41.64404, 6);
INSERT INTO streetlocation VALUES(16, 109, 41.64228, 41.63527, 6);
#Batumi Vakhtang Gorgasali Street
INSERT INTO streetlocation VALUES(17, 4, 41.64999, 41.64262, 7);

#Tbilisi David Agmashenebeli Avenue
INSERT INTO streetlocation VALUES(18, 2, 41.70628, 44.79994, 8);
INSERT INTO streetlocation VALUES(19, 15, 41.70357, 44.80391, 8);
INSERT INTO streetlocation VALUES(20, 105, 41.71236, 44.79608, 8);
INSERT INTO streetlocation VALUES(21, 135, 41.71555, 44.79333, 8);
#Tbilisi Pekini Street
INSERT INTO streetlocation VALUES(22, 20, 41.72335, 44.77228, 9);
INSERT INTO streetlocation VALUES(23, 35, 41.72782, 44.76847, 9);
INSERT INTO streetlocation VALUES(24, 55, 41.73056, 44.76760, 9);
#Tbilisi Alexander Kazbegi Avenue
INSERT INTO streetlocation VALUES(25, 10, 41.72602, 44.76476, 10);
INSERT INTO streetlocation VALUES(26, 45, 41.72442, 44.74481, 10);
INSERT INTO streetlocation VALUES(27, 63, 41.72398, 44.73946, 10);
#Tbilisi Erekle Tatishvili Street
INSERT INTO streetlocation VALUES(28, 31, 41.70534, 44.78330, 11);
INSERT INTO streetlocation VALUES(29, 105, 41.70493, 44.78300, 11);
INSERT INTO streetlocation VALUES(30, 3, 41.70726, 44.78448, 11);
#Tbilisi Ilia Chavchavadze Street
INSERT INTO streetlocation VALUES(31, 17, 41.68899, 44.77665, 12);
INSERT INTO streetlocation VALUES(32, 49, 41.68975, 44.77557, 12);
#Tbilisi Tsotne Dadiani Street
INSERT INTO streetlocation VALUES(33, 2, 41.73577, 44.79650, 13);
#Tbilisi Ksani Street
INSERT INTO streetlocation VALUES(34, 4, 41.76673, 44.78985, 14);

#Kutaisi Bagrati Street
INSERT INTO streetlocation VALUES(35, 4, 42.27637, 42.70274, 15);
INSERT INTO streetlocation VALUES(36, 14, 42.27616, 42.70371, 15);
INSERT INTO streetlocation VALUES(37, 22, 42.27706, 42.70286, 15);
#Kutaisi Grishashvili Street
INSERT INTO streetlocation VALUES(38, 33, 42.26781, 42.69734, 16);
INSERT INTO streetlocation VALUES(39, 52, 42.26761, 42.69506, 16);
INSERT INTO streetlocation VALUES(40, 14, 42.26800, 42.69705, 16);
#Kutaisi Gogebashvili Street
INSERT INTO streetlocation VALUES(41, 1, 42.26975, 42.70617, 17);
INSERT INTO streetlocation VALUES(42, 29, 42.26860, 42.71033, 17);
#Kutaisi David Agmashenebeli Street
INSERT INTO streetlocation VALUES(43, 6, 42.26796, 42.70385, 18);
INSERT INTO streetlocation VALUES(44, 22, 42.26159, 42.70257, 18);
#Kutaisi Nikea Street
INSERT INTO streetlocation VALUES(45, 1, 42.24517, 42.69903, 19);
INSERT INTO streetlocation VALUES(46, 5, 42.24867, 42.69454, 19);
#Kutaisi Sulkhan Saba Avenue
INSERT INTO streetlocation VALUES(47, 9, 42.26744, 42.71791, 20);