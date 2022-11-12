FROM openjdk:8-alpine
add /target/*  app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
