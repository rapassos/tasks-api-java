# Tasks API 🚀

Uma API REST robusta e simplificada para gerenciamento de tarefas (To-Do List), desenvolvida com o ecossistema moderno do **Spring Boot 3 / Spring 7** e **Java 17**. Este projeto foi estruturado seguindo as melhores práticas de mercado, incluindo arquitetura em camadas, validação de dados, testes unitários integrados e documentação automatizada.

## 🛠️ Tecnologias Utilizadas

- **Java 17** (LTS)
- **Spring Boot 3.x / Spring 7.x**
- **Spring Data JPA** (Persistência de dados)
- **H2 Database** (Banco de dados em memória para testes rápidos)
- **Lombok** (Produtividade e redução de código boilerplate)
- **Jakarta Validation** (Validação de payloads de entrada)
- **Springdoc OpenAPI 3 (Swagger UI)** (Documentação interativa da API)
- **JUnit 5 & Mockito** (Testes unitários e simulação de camadas)
- **Maven** (Gerenciamento de dependências e build)

## 🏗️ Arquitetura do Projeto

O projeto adota uma arquitetura em camadas bem definida para garantir a separação de responsabilidades e facilidade de manutenção:

- **`model`**: Entidades mapeadas para o banco de dados (`Task`).
- **`dto`**: Objetos de transferência de dados (`TaskRequestDTO`) utilizando *Java Records* para imutabilidade e validação com `@NotBlank`.
- **`repository`**: Interface de comunicação com o banco de dados via Spring Data JPA.
- **`service`**: Camada de regras de negócio com controle transacional (`@Transactional`).
- **`controller`**: Exposição dos endpoints REST e manipulação de respostas HTTP (`ResponseEntity`).

## 🛣️ Endpoints da API

A API expõe as seguintes rotas sob o contexto `/api/tasks`:

| Método | Endpoint | Descrição | Status HTTP Esperado |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/tasks` | Lista todas as tarefas | `200 OK` |
| **GET** | `/api/tasks/{id}` | Busca uma tarefa por ID | `200 OK` ou `404 Not Found` |
| **POST** | `/api/tasks` | Cria uma nova tarefa | `201 Created` ou `400 Bad Request` |
| **PUT** | `/api/tasks/{id}` | Atualiza uma tarefa existente | `200 OK` ou `404 Not Found` |
| **DELETE** | `/api/tasks/{id}` | Remove uma tarefa do banco | `204 No Content` ou `404 Not Found` |

### Exemplo de Payload para Criação (`POST`):
```json
{
  "title": "Estudar Spring Boot 3",
  "description": "Finalizar a documentação do Swagger UI no projeto prático.",
  "completed": false
}
```

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos
- JDK 17 instalado.
- Código clonado em sua máquina local.

### 1. Clonar e Compilar
Abra o terminal na raiz do projeto e execute a limpeza e compilação das dependências:
```bash
./mvnw clean package -DskipTests
```

### 2. Rodar a Aplicação
Para iniciar o servidor Tomcat embutido na porta `8080`:
```bash
./mvnw spring-boot:run
```

### 3. Acessar a Documentação Interativa (Swagger)
Com a aplicação rodando, acesse o painel visual para testar todos os endpoints sem necessidade de ferramentas externas:
👉 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

### 4. Acessar o Banco de Dados (H2 Console)
Para inspecionar as tabelas criadas automaticamente pelo Hibernate em tempo real:
👉 [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

*Configurações de Acesso:*
- **JDBC URL:** `jdbc:h2:mem:taskdb`
- **User Name:** `sa`
- **Password:** *(deixar em branco)*

## 🧪 Testes Unitários

A aplicação conta com uma suíte de testes focada na camada de serviços (`TaskServiceTest`), utilizando **Mockito** para isolar o comportamento do repositório.

Para rodar os testes e validar a integridade do código, execute:
```bash
./mvnw test
```

---
Desenvolvido por [Rafael Passos](https://github.com/rapassos).
