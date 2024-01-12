#!/usr/bin/env groovy
def call(String imageName) {
    echo "building the image"
    sh "docker build -t $imageName ."
}
