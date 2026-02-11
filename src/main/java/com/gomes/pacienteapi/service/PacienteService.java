package com.gomes.pacienteapi.service;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;

public interface PacienteService {
    
    PacienteResponse criar(PacienteRequest request);
}
