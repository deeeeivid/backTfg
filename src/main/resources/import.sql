INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antartida');


INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('David', 'Muñoz', 'david@hotmail.com', '2021-01-01', 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Iván', 'Pérez', 'ivan@hotmail.com', '2022-02-20', 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Victor', 'Aguilar', 'victor@hotmail.com', '2024-03-19', 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Raquel', 'Trino', 'raquel@hotmail.com', '2024-04-18', 8);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('María', 'Muñoz', 'maria@hotmail.com', '2024-05-15', 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Pedro', 'López', 'pedro@hotmail.com', '2023-06-10', 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Adrian', 'Macias', 'adri@hotmail.com', '2023-07-10', 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Luis', 'Carlos', 'luis@hotmail.com', '2023-08-10', 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Alicia', 'Ortega', 'alicia@hotmail.com', '2024-11-10', 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Elena', 'Nieto', 'elena@hotmail.com', '2022-03-28', 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Irene', 'Pastrana', 'irene@hotmail.com', '2021-02-09', 5);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Sandra', 'López', 'san@hotmail.com', '2022-07-14', 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Jesus', 'Rodri', 'jesus@hotmail.com', '2022-07-14', 1);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Alberto', 'Fdez', 'afs@hotmail.com', '2022-07-01', 3);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Iñaki', 'López', 'iñaki@hotmail.com', '2022-09-14', 4);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Oscar', 'López', 'oscar@hotmail.com', '2022-02-11', 2);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Daniel', 'Sanz', 'sanz@hotmail.com', '2022-04-14', 7);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Victorio', 'Matesta', 'mat@hotmail.com', '2022-05-02', 6);
INSERT INTO clientes (nombre, apellido, email, create_at, region_id) VALUES ('Carlos', 'Peña', 'peña@hotmail.com', '2022-08-13', 3);


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('David','$2a$10$9PFNOc/LWDB6ylGLx1RYtOAi5tPDS/EtK40iokjhS1VZZEjZCduGS', 1, 'David', 'Munoz', 'david@hotmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('ADMIN','$2a$10$9PFNOc/LWDB6ylGLx1RYtOAi5tPDS/EtK40iokjhS1VZZEjZCduGS', 1, 'Admin', 'Admin', 'admin@hotmail.com');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,1);
-- INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2,1);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2,2);



