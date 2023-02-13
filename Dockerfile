FROM eclipse-temurin:17-jdk-alpine
LABEL maintainer="balex97531@gmail.com"
COPY ./build/libs/test-project-1.0-SNAPSHOT.jar ./
EXPOSE 8080
ENTRYPOINT ["java","-jar","/test-project-1.0-SNAPSHOT.jar"]