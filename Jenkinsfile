pipeline {
    agent any

    stages {

        stage('Test') {
            steps {
                echo 'Testing...'
                // Add your test steps here
            }
        }
        stage('Build') {
            when {
                expression {
                    BRANCH_NAME == 'main'
                    echo "Branch name is: ${BRANCH_NAME}"
                }
            }
            steps {
                echo 'Building...'
                // Add your build steps here
            }
        }
        
        stage('Deploy') {
             when {
                expression {
                    BRANCH_NAME == 'main'
                }
            }
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
            }
        }
    } 
}