Tasks API - Java Spring Boot Edition 🚀

Este repositório apresenta uma API REST completa para gerenciamento de tarefas, desenvolvida como uma evolução técnica do projeto original em Flask. O foco desta implementação é aplicar os rigorosos padrões da plataforma Java, utilizando Spring Boot 3 e uma arquitetura baseada em princípios de Clean Code e separação de responsabilidades.
📌 Diferenciais do Projeto

Diferente da versão inicial, esta implementação foca em padrões corporativos:

    Layered Architecture: Organização clara entre Controller, Service, Repository e Model.

    Data Transfer Objects (DTOs): Utilização de Java Records para tráfego de dados seguro entre camadas.

    Bean Validation: Validação de payload em tempo de execução com @Valid.

    Reliability: Implementação de testes unitários com JUnit 5 e Mockito para garantir a integridade das regras de negócio.

    In-Memory Database: Configuração ágil com H2 Database, permitindo execução imediata sem dependências externas.

🛠️ Tecnologias e Ferramentas

    Linguagem: Java 17

    Framework: Spring Boot 3.x

    Persistência: Spring Data JPA / Hibernate

    Banco de Dados: H2 Database (em memória)

    Build Tool: Maven

    Testes: JUnit 5 e Mockito

    Produtividade: Lombok

🏗️ Estrutura do Projeto

Seguindo o padrão de pacotes observado no desenvolvimento:

    controller: Camada de exposição dos endpoints REST.

    service: Camada contendo as regras de negócio e lógica da aplicação.

    repository: Interface de comunicação com o banco de dados (JPA).

    model: Representação das entidades de banco de dados.

    dto: Objetos de transferência de dados para requisições e respostas.

🚀 Como Executar o Projeto

Para rodar o projeto localmente, siga os passos abaixo:

    Clone o repositório:
    Bash

    git clone https://github.com/rapassos/tasks-api-java.git

    Instale as dependências:
    Certifique-se de ter o Maven instalado e execute:
    Bash

    mvn clean install

    Execute a aplicação:
    Bash

    mvn spring-boot:run

    Acesse a documentação/console:

        API: http://localhost:8080/api/tasks

        H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:tasksdb)

🧪 Executando Testes

Para garantir que todas as funcionalidades e regras de negócio estão operacionais:
Bash

mvn test

📈 Roadmap e Melhorias Futuras

Como parte da evolução contínua deste portfólio:

    [ ] Integração com PostgreSQL via Docker Compose.

    [ ] Implementação de Segurança com Spring Security & JWT.

    [ ] Documentação interativa com Swagger/OpenAPI.

    [ ] Deploy automatizado via GitHub Actions.

Desenvolvido com foco em qualidade de software por Rafael Passos.