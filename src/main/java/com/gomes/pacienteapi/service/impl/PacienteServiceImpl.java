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

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public List<PacienteResponse> listarTodos() {
        return  repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteResponse buscarPorId(Long id) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + id));
        return mapper.toResponse(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public PacienteResponse buscarPorCpf(String cpf) {
        Paciente paciente = repository.findByCpf(cpf)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o CPF: " + cpf));
        return mapper.toResponse(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PacienteResponse> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Paciente não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional
    public PacienteResponse atualizar(Long id, PacienteRequest request) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + id));

        validarCpfDuplicado(paciente.getCpf(), request.getCpf());

        mapper.updateEntity(paciente, request);
        Paciente atualizado = repository.save(paciente);
        return mapper.toResponse(atualizado);
    }

    @Override
    @Transactional
    public PacienteResponse atualizarParcial(Long id, PacienteRequest request) {
        Paciente paciente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado com o ID: " + id));

        if (request.getCpf() != null) {
            validarCpfDuplicado(paciente.getCpf(), request.getCpf());
        }

        mapper.updateEntityPartial(paciente, request);
        Paciente atualizado = repository.save(paciente);
        return mapper.toResponse(atualizado);
    }

    private void validarCpfDuplicado(String cpfAtual, String cpfNovo) {
        if (!cpfAtual.equals(cpfNovo) && repository.existsByCpf(cpfNovo)) {
            throw new IllegalArgumentException("CPF já cadastrado para outro paciente");
        }
    }
}
