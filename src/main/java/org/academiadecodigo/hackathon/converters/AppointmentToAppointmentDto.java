package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.AppointmentDto;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AppointmentToAppointmentDto extends AbstractConverter<Appointment, AppointmentDto> {

    private AppointmentService appointmentService;

    @Override
    public AppointmentDto convert(Appointment appointment) {

        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setPatientId(appointment.getPatient().getId());
        appointmentDto.setProfessionalId(appointment.getProfessional().getId());
        appointmentDto.setDate(appointment.getDate());

        return appointmentDto;

    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
}
