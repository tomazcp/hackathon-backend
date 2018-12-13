package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.dao.PatientDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaPatientDao extends GenericJpaDao<Patient> implements PatientDao {

    public JpaPatientDao() {
        super(Patient.class);
    }


}
