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
        stage('S2I Build') {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject() {
                            def build = openshift.selector("bc", applicationName);
                            def startedBuild = build.startBuild("--from-file=\"./target/${applicationName}-0.0.1.jar\"");
                            startedBuild.logs('-f');
                            echo "${applicationName} build status: ${startedBuild.object().status}";
                        }
                    }
                }
            }
        }
    }
}