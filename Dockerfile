# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-alpine

# Copia el archivo JAR de tu aplicación a la imagen
COPY target/tu-aplicacion.jar /app.jar

# Expone el puerto donde tu aplicación va a escuchar
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app.jar"]