FROM openjdk:11-jre-slim

WORKDIR /app


ADD target/demo-0.0.1-SNAPSHOT.jar devops-integration.jar.jar

EXPOSE 8080

CMD ["java", "-jar", "devops-integration.jar"]