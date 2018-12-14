package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.AppointmentDto;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.springframework.stereotype.Component;


@Component
public class AppointmentToAppointmentDto extends AbstractConverter<Appointment, AppointmentDto> {


    @Override
    public AppointmentDto convert(Appointment appointment) {

        AppointmentDto appointmentDto = new AppointmentDto();
        appointmentDto.setPatient(appointment.getPatient());
        appointmentDto.setProfessional(appointment.getProfessional());
        appointmentDto.setDate(appointment.getDate());

        return appointmentDto;

    }
}
