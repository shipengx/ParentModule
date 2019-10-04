FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./target/spring-boot-example-0.1.0.jar spring-boot-example-0.1.0.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-example-0.1.0.jar"]
