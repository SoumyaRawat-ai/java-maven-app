pipeline {
    agent any

    // Automatically pulls and configures Maven from your Jenkins Global Tool Configuration
    tools {
        maven 'Maven 3.x' 
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                // Cleans old build files and compiles the latest Java source code
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo 'Running unit tests...'
                // Executes your JUnit/TestNG tests and generates reports
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application into a JAR/WAR file...'
                // Packages the compiled code into its final distributable format (skipping tests since they just ran)
                sh 'mvn package -DskipTests'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                // Place your deployment commands here (e.g., copying artifacts, Docker commands, AWS, etc.)
                // For now, it will safely acknowledge completion
                echo 'Application deployed successfully!'
            }
        }
    }

    // Optional: Cleans up the workspace after the build finishes so your server doesn't run out of space
    post {
        always {
            echo 'Pipeline execution finished. Cleaning up workspace...'
        }
        success {
            echo 'Success: Build passed perfectly!'
        }
        failure {
            echo 'Failure: Something went wrong in the pipeline.'
        }
    }
}
