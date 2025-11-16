# Usa una imagen oficial de OpenJDK 17
FROM eclipse-temurin:17-jdk-jammy

# Copia el archivo JAR generado a la imagen
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# Expone el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "/app.jar"]
