package org.academiadecodigo.hackathon.service.professional;

import org.academiadecodigo.hackathon.persistence.dao.ProfessionalDao;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProfessionalServiceImpl implements ProfessionalService {

    private ProfessionalDao professionalDao;

    @Autowired
    public void setProfessionalDao(ProfessionalDao professionalDao) {
        this.professionalDao = professionalDao;
    }

    @Override
    public Professional get(Integer id) {
        return professionalDao.findById(id);
    }

    @Override
    public Professional saveOrUpdate(Professional professional) {
        return professionalDao.saveOrUpdate(professional);
    }

    @Override
    public List<Patient> listPatients(Integer id) {
        return new ArrayList<>(professionalDao.findById(id).getPatients());
    }

    @Override
    public List<Appointment> listAppointments(Integer id) {
        return new ArrayList<>(professionalDao.findById(id).getAppointments());
    }

    @Override
    public int addAppointment(Integer patientId, Integer professionalId, Date date) {
      return 0;
    }
}
