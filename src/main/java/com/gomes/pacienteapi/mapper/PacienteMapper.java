package com.gomes.pacienteapi.mapper;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;
import com.gomes.pacienteapi.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente toEntity(PacienteRequest request) {
        return Paciente.builder()
                .nome(request.getNome())
                .cpf(request.getCpf())
                .dataNascimento(request.getDataNascimento())
                .email(request.getEmail())
                .telefone(request.getTelefone())
                .endereco(request.getEndereco())
                .observacoes(request.getObservacoes())
                .build();
    }

    public PacienteResponse toResponse(Paciente paciente) {
        return new PacienteResponse(
                paciente.getId(),
                paciente.getNome(),
                paciente.getCpf(),
                paciente.getDataNascimento(),
                paciente.getEmail(),
                paciente.getTelefone(),
                paciente.getEndereco(),
                paciente.getObservacoes(),
                paciente.getDataCadastro(),
                paciente.getDataAtualizacao()
        );
    }
}
