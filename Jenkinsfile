pipeline {
    agent any
	
	  tools
    {
       maven "Maven"
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
              
                sh 'docker build -t WebApp:latest .' 
                sh 'docker tag WebApp devopeng121/WebApp:latest'
                //sh 'docker tag WebApp devopeng121/WebApp:$BUILD_NUMBER'
               
          }
        }
     
  stage('Publish image to Docker Hub') {
          
           steps {
             withDockerRegistry(credentialsId: 'dockerHub') {
             sh  'docker push devopeng121/WebApp:latest'
               // sh  'docker push devopeng121/WebApp:$BUILD_NUMBER' 
        }
                  
          }
        }
     
      stage('Run Docker container on Jenkins Agent') {
             
            steps 
			{
                sh "docker run -d -p 8002:8080 devopeng121/WebApp"
 
            }
        }
 stage('Run Docker container on remote hosts') {
             
            steps {
                sh "docker -H ssh://jenkins@10.2.1.85 run -d -p 8002:8080 devopeng121/WebApp"
 
            }
        }
    }
	}
    
