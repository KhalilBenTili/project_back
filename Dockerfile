FROM imagenarium/jdk-maven
ADD https://github.com/cladiators1/project_back/tree/master/target
ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar"]
