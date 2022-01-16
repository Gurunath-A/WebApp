pipeline {
    agent any
	
	  tools
    {
       maven "Maven3"
    }
 stages {
      stage('checkout') {
           steps {
             
                git branch: 'master', url: 'https://github.com/Gurunath-A/WebApp.git'
             
          }
        }
	 stage('Execute Maven') {
           steps {
             
                sh 'mvn package'             
          }
        }
        

  stage('Docker Build and Tag') {
           steps {
              
                sh 'docker build -t webapp:latest .' 
                sh 'docker tag webapp devopeng121/webapp:latest'
                //sh 'docker tag webapp devopeng121/WebApp:$BUILD_NUMBER'
               
          }
        }
     
  stage('Publish image to Docker Hub') {
          
           steps {
             withDockerRegistry([credentialsId: 'dockerHub',url: ""]) {
             sh  'docker push devopeng121/webapp:latest'
               // sh  'docker push devopeng121/webapp:$BUILD_NUMBER' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                sh "docker run -d -p 8002:8080 devopeng121/webapp"
 
            }
        }
 stage('Run Docker container on remote hosts') {
             
            steps {
                sh "docker -H ssh://jenkins@10.2.1.85 run -d -p 8002:8080 devopeng121/webapp"
 
            }
        }
    }
	}
    
