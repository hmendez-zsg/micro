def applicationName = "micro";

pipeline {
    agent any
    options {
        timeout(time: 20, unit: 'MINUTES')
    }
    environment {
        APP_NAME = "micro"
        PRJ_DEV  = "zsg-dev-" + "${APP_NAME}"
        PRJ_QA   = "zsg-qa-" + "${APP_NAME}"
        PRJ_PROD = "zsg-prod-" + "${APP_NAME}"
    }
    stages {
        stage('Check Micro Projects Exist') {
            steps {
                script {
                    openshift.withCluster() {
                        echo "Current project env";
                        sh 'env | sort'
                        try {
                            openshift.selector("projects", PRJ_DEV).exists();
                            echo "Project ${PRJ_DEV} exists."
                        } catch (e) {
                            error "Missing ${PRJ_DEV} Project or RBAC policy."
                        }

                        try {
                            openshift.selector("projects", PRJ_QA).exists();
                            echo "Project ${PRJ_QA} exists."
                        } catch (e) {
                            error "Missing ${PRJ_QA} Project or RBAC policy."
                        }

                        try {
                            openshift.selector("projects", PRJ_PROD).exists();
                            echo "Project ${PRJ_PROD} exists."
                        } catch (e) {
                            error "Missing ${PRJ_PROD} Project or RBAC policy."
                        }
                    }
                }
            }
        }
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