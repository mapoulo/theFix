FROM openjdk:17
VOLUME /temp
ADD target/thedocker-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]