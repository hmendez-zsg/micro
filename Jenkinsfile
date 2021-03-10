def applicationName = "micro";

pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('Build') {
            steps {
                sh script: "mvn clean package"
            }
        }
    }
}