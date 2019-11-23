#Brhane insert room

insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (0, 110, 0, 1, '010',  0, 1, 11);
insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (1, 75, 2, 2, '201',  1, 0, 111);
insert into Room (airConditioning, basePrice, floorNumber, numBeds, roomNumber, smoking, windows, id) values (0, 85, 1, 3, '101', 0, 1, 1111);


#Ekubay insert to auth_role
INSERT INTO auth_user (auth_user_id, email, first_name, last_name, mobile, status, password, userName)
VALUES (1, 'ad@mum.edu','admin', 'admin', '6142313425','yes','123', 'ADMIN_ROLE');
INSERT INTO auth_user (auth_user_id,email,first_name,last_name,mobile, status, password, userName)
VALUES (2, 'user@mum.edu','admin', 'admin', '6142313555','no','123', 'USER_ROLE');

INSERT INTO auth_user (auth_user_id,email,first_name,last_name,mobile, status, password, userName)
VALUES (3, 'manager@mum.edu','manager', 'manager', '6142313466','yes','123', 'USER_ROLE');

INSERT INTO auth_role VALUES(1, 'this user have access to login and signup', 'USER_ROLE');
INSERT INTO auth_role VALUES(2, 'this user have access to everything', 'ADMIN_ROLE');
INSERT INTO auth_role VALUES(3, 'this user have access to few employees', 'MANAGER_ROLE');

INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (1, 1);
INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (2, 2);
INSERT INTO auth_user_role (auth_user_id, auth_role_id) VALUES (3, 3);