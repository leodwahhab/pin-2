# Etapa 1: Construção do projeto usando Maven com Amazon Corretto 21
FROM amazoncorretto:21-alpine3.18 AS builder

RUN apk add --no-cache maven

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo pom.xml e o diretório src para o container
COPY pom.xml .
COPY src ./src

# Execute o comando para construir o projeto
RUN mvn clean package -DskipTests

# Etapa 2: Rodar a aplicação com a imagem do Amazon Corretto 21
FROM amazoncorretto:21-alpine3.18

# Defina o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo JAR gerado na etapa anterior para o container
COPY --from=builder /app/target/BackEnd-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que o Spring Boot vai rodar (por padrão, o Spring Boot usa 8080)
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
