INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antartida');

INSERT INTO tipo_eventos (id, nombre) VALUES (1, 'Discoteca');
INSERT INTO tipo_eventos (id, nombre) VALUES (2, 'Boda');
INSERT INTO tipo_eventos (id, nombre) VALUES (3, 'Bautizo');
INSERT INTO tipo_eventos (id, nombre) VALUES (4, 'Comunion');
INSERT INTO tipo_eventos (id, nombre) VALUES (5, 'Despedida de Solteros');
INSERT INTO tipo_eventos (id, nombre) VALUES (6, 'Fiesta de Empresa');
INSERT INTO tipo_eventos (id, nombre) VALUES (7, 'Restaurante');
INSERT INTO tipo_eventos (id, nombre) VALUES (8, 'Cumpleaños');
INSERT INTO tipo_eventos (id, nombre) VALUES (9, 'Verbenas');

INSERT INTO generos_musicales (id, nombre) VALUES (1, 'Reggaeton');
INSERT INTO generos_musicales (id, nombre) VALUES (2, 'Techno');
INSERT INTO generos_musicales (id, nombre) VALUES (3, 'Comercial');
INSERT INTO generos_musicales (id, nombre) VALUES (4, 'Pop');
INSERT INTO generos_musicales (id, nombre) VALUES (5, 'Pachangueo');
INSERT INTO generos_musicales (id, nombre) VALUES (6, 'Remember');
INSERT INTO generos_musicales (id, nombre) VALUES (7, 'Hard Techno');
INSERT INTO generos_musicales (id, nombre) VALUES (8, 'Años 80');
INSERT INTO generos_musicales (id, nombre) VALUES (9, 'Rock');
INSERT INTO generos_musicales (id, nombre) VALUES (10, 'Indie');
INSERT INTO generos_musicales (id, nombre) VALUES (11, 'Chill Out');

INSERT INTO rango_edades (id, nombre) VALUES (1, '0 - 13 años');
INSERT INTO rango_edades (id, nombre) VALUES (2, '14 - 17 años');
INSERT INTO rango_edades (id, nombre) VALUES (3, '18 - 23 años');
INSERT INTO rango_edades (id, nombre) VALUES (4, '24 - 32 años');
INSERT INTO rango_edades (id, nombre) VALUES (5, '33 - 45 años');
INSERT INTO rango_edades (id, nombre) VALUES (6, '45 - 55 años');
INSERT INTO rango_edades (id, nombre) VALUES (7, '55 - 70 años');
INSERT INTO rango_edades (id, nombre) VALUES (8, '70 - 90 años');


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


INSERT INTO reservas ( nombre, apellido, email, fechaEvento, ubicacion, observacion, tipoEvento_id, generoMusical_id , rangoEdad_id) VALUES ('Iñaki', 'López', 'iñaki@hotmail.com', '2021-09-14', 'Mirasierra', 'Restaurante de lujo',1, 3, 4);
INSERT INTO reservas ( nombre, apellido, email, fechaEvento, ubicacion, observacion, tipoEvento_id, generoMusical_id , rangoEdad_id) VALUES ('David', 'López', 'david@hotmail.com', '2023-11-12', 'Mirasierra', 'Restaurante de lujo',2, 2, 5);
INSERT INTO reservas ( nombre, apellido, email, fechaEvento, ubicacion, observacion, tipoEvento_id, generoMusical_id , rangoEdad_id) VALUES ('Pedro', 'Muñoz', 'pedro@hotmail.com', '2022-09-06', 'Mirasierra', 'Restaurante de lujo',4, 2 ,3);
INSERT INTO reservas ( nombre, apellido, email, fechaEvento, ubicacion, observacion, tipoEvento_id, generoMusical_id , rangoEdad_id) VALUES ('Maria', 'Sevilla', 'maria@hotmail.com', '2022-09-14', 'Mirasierra', 'Restaurante de lujo',3, 1, 7);
INSERT INTO reservas ( nombre, apellido, email, fechaEvento, ubicacion, observacion, tipoEvento_id, generoMusical_id , rangoEdad_id) VALUES ('Luisa', 'Nieta', 'luisa@hotmail.com', '2020-09-09', 'Mirasierra', 'Restaurante de lujo',5, 1, 3);


INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('David','$2a$10$9PFNOc/LWDB6ylGLx1RYtOAi5tPDS/EtK40iokjhS1VZZEjZCduGS', 1, 'David', 'Munoz', 'david@hotmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email) VALUES ('Admin','$2a$10$9PFNOc/LWDB6ylGLx1RYtOAi5tPDS/EtK40iokjhS1VZZEjZCduGS', 1, 'Admin', 'Admin', 'admin@hotmail.com');

INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,1);
-- INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (1,2);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2,1);
INSERT INTO usuarios_roles (usuario_id, rol_id) VALUES (2,2);

INSERT INTO productos (nombre, precio, create_at) VALUES ('Mesa Pioneer Rx3', 1900, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Soporte Mesa', 100, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Luces Led Apoyo', 300, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Altavoz Mackie 15', 400, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Cable XLR', 30, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('MacBook', 500, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES ('Micro X', 100, NOW());

