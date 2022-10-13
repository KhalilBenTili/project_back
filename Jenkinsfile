pipeline {
  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  stages {
    stage ('Check Tools Initializing') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    stage('Cleaning the Project') {
      steps {
         sh 'echo "Clean the Project is processing ...."'
        sh 'mvn clean'
      }
    }
    
    stage ('Artifact construction') {
            steps {
                sh 'echo "Artifact construction is processing ...."'
                sh 'mvn  package' 
            }
            
        }
    stage('Junit Testing') {
      steps {
         sh 'echo "Junit Test is processing ...."'
        sh 'mvn  test'

      }
    }
    
    stage('Docker Build') {
    	agent any
      steps {
        sh 'echo "Docker is building ...."'
      	sh 'docker build -t ademesprit98/DevOpsProject5DS1group5 .'
      }
  }
}



