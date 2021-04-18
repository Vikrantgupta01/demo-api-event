# Use JRE11 slim
FROM openjdk:11.0-jre-slim

COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]