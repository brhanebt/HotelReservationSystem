#Brhane insert room


insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (0, 110, 0, 1, 'R010',  0, 1, 11);
insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (1, 75, 2, 2, 'R201',  1, 0, 111); 
insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (0, 85, 1, 3, 'R101', 0, 1, 1111);

#Ekubay insert to auth_role
INSERT INTO auth_user (auth_user_id, email, first_name, last_name, mobile, status, password, userName) VALUES (101, 'ad@mum.edu','admin', 'admin', '6142313425','ACTIVE','admin', 'admin');
INSERT INTO auth_user (auth_user_id,email,first_name,last_name,mobile, status, password, userName) VALUES (202, 'user@mum.edu','user1', 'user1', '6142313555','ACTIVE','user', 'user');

INSERT INTO auth_user (auth_user_id,email,first_name,last_name,mobile, status, password, userName) VALUES (303, 'manager@mum.edu','manager', 'manager', '6142313466','ACTIVE','manager', 'manager');

INSERT INTO auth_role VALUES(1, 'this user have access to login and signup', 'ROLE_ADMIN');
INSERT INTO auth_role VALUES(2, 'this user have access to everything', 'ROLE_USER');
INSERT INTO auth_role VALUES(3, 'this user have access to few employees', 'ROLE_MANAGER');

INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (101, 1);
INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (202, 2);
INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (303, 3);


INSERT INTO customer (id, email, firstName, lastName, telephone) VALUES ('001', 'jxao@mum.edu', 'jxao', 'xao', '6134368967');
INSERT INTO customer (id, email, firstName, lastName, telephone) VALUES ('002', 'teka@mum.edu', 'merhawi', 'teka', '4567892345');
