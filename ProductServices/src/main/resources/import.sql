
-- Inicializamos la BD
CREATE TABLE Usuario (id INT PRIMARY KEY, username VARCHAR(1000) NOT NULL, password VARCHAR(1000));
INSERT INTO Usuario (username, password) VALUES ('admin', '$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.');
