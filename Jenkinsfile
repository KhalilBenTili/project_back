pipeline {
  agent any

  
  stages {
    stage('hello') {
      steps {
        sh 'echo "Hello World   "'
      }
    }
    stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    stage('Test') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true test'

      }
    }
  }
}



