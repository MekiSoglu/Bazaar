FROM openjdk:17-jre-slim

WORKDIR /app


ADD target/devops-integration.jar devops-integration.jar

EXPOSE 4444

CMD ["java", "-jar", "devops-integration.jar"]