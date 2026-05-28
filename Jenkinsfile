pipeline {

    agent any
    parameters {
        choice(name:'VERSION', choise: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name:'executeTests', defaultValue: true, description: '')
    }

    stages {

        stage('Build') {
            steps {
                echo 'Building the application...'
            }
        }

        stage('Test') {
            when {
                expression {
                        params.executeTests
                }
            }
            steps {
                echo 'testing the application...'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying the application...'
                echo "deploying version ${VERSION}"
            }
        }
    }
}
