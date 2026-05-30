#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
    [
        $class: 'GitSCMSource',
        remote: 'https://github.com/SoumyaRawat-ai/jenkins-shared-library.git',
        credentialsId: 'github-credentials'
    ]
)


def gv

pipeline {

    agent any

    tools {
        maven 'Maven 3.x'
    }

    stages {

        stage('init') {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('build jar') {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage('build and push image') {
            steps {
                script {
                    buildImage 'soumyarawat03/demo-app:jma-3.0'
                    dockerLogin()
                    dockerPush 'soumyarawat03/demo-app:jma-3.0'
                }
            }
        }

        stage('deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}