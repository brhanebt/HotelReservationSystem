DROP TABLE IF EXISTS auth_user_role;
DROP TABLE IF EXISTS auth_role;
DROP TABLE IF EXISTS auth_user;
DROP TABLE IF EXISTS Booking;
DROP TABLE IF EXISTS room;

CREATE TABLE auth_role(

    auth_role_id int NOT NULL AUTO_INCREMENT,
    role_name varchar(255) DEFAULT NULL,
    role_desc varchar(255) DEFAULT NULL,
    PRIMARY KEY (auth_role_id)
);

CREATE TABLE auth_user(

  auth_user_id int NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  mobile varchar(255) Not Null,
  status varchar(255),
  userName varchar(255) Not Null,
  PRIMARY KEY (auth_user_id)
);

CREATE TABLE auth_user_role (

  auth_user_id int NOT NULL,
  auth_role_id int NOT NULL,
  PRIMARY KEY (auth_user_id, auth_role_id),
  CONSTRAINT Fk_auth_user FOREIGN KEY (auth_user_id) REFERENCES auth_user(auth_user_id),
  CONSTRAINT Fk_auth_user_role FOREIGN KEY (auth_role_id) REFERENCES auth_role(auth_role_id)
) ;

create table room( ID BIGINT primary key AUTO_INCREMENT NOT NULL, 
	roomNumber varchar(25),
	floorNumber BIGINT,
	basePrice DOUBLE(5, 2),
	numBeds BIGINT,
	smoking boolean,
	windows boolean,
	airConditioning boolean
);


CREATE TABLE customer (
  id bigint(20) NOT NULL,
  email varchar(255) DEFAULT NULL,
  firstName varchar(255) NOT NULL,
  lastName varchar(255) NOT NULL,
  telephone varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);
