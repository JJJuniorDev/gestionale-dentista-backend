# Utilizza l'immagine ufficiale di OpenJDK come base
FROM openjdk:11-jre-slim

# Imposta la directory di lavoro
WORKDIR /app

# Copia il file JAR generato dal progetto nella directory di lavoro
COPY target/appointment-service-0.0.1-SNAPSHOT.jar app.jar

# Comando per eseguire l'applicazione Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]
