pipeline {
  
  agent any
  tools {
     jdk 'JAVA_HOME'
     maven 'M2_HOME'
  }
  environment {
        
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
	               
    
    stage('Junit Testing') {
      steps {
         sh 'echo "Junit Test is processing ...."'
        sh 'mvn  test'

      }
    }
    
    stage('Quality Gate Status Check'){
                  steps{
                      script{
			withSonarQubeEnv('sonar') {
			     sh "mvn compile sonar:sonar"
                       	          }
		    	    sh "mvn clean install"

                 	}
               	 }
              }
    
    stage ('Artifact construction') {
            steps {
                sh 'echo "Artifact construction is processing ...."'
                sh 'mvn  package' 
            }
      
            
        }
    
    
    
    stage('Docker build') {
    	agent any
      steps {
        sh 'echo "Docker is building ...."'
      	sh 'docker build -t $DOCKERHUB_CREDENTIALS_USR/devops_project_5ds1group5 .'
      }
  }
    
    
    stage('Docker login') {
    	agent any
      steps {
        sh 'echo "login Docker ...."'
      	sh 'docker login -u $DOCKERHUB_CREDENTIALS_USR -p $DOCKERHUB_CREDENTIALS_PSW'
      }
  }
    
    stage('Docker push') {
    	agent any
      steps {
        sh 'echo "Docker is pushing ...."'
      	sh 'docker push $DOCKERHUB_CREDENTIALS_USR/devops_project_5ds1group5'
      }
  }
	  stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: '192.168.56.4:8081',
                            groupId: 'pom.com.esprit.examen',
                            version: 'pom.2.0',
                            repository: 'maven-releases',
                            credentialsId: 'nexus',
                            artifacts: [
                                [artifactId: 'pom.tpAchatProject',
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: 'pom.tpAchatProject',
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
        }
    
}
  post {
        success {
             mail to: "houaidafatma.karoui@esprit.tn",
                    subject: "Build sucess",
                    body: "sucess"
            echo 'successful'
        }
        failure {
             mail to: "houaidafatma.karoui@esprit.tn",
                    subject: "Build failed",
                    body: "failed"
            echo 'failed'
        }
      }
}



