package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.dao.AppointmentDao;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAppointmentDao extends GenericJpaDao<Appointment> implements AppointmentDao {

    public JpaAppointmentDao() {
        super(Appointment.class);
    }
}
