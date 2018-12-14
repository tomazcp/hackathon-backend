package org.academiadecodigo.hackathon.controller;

import org.academiadecodigo.hackathon.converters.ProfessionalDtoToProfessional;
import org.academiadecodigo.hackathon.converters.ProfessionalToProfessionalDto;
import org.academiadecodigo.hackathon.dto.PatientDto;
import org.academiadecodigo.hackathon.dto.ProfessionalDto;
import org.academiadecodigo.hackathon.persistence.model.Professional;
import org.academiadecodigo.hackathon.service.professional.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * REST controller responsible for {@link Professional} related CRUD operations
 */
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/professional")
public class ProfessionalController {

    private ProfessionalService professionalService;
    private ProfessionalDtoToProfessional professionalDtoToProfessional;
    private ProfessionalToProfessionalDto professionalToProfessionalDto;

    @Autowired
    public void setProfessionalService(ProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

    @Autowired
    public void setProfessionalDtoToProfessional(ProfessionalDtoToProfessional professionalDtoToProfessional) {
        this.professionalDtoToProfessional = professionalDtoToProfessional;
    }

    @Autowired
    public void setProfessionalToProfessionalDto(ProfessionalToProfessionalDto professionalToProfessionalDto) {
        this.professionalToProfessionalDto = professionalToProfessionalDto;
    }

    @GetMapping(
            path = {"/", ""},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ProfessionalDto>> listProfessionals() {

        List<ProfessionalDto> professionalDtos = new ArrayList<>();
        List<Professional> professionals = professionalService.listProfessionals();

        for (Professional professional : professionals) {
            professionalDtos.add(professionalToProfessionalDto.convert(professional));
        }

        return new ResponseEntity<>(professionalDtos, HttpStatus.OK);

    }

    @GetMapping(
            path = {"/{id}"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ProfessionalDto> showProfessional(@PathVariable Integer id) {

        Professional professional = professionalService.get(id);

        if (professional == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(professionalToProfessionalDto.convert(professional), HttpStatus.OK);
    }

}
