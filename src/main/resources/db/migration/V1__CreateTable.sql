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
                                        username VARCHAR(255) UNIQUE,
                                        password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS usuario_roles (
                                             usuario_id BIGINT,
                                             role_id INT,
                                             PRIMARY KEY (usuario_id, role_id),
                                             FOREIGN KEY (usuario_id) REFERENCES Usuarios(id) ON DELETE CASCADE,
                                             FOREIGN KEY (role_id) REFERENCES Roles(id)
);

CREATE TABLE IF NOT EXISTS Guardia (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       nombreAsistido VARCHAR(255),
                                       juzgado VARCHAR(255),
                                       fecha DATE,
                                       porJuzgado BOOLEAN DEFAULT FALSE,
                                       cobrado BOOLEAN DEFAULT FALSE,
                                       observaciones TEXT
);

CREATE TABLE IF NOT EXISTS Registro (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        nombre VARCHAR(255) UNIQUE,
                                        dni VARCHAR(255),
                                        euros DECIMAL(10,2),
                                        presentado BOOLEAN DEFAULT FALSE,
                                        validado BOOLEAN DEFAULT FALSE,
                                        pagado BOOLEAN DEFAULT FALSE,
                                        comentarios TEXT
);

INSERT INTO Roles (id, name) VALUES (1, 'ROLE_ADMIN')
ON DUPLICATE KEY UPDATE name = name;

INSERT INTO Roles (id, name) VALUES (2, 'ROLE_USUARIO')
ON DUPLICATE KEY UPDATE name = name;

CREATE TABLE IF NOT EXISTS ApelacionGuardia (
                                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                guardia_id BIGINT NOT NULL,
                                                nExpediente VARCHAR(255),
                                                admitido BOOLEAN DEFAULT FALSE,
                                                presentado BOOLEAN DEFAULT FALSE,
                                                sentencia BOOLEAN DEFAULT FALSE,
                                                FOREIGN KEY (guardia_id) REFERENCES Guardia(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS RecursoExtraOrdinario (
                                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                     guardia_id BIGINT NOT NULL,
                                                     nExpediente INT,
                                                     admitido BOOLEAN DEFAULT FALSE,
                                                     FOREIGN KEY (guardia_id) REFERENCES Guardia(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS RecursoGuardia (
                                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                              guardia_id BIGINT NOT NULL,
                                              nExpediente VARCHAR(255),
                                              resuelto BOOLEAN DEFAULT FALSE,
                                              FOREIGN KEY (guardia_id) REFERENCES Guardia(id) ON DELETE CASCADE
);

