package com.pacientetapi.mappers;

import com.pacientetapi.dtos.PacientetDto;
import com.pacientetapi.models.Pacientet;
import org.springframework.stereotype.Component;

@Component
public class PacientetMapper {
    public Pacientet toEntity(PacientetDto dto) {
        Pacientet pacient = new Pacientet();
        pacient.setFirstName(dto.getFirstName());
        pacient.setLastName(dto.getLastName());
        pacient.setAddress(dto.getAddress());
        pacient.setGender(dto.getGender());
        pacient.setDateOfBirth(dto.getDateOfBirth());
        pacient.setPhoneNumber(dto.getPhoneNumber());
        return pacient;

    }

    public PacientetDto toDto(Pacientet pacientet) {
        PacientetDto pacientetDto = new PacientetDto();
        pacientetDto.setFirstName(pacientet.getFirstName());
        pacientetDto.setLastName(pacientet.getLastName());
        pacientetDto.setAddress(pacientet.getAddress());
        pacientetDto.setGender(pacientet.getGender());
        pacientetDto.setPhoneNumber(pacientet.getPhoneNumber());
        pacientetDto.setDateOfBirth(pacientet.getDateOfBirth());
        return pacientetDto;
    }
}
