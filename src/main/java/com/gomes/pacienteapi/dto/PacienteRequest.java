package com.gomes.pacienteapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "Dados para cadastro de paciente")
public class PacienteRequest {

    @NotBlank(message = "Nome é obrigatório")
    @Schema(description = "Nome completo do paciente", example = "João Silva")
    private String nome;

    @NotBlank(message = "CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter exatamente 11 dígitos")
    @CPF(message = "CPF inválido")
    @Schema(description = "CPF do paciente (apenas números)", example = "12345678909")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    @Schema(description = "Data de nascimento do paciente", example = "1990-05-15")
    private LocalDate dataNascimento;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    @Schema(description = "Email do paciente", example = "joao.silva@email.com")
    private String email;

    @Schema(description = "Telefone do paciente", example = "11999999999")
    private String telefone;

    @Schema(description = "Endereço completo do paciente", example = "Rua das Flores, 123 - São Paulo/SP")
    private String endereco;

    @Schema(description = "Observações adicionais sobre o paciente", example = "Paciente com alergia a penicilina")
    private String observacoes;
}
