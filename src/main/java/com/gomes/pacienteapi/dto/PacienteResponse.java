package com.gomes.pacienteapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Schema(description = "Dados de resposta do paciente")
public record PacienteResponse(
        @Schema(description = "ID do paciente", example = "1")
        Long id,
        
        @Schema(description = "Nome completo do paciente", example = "João Silva")
        String nome,
        
        @Schema(description = "CPF do paciente", example = "12345678909")
        String cpf,
        
        @Schema(description = "Data de nascimento", example = "1990-05-15")
        LocalDate dataNascimento,
        
        @Schema(description = "Email do paciente", example = "joao@email.com")
        String email,
        
        @Schema(description = "Telefone do paciente", example = "11999999999")
        String telefone,
        
        @Schema(description = "Endereço do paciente", example = "Rua Teste, 123")
        String endereco,
        
        @Schema(description = "Observações sobre o paciente", example = "Paciente com alergia a penicilina")
        String observacoes,
        
        @Schema(description = "Data e hora do cadastro", example = "2026-02-11T10:30:00")
        LocalDateTime dataCadastro,
        
        @Schema(description = "Data e hora da última atualização", example = "2026-02-11T10:30:00")
        LocalDateTime dataAtualizacao
) {
}
