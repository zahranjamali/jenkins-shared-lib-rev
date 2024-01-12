#!/usr/bin/env groovy

package com.example

class Docker implements Serializable {
    def script
    Docker(script) {
        this.script = script
    }

    def buildJar () {
        script.echo "building the jar file in $script.BRANCH_NAME"
        script.sh 'mvn package'
    }

    def buildDockerImage (String imageName) {
        script.echo "building the image"
        script.sh "docker build -t $imageName ."
    }


    def dockerLogin () {
        script.withCredentials([script.usernamePassword(credentialsId: 'DOCKER_HUB_REPO', passwordVariable: 'PASS', usernameVariable: 'USER')]){
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
        }
    }

    def dockerPush (String imageName) {
        script.sh "docker push $imageName"
    }
}

