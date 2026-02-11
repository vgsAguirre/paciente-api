# API de Gerenciamento de Pacientes

API RESTful para gerenciamento de pacientes com operações CRUD completas, seguindo boas práticas de desenvolvimento backend.

## 🚀 Tecnologias Utilizadas

- **Java 21** (LTS)
- **Spring Boot 3.5.11-SNAPSHOT**
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **H2 Database** - Banco de dados em memória
- **PostgreSQL Driver** - Preparado para uso em produção (implementação futura)
- **Lombok** - Redução de boilerplate
- **Springdoc OpenAPI 2.7.0** - Documentação automática (Swagger)
- **JUnit 5 + Mockito** - Testes unitários
- **Maven** - Gerenciamento de dependências

### Configuração Inicial

O projeto foi criado utilizando o **Spring Initializr** com as seguintes dependências principais:

- ✅ **Spring Web**
- ✅ **Spring Data JPA**
- ✅ **Validation** -
- ✅ **Lombok**
- ✅ **H2 Database**
- ✅ **PostgreSQL Driver**
- ✅ **Spring Boot DevTools**

## 📋 Pré-requisitos

- Java 21 ou superior
- Maven 3.8+
- Git

## 🔧 Instalação e Execução

### 1. Clone o repositório
```bash
git clone https://github.com/vgsAguirre/paciente-api.git
cd paciente-api
```

### 2. Compile o projeto e gera o JAR
```bash
mvn clean install
```

### 3. Execute a aplicação
```bash
mvn spring-boot:run
```

Ou execute o JAR gerado:
```bash
java -jar target/paciente-api-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8080`

## 📚 Documentação da API

### Swagger UI
Acesse a documentação interativa em: `http://localhost:8080/swagger-ui.html`

### Endpoints Disponíveis

#### **POST** `/api/pacientes`
Cria um novo paciente no sistema.

**Request Body:**
```json
{
  "nome": "João Silva",
  "cpf": "12345678909",
  "dataNascimento": "1990-05-15",
  "email": "joao.silva@email.com",
  "telefone": "11999999999",
  "endereco": "Rua das Flores, 123 - São Paulo/SP",
  "observacoes": "Paciente com alergia a penicilina"
}
```

**Response:** `201 Created`

---

#### **GET** `/api/pacientes`
Retorna a lista de todos os pacientes cadastrados.

**Response:** `200 OK`
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "cpf": "12345678909",
    "dataNascimento": "1990-05-15",
    "email": "joao.silva@email.com",
    "telefone": "11999999999",
    "endereco": "Rua das Flores, 123 - São Paulo/SP",
    "observacoes": "Paciente com alergia a penicilina",
    "dataCadastro": "2026-02-11T10:30:00",
    "dataAtualizacao": "2026-02-11T10:30:00"
  }
]
```

---

#### **GET** `/api/pacientes/{id}`
Busca um paciente específico pelo ID.

**Exemplo:** `/api/pacientes/1`

**Response:** `200 OK`

---

#### **GET** `/api/pacientes/{id}`
Busca um paciente específico pelo ID.

**Exemplo:** `/api/pacientes/1`

**Response:** `200 OK`

---

#### **GET** `/api/pacientes/cpf/{cpf}`
Busca um paciente específico pelo CPF (aceita com ou sem máscara).

**Exemplos:**
- `/api/pacientes/cpf/12345678909`
- `/api/pacientes/cpf/123.456.789-09`

**Response:** `200 OK`

---

#### **GET** `/api/pacientes/nome?nome={nome}`
Busca pacientes por nome (busca parcial, case-insensitive).

**Exemplo:** `/api/pacientes/nome?nome=João`

**Response:** `200 OK`

---

#### **PUT** `/api/pacientes/{id}`
Atualiza todos os dados de um paciente (atualização completa).

**Request Body:** Todos os campos obrigatórios

**Response:** `200 OK`

---

#### **PATCH** `/api/pacientes/{id}`
Atualiza parcialmente os dados de um paciente (apenas campos enviados).

**Request Body:** Apenas os campos que deseja atualizar
```json
{
  "email": "novoemail@email.com"
}
```

**Response:** `200 OK`

---

#### **DELETE** `/api/pacientes/{id}`
Remove um paciente do sistema.

**Response:** `204 No Content`

## 🗄️ Banco de Dados

### H2 Console
Acesse o console do H2 em: `http://localhost:8080/h2-console`

**Configurações de conexão:**
- JDBC URL: `jdbc:h2:mem:pacientedb`
- Username: `sa`
- Password: (deixar vazio)

### Schema
O schema é criado automaticamente pelo Hibernate baseado nas entidades JPA.

## 🧪 Testes

### Executar todos os testes
```bash
mvn test
```

## 🔀 Versionamento

Este projeto utiliza [Git](https://git-scm.com/) para controle de versão e segue o padrão de commits convencionais:

- `feat:` - Nova funcionalidade
- `fix:` - Correção de bug
- `docs:` - Alterações na documentação
- `test:` - Adição ou modificação de testes
- `refactor:` - Refatoração de código
- `chore:` - Atualizações de build, configurações, etc.

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/gomes/pacienteapi/
│   │   ├── controller/     # Controllers REST
│   │   ├── service/        # Interfaces de serviço
│   │   │   └── impl/       # Implementações de serviço
│   │   ├── repository/     # Camada de persistência
│   │   ├── model/          # Entidades JPA
│   │   ├── dto/            # Data Transfer Objects
│   │   ├── mapper/         # Conversões entre DTO e Entity
│   │   ├── validation/     # Validadores customizados
│   │   ├── exception/      # Tratamento de exceções
│   │   └── config/         # Configurações
│   └── resources/
│       └── application.properties
└── test/
    └── java/com/gomes/pacienteapi/
        ├── controller/     # Testes de controller
        ├── service/        # Testes de service
        └── repository/     # Testes de repository
```

## 👤 Autor

**Vinicius Gomes da Silva**
- Email: vgs.aguirre@gmail.com

## 📄 Licença

Este projeto foi desenvolvido como parte de um teste técnico.
