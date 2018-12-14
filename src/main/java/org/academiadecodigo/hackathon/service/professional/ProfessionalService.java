package org.academiadecodigo.hackathon.service.professional;

import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;

import java.util.Date;
import java.util.List;

public interface ProfessionalService {

    Professional get(Integer id);

    Professional saveOrUpdate(Professional professional);

    int addAppointment(Integer patientId, Integer professionalId, Date date);

    List<Patient> listPatients(Integer id);


    /**
     * Gets a list of the customers
     *
     * @return the customers list
     */
    List<Professional> listProfessionals();

    //List<Appointment> listAppointments(Integer id);
    List<Appointment> listAppointments(Integer id);
}
