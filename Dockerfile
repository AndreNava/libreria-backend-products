# Usar una imagen base con Java
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/products-0.0.1-SNAPSHOT.jar prducts.jar

# Exponer el puerto del microservicio
EXPOSE 8086

# Definir el comando para ejecutar el servicio
ENTRYPOINT ["java", "-jar", "prducts.jar"]