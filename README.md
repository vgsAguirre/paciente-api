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

---

## 💬 Perguntas e Respostas Técnicas

### 1. Como você escolheria a stack tecnológica para esse projeto?

Eu escolheria a stack considerando principalmente os requisitos do negócio, escalabilidade e a maturidade das tecnologias. Para backend, utilizaria Java 17 com Spring Boot pela robustez e amplo ecossistema. Também avaliaria integração com cloud, containers e ferramentas de observabilidade. Além disso, priorizo tecnologias que a equipe já tenha domínio para reduzir curva de aprendizado e riscos no projeto.

---

### 2. Quais critérios usa para definir arquitetura de backend, frontend e mobile?

Avalio primeiro a complexidade do sistema, volume de acessos e necessidade de evolução. Para cenários que exigem maior escalabilidade e independência de evolução, considero o uso de microsserviços, ainda assim considero que um monólito bem estruturado e modularizado costuma atender muito bem a maioria dos cenários. Também considero manutenibilidade, testabilidade e segurança. A arquitetura precisa suportar crescimento sem gerar alto acoplamento e deve facilitar entregas contínuas.

---

### 3. Como garantir qualidade de código na equipe?

Para garantir qualidade de código, eu acredito muito na combinação de práticas técnicas com cultura de equipe. No dia a dia, utilizo code reviews para promover troca de conhecimento e evitar que problemas cheguem à produção. Também incentivo testes automatizados, principalmente unitários, e acompanho métricas com ferramentas como JaCoCo e Sonar para manter uma boa cobertura e identificar possíveis vulnerabilidades — e, quando o projeto exige, utilizamos também o Fortify para reforçar a segurança.

Além das ferramentas, valorizo padrões de desenvolvimento e boas práticas como Clean Code, para manter o sistema legível e fácil de evoluir. Também gosto de práticas colaborativas, como programação em par e compartilhamento de conhecimento, seja atualizando documentações como o README ou realizando sessões rápidas para apresentar novas funcionalidades.

Para mim, qualidade não vem só de ferramentas, mas de uma cultura onde o time se preocupa de verdade com a sustentabilidade do sistema.

---

### 4. Como você define priorização de tarefas em um sprint?

Eu costumo priorizar as tarefas considerando principalmente o valor para o negócio, riscos técnicos e dependências, sempre alinhando com o Product Owner para garantir que o time esteja trabalhando no que realmente gera impacto.

Durante o refinamento e o planning, avaliamos o esforço das histórias junto com o time — geralmente usando alguma técnica de estimativa (Planning Poker) e quando identificamos itens muito grandes ou incertos, buscamos quebrá-los em partes menores. Isso ajuda a reduzir riscos, melhorar a previsibilidade das entregas e manter um fluxo mais contínuo dentro da sprint.

---

### 5. Qual sua estratégia para gerenciar integrações com serviços externos?

Minha estratégia começa evitando alto acoplamento com serviços externos. Costumo criar uma camada específica para essas integrações, como clients ou adapters, para que mudanças no serviço não impactem diretamente as regras de negócio.

Também considero que integrações são pontos naturais de falha, então defino timeouts adequados e, quando necessário, aplico estratégias de resiliência para evitar efeito cascata na aplicação.

Além disso, me preocupo bastante com observabilidade — logs bem estruturados e monitoramento — para identificar rapidamente qualquer degradação ou indisponibilidade. O objetivo é manter a aplicação estável mesmo quando dependemos de terceiros.

---

### 6. Como você lidaria com falhas em produção?

Em caso de falha, minha primeira prioridade é restaurar o serviço o mais rápido possível para reduzir o impacto no negócio. Normalmente esses cenários chegam por meio de chamados ou alertas, o que já fornece um ponto de partida para a análise. A partir disso, verifico logs e o comportamento da aplicação para identificar a causa do problema e aplicar a correção imediata.

Após estabilizar o ambiente, aprofundo a investigação para encontrar a causa raiz e evitar recorrências, seja ajustando código, configuração ou processos. Também valorizo boas práticas de observabilidade e registros consistentes, pois ajudam a acelerar o diagnóstico e tornam a resposta a incidentes mais eficiente.

---

### 7. Qual abordagem adotaria para CI/CD nessa API?

Adotaria um pipeline automatizado com etapas de build, execução de testes e análise de qualidade antes do deploy. Utilizaria ferramentas como GitHub Actions, GitLab CI ou Azure DevOps para garantir integrações frequentes e seguras.

Também incluiria validações com Sonar e cobertura de testes para evitar regressões. Para deploy, priorizaria ambientes segregados (dev, homologação e produção) e estratégias que reduzam riscos, como deploy gradual ou rollback rápido, tornando as entregas mais previsíveis e confiáveis.

---

### 8. Como você decide entre REST, GraphQL ou outra forma de API?

REST costuma ser minha escolha padrão pela simplicidade, maturidade do ecossistema e ampla adoção no mercado, o que facilita integrações e manutenção. É um modelo bem consolidado e que atende muito bem a maioria dos cenários corporativos.

Tenho buscado me aprofundar em outras abordagens, como o GraphQL, e entendo que ele se torna uma boa opção quando há necessidade de maior flexibilidade na consulta de dados.

De qualquer forma, acredito que a decisão deve sempre considerar o contexto do sistema como requisitos de negócio, arquitetura existente, experiência do time e até cenários de legado. Mais do que preferência pessoal, o importante é escolher a tecnologia que melhor resolve o problema e se adaptar quando necessário.

---

### 9. Como avalia desempenho e otimização de APIs?

Avalio o desempenho acompanhando métricas como tempo de resposta e taxa de erros, utilizando logs e ferramentas como Postman e monitoramento para identificar gargalos. Também busco otimizar consultas ao banco (evitando N+1 com fetch join, usando paginação e criando índices quando necessário). Quando faz sentido, considero estratégias como cache — com soluções em memória como Caffeine ou distribuídas como Redis — para reduzir latência e carga no banco.

---

### 10. Como você documenta decisões técnicas e garante o conhecimento compartilhado na equipe?

Busco documentar decisões técnicas de forma clara e objetiva, normalmente no próprio repositório do projeto, além de diagramas quando necessário e documentação da API com Swagger/OpenAPI.

Para garantir o conhecimento compartilhado, incentivo práticas como code reviews, programação em par e conversas técnicas sempre que algo relevante é implementado. Acredito que uma documentação simples e útil, aliada a uma cultura colaborativa, é o que realmente mantém o time alinhado.