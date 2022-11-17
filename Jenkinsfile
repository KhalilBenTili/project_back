pipeline {
  
  agent any

  stages {

    stage('docker-compose nexus up') {
      steps {
         sh 'docker-compose -f docker-composeSX.yml up -d'
      
      }
    }

    stage('docker-compose Spring up') {
      steps {
         sh 'docker-compose -f docker-compose.yml up -d'
      
      }
    }    
    
    stage('show containers ') {
      steps {
         sh 'docker ps'
      
      }
    } 
    stage('grafana prometheus ') {
      steps {
         sh 'docker restart prometheus'
         sh 'docker restart grafana'
      
      }
    } 


}
 
}
