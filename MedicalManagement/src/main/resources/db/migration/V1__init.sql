CREATE TABLE doctor
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    fullname  VARCHAR(255) NOT NULL,
    birthdate TIMESTAMP,
    CONSTRAINT pk_doctor PRIMARY KEY (id)
);

CREATE TABLE patient
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    fullname  VARCHAR(255) NOT NULL,
    birthdate TIMESTAMP,
    doctor_id BIGINT,
    CONSTRAINT pk_patient PRIMARY KEY (id)
);

ALTER TABLE patient
    ADD CONSTRAINT FK_PATIENT_ON_DOCTOR FOREIGN KEY (doctor_id) REFERENCES doctor (id);