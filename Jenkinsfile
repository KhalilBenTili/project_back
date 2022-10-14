pipeline {
  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  environment{
    DOCKERHUB_CREDENTIALS = credentials('DockerHubID')
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
    
    stage('Docker build') {
    	agent any
      steps {
        sh 'echo "Docker is building ...."'
      	sh 'docker build -t ademesprit98/devops_project_5ds1group5 .'
      }
  }
    
    
    stage('Docker login') {
    	agent any
      steps {
        sh 'echo "login Docker ...."'
      	sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR DOCKERHUB_CREDENTIALS_PSW'
      }
  }
    
    stage('Docker push') {
    	agent any
      steps {
        sh 'echo "Docker is pushing ...."'
      	sh 'docker push ademesprit98/devops_project_5ds1group5'
      }
  }
    
}
  post {
        success {
             mail to: "khalilbentili2@gmail.com",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "khalilbentili2@gmail.com",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
}



