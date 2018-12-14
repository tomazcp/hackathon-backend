package org.academiadecodigo.hackathon.controller.appointment;

import org.academiadecodigo.hackathon.converters.*;
import org.academiadecodigo.hackathon.dto.AppointmentDto;
import org.academiadecodigo.hackathon.persistence.model.Appointment;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.academiadecodigo.hackathon.service.appointment.AppointmentService;
import org.academiadecodigo.hackathon.service.patient.PatientService;
import org.academiadecodigo.hackathon.service.professional.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private PatientService patientService;
    private ProfessionalService professionalService;
    private AppointmentService appointmentService;

    private AppointmentDtoToAppointment appointmentDtoToAppointment;
    private AppointmentToAppointmentDto appointmentToAppointmentDto;

    private PatientDtoToPatient patientDtoToPatient;
    private PatientToPatientDto patientToPatientDto;

    private ProfessionalDtoToProfessional professionalDtoToProfessional;
    private ProfessionalToProfessionalDto professionalToProfessionalDto;



    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDto> showAppointment(@PathVariable Integer appointmentId) {

        Appointment appointment = appointmentService.get(appointmentId);
        return new ResponseEntity<>(appointmentToAppointmentDto.convert(appointment), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/patient/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentDto>> showPatientAppointment(@PathVariable Integer patientId) {

        Patient patient = patientService.get(patientId);
        return new ResponseEntity<>(appointmentToAppointmentDto.convert(patient.getAppointments()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/professional/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AppointmentDto>> showProfessionalAppointment(@PathVariable Integer professionalId) {

        Professional professional = professionalService.get(professionalId);
        return new ResponseEntity<>(appointmentToAppointmentDto.convert(professional.getAppointments()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto, String date) {

        Patient patient = patientService.get(appointmentDto.getPatientId());
        Professional professional = professionalService.get(appointmentDto.getProfessionalId());
        Appointment appointment = new Appointment(patient, professional);
        appointment.setDate(date);
        patientService.addAppointment(patient.getId(), professional.getId(), date);
        appointmentService.saveOrUpdate(appointment);
        return new ResponseEntity<>(appointmentToAppointmentDto.convert(appointment), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDto> deleteAppointment(@PathVariable Integer appointmentId) {

        appointmentService.delete(appointmentId);

        return new ResponseEntity<>(HttpStatus.OK);
    }



    // GETTERS AND SETTERS

    public PatientService getPatientService() {
        return patientService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    public ProfessionalService getProfessionalService() {
        return professionalService;
    }

    @Autowired
    public void setProfessionalService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    public AppointmentService getAppointmentService() {
        return appointmentService;
    }

    @Autowired
    public void setAppointmentService(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    public AppointmentDtoToAppointment getAppointmentDtoToAppointment() {
        return appointmentDtoToAppointment;
    }

    @Autowired
    public void setAppointmentDtoToAppointment(AppointmentDtoToAppointment appointmentDtoToAppointment) {
        this.appointmentDtoToAppointment = appointmentDtoToAppointment;
    }

    public AppointmentToAppointmentDto getAppointmentToAppointmentDto() {
        return appointmentToAppointmentDto;
    }

    @Autowired
    public void setAppointmentToAppointmentDto(AppointmentToAppointmentDto appointmentToAppointmentDto) {
        this.appointmentToAppointmentDto = appointmentToAppointmentDto;
    }

    public PatientDtoToPatient getPatientDtoToPatient() {
        return patientDtoToPatient;
    }

    @Autowired
    public void setPatientDtoToPatient(PatientDtoToPatient patientDtoToPatient) {
        this.patientDtoToPatient = patientDtoToPatient;
    }

    public PatientToPatientDto getPatientToPatientDto() {
        return patientToPatientDto;
    }

    @Autowired
    public void setPatientToPatientDto(PatientToPatientDto patientToPatientDto) {
        this.patientToPatientDto = patientToPatientDto;
    }

    public ProfessionalDtoToProfessional getProfessionalDtoToProfessional() {
        return professionalDtoToProfessional;
    }

    @Autowired
    public void setProfessionalDtoToProfessional(ProfessionalDtoToProfessional professionalDtoToProfessional) {
        this.professionalDtoToProfessional = professionalDtoToProfessional;
    }

    public ProfessionalToProfessionalDto getProfessionalToProfessionalDto() {
        return professionalToProfessionalDto;
    }

    @Autowired
    public void setProfessionalToProfessionalDto(ProfessionalToProfessionalDto professionalToProfessionalDto) {
        this.professionalToProfessionalDto = professionalToProfessionalDto;
    }
}
