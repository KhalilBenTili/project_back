FROM openjdk:8
EXPOSE 8088
ADD /target/*.jar  app.jar
ENTRYPOINT ["java","-jar","app.jar"]
