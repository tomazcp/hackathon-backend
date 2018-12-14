package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.AppointmentDto;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.service.appointment.AppointmentService;
import org.academiadecodigo.hackathon.service.patient.PatientService;
import org.academiadecodigo.hackathon.service.professional.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoToAppointment extends AbstractConverter<AppointmentDto, Appointment> {

    private AppointmentService appointmentService;
    private ProfessionalService professionalService;
    private PatientService patientService;

    @Autowired
    public void setProfessionalService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public Appointment convert(AppointmentDto appointmentDto) {

        Appointment appointment = (appointmentDto.getId() != null ? appointmentService.get(appointmentDto.getId())
                : new Appointment());




        appointment.setPatient(patientService.get(appointmentDto.getPatientId()));
        appointment.setProfessional(professionalService.get(appointmentDto.getProfessionalId()));
        appointment.setDate(appointmentDto.getDate());

        return appointment;

    }
}

