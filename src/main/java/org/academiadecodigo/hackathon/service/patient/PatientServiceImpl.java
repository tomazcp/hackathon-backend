package org.academiadecodigo.hackathon.service.patient;

import org.academiadecodigo.hackathon.persistence.dao.AppointmentDao;
import org.academiadecodigo.hackathon.persistence.dao.PatientDao;
import org.academiadecodigo.hackathon.persistence.dao.ProfessionalDao;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
public class PatientServiceImpl implements PatientService {

    private PatientDao patientDao;
    private ProfessionalDao professionalDao;
    private AppointmentDao appointmentDao;

    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Autowired
    public void setProfessionalDao(ProfessionalDao professionalDao) {
        this.professionalDao = professionalDao;
    }

    @Autowired
    public void setAppointmentDao(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    @Override
    @Transactional(readOnly = true)
    public Patient get(Integer id) {
        return patientDao.findById(id);
    }

    @Transactional
    @Override
    public Patient saveOrUpdate(Patient patient) {
        return patientDao.saveOrUpdate(patient);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        patientDao.delete(id);
    }

    @Transactional
    @Override
    public int addAppointment(Integer patientId, Integer professionalId, Date date) {
        Patient patient = patientDao.findById(patientId);
        Professional professional = professionalDao.findById(professionalId);
        Appointment appointment = new Appointment(patient, professional);
        appointment.setDate(date);
        return appointment.getId();
    }

    @Override
    public void removeAppointment(Integer patientId, Integer professionalId, Integer appointmentId) {
        Patient patient = patientDao.findById(patientId);
        Professional professional = professionalDao.findById(professionalId);
        Appointment appointment = appointmentDao.findById(appointmentId);
        patient.removeAppointment(appointment);
        professional.removeAppointment(appointment);

    }

//    @Override
//    public List<Appointment> listAppointments(Integer id) {
//
//        Patient patient = patientDao.findById(id);
//
//        return new ArrayList<>(patient.getAppointments());
//    }
}
