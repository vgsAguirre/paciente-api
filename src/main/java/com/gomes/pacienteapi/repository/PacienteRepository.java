package com.gomes.pacienteapi.repository;

import com.gomes.pacienteapi.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    
    Optional<Paciente> findByCpf(String cpf);
    
    boolean existsByCpf(String cpf);
}
