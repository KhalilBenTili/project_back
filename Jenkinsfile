pipeline {
  agent any
  stages {
    stage('hello') {
      steps {
        sh 'echo "Hello World "'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn clean package'
        sh 'mvn test'

      }
    }
  }
}
