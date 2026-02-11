package com.gomes.pacienteapi.validation;

import org.springframework.stereotype.Component;

@Component
public class CpfValidator {

    public String validar(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser vazio");
        }

        String cpfSemMascara = cpf.replaceAll("\\D", "");

        if (cpfSemMascara.length() != 11) {
            throw new IllegalArgumentException("CPF inválido. Informe 11 dígitos numéricos");
        }

        return cpfSemMascara;
    }
}
