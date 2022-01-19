FROM openjdk:17
VOLUME /temp
ADD target/eureka-server-spring-boot-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]