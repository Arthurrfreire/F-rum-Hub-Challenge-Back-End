# Fórum Hub Challenge Back-End

Este repositório contém o código do back-end para o projeto **Fórum Hub Challenge**, uma aplicação que simula um fórum para interação e gerenciamento de tópicos e respostas. A aplicação foi desenvolvida utilizando **Spring Boot**, **Hibernate**, e segue boas práticas de APIs RESTful.

---

## **Índice**
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Rodar o Projeto](#como-rodar-o-projeto)
- [Endpoints Disponíveis](#endpoints-disponíveis)
- [Modelos de Dados](#modelos-de-dados)
- [Contribuição](#contribuição)

---

## **Tecnologias Utilizadas**
- **Java 17**
- **Spring Boot 2.7.6**
- **Hibernate ORM**
- **MySQL**
- **Maven**
- **JWT (JSON Web Token)** para autenticação
- **Postman** para testes de API

---

## **Estrutura do Projeto**
A estrutura do projeto segue o padrão **MVC**:

src/ ├── main/ │ ├── java/com/alura/forumhub/ │ │ ├── controller/ # Controladores da API │ │ ├── model/ # Modelos (Entidades) │ │ ├── repository/ # Interfaces do JPA Repository │ │ ├── service/ # Serviços para lógica de negócios │ │ ├── security/ # Configurações de segurança (JWT, autenticação) │ │ └── dto/ # Data Transfer Objects │ ├── resources/ │ │ ├── application.properties # Configurações da aplicação │ │ └── data.sql # Dados de inicialização └── test/ # Testes unitários e de integração

---

## **Configuração do Ambiente**

### **Pré-requisitos**
1. **Java 17** ou superior.
2. **Maven** instalado.
3. Banco de dados **MySQL** rodando localmente.
4. Ferramenta de teste de API, como o **Postman**.

---

### **Variáveis de Ambiente**
Configure as variáveis no arquivo `application.properties` para conectar ao banco de dados:

        spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
        spring.datasource.username=<SEU_USUÁRIO>
        spring.datasource.password=<SUA_SENHA>
        spring.jpa.hibernate.ddl-auto=update
        spring.jpa.show-sql=true
        jwt.secret=<SEGREDO_JWT>
        jwt.expiration=86400000

## Como Rodar o Projeto

1. Clone o Repositório

        git clone https://github.com/Arthurrfreire/F-rum-Hub-Challenge-Back-End.git
        cd F-rum-Hub-Challenge-Back-End

2. Instale as Dependências

        mvn clean install

3. Configure o Banco de Dados

  - Crie o banco forumhub no MySQL.
  - (Opcional) Preencha a tabela usuarios com um usuário administrador.

4. Inicie a Aplicação

        mvn spring-boot:run

5. Acesse a API

        URL base: http://localhost:8080

## Endpoints Disponíveis

## 1. Autenticação
- POST /login
  - Body (JSON):
    
        {
          "username": "admin@example.com",
          "password": "admin123"
        }
  - Resposta:

        {
          "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..."
        }
    
## 2. Gerenciamento de Tópicos

  2.1. Listar Todos os Tópicos

  - GET /topicos
    
    - Parâmetros:
        
    - curso (opcional): Filtrar por curso.
        
Exemplo de Resposta:

      [
        {
          "id": 1,
          "titulo": "Título do Tópico",
          "mensagem": "Mensagem",
          "dataCriacao": "2024-12-12T20:00:00",
          "curso": { "nome": "Java" },
          "autor": { "nome": "João" }
        }
      ]
      
2.2. Cadastrar Novo Tópico

- POST /topicos

- Body (JSON):

      {
        "titulo": "Título",
        "mensagem": "Mensagem",
        "curso": { "nome": "Java" },
        "autor": { "nome": "João" }
      }
  
2.3. Buscar Detalhes de um Tópico

- GET /topicos/{id}
  
- Resposta:

      {
        "id": 1,
        "titulo": "Título",
        "mensagem": "Mensagem",
        "curso": { "nome": "Java" },
        "autor": { "nome": "João" }
      }
  
2.4. Atualizar Tópico

- PUT /topicos/{id}

- Body (JSON):

      {
        "titulo": "Título Atualizado",
        "mensagem": "Mensagem Atualizada"
      }
    
2.5. Deletar Tópico

- DELETE /topicos/{id}

# Modelos de Dados
  
- Usuário

      {
        "id": 1,
        "nome": "Admin",
        "email": "admin@example.com",
        "senha": "hashed_password",
        "role": "ADMIN"
      }
  
- Tópico

      {
        "id": 1,
        "titulo": "Título",
        "mensagem": "Mensagem",
        "dataCriacao": "2024-12-12T20:00:00",
        "curso": { "nome": "Java" },
        "autor": { "nome": "João" }
      }
  
## Contribuição

1. Fork o repositório.

2. Crie uma branch para sua feature:

        git checkout -b minha-feature
   
3. Faça suas alterações e abra um pull request.
