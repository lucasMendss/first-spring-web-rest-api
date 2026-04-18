 # Spring Boot Essentials

 API REST feita com Spring Boot para estudo de conceitos essenciais como controllers, services, tratamento global de exceções, DTOs e documentação automática com Swagger/OpenAPI. Trabalha com uma lista de produtos em memória, permitindo operações de CRUD sem banco de dados. 
 
 ## Funcionalidades

 - CRUD de produtos
 - Busca de produto por ID
 - Endpoints de teste `hello`
 - Tratamento global de erros com resposta padronizada
 - Documentação Swagger/OpenAPI

 ## Tecnologias utilizadas

 - Java 17
 - Spring Boot 4.0.5
 - Spring Web MVC
 - SpringDoc OpenAPI UI
 - Lombok
 - Maven

 ## Requisitos

 Antes de executar o projeto, verifique se você tem instalado:

 - **Java 17** ou superior compatível
 - **Maven 3.9+** ou o uso do Maven Wrapper incluído no projeto
 - **Git** para clonar o repositório

 ## Download do projeto

 Clone o repositório com:

 ```bash
 git clone https://github.com/lucasMendss/first-spring-web-rest-api
 cd spring-boot-essentials
 ```

 Se você estiver usando o projeto direto no IntelliJ IDEA, basta abrir a pasta raiz do módulo `spring-boot-essentials`.

 ## Executando localmente

 ### Com Maven Wrapper

 No Windows:

 ```bat
 mvnw.cmd spring-boot:run
 ```

 No Linux/macOS:

 ```bash
 ./mvnw spring-boot:run
 ```

 ### Gerando o build e executando o JAR

 ```bash
 mvn clean package
 java -jar target/spring-boot-essentials-0.0.1-SNAPSHOT.jar
 ```

 ## Como testar a aplicação

 Depois de subir a aplicação, acesse:

 - Swagger UI: `http://localhost:8080/swagger-ui/index.html`
 - Endpoint de produtos: `http://localhost:8080/v1/produtos`

 Você também pode testar com `curl`, Postman ou Insomnia.

 ### Exemplos de requisição

 **Listar produtos**

 ```bash
 curl http://localhost:8080/v1/produtos
 ```

 **Buscar produto por ID**

 ```bash
 curl http://localhost:8080/v1/produtos/1
 ```

 **Criar produto**

 ```bash
 curl -X POST http://localhost:8080/v1/produtos \
   -H "Content-Type: application/json" \
   -d "{\"nome\":\"Mouse Gamer\",\"preco\":199,\"quantidade\":10}"
 ```

 **Atualizar produto**

 ```bash
 curl -X PUT http://localhost:8080/v1/produtos/1 \
   -H "Content-Type: application/json" \
   -d "{\"nome\":\"Mouse Gamer Pro\",\"preco\":249,\"quantidade\":8}"
 ```

 **Remover produto**

 ```bash
 curl -X DELETE http://localhost:8080/v1/produtos/1
 ```

 ## Endpoints disponíveis

 ### Produtos

 Base URL: `/v1/produtos`

 | Método | Rota | Descrição |
 |---|---|---|
 | `GET` | `/v1/produtos` | Lista todos os produtos |
 | `GET` | `/v1/produtos/{id}` | Busca um produto pelo ID |
 | `POST` | `/v1/produtos` | Cria um novo produto |
 | `PUT` | `/v1/produtos/{id}` | Atualiza um produto existente |
 | `DELETE` | `/v1/produtos/{id}` | Remove um produto |

 ### Hello World

 Base URL: `/v1/hello`

 | Método | Rota | Descrição |
 |---|---|---|
 | `GET` | `/v1/hello/{name}` | Retorna uma saudação usando path variable |
 | `GET` | `/v1/hello?name=...` | Retorna uma saudação usando query param |
 | `POST` | `/v1/hello` | Retorna uma saudação usando body |

 ## Tratamento de erros

 O projeto possui um handler global para exceções, devolvendo uma resposta padronizada no formato JSON.

 Exemplos:

 - **404 Not Found** quando o produto não existe
 - **500 Internal Server Error** para exceções genéricas

 ## Estrutura do projeto

 - `controller` — define os endpoints REST
 - `service` — contém as regras de negócio
 - `dto` — objetos de entrada/saída
 - `database/model` — entidades do domínio
 - `exception` — exceções e payloads de erro
 - `handler` — tratamento global de exceções

 ## Observação sobre persistência

 Os produtos estão armazenados em memória dentro de `ProdutoService`. Isso significa que:

 - os dados são perdidos ao reiniciar a aplicação
 - não há banco de dados configurado neste momento
 - o projeto é ideal para fins didáticos e testes locais


