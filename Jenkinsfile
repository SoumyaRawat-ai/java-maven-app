#!/usr/bin/env groovy

@Library('jenkins-shared-library') _

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
                    buildDockerImage 'soumyarawat03/demo-app:jma-3.0'
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