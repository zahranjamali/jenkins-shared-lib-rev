#!/usr/bin/env groovy

def call(String imageName) {
        echo "pushing to docker hub"
        withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
            sh "echo $PASS | docker login -u $USER --password-stdin"
            sh "docker push $imageName"
    }
}