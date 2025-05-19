# Etapa 1: Compilación del proyecto
FROM maven:3.8.8-eclipse-temurin-17 AS build
WORKDIR /soporte_app

# Copia el descriptor de dependencias y descarga dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia el resto del código solo después
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen liviana de ejecución
FROM eclipse-temurin:17-jre
WORKDIR /soporte_app
COPY --from=build /soporte_app/target/*.jar soporte_app.jar

# Crear el directorio para la wallet
RUN mkdir -p /wallet
EXPOSE 8082

ENTRYPOINT ["java", "-jar", "soporte_app.jar"]
