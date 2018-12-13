package org.academiadecodigo.hackathon.service.professional;

import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;

import java.util.List;

public interface ProfessionalService {

    Professional get(Integer id);

    Professional saveOrUpdate(Professional professional);

    List<Patient> listPatients(Integer id);

    //List<Appointment> listAppointments(Integer id);
}
