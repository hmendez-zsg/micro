def applicationName = "micro";

pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('Build') {
            steps {
                sh script: "cd ${applicationName} && mvn clean package"
            }
        }
    }
}