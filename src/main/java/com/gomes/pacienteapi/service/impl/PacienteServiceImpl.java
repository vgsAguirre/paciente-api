package com.gomes.pacienteapi.service.impl;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;
import com.gomes.pacienteapi.mapper.PacienteMapper;
import com.gomes.pacienteapi.model.Paciente;
import com.gomes.pacienteapi.repository.PacienteRepository;
import com.gomes.pacienteapi.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository repository;
    private final PacienteMapper mapper;

    @Override
    @Transactional
    public PacienteResponse criar(PacienteRequest request) {
        if (repository.existsByCpf(request.getCpf())) {
            throw new IllegalArgumentException("CPF já cadastrado");
        }

        Paciente paciente = mapper.toEntity(request);
        Paciente salvo = repository.save(paciente);
        
        return mapper.toResponse(salvo);
    }
}
