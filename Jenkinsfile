pipeline {
  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  stages {
    stage('hello') {
      steps {
        sh 'echo "Hello World"' 
      }
    }
    stage ('Initialize') {
            steps {
                sh 'mvn --version'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    stage ('Build') {
            steps {
                sh 'mvn  package' 
            }
            
        }
    stage('Test') {
      steps {
        sh 'mvn  test'

      }
    }
  }
}



