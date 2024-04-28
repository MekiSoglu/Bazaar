FROM openjdk:17-jdk

WORKDIR /app

ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver"
ENV SPRING_DATASOURCE_URL="jdbc:mysql://localhost:3306/Ecommerce?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC"
ENV SPRING_DATASOURCE_USERNAME="ecommerceapp"
ENV SPRING_DATASOURCE_PASSWORD="ecommerceapp"
ENV SPRING_JPA_HIBERNATE_DDL_AUTO="update"
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT="org.hibernate.dialect.MySQL8Dialect"
ENV SPRING_DATA_REST_BASE_PATH="/api"

ADD target/devops-integration.jar devops-integration.jar

EXPOSE 4444

CMD ["java", "-jar", "devops-integration.jar"]