package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converters.PatientDtoToPatient;
import org.academiadecodigo.hackathon.converters.PatientToPatientDto;
import org.academiadecodigo.hackathon.dto.PatientDto;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.service.patient.PatientService;
import org.academiadecodigo.hackathon.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for {@link Patient} related CRUD operations
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/patient")
public class PatientController {

    private PatientService patientService;
    private PatientDtoToPatient patientDtoToPatient;
    private PatientToPatientDto patientToPatientDto;
    private SessionService sessionService;

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setPatientDtoToPatient(PatientDtoToPatient patientDtoToPatient) {
        this.patientDtoToPatient = patientDtoToPatient;
    }

    @Autowired
    public void setPatientToPatientDto(PatientToPatientDto patientToPatientDto) {
        this.patientToPatientDto = patientToPatientDto;
    }

    /**
     * Edits a patient
     *
     * @param patientDto   the patient DTO
     * @param id            the patient id
     * @return the response entity
     */
    @PutMapping(
            path = {"/{id}"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PatientDto> editPatient(@RequestBody PatientDto patientDto, @PathVariable Integer id) {

        if (patientDto.getId() != null && !patientDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (patientService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        patientDto.setId(id);

        Patient editedPatient =  patientService.saveOrUpdate(patientDtoToPatient.convert(patientDto));

        sessionService.setAccessingPacient(editedPatient);

        return new ResponseEntity<>(patientToPatientDto.convert(editedPatient), HttpStatus.OK);
    }
}
