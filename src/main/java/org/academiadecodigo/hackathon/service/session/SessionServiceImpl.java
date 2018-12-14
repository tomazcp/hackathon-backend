package org.academiadecodigo.hackathon.service.session;

import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.springframework.stereotype.Service;

/**
 * Created by codecadet on 14/12/2018.
 */
@Service
public class SessionServiceImpl implements SessionService{

    private Patient accessingPatient;


    @Override
    public void setAccessingPacient(Patient accessingPatient) {
        this.accessingPatient = accessingPatient;
    }

    @Override
    public Patient getAccessingPatient() {

        return accessingPatient;
    }
}
