package org.academiadecodigo.hackathon.converters;

import org.academiadecodigo.hackathon.dto.ProfessionalDto;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.springframework.stereotype.Component;

@Component
public class ProfessionalToProfessionalDto extends AbstractConverter<Professional, ProfessionalDto> {

    /**
     * Converts the professional model object into a professional DTO
     *
     * @param professional the professional
     * @return the professional DTO
     */
    @Override
    public ProfessionalDto convert(Professional professional) {

        ProfessionalDto professionalDto = new ProfessionalDto();
        professionalDto.setId(professional.getId());
        professionalDto.setName(professional.getName());
        //professionalDto.setState(professional.getState());
        professionalDto.setEmail(professional.getEmail());
        professionalDto.setSuperPower(professional.getSuperPower());

        return professionalDto;
    }
}
