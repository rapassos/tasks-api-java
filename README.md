# 🚀 Tasks API (Java)

> **API RESTful corporativa para gerenciamento de tarefas, desenvolvida como modelo de referência para boas práticas em Spring Boot 3, arquitetura em camadas e alta cobertura de testes automatizados.**

[![Java Version](https://img.shields.io/badge/Java-17%2F21-ED8B00?style=flat-pro&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-6DB33F?style=flat-pro&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot)
[![Testing](https://img.shields.io/badge/Tests-JUnit%205%20%2B%20Mockito-4CI51C?style=flat-pro)](https://junit.org/junit5/)
[![Lombok](https://img.shields.io/badge/Lombok-Boilerplate%20Free-red?style=flat-pro)](https://projectlombok.org/)

---

## 🎯 Propósito do Projeto

Este projeto vai além de um CRUD convencional. Ele foi desenvolvido com o objetivo de servir como um **padrão de referência (Boilerplate/Template)** para APIs prontas para produção. O foco principal foi aplicar os princípios do **SOLID**, garantir o encapsulamento estrito das regras de negócio e demonstrar padrões avançados de tratamento de erros e testes de software no ecossistema Java moderno.

---

## 🏛️ Arquitetura e Organização de Pacotes

A aplicação adota uma **Arquitetura em Camadas (Layered Architecture)** bem definida, garantindo o baixo acoplamento e facilitando a manutenção do código.

    src/main/java/com/rafaelpassos/tasksapi/
    ├── controllers/      # Camada de Exposição: Endpoints REST e validação de entrada
    ├── services/         # Camada de Negócio: Onde residem as regras e fluxos lógicos
    ├── repositories/     # Camada de Persistência: Interfaces Spring Data JPA
    ├── models/           # Camada de Domínio: Entidades JPA (mapeamento do banco)
    ├── dtos/             # Data Transfer Objects: Tráfego seguro de dados entre camadas
    └── exceptions/       # Tratamento de Erros: Exceções customizadas e Global Handler

### 💡 Destaques de Design Pattern aplicados:

* **Padrão DTO:** Isolamento completo das entidades do banco de dados na camada de controle, evitando vazamento de dados ou acoplamento precoce com a API externa.
* **Global Exception Handler (@ControllerAdvice):** Centralização de todos os erros da API. Qualquer exceção de negócio resulta em um payload JSON padronizado com códigos de status HTTP semânticos (400, 404, 422).
* **Bean Validation:** Uso rigoroso de anotações (@NotBlank, @Size, @FutureOrPresent) para garantir a integridade dos dados na entrada.
* **Lombok Estruturado:** Utilização limpa para eliminação de código boilerplate, mantendo o código conciso e legível.

---

## 🧪 Estratégia de Testes Automatizados

O core deste repositório é a sua resiliência. A aplicação foi desenhada para ser altamente testável, utilizando JUnit 5 para a suíte de testes e Mockito para o isolamento completo da camada de serviço através do mock de dependências.

### O que está sendo testado?

* **Testes Unitários de Serviço (Business Logic):** Validação de regras críticas, como o impedimento de editar tarefas concluídas, comportamento correto ao buscar IDs inexistentes (lançamento de ResourceNotFoundException) e fluxos alternativos de falha.
* **Testes de Integração/Componente (Em progresso):** Validação dos endpoints usando MockMvc para garantir o comportamento correto dos filtros e retornos HTTP.

Para rodar os testes e analisar a cobertura:

    mvn test

---

## 🛠️ Stack Tecnológica

* **Linguagem:** Java 17 ou superior
* **Framework:** Spring Boot 3.x
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** PostgreSQL (Configuração de produção) / H2 Database (Memória para testes)
* **Ferramentas auxiliares:** Project Lombok, Jakarta Validation

---

## 🔧 Como Executar a API

### Pré-requisitos
* JDK 17 ou 21
* Maven 3.x

### Execução local

1. Clone o repositório:

    git clone https://github.com/rapassos/tasks_api_java.git
    cd tasks_api_java

2. Compile o projeto e baixe as dependências:

    mvn clean install

3. Execute a aplicação:

    mvn spring-boot:run

A API estará ativa em `http://localhost:8080`.

---

## Autor

**Rafael Passos** Engenheiro de Software Backend | Especialista em Operações Industriais  

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/rapassos)
[![Email](https://img.shields.io/badge/Email-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:rapassos@gmail.com)

---
*Este é um projeto de portfólio focado em demonstrar competências em Engenharia de Software Backend, Java Enterprise e padrões rigorosos de testes automatizados.*
