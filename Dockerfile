# --- Etapa 1: Compilacion con Maven ---
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# --- Etapa 2: Servidor Tomcat con el WAR compilado ---
FROM tomcat:9.0-jdk17-corretto
RUN rm -rf /usr/local/tomcat/webapps/ROOT
COPY --from=build /app/target/gestion_futbol.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
CMD ["catalina.sh", "run"]
