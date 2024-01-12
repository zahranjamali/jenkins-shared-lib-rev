#!/usr/bin/env groovy

def call() {
        echo "pushing to docker hub"
        withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh 'docker push zahranjamali/myrepo:java-maven-app-rev-1.1'
    }
}