FROM maven:3.8.4-openjdk-11 as builder
WORKDIR  /app
COPY . .
RUN  mvn clean package spring-boot:repackage 

FROM openjdk:11-jre-slim
RUN groupadd  spring && \
    useradd -M spring -g spring
WORKDIR /app
COPY  --from=builder /app/target/spring-rest-server.jar application.jar
RUN chown -R spring:spring /app
USER spring:spring
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app/application.jar"]