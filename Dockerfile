FROM eclipse-temurin:21-jdk
LABEL maintainer="SivaReddy"
WORKDIR /app
COPY target/rest-demo.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]