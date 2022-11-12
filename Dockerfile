FROM openjdk:11
EXPOSE 8088
ADD /target/tpAchatProject-1.0.jar  devopsproject-1.0.jar
ENTRYPOINT ["java", "-jar", "devopsproject-1.0.jar"]
