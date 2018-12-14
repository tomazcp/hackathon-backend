package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converters.PatientDtoToPatient;
import org.academiadecodigo.hackathon.converters.PatientToPatientDto;
import org.academiadecodigo.hackathon.dto.PatientDto;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.service.patient.PatientService;
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
@RequestMapping("/api/auth")
public class AuthController {

    private PatientService patientService;
    private PatientDtoToPatient patientDtoToPatient;
    private PatientToPatientDto patientToPatientDto;

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

    @PostMapping(
            path = "/register",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity registerPatient(@RequestBody PatientDto patientDto) {

//        if (bindingResult.hasErrors() || patientDto.getId() != null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        Patient patient = patientDtoToPatient.convert(patientDto);

        Patient newPatient = patientService.saveOrUpdate(patient);

       // UriComponents uriComponents = uriComponentsBuilder.path("/api/patient/" + newPatient.getId()).build();

       /* HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());*/

        return new ResponseEntity(HttpStatus.CREATED);

    }

   /* @GetMapping(
            path = "/api/patient/"
    )
    public ResponseEntity loginPatient(PatientDto patientDto) {
    return ;
    }*/
}
