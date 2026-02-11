# API de Gerenciamento de Pacientes

API RESTful para gerenciamento de pacientes com operações CRUD completas, seguindo boas práticas de desenvolvimento backend.

## 🚀 Tecnologias Utilizadas

- **Java 21** (LTS)
- **Spring Boot 3.5.11 (SNAPSHOT)**
- **Spring Data JPA** - Persistência de dados
- **Spring Validation** - Validação de dados
- **H2 Database** - Banco de dados em memória
- **PostgreSQL Driver** - Preparado para uso em produção (implementação futura)
- **Lombok** - Redução de boilerplate
- **Springdoc OpenAPI** - Documentação automática (Swagger)
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

### 2. Compile o projeto
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
│   │   ├── service/        # Lógica de negócio
│   │   ├── repository/     # Camada de persistência
│   │   ├── model/          # Entidades JPA
│   │   ├── dto/            # Data Transfer Objects
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
