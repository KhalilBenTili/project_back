FROM imagenarium/jdk-maven:17
ADD /target/tpAchatProject-1.0.jar  tpAchatProject-1.0.jar
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
