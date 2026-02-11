package com.gomes.pacienteapi.controller;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;
import com.gomes.pacienteapi.service.PacienteService;
import com.gomes.pacienteapi.validation.CpfValidator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@RequiredArgsConstructor
@Validated
@Tag(name = "Pacientes", description = "API de gerenciamento de pacientes")
public class PacienteController {

    private final PacienteService service;
    private final CpfValidator cpfValidator;

    @PostMapping
    @Operation(summary = "Criar novo paciente", description = "Cria um novo paciente no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Paciente criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos ou CPF já cadastrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<PacienteResponse> criar(@Valid @RequestBody PacienteRequest request) {
        PacienteResponse response = service.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @Operation(summary = "Listar todos os pacientes", description = "Retorna uma lista com todos os pacientes cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        List<PacienteResponse> pacientes = service.listarTodos();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/cpf/{cpf}")
    @Operation(summary = "Buscar paciente por CPF", description = "Retorna um paciente específico pelo CPF")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paciente encontrado"),
            @ApiResponse(responseCode = "400", description = "Paciente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<PacienteResponse> buscarPorCpf(@PathVariable String cpf) {
        String cpfValidado = cpfValidator.validar(cpf);
        PacienteResponse paciente = service.buscarPorCpf(cpfValidado);
        return ResponseEntity.ok(paciente);
    }

    @GetMapping("/nome")
    @Operation(summary = "Buscar pacientes por nome", description = "Retorna uma lista de pacientes que contém o nome informado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pacientes retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno no servidor")
    })
    public ResponseEntity<List<PacienteResponse>> buscarPorNome(@RequestParam String nome) {
        List<PacienteResponse> pacientes = service.buscarPorNome(nome);
        return ResponseEntity.ok(pacientes);
    }
}