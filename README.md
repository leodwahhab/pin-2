# PIN-2

Este repositório contém o projeto desenvolvido como freelancer para o Trabalho de Conclusão de Curso (TCC) de um colega, que gentilmente autorizou sua publicação. O projeto consiste em um sistema completo com arquitetura separada em FrontEnd, BackEnd e integração via Docker Compose.

## Estrutura do Projeto

O projeto é organizado nos seguintes diretórios principais:

```
PIN-2/
├── FrontEnd/          # Código-fonte do front-end
├── BackEnd/           # Código-fonte do back-end
├── docker-compose.yml # Configuração dos serviços Docker
└── README.md          # Documentação do projeto
```

### 1. FrontEnd
- Desenvolvido para oferecer a interface visual do sistema.
- Estrutura organizada com arquivos HTML e scripts.

#### Estrutura do Diretório FrontEnd:
```
FrontEnd/
├── scripts/            # Scripts utilizados pelo front-end
├── cadastro.html       # Página de cadastro
├── historico.html      # Página de histórico
├── index.html          # Página de login
├── opcoes.html         # Página de opções
├── produto.html        # Página de detalhes do produto
```

### 2. BackEnd
- API desenvolvida em Java utilizando o framework Spring Boot.
- Responsável por gerenciar a lógica de negócio e comunicação com o banco de dados.
- Configurado para se integrar com o banco de dados SQL Server via Docker Compose.

#### Estrutura do Diretório BackEnd:
```
BackEnd/
├── src/                # Código-fonte principal do back-end
├── .mvn/               # Configurações do Maven
├── Dockerfile          # Arquivo de construção do container Docker
├── pom.xml             # Configuração do Maven para dependências e plugins
└── mvnw*               # Wrapper do Maven para execução local
```

### 3. Docker Compose
- Arquivo `docker-compose.yml` utilizado para orquestrar os serviços do projeto:
  - **db**: Banco de dados Microsoft SQL Server.
  - **api**: BackEnd containerizado com Spring Boot.
  - **frontend**: Aplicação FrontEnd servida via Nginx.

#### Configuração dos Serviços no Docker Compose:
```yaml
db:
  image: mcr.microsoft.com/mssql/server:latest
  environment:
    - "ACCEPT_EULA=Y"
    - "MSSQL_SA_PASSWORD=yourStrong(!)Password"
    - "MSSQL_PID=Evaluation"
  ports:
    - "1433:1433"
  networks:
    - backend-network
  restart: always

api:
  build:
    context: ./BackEnd
  ports:
    - '8080:8080'
  environment:
    - SPRING_DATASOURCE_URL=jdbc:sqlserver://db:1433;databaseName=master;encrypt=false;trustServerCertificate=true
    - SPRING_DATASOURCE_USERNAME=sa
    - SPRING_DATASOURCE_PASSWORD=yourStrong(!)Password
    - SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.SQLServerDialect
    - SPRING_JPA_HIBERNATE_DDL-AUTO=update
    - SPRING_JPA_HIBERNATE_SHOW-SQL=true
    - SERVER_PORT=8080
  networks:
    - backend-network
  depends_on:
    - db
```

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/leodwahhab/pin-2.git
   ```
2. Certifique-se de ter o Docker e o Docker Compose instalados.
3. No diretório raiz do projeto, execute:
   ```bash
   docker-compose up --build
   ```
4. Acesse o sistema:
   - **FrontEnd**: *acessado diretamente pelo arquivo ``index.html``
   - **BackEnd API**: [http://localhost:8080](http://localhost:8080)

## Tecnologias Utilizadas

- **FrontEnd**:
  - HTML, CSS, JavaScript
- **BackEnd**:
  - Java com Spring Boot
  - Hibernate para ORM
- **Banco de Dados**:
  - Microsoft SQL Server
- **Containerização**:
  - Docker e Docker Compose

## Agradecimentos

Este projeto foi desenvolvido como parte do TCC de [nome do colega], que permitiu sua publicação pública. Foi uma excelente oportunidade para consolidar conhecimentos e contribuir com uma solução prática e funcional.

---

Espero que este repositório seja útil para estudantes, desenvolvedores e curiosos. Feedbacks e contribuições são sempre bem-vindos!
