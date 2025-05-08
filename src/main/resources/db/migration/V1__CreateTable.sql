CREATE TABLE registros
(
    id           BIGINT AUTO_INCREMENT NOT NULL,
    nombre       VARCHAR(255)          NOT NULL,
    dni          VARCHAR(255)          NULL,
    n_expediente VARCHAR(255)          NULL,
    euros        DOUBLE                NULL,
    presentado   BIT(1)                NOT NULL,
    validado     BIT(1)                NOT NULL,
    pagado       BIT(1)                NOT NULL,
    n_talon      INT                   NULL,
    comentarios  VARCHAR(255)          NULL,
    CONSTRAINT pk_registros PRIMARY KEY (id)
);

ALTER TABLE registros
    ADD CONSTRAINT uc_registros_nombre UNIQUE (nombre);