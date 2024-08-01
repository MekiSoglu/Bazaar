FROM openjdk:17-jdk

WORKDIR /app

ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME="com.mysql.cj.jdbc.Driver"
ENV SPRING_DATASOURCE_URL="jdbc:mysql://host.docker.internal:3306/Ecommerce?useSSL=false&useUnicode=yes&characterEncoding=UTF-8&allowPublicKeyRetrieval=true&serverTimezone=UTC"
ENV SPRING_DATASOURCE_USERNAME="ecommerceapp"
ENV SPRING_DATASOURCE_PASSWORD="ecommerceapp"
ENV SPRING_JPA_HIBERNATE_DDL_AUTO="update"
ENV SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT="org.hibernate.dialect.MySQL8Dialect"
ENV SPRING_DATA_REST_BASE_PATH="/api"

ADD target/devops-integration.jar devops-integration.jar

EXPOSE 80

CMD ["java", "-jar", "devops-integration.jar"]


pipeline{
    agent any
    tools{
        maven 'Maven3'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/MekiSoglu/Bazaar']])
                sh 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                sh 'docker build -t zeus12419/devops-integration:latest .'
            }
        }
        stage('Push image to Hub '){
            steps{
                withCredentials([string(credentialsId: 'dockerhubpwd', variable: 'dockerhubpwd')]) {
                sh 'docker login -u zeus12419 -p ${dockerhubpwd}'
}
                sh 'docker push zeus12419/devops-integration'
            }
        }
        stage('Compose docker image'){
            steps{
                sh 'docker-compose -f docker-compose.yml up -d'
            }
        }

    }
}

withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')])

