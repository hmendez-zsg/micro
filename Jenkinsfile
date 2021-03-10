def applicationName = "micro";

pipeline {
    agent {
        label 'maven'
    }
    stages {
        stage('S2I Build - Dev') {
            steps {
                script {
                    openshift.withCluster() {
                        openshift.withProject('zsg-dev-micro') {
                            def build = openshift.selector("bc", applicationName);
                            def startedBuild = build.startBuild();
                            startedBuild.logs('-f');
                            echo "${applicationName} build status: ${startedBuild.object().status}";
                        }
                    }
                }
            }
        }
    }
}