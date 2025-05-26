CREATE TABLE IF NOT EXISTS Datos (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     nombre VARCHAR(255) UNIQUE,
                                     dni VARCHAR(255),
                                     nExpediente VARCHAR(255),
                                     euros DECIMAL(10,2),
                                     email VARCHAR(255),
                                     telefono INT,
                                     presentado BOOLEAN DEFAULT FALSE,
                                     validado BOOLEAN DEFAULT FALSE,
                                     pagado BOOLEAN DEFAULT FALSE,
                                     nTalon INT,
                                     comentarios TEXT
);

CREATE TABLE IF NOT EXISTS Roles (
                                     id INT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(20) UNIQUE
);

CREATE TABLE IF NOT EXISTS Usuarios (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        usuario VARCHAR(255) UNIQUE,
                                        contrasena VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS usuario_roles (
                                             usuario_id BIGINT,
                                             role_id INT,
                                             PRIMARY KEY (usuario_id, role_id),
                                             FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
                                             FOREIGN KEY (role_id) REFERENCES Roles(id)
);

