FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/facilityservice-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8082

# run command - application
ENTRYPOINT ["java", "-jar", "app.jar"]