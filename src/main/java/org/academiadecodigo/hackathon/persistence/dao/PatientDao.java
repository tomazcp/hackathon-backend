package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.persistence.model.Patient;

public interface PatientDao extends Dao<Patient> {

    Patient getByEmail(String email);

}
