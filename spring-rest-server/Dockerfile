FROM openjdk:11-jre-slim
ARG JAR_FILE=target/*.jar
RUN groupadd  spring && \
    useradd -M spring -g spring
WORKDIR /app
COPY ${JAR_FILE} application.jar
RUN chown -R spring:spring /app
USER spring:spring
ENTRYPOINT ["java", "-Djava.security.edg=file:/dev/./urandom","-jar","/app/application.jar"]