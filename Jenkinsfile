pipeline {
    agent any

    tools {
        // This configures Maven. Make sure 'Maven 3.x' matches the name in your Jenkins Global Tool Configuration.
        maven 'Maven 3.x' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application...'
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Placeholder for deployment steps
                echo 'Application deployed successfully!'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished. Cleaning up workspace...'
        }
        success {
            echo 'Build passed successfully!'
        }
        failure {
            echo 'Build failed. Check the logs above.'
        }
    }
}
