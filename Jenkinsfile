pipeline {

    agent any

    parameters {
        choice(
                name: 'VERSION',
                choices: ['1.1.0', '1.2.0', '1.3.0'],
                description: 'Select application version'
        )

        booleanParam(
                name: 'executeTests',
                defaultValue: true,
                description: 'Execute test stage'
        )
    }

    stages {

        stage('Init'){
                steps {
                    script {
                        gv = load "script.groovy"
                    }
                }
        }

        stage('Build') {
            steps {
                script {
                    gv.buildAPP()
                }
            }
        }

        stage('Test') {
            when {
                expression {
                    params.executeTests
                }
            }

            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage('Deploy') {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}