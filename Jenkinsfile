pipeline {
  agent any 
  stages {
    stage('build') {
      agent { docker { image 'maven:3.5.4' } }
      steps {
        sh 'mvn --version'
      }
    }
  }
}

try {
  Stuff here
catch
