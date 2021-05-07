pipeline {
  agent any 
  stages {
    
    stage('package') {
      agent { docker { image 'maven:3.8.1-openjdk-11' } }
      steps {
        sh 'mvn --version'
        sh 'mvn clean install'
      }
    }
    
    stage('test') {
      agent { docker { image 'maven:3.8.1-openjdk-11' } }
      steps {
        sh 'mvn test'
      }
    }
    
    stage('build') {
      agent { docker { image 'maven:3.8.1-openjdk-11' } }
      steps {
        sh 'mvn clean package'
      }
    }
    
    stage('deploy') {
      steps {
        sh 'docker build -t server-jenkins .'
        sh 'docker kill $(docker ps -q)'
        sh 'docker rm $(docker ps -a -q)'
        sh 'docker run -d -p 8080:8080 server-jenkins'
      }
    }
    
  }
}
