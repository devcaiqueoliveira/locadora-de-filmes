<br />
<div align="center">
  <h1 align="center">API de Locadora de Filmes</h1>

  <p align="center">
    Uma API RESTful em Spring Boot focada em Arquitetura Limpa, Domain-Driven Design (DDD) e persistência robusta com JPA/Hibernate.
    <br />
    <br />
    <a href="https://github.com/devcaiqueoliveira/locadora-de-filmes/issues">Reportar Bug</a>
    ·
    <a href="https://github.com/devcaiqueoliveira/locadora-de-filmes/issues">Sugerir Feature</a>
  </p>
</div>

<p align="center">
  <img alt="Java" src="https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white">
  <img alt="Spring Boot" src="https://img.shields.io/badge/Spring_Boot-3.3-green?logo=spring-boot&logoColor=white">
  <img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-blue?logo=postgresql&logoColor=white">
  <img alt="Spring Data JPA" src="https://img.shields.io/badge/Spring_Data_JPA-gray?logo=hibernate&logoColor=white">
  <img alt="Maven" src="https://img.shields.io/badge/Maven-red?logo=apache-maven&logoColor=white">
</p>

<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#-sobre-o-projeto">Sobre o Projeto</a>
      <ul>
        <li><a href="#-stack-tecnológica">Stack Tecnológica</a></li>
      </ul>
    </li>
    <li>
      <a href="#-começando">Começando</a>
      <ul>
        <li><a href="#-pré-requisitos">Pré-requisitos</a></li>
        <li><a href="#-instalação">Instalação</a></li>
      </ul>
    </li>
    <li><a href="#-uso-da-api">Uso da API</a></li>
    <li><a href="#-roadmap">Roadmap</a></li>
  </ol>
</details>

---

## 🏛️ Sobre o Projeto

Este projeto implementa o backend para uma API de locadora de filmes. O objetivo principal não é apenas a funcionalidade, mas sim a demonstração de uma **arquitetura de software robusta, testável e escalável**.

As decisões de design foram baseadas em princípios da **Arquitetura Limpa** e **Domain-Driven Design (DDD)** para garantir uma clara separação de responsabilidades.

### 1. Camada de Domínio (O Coração)
A camada `domain` é o núcleo do sistema e não possui dependências de frameworks.
* **Modelo de Domínio Rico:** Entidades (`@Entity`) e Value Objects (`@Embeddable` como `Stock`, `Cpf`, `Email`) são responsáveis por proteger suas próprias regras de negócio (invariantes).
* **Validação na Fonte:** A lógica de validação (ex: "um estoque não pode ser negativo") reside *dentro* dos próprios VOs, tornando impossível criar um objeto de domínio em estado inválido.
* **Testes Unitários:** Toda a lógica de domínio é 100% coberta por testes unitários (JUnit 5).

### 2. Camada de Aplicação (O Orquestrador)
Esta camada coordena a lógica de negócio e é a "dona" das transações.
* **Serviços (`@Service`):** Orquestram o fluxo de dados, recebem DTOs e os "traduzem" em ações de domínio.
* **Padrão Unit of Work:** O `@Transactional` do Spring é usado para garantir que operações complexas (como `rentMovie`) sejam **atômicas (ACID)**. Isso garante que o `UPDATE` no estoque e o `INSERT` no aluguel funcionem, ou ambos falhem.

### 3. Camada de API (A Fachada)
A camada mais externa, responsável por "falar" HTTP.
* **Controllers (`@RestController`):** Mantidos "magros" (thin). Recebem DTOs, chamam o serviço e retornam DTOs.
* **DTOs (Data Transfer Objects):** A API nunca expõe as entidades de domínio. O contrato é definido por DTOs (ex: `MovieRequestDTO`), desacoplando o modelo interno do externo.
* **Exception Handling (`@ControllerAdvice`):** Um `RestExceptionHandler` global intercepta exceções de domínio (ex: `ResourceNotFoundException`) e as traduz em respostas HTTP corretas (ex: `404 Not Found`), mantendo os controllers limpos.

<p align="right">(<a href="#top">voltar ao topo</a>)</p>

### 💻 Stack Tecnológica

