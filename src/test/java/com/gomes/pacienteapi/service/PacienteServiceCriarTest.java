package com.gomes.pacienteapi.service;

import com.gomes.pacienteapi.dto.PacienteRequest;
import com.gomes.pacienteapi.dto.PacienteResponse;
import com.gomes.pacienteapi.mapper.PacienteMapper;
import com.gomes.pacienteapi.model.Paciente;
import com.gomes.pacienteapi.repository.PacienteRepository;
import com.gomes.pacienteapi.service.impl.PacienteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PacienteServiceCriarTest {

    @Mock
    private PacienteRepository repository;

    @Mock
    private PacienteMapper mapper;

    @InjectMocks
    private PacienteServiceImpl service;

    private PacienteRequest request;
    private Paciente paciente;
    private Paciente pacienteSalvo;
    private PacienteResponse response;

    @BeforeEach
    void setUp() {
        request = PacienteRequest.builder()
                .nome("João Silva")
                .cpf("12345678909")
                .dataNascimento(LocalDate.of(1990, 5, 15))
                .email("joao@email.com")
                .telefone("11999999999")
                .endereco("Rua Teste, 123")
                .observacoes("Teste")
                .build();

        paciente = Paciente.builder()
                .nome("João Silva")
                .cpf("12345678909")
                .dataNascimento(LocalDate.of(1990, 5, 15))
                .email("joao@email.com")
                .telefone("11999999999")
                .endereco("Rua Teste, 123")
                .observacoes("Teste")
                .build();

        pacienteSalvo = Paciente.builder()
                .id(1L)
                .nome("João Silva")
                .cpf("12345678909")
                .dataNascimento(LocalDate.of(1990, 5, 15))
                .email("joao@email.com")
                .telefone("11999999999")
                .endereco("Rua Teste, 123")
                .observacoes("Teste")
                .dataCadastro(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        response = new PacienteResponse(
                1L,
                "João Silva",
                "12345678909",
                LocalDate.of(1990, 5, 15),
                "joao@email.com",
                "11999999999",
                "Rua Teste, 123",
                "Teste",
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    @Test
    void deveCriarPacienteComSucesso() {
        when(repository.existsByCpf(request.getCpf())).thenReturn(false);
        when(mapper.toEntity(request)).thenReturn(paciente);
        when(repository.save(paciente)).thenReturn(pacienteSalvo);
        when(mapper.toResponse(pacienteSalvo)).thenReturn(response);

        PacienteResponse resultado = service.criar(request);

        assertNotNull(resultado);
        assertEquals(1L, resultado.id());
        assertEquals("João Silva", resultado.nome());
        assertEquals("12345678909", resultado.cpf());
        assertEquals("joao@email.com", resultado.email());

        verify(repository).existsByCpf(request.getCpf());
        verify(mapper).toEntity(request);
        verify(repository).save(paciente);
        verify(mapper).toResponse(pacienteSalvo);
    }

    @Test
    void naoDeveCriarQuandoCpfJaExiste() {
        when(repository.existsByCpf(request.getCpf())).thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.criar(request)
        );

        assertEquals("CPF já cadastrado", exception.getMessage());
        verify(repository).existsByCpf(request.getCpf());
        verify(mapper, never()).toEntity(any());
        verify(repository, never()).save(any());
    }

    @Test
    void deveCriarComCamposOpcionaisNulos() {
        PacienteRequest req = PacienteRequest.builder()
                .nome("Maria Silva")
                .cpf("98765432100")
                .dataNascimento(LocalDate.of(1995, 3, 20))
                .email("maria@email.com")
                .build();

        Paciente pac = Paciente.builder()
                .nome("Maria Silva")
                .cpf("98765432100")
                .dataNascimento(LocalDate.of(1995, 3, 20))
                .email("maria@email.com")
                .build();

        Paciente salvo = Paciente.builder()
                .id(2L)
                .nome("Maria Silva")
                .cpf("98765432100")
                .dataNascimento(LocalDate.of(1995, 3, 20))
                .email("maria@email.com")
                .dataCadastro(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();

        PacienteResponse resp = new PacienteResponse(
                2L, "Maria Silva", "98765432100",
                LocalDate.of(1995, 3, 20), "maria@email.com",
                null, null, null,
                LocalDateTime.now(), LocalDateTime.now()
        );

        when(repository.existsByCpf(req.getCpf())).thenReturn(false);
        when(mapper.toEntity(req)).thenReturn(pac);
        when(repository.save(pac)).thenReturn(salvo);
        when(mapper.toResponse(salvo)).thenReturn(resp);

        PacienteResponse resultado = service.criar(req);

        assertNotNull(resultado);
        assertEquals(2L, resultado.id());
        assertNull(resultado.telefone());
        assertNull(resultado.endereco());
        assertNull(resultado.observacoes());
    }

    @Test
    void devePropararExcecaoQuandoSaveFalha() {
        when(repository.existsByCpf(request.getCpf())).thenReturn(false);
        when(mapper.toEntity(request)).thenReturn(paciente);
        when(repository.save(paciente)).thenThrow(new RuntimeException("Erro ao salvar"));

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> service.criar(request)
        );

        assertEquals("Erro ao salvar", exception.getMessage());
        verify(mapper, never()).toResponse(any());
    }
}
