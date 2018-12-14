package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.PatientDto;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientToPatientDto extends AbstractConverter<Patient, PatientDto> {

    /**
     * Converts the patient model object into a patient DTO
     *
     * @param patient the patient
     * @return the patient DTO
     */
    @Override
    public PatientDto convert(Patient patient) {

        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        //patientDto.setState(patient.getState());
        patientDto.setEmail(patient.getEmail());
        patientDto.setGender(patient.getGender());

        return patientDto;
    }
}
