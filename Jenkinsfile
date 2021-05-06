pipeline {
  agent any 
  stages {
    
    stage('package') {
      agent { docker { image 'maven:3.5.4' } }
      steps {
        git 'https://github.com/cmitchell2324/server-jenkins.git'
        sh 'mvn --version'
        sh 'mvn clean install'
      }
    }
    
    stage('build') {
      agent { dockerfile true }
      steps {
        sh 'docker build -t server-jenkins .'
      }
    }
    
    stage('deploy') {
      agent { dockerfile true }
      steps {
        sh 'docker run -p 8080:8080 server-jenkins'
      }
    }
    
  }
}
