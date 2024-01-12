#!/usr/bin/env groovy
def call() {
    echo "building the image"
    sh 'docker build -t zahranjamali/myrepo:java-maven-app-rev-1.1 .'
}
