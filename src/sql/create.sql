DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS Booking;
create table room( ID BIGINT primary key AUTO_INCREMENT NOT NULL, 
	roomNumber varchar(25),
	floorNumber BIGINT,
	basePrice DOUBLE(5, 2),
	numBeds BIGINT,
	smoking boolean,
	windows boolean,
	airConditioning boolean
);
					