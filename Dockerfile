FROM imagenarium/jdk-maven:17
ADD https://github.com/cladiators1/project_back/tree/master/target .
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]

