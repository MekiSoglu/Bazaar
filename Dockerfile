FROM openjdk:11-jre-slim

WORKDIR /app

COPY /Users/meki/Desktop/e-commerce-backend/backend/demo14/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar

ADD target/demo-0.0.1-SNAPSHOT.jar devops-integration.jar

EXPOSE 8080

CMD ["java", "-jar", "devops-integration.jar"]