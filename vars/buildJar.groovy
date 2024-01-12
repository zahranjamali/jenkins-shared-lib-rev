#!/usr/bin/env groovy

def call() {
    echo "building the jar file in $BRANCH_NAME"
    sh 'mvn package'
}
