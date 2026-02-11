package com.gomes.pacienteapi.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record PacienteResponse(
        Long id,
        String nome,
        String cpf,
        LocalDate dataNascimento,
        String email,
        String telefone,
        String endereco,
        String observacoes,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao
) {
}
