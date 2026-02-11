package com.gomes.pacienteapi.service;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;

import java.util.List;

public interface PacienteService {
    
    PacienteResponse criar(PacienteRequest request);
    
    List<PacienteResponse> listarTodos();
    
    PacienteResponse buscarPorCpf(String cpf);
    
    List<PacienteResponse> buscarPorNome(String nome);
    
    void deletar(Long id);
    
    PacienteResponse atualizar(Long id, PacienteRequest request);
    
    PacienteResponse atualizarParcial(Long id, PacienteRequest request);
}
