package org.academiadecodigo.hackathon.service.appointment;

import org.academiadecodigo.hackathon.persistence.dao.AppointmentDao;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private AppointmentDao appointmentDao;

    @Autowired
    public void setAppointmentDao(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Transactional
    @Override
    public Appointment get(Integer id) {
        return appointmentDao.findById(id);
    }

    @Transactional
    @Override
    public Appointment saveOrUpdate(Appointment appointment) {
        return appointmentDao.saveOrUpdate(appointment);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        appointmentDao.delete(id);
    }
}

