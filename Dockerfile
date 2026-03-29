FROM openjdk:17-jdk-slim
COPY target/digital-wallet-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]