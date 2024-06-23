# API de Cursos

Este é um projeto de API para gerenciamento de cursos desenvolvido em Spring Boot. A API permite criar, atualizar, deletar e consultar cursos com diferentes níveis de dificuldade.

## Tecnologias Utilizadas

- Java 22
- Spring Data JPA
- H2 Database (para desenvolvimento e testes)
- Maven

## Configuração do Projeto

### Pré-requisitos

- Java 22 
- Maven

### Como Executar

1. Clone o repositório:
    ```sh
    git clone https://github.com/seu-usuario/api-cursos.git
    ```
2. Navegue até o diretório do projeto:
    ```sh
    cd api-cursos
    ```
3. Compile e execute o projeto usando Maven:
    ```sh
    mvn spring-boot:run
    ```

### Endpoints Disponíveis

#### Criar Curso

- **URL**: `/cursos/`
- **Método**: `POST`
- **Body**: 
    ```json
    {
        "name": "Curso de Programação Java",
        "description": "Este curso abrange os fundamentos da programação em Java, incluindo orientação a objetos, coleções e streams.",
        "preRequisites": "Conhecimento básico em lógica de programação e alguma experiência com outra linguagem de programação.",
        "workload": 40.0,
        "value": 299.99,
        "nivel": 1
    }
    ```
- **Resposta**: `200 OK` com o curso criado ou `400 Bad Request` com a mensagem de erro

#### Consultar Todos os Cursos

- **URL**: `/cursos/`
- **Método**: `GET`
- **Resposta**: `200 OK` com a lista de cursos

#### Consultar Curso por ID

- **URL**: `/cursos/{id}`
- **Método**: `GET`
- **Resposta**: `200 OK` com o curso encontrado ou `404 Not Found` se não encontrado

#### Atualizar Curso

- **URL**: `/cursos/{id}`
- **Método**: `PUT`
- **Body**: 
    ```json
    {
        "name": "Curso de Programação Java",
        "description": "Este curso abrange os fundamentos da programação em Java, incluindo orientação a objetos, coleções e streams.",
        "preRequisites": "Conhecimento básico em lógica de programação e alguma experiência com outra linguagem de programação.",
        "workload": 40.0,
        "value": 299.99,
        "nivel": 1
    }
    ```
- **Resposta**: `200 OK` com o curso atualizado ou `404 Not Found` se não encontrado

#### Deletar Curso

- **URL**: `/cursos/{id}`
- **Método**: `DELETE`
- **Resposta**: `200 OK` com mensagem de sucesso ou `404 Not Found` se não encontrado

#### Consultar Cursos por Nível

- **URL**: `/cursos/nivel/{nivel}`
- **Método**: `GET`
- **Resposta**: `200 OK` com a lista de cursos do nível especificado