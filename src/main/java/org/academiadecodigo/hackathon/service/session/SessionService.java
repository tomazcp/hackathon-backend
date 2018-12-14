package org.academiadecodigo.hackathon.service.session;

import org.academiadecodigo.hackathon.persistence.model.Patient;

/**
 * Created by codecadet on 14/12/2018.
 */
public interface SessionService {

    void setAccessingPacient(Patient accessingPatient);

    Patient getAccessingPatient();
}
