INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

INSERT INTO users (login, name, password) VALUES ('joao@joao.com', 'John Buscow', '$2a$10$bEwBwmh9i8t6Zt6o0kY40.yoG93LsiJBqfHDbETNxeT1LbxOevnPG');

INSERT INTO users_roles (roles_id, user_id) VALUES (2, 1);