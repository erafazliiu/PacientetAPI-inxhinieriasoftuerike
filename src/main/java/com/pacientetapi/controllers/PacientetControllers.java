package com.pacientetapi.controllers;

import com.pacientetapi.dtos.PacientetDto;
import com.pacientetapi.mappers.PacientetMapper;
import com.pacientetapi.sevices.PacientetServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientet")
@CrossOrigin
public class PacientetControllers {


        private final PacientetMapper pacientetMapper;
        private final PacientetServices pacientetServices;

        public PacientetControllers(PacientetMapper pacientetMapper, PacientetServices pacientetServices) {
            this.pacientetMapper = pacientetMapper;
            this.pacientetServices = pacientetServices;
        }


        @GetMapping("/")
        public ResponseEntity<List<PacientetDto>> getPacientet() {
            return ResponseEntity.ok(
                    pacientetServices.getAllPacientet()
                            .stream().map(pacientetMapper::toDto)
                            .toList()
            );
        }

        @GetMapping("/{id}")
        public ResponseEntity<PacientetDto> getPacientetById(@PathVariable Long id) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pacientetMapper.toDto(pacientetServices.getPacientetById(id)));
        }

        @PostMapping("/")
        public ResponseEntity<PacientetDto> createConcert(@RequestBody PacientetDto dto) {
            return ResponseEntity.ok(pacientetMapper.toDto(
                    pacientetServices.createPacient(
                            pacientetMapper.toEntity(dto)
                    )));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity deletePacient(@PathVariable Long id) {
            pacientetServices.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<PacientetDto> updateUser(@PathVariable Long id, @RequestBody PacientetDto dto) {
            return ResponseEntity.ok(pacientetMapper.toDto(
                    pacientetServices.updatePacientet(id,
                            pacientetMapper.toEntity(dto)
                    )));
        }
    }

