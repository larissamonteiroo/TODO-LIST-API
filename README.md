# 📌 TODO-LIST API 

TODO List é uma API simples que utiliza endpoits para armazenar e atualizar tarefas.

O projeto foi desenvolvido em Java utilizando Spring Boot e banco de dados MySQL.

<b>Dependências</b>

- Docker
- Docker Compose
- Java 11 ou superior
- Maven 3.6.0 ou superior

## 📁 Como baixar o projeto?

```bash
# Clonar o Repositório
$ git clone https://github.com/Larissamonteiroo/TODO-LIST-API.git
```
 OU

Fazer Deploy direto do docker
```cmd
docker pull larissamonteiroo/todo-list-api:latest
```

## ☁ Como subir o projeto utilizando Docker? 
O projeto já esta configurado com os arquivos necessários para ser executado localmente no ambiente Docker.

<b>Porta que o projeto será executado</b>: Foi configurado no arquivo <b>docker-compose.yaml</b> que o container será exposto para a porta 8000 da máquina local.

<b>MySQL</b>: A imagem está configurada para se conectar na porta 3307 do MySQL que será criado pelo Docker Compose.

Para subir o projeto e o banco de dados, basta executar o comando abaixo no terminal (Certifique-se que esteja na pasta do projeto)

```cmd
docker-compose up
```

Após executar os passos acima, o TODO List já estará disponível para receber requisições no endereço direcionado.

## 💻 Enpoints

### Cadastrar tarefa

Método HTTP: POST

Endpoint: http://localhost:8080/todo

Parâmetros do corpo da requisição (json):
- <b>title</b>: Titulo da tarefa, pode ser inserido um texto livre neste parâmetro
- <b>description</b>: Descrição da tarefa, pode ser inserido um texto livre neste parâmetro
- <b>status</b>: Status da tarefa, apenas é possível passar os valores PENDING ou COMPLETED
```json
{
  "title": "string",
  "description": "string",
  "status": "<STATUS>"
}
```

Exemplo de requisição CURL:
```cmd
curl -X POST "http://localhost:8080/todo" -H "Content-Type: application/json" -d "{ \"description\": \"string\", \"status\": \"<STATUS>\", \"title\": \"string\"}"
```

### Listar todas tarefas

Método HTTP: GET

Endpoint: http://localhost:8080/todo

Exemplo de requisição CURL:
```
curl -X GET "http://localhost:8080/todo" 
```

### Listar tarefa por ID

Método HTTP: GET

Endpoint: http://localhost:8080/todo/ID

Parâmetros da URL:
- <b>id</b>: ID da tarefa, o ID é obtido no cadastro da tarefa

Exemplo de requisição CURL:
```cmd
curl -X GET "http://localhost:8080/todo/ID"
```

### Editar tarefa

Método HTTP: PUT

Endpoint: http://localhost:8080/todo/ID

Parâmetros do corpo da requisição (json):

- <b>status</b>: Status da tarefa, Somente o status pode ser alterado, para PENDING ou COMPLETED

Parâmetros da URL:
- <b>id</b>: ID da tarefa, o ID é obtido no cadastro da tarefa
```json
{
  "title": "string",
  "description": "string",
  "status": "<STATUS>"
}
```
Exemplo de requisição CURL:
```cmd
curl -X PUT "http://localhost:8080/todo/ID" -H "Content-Type: application/json" -d "{ \"description\": \"string\", \"status\": \"<STATUS>\", \"title\": \"string\"}"
```

### Deletar tarefa

Método HTTP: POST

Endpoint: http://localhost:8080/todo

Parâmetros da URL:
- <b>id</b>: ID da tarefa, o ID é obtido no cadastro da tarefa

Exemplo de requisição CURL:
```cmd
curl -X DELETE "http://localhost:8080/todo/ID"
```

## 🩺 Helthcheck
É possível consultar o status da API através do endereço 

- http://localhost:8080/actuator/health.

## 📊 Métrica 
É possível consultar o tempo e status das requisições no endereço.

- http://localhost:8080/actuator/metrics/http.server.requests.

## 📄 Documentação
É possível consultar a documentação e testar os Endpoints direto pelo browser.

- http://localhost:8080/swagger-ui.html#/task-controller