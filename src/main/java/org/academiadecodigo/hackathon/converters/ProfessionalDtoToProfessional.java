package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.ProfessionalDto;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.academiadecodigo.hackathon.service.professional.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalDtoToProfessional implements Converter<ProfessionalDto, Professional> {

    private ProfessionalService professionalService;

    /**
     * Sets the professional service
     *
     * @param professionalService the professional  service to set
     */
    @Autowired
    public void setPatientService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    /**
     * Converts the professional  DTO into a professional  model object
     *
     * @param professionalDto the professional DTO
     * @return the professional
     */
    @Override
    public Professional convert(ProfessionalDto professionalDto) {

        Professional professional = (professionalDto.getId() != null ? professionalService.get(professionalDto.getId()) : new Professional());

        professional.setName(professionalDto.getName());
        professional.setEmail(professionalDto.getEmail());
        professional.setGender(professionalDto.getGender());

        return professional;
    }
}
