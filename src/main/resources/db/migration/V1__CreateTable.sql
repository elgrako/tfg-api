CREATE TABLE IF NOT EXISTS registro (
                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                     nombre VARCHAR(255) UNIQUE,
                                     dni VARCHAR(255),
                                     n_expediente VARCHAR(255),
                                     euros DECIMAL(10,2),
                                     email VARCHAR(255),
                                     telefono INT,
                                     presentado BOOLEAN DEFAULT FALSE,
                                     validado BOOLEAN DEFAULT FALSE,
                                     pagado BOOLEAN DEFAULT FALSE,
                                     n_talon INT,
                                     comentarios TEXT
);

CREATE TABLE IF NOT EXISTS roles (
                                     id INT PRIMARY KEY AUTO_INCREMENT,
                                     name VARCHAR(20) UNIQUE
);

CREATE TABLE IF NOT EXISTS usuarios (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        username VARCHAR(255) UNIQUE,
                                        password VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS usuario_roles (
                                             usuario_id BIGINT,
                                             role_id INT,
                                             PRIMARY KEY (usuario_id, role_id),
                                             FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
                                             FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE IF NOT EXISTS guardia (
                                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                       nombre_asistido VARCHAR(255),
                                       juzgado VARCHAR(255),
                                       fecha DATE,
                                       dia_actualizacion DATE,
                                       por_juzgado BOOLEAN DEFAULT FALSE,
                                       cobrado BOOLEAN DEFAULT FALSE,
                                       observaciones TEXT
);

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN')
ON DUPLICATE KEY UPDATE name = name;

INSERT INTO roles (id, name) VALUES (2, 'ROLE_USUARIO')
ON DUPLICATE KEY UPDATE name = name;

CREATE TABLE IF NOT EXISTS apelacion_guardia (
                                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                guardia_id BIGINT NOT NULL,
                                                n_expediente VARCHAR(255),
                                                admitido BOOLEAN DEFAULT FALSE,
                                                presentado BOOLEAN DEFAULT FALSE,
                                                sentencia BOOLEAN DEFAULT FALSE,
                                                FOREIGN KEY (guardia_id) REFERENCES guardia(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS recurso_extra_ordinario (
                                                     id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                     guardia_id BIGINT NOT NULL,
                                                     n_expediente INT,
                                                     admitido BOOLEAN DEFAULT FALSE,
                                                     FOREIGN KEY (guardia_id) REFERENCES guardia(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS recurso_guardia (
                                              id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                              guardia_id BIGINT NOT NULL,
                                              n_expediente VARCHAR(255),
                                              resuelto BOOLEAN DEFAULT FALSE,
                                              FOREIGN KEY (guardia_id) REFERENCES guardia(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS situacion_guardia (
                                                 id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                                 guardia_id BIGINT NOT NULL,
                                                 comentarios VARCHAR(1000),
                                                 n_talon VARCHAR(255),
                                                 euros VARCHAR(255),
                                                 presentado BOOLEAN DEFAULT FALSE,
                                                 validado BOOLEAN DEFAULT FALSE,
                                                 pagado BOOLEAN DEFAULT FALSE,
                                                 FOREIGN KEY (guardia_id) REFERENCES guardia(id) ON DELETE CASCADE
);