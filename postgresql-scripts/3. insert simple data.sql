-- INSERT SOME CLIENTS
INSERT INTO clients(name,status)
	VALUES
		('Warzywniak','A'),
		('Komputerowy','A'),
		('Butik','A');
-- INSERT SOME SYSTEMS
INSERT INTO systems (name,description,tech_desc,client_id,status)
	VALUES
		('ZiemniOR','Kazdy je lubi!','Noz, widelec, Javascript',(SELECT order_id FROM clients WHERE name = 'Warzywniak'),'A'),
		('PeCet','','Myszka, klawiatura',(SELECT order_id FROM clients WHERE name = 'Komputerowy'),'A'),
		('KieCKa','Jedna krotsza, druga dluzsza.','Python',(SELECT order_id FROM clients WHERE name = 'Butik'),'A');
-- INSERT SOME CONTRACTS
INSERT INTO contracts(contract_number, system_id, date_from, date_to, amount, currency, amount_type, amount_period, status)
	VALUES
		('122/2016',(SELECT order_id FROM systems WHERE name = 'ZiemniOR'),'2016-10-01','2016-10-31',5200,'USD','NET','MONTH','N'),
		('132/2016',(SELECT order_id FROM systems WHERE name = 'ZiemniOR'),'2016-11-01','2016-11-30',5200,'PLN','BRU','MONTH','A'),
		('111/2016',(SELECT order_id FROM systems WHERE name = 'PeCet'),'2016-09-01','2016-11-30',15000,'PLN','NET','YEAR','A'),
		('1/2016',(SELECT order_id FROM systems WHERE name = 'KieCKa'),'2016-01-01','2016-12-31',88000,'PLN','BRU','YEAR','A');

