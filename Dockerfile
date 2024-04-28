FROM openjdk:11-jre-slim

WORKDIR /app


ADD target/devops-integration.jar devops-integration.jar

EXPOSE 8080

CMD ["java", "-jar", "devops-integration.jar"]