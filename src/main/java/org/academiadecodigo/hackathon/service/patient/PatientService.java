package org.academiadecodigo.hackathon.service.patient;


import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.persistence.model.Patient;

import java.util.Date;
import java.util.List;

public interface PatientService {

    Patient get(Integer id);

    Patient get(String email);

    Patient saveOrUpdate(Patient patient);

    void delete(Integer id);
    
    int addAppointment(Integer patientId, Integer professionalId, String date);
    
    void removeAppointment(Integer patientId, Integer professionalId, Integer appointmentId);

<<<<<<< HEAD

    //List<Appointment> listAppointments(Integer id);
=======
    List<Appointment> listAppointments(Integer id);
>>>>>>> 6daebe8aa03ccbf849e8d252f4187c6416beb2b4
}
