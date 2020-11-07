
CREATE TABLE hospital(
    id bigserial primary key,
    cod_hospital varchar(100) NOT NULL,
    nombre varchar(255) NOT NULL,
    ciudad varchar(255) NOT NULL,
    telefono varchar(20) NOT NULL,
    director varchar(255) NOT NULL
);

CREATE TABLE servicio(
    id bigserial primary key,
    nombre varchar(255) NOT NULL,
    descripcion varchar(1000) NOT NULL,
    cod_servicio varchar(20) NOT NULL,
    nro_camas_totales int NOT NULL
);

CREATE TABLE medico(
    id bigserial primary key,
    tipo_documento varchar(10) NOT NULL,
    nro_documento varchar(10) NOT NULL,
    nombres varchar(255) NOT NULL,
    apellidos varchar(255) NOT NULL,
    fecha_nacimiento date NOT NULL
);

CREATE TABLE servicio_prestado(
    id bigserial PRIMARY KEY,
    id_hospital bigint NOT NULL,
    id_servicio bigint NOT NULL,
    id_medico bigint NOT NULL,
    CONSTRAINT fk_id_hospital_servicio_prestado FOREIGN KEY (id_hospital)
        REFERENCES hospital (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT fk_id_servicio_servicio_prestado FOREIGN KEY (id_servicio)
        REFERENCES servicio (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT fk_id_medico_servicio_prestado FOREIGN KEY (id_medico)
        REFERENCES medico (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE paciente(
    id bigserial PRIMARY KEY,
    cod_historial varchar(100) NOT NULL,
    nombres varchar(255) NOT NULL,
    apellidos varchar(255) NOT NULL,
    tipo_documento varchar(10) NOT NULL,
    nro_documento varchar(10) NOT NULL,
    fecha_nacimiento date NOT NULL,
    datos_adicionales varchar(1000)
);

CREATE TABLE detalle_consulta(
    id bigserial PRIMARY KEY,
    diagnostico varchar(1000) NOT NULL,
    tratamiento varchar(1000) NOT NULL,
    paciente_admitido boolean NOT NULL,
    nro_habitacion int,
    fecha_alta timestamp without time zone
);

CREATE TABLE consulta(
    id bigserial PRIMARY KEY,
    id_paciente bigint NOT NULL,
    id_servicio_prestado bigint NOT NULL,
    id_detalle bigint NOT NULL,
    fecha_consulta  timestamp without time zone NOT NULL,
    CONSTRAINT fk_id_paciente_consulta FOREIGN KEY (id_paciente)
        REFERENCES paciente (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT fk_id_servicio_prestado_consulta FOREIGN KEY (id_servicio_prestado)
         REFERENCES servicio_prestado (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT fk_id_detalle_consulta FOREIGN KEY (id_detalle)
         REFERENCES detalle_consulta (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE TABLE camas(
    id bigserial primary key,
    id_hospital bigint NOT NULL,
    id_servicio bigint NOT NULL,
    cant_camas int NOT NULL,
    CONSTRAINT fk_id_hospital_camas FOREIGN KEY (id_hospital)
        REFERENCES hospital (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
    CONSTRAINT fk_id_servicio_camas FOREIGN KEY (id_servicio)
        REFERENCES servicio (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);
CREATE UNIQUE INDEX id_servicio_hospital ON camas (id_servicio, id_hospital);
CREATE UNIQUE INDEX id_medico_hospital_servicio ON servicio_prestado (id_medico, id_hospital,id_servicio);
CREATE UNIQUE INDEX nro_documento_medico ON medico (tipo_documento, nro_documento);
CREATE UNIQUE INDEX nro_documento_paciente_historial ON paciente (tipo_documento, nro_documento, cod_historial);
