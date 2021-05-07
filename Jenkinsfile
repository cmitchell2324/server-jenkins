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
      agent { dockerfile true }
      steps {
        sh 'docker build server-jenkins .'
      }
    }
    
    stage('deploy') {
      agent { dockerfile true }
      steps {
        sh 'docker run -d -p 8080:8080 server-jenkins'
      }
    }
    
  }
}
