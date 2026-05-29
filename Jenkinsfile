#!/usr/bin/env groovy
import org.apache.tomcat.jni.Library

@Library('jenkins-shared-library')
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
        stage('build image') {
            steps {
                script {
                    buildImage()
                }
            }
        }

        stage('deploy') {
            steps {
                gv.deployApp()
            }
        }
    }

}
