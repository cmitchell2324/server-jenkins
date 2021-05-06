pipeline {
  agent any 
  stages {
    stage('build') {
      agent { docker { image 'maven:3.5.4' } }
      steps {
        git 'https://github.com/cmitchell2324/server-jenkins.git'
        sh 'mvn --version'
        sh 'mvn clean install'
      }
    }
  }
}
