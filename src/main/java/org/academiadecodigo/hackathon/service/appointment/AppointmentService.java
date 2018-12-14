package org.academiadecodigo.hackathon.service.appointment;

import org.academiadecodigo.hackathon.persistence.model.Appointment;


public interface AppointmentService {


    Appointment get(Integer id);

    Appointment saveOrUpdate(Appointment appointment);

    void delete(Integer id);
}

