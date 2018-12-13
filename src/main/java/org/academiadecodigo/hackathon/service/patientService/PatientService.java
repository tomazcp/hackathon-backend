package org.academiadecodigo.hackathon.service.patientService;


import java.util.Date;

public interface PatientService {

    Patient get(Integer id);

    Patient saveOrUpdate(Patient patient);

    void delete(Integer id);
    
    int addAppointment(Patient patientId, Professional professionalId, Date date);
    
    void removeAppointment(Patient patientId, Professional professionalId, Appointment appointmentId);
}