Esta seção lista as principais tecnologias usadas.

* ![Java](https://img.shields.io/badge/Java-21-blue?logo=openjdk&logoColor=white)
* ![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3-green?logo=spring-boot&logoColor=white)
* ![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-gray?logo=hibernate&logoColor=white)
* ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-blue?logo=postgresql&logoColor=white)
* ![Maven](https://img.shields.io/badge/Maven-red?logo=apache-maven&logoColor=white)
* ![JUnit 5](https://img.shields.io/badge/JUnit_5-green?logo=junit5&logoColor=white)
* ![Lombok](https://img.shields.io/badge/Lombok-black?logo=lombok&logoColor=white)
* ![H2 Database](https://img.shields.io/badge/H2_Database-red?logo=h2&logoColor=white) (para Testes de Integração)

<p align="right">(<a href="#top">voltar ao topo</a>)</p>

## 🚀 Começando

Siga estas instruções para configurar e rodar o projeto localmente.

### Pré-requisitos

* **JDK 21** (ou superior)
* **Maven 3.8+**
* **PostgreSQL** (rodando localmente ou via Docker)

### Instalação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/devcaiqueoliveira/locadora-de-filmes.git](https://github.com/devcaiqueoliveira/locadora-de-filmes.git)
    cd locadora-de-filmes
    ```

2.  **Crie o banco de dados:**
    Conecte-se ao seu PostgreSQL e crie o banco de dados.
    ```sql
    CREATE DATABASE locadora_db;
    ```
    *(As tabelas serão criadas automaticamente pelo Hibernate na primeira execução).*

3.  **Crie seu arquivo de configuração:**
    O arquivo `application.properties` (que contém senhas) está ignorado pelo `.gitignore` por segurança. Você precisa criar o seu a partir do template.
    ```bash
    # No Windows (PowerShell):
    cp src/main/resources/application.properties.example src/main/resources/application.properties
    ```

4.  **Edite suas credenciais:**
    Abra o novo arquivo `src/main/resources/application.properties` e preencha com seu usuário e senha do Postgres:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/locadora_db
    spring.datasource.username=seu_usuario_postgres
    spring.datasource.password=sua_senha_postgres
    ```

5.  **Execute a Aplicação:**
    Você pode rodar pela sua IDE (classe `LocadoraDeFilmesApplication.java`) ou via Maven:
    ```bash
    mvn spring-boot:run
    ```
    O servidor estará no ar em `http://localhost:8080`.

<p align="right">(<a href="#top">voltar ao topo</a>)</p>

## 🕹️ Uso da API

Você pode usar o [Postman](https://www.postman.com/) ou similar para testar os endpoints.

### Fluxo de Teste (Ponta-a-Ponta)

**1. Criar um novo Filme:**
`POST http://localhost:8080/api/movies`
*Body (JSON):*
```json
{
  "title": "O Poderoso Chefão",
  "genre": "DRAMA",
  "description": "Um filme clássico sobre a máfia italiana.",
  "releaseDate": "1972-03-24",
  "duration": 175,
  "stock": 10
}
```

**2. Criar um novo Cliente:**
`POST http://localhost:8080/api/customers`
```json
{
  "name": "Cliente Teste",
  "email": "cliente@teste.com",
  "cpf": "12345678900"
}
```
**3. Alugar um Filme (ID 1 para Cliente 1):**
`POST http://localhost:8080/api/rentals`
```json
{
  "customerId": 1,
  "movieId": 1
}
```
**4. Devolver o Filme (Aluguel do ID 1):**
`POST http://localhost:8080/api/rentals/1/return`</br>
</br>**5. Verificar o Estoque:**
`GET http://localhost:8080/api/movies/1`</br>
<p align="right">(<a href="#top">voltar ao topo</a>)</p>

🗺️ Roadmap </br>
[ ] Implementar paginação (Spring Data Pageable) nos endpoints GET</br>

[ ] Implementar mais regras de negócio (ex: cliente não pode alugar se tiver devolução atrasada)

[ ] Adicionar Spring Security (JWT) para proteger a API

<p align="right">(<a href="#top">voltar ao topo</a>)</p>
