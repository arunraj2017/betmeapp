FROM openjdk:8-jdk-alpine
COPY target/bet-me-app-1.0.0.jar bet-me-app.jar
ENTRYPOINT ["java","apiKey=${apiKey}","connection=${connection}","-jar","/bet-me-app.jar"]