package org.academiadecodigo.hackathon.converters;

import org.springframework.core.convert.converter.Converter;
import org.academiadecodigo.hackathon.dto.PatientDto;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.academiadecodigo.hackathon.service.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientDtoToPatient implements Converter<PatientDto, Patient> {

    private PatientService patientService;

    /**
     * Sets the customer service
     *
     * @param patientService the customer service to set
     */
    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Converts the patient DTO into a patient model object
     *
     * @param patientDto the patient DTO
     * @return the patient
     */
    @Override
    public Patient convert(PatientDto patientDto) {

        Patient patient = (patientDto.getId() != null ? patientService.get(patientDto.getId()) : new Patient());

        patient.setName(patientDto.getName());
        patient.setPassword(patientDto.getPassword());
        //patient.setState(patientDto.getState());
        patient.setEmail(patientDto.getEmail());
        patient.setGender(patientDto.getGender());

        return patient;
    }

}
