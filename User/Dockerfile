FROM openjdk:17
VOLUME /temp
ADD target/thefix-user.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]