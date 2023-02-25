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
#Vakhtang Gorgasali Street
INSERT INTO streetlocation VALUES(17, 4, 41.64999, 41.64262, 7);