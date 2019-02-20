DELETE from crime_type;
DELETE from city;
DELETE from role;
INSERT INTO crime_type (name, type) VALUES ('Abuse', 'ABUSE'), 
										   ('Arson', 'ARSON'),
										   ('Bulgrary', 'BURGLARY'),
										   ('Harasment', 'HARASMENT'),
										   ('Fraud', 'FRAUD'),
										   ('Murder', 'MURDER');
										   
INSERT INTO city (name) VALUES ('Addis Ababa'), 
										   ('Adama'),
										   ('Dire Dawa'),
										   ('Mekele')
										  ;
INSERT INTO role (role) VALUES ('USER'), ('ADMIN') , ('SUPER_ADMIN');
