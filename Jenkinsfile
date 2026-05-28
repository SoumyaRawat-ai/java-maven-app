pipeline {
    agent any
    tools {
        maven "maven-3.6"
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Building the project..."
                    sh "mvn package"
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "Building the Docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS', usernameVariable: 'USER' )]) {
                        sh 'docker build -t soumyarawat03/demo-app:jma2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push soumyarawat03/demo-app:jma2.0'
                    }
                }
            }
        }
        stage("deploy to kubernetes") {
            steps {
                script {
                    echo "Deploying to Kubernetes..."
                }
            }
        }
    }
}