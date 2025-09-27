# Sistema Cliente HTTP - Consumo de APIs - INFNET - DR3 AT

![Java](https://img.shields.io/badge/Java-17+-blue.svg)
![Maven](https://img.shields.io/badge/Maven-3.8+-green.svg)
![HttpURLConnection](https://img.shields.io/badge/HttpURLConnection-Java%20Native-red.svg)
![License](https://img.shields.io/badge/License-MIT-yellow.svg)
![Status](https://img.shields.io/badge/Status-Ativo-success.svg)

Sistema cliente HTTP desenvolvido como projeto prático para consumo de APIs RESTful, implementando conceitos de integração entre sistemas, HttpURLConnection nativo do Java e arquitetura cliente-servidor.

## Sobre o Projeto

Este projeto foi desenvolvido como parte da **DR3 AT - Desenvolvimento de Aplicações Web** do Instituto Infnet, implementando um sistema cliente que consome os endpoints do [Sistema de Folha de Pagamento Backend](https://github.com/thiagoperest/dr3-at-parte-1) através de HttpURLConnection.

**Instituto Infnet**  
**Disciplina:** Desenvolvimento de Aplicações Web  
**Aluno:** Thiago Teodoro Peres

## Projeto Dependente

⚠️ **IMPORTANTE**: Este projeto cliente necessita que o **Sistema Backend** esteja em execução para funcionar corretamente.

**Sistema Backend (Projeto 1)**: https://github.com/thiagoperest/dr3-at-parte-1  
**Porta do Backend**: 8080  
**Porta do Cliente**: 8081

## Arquitetura

O sistema implementa uma arquitetura cliente-servidor seguindo os padrões de integração de APIs:

```
Cliente (Porta 8081)         Backend (Porta 8080)
        │                           │
Controller Layer ────HttpURLConnection────► Controller Layer
        │                           │
Service Layer    ◄────JSON Response──────── Service Layer
        │                           │
HTTP Client      ◄────HTTP Request/Response─► HTTP Server
```

O sistema foi modelado seguindo princípios de separação de responsabilidades, com camadas específicas para comunicação HTTP, processamento de dados e apresentação de resultados.

## Funcionalidades Implementadas

### Rubrica 3 - Cliente HTTP com HttpURLConnection

#### Item 1 - Criação de Mensalista
- **POST /mensalistas** - Cliente que envia requisição para criar mensalista
- **HttpURLConnection** - Uso nativo do Java sem bibliotecas externas
- **Validação automática** - Integra com validações do sistema backend

#### Item 2 - Listagem de Mensalistas  
- **GET /mensalistas** - Cliente que busca todos os mensalistas
- **Console output** - Imprime dados retornados no console do sistema
- **Formatação JSON** - Exibe resposta completa da API

#### Item 3 - Busca por Matrícula
- **GET /mensalistas/{matricula}** - Cliente com path parameter
- **Console output** - Imprime dados do mensalista específico no console
- **Tratamento de erros** - Gerencia respostas 404 e outras falhas

#### Item 4 - Status do Sistema
- **GET /status** - Cliente que consome endpoint de status da Rubrica 1
- **Console output** - Imprime JSON com status e timestamp no console
- **Monitoramento** - Permite verificar saúde do sistema backend

## Como Executar

### Pré-requisitos
- Java 17 ou superior
- Maven 3.8 ou superior
- **Sistema Backend em execução** (Projeto 1 na porta 8080)

### Execução

1. **Certifique-se que o Backend está rodando:**
   ```bash
   # No diretório do Projeto 1 (dr3-at-parte-1)
   mvn exec:java
   # Deve estar disponível em http://localhost:8080
   ```

2. **Clone e compile o cliente:**
   ```bash
   git clone https://github.com/thiagoperest/dr3-at-parte-2.git
   cd dr3-at-parte-2  
   mvn clean compile
   ```

3. **Execute o cliente:**
   ```bash
   mvn exec:java
   ```

4. **O cliente iniciará na porta 8081:**
   ```
   Servidor Cliente Javalin iniciado na porta: 8081
   Endpoints Rubrica 3 - Cliente HTTP:
   Item 1: http://localhost:8081/mensalistas (POST)
   Item 2: http://localhost:8081/mensalistas
   Item 3: http://localhost:8081/mensalistas/{matricula}
   Item 4: http://localhost:8081/status
   ```

## Estrutura do Projeto

```
src/main/java/br/edu/infnet/dr3atparte2/
├── Dr3AtParte2Application.java        # Classe principal do cliente
├── config/
│   └── RouteConfig.java               # Configuração de rotas do cliente
├── controller/
│   └── MensalistaClientController.java # Controller que gerencia requisições HTTP
├── service/
│   └── MensalistaClientService.java   # Lógica de negócio do cliente
├── client/
│   └── MensalistaHttpClient.java      # Cliente HTTP usando HttpURLConnection
└── dto/
    ├── MensalistaRequestDto.java      # DTO para requisições
    └── MensalistaResponseDto.java     # DTO para respostas
```

## Fluxo de Funcionamento

### Exemplo: Criar Mensalista

1. **Cliente recebe requisição:**
   ```
   POST http://localhost:8081/mensalistas
   ```

2. **Cliente faz HttpURLConnection para Backend:**
   ```
   POST http://localhost:8080/mensalistas
   ```

3. **Backend processa e retorna:**
   ```json
   {
     "id": 4,
     "matricula": "M004", 
     "nome": "Ana Costa",
     "cargo": "Designer",
     "salario": 4800.0
   }
   ```

4. **Cliente exibe no console e retorna ao solicitante**

## Exemplos de Uso

### Criar Mensalista via Cliente
```bash
POST http://localhost:8081/mensalistas
Content-Type: application/json

{
  "matricula": "M555",
  "nome": "Cliente Teste",
  "cargo": "Desenvolvedor",
  "salario": 8000.0
}
```

### Listar Mensalistas via Cliente
```bash
GET http://localhost:8081/mensalistas
```
**Console Output:**
```
--- ITEM 2 - LISTAGEM DE TODOS OS MENSALISTAS ---
[{"id":1,"matricula":"M001","nome":"João Silva"...}]
------------
```

### Buscar por Matrícula via Cliente  
```bash
GET http://localhost:8081/mensalistas/M001
```
**Console Output:**
```
--- ITEM 3 - BUSCA DE MENSALISTA POR MATRÍCULA ---
{"id":1,"matricula":"M001","nome":"João Silva"...}
------------
```

### Verificar Status via Cliente
```bash
GET http://localhost:8081/status
```  
**Console Output:**
```
--- ITEM 4 - STATUS DO SISTEMA ---
{"status":"ok","timestamp":"2025-01-21T14:30:45.123Z"}
------------
```

## Tecnologias Utilizadas

- **Java 17** - Linguagem de programação principal
- **HttpURLConnection** - Cliente HTTP nativo do Java (sem libs externas)
- **Javalin 6.7.0** - Framework web para expor endpoints do cliente
- **Jackson** - Serialização/deserialização JSON
- **Maven** - Gerenciamento de dependências

## Integração com Sistema Backend

### Endpoints Consumidos
| Cliente (8081) | Backend (8080) | Funcionalidade |
|---|---|---|
| POST /mensalistas | POST /mensalistas | Criar mensalista |
| GET /mensalistas | GET /mensalistas | Listar mensalistas |
| GET /mensalistas/{matricula} | GET /mensalistas/{matricula} | Buscar por matrícula |
| GET /status | GET /status | Status do sistema |

### Dependências
- **Sistema Backend** deve estar rodando na porta 8080
- **Conectividade HTTP** entre cliente e servidor

## Contato

**Thiago Teodoro Peres**  
Email: thiago.peres@al.infnet.edu.br  
Instituto Infnet - Desenvolvimento de Serviços Web e Testes com Java
---

**Projeto desenvolvido para o Instituto Infnet - DR3 AT**

**Sistema Backend**: https://github.com/thiagoperest/dr3-at-parte-1