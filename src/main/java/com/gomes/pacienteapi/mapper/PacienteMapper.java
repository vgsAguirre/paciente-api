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

    public void updateEntity(Paciente paciente, PacienteRequest request) {
        paciente.setNome(request.getNome());
        paciente.setCpf(request.getCpf());
        paciente.setDataNascimento(request.getDataNascimento());
        paciente.setEmail(request.getEmail());
        paciente.setTelefone(request.getTelefone());
        paciente.setEndereco(request.getEndereco());
        paciente.setObservacoes(request.getObservacoes());
    }

    public void updateEntityPartial(Paciente paciente, PacienteRequest request) {
        if (request.getNome() != null) {
            paciente.setNome(request.getNome());
        }
        if (request.getCpf() != null) {
            paciente.setCpf(request.getCpf());
        }
        if (request.getDataNascimento() != null) {
            paciente.setDataNascimento(request.getDataNascimento());
        }
        if (request.getEmail() != null) {
            paciente.setEmail(request.getEmail());
        }
        if (request.getTelefone() != null) {
            paciente.setTelefone(request.getTelefone());
        }
        if (request.getEndereco() != null) {
            paciente.setEndereco(request.getEndereco());
        }
        if (request.getObservacoes() != null) {
            paciente.setObservacoes(request.getObservacoes());
        }
    }
}
