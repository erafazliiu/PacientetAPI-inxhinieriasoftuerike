package com.pacientetapi.repositories;

import com.pacientetapi.models.Pacientet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientetRepository extends JpaRepository<Pacientet, Long> {
}
