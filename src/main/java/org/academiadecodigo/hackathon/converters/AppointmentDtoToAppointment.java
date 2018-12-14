package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.AppointmentDto;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.service.appointment.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentDtoToAppointment extends AbstractConverter<AppointmentDto, Appointment> {

    private AppointmentService appointmentService;

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @Override
    public Appointment convert(AppointmentDto appointmentDto) {

        Appointment appointment = (appointmentDto.getId() != null ? appointmentService.get(appointmentDto.getId())
                : new Appointment(appointmentDto.getPatient(), appointmentDto.getProfessional()));

        appointment.setDate(appointmentDto.getDate());

        return appointment;

    }
}

