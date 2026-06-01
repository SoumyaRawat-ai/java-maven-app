pipeline {
    agent any

    tools {
        maven 'Maven 3.x' 
    }

    stages {
        stage('Increment Version') {
            steps {
                script {
                    echo 'Incrementing version...'
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "${version}-${BUILD_NUMBER}"
                }
            }
        }
        
        stage('Build App') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean package'
            }
        }

        stage('Build Image') {
            steps {
                script {
                    echo 'Building Docker image...'
                    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t soumyarawat03/demo-app:${env.IMAGE_NAME} ."
                        sh "echo \${PASS} | docker login -u \${USER} --password-stdin"
                        sh "docker push soumyarawat03/demo-app:${env.IMAGE_NAME}"
                    }
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying docker image to EC2...'
                // Your deployment scripts will go here
            }
        }

       stage('Commit Version Update') {
    steps {
        script {
            echo 'Pushing updated version to GitHub...'
            withCredentials([usernamePassword( 
                credentialsId: 'jenkins-write12',
                passwordVariable: 'GIT_PASSWORD',
                usernameVariable: 'GIT_USERNAME'
            )]){
                    sh 'git config --global user.email "jenkins@example.com"'
                    sh 'git config --global user.name "jenkins"'
                    sh 'git status'
                    sh 'git branch'
                    sh 'git config --list'
                      sh "git remote set-url origin https://${GIT_USERNAME}:${GIT_PASSWORD}@github.com/SoumyaRawat-ai/java-maven-app.git"
                      sh 'git add .'
                      sh 'git commit -m "ci: version bump"'
                      sh 'git push origin HEAD:jenkins-jobs'
            }
        }
    }
       }
    }
}
