def buildJar() {
    echo "Building the project..."
    sh "mvn package"
}

def buildImage() {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS', usernameVariable: 'USER' )]) {
    sh 'docker build -t soumyarawat03/demo-app:jma2.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin"
    sh 'docker push soumyarawat03/demo-app:jma2.0'
}

def deployApp() {
    echo "Deploying the application..."
}
return this