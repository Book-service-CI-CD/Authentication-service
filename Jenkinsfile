pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Book-service-CI-CD/Authentication-service.git', branch: 'main'
            }
        }
        stage('Build') {
            steps {
                echo 'Building Authentication Service...'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing Authentication Service...'
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying Authentication Service...'
                bat 'docker build -t auth-service:latest .'
                bat 'docker run -d -p 9292:9292 auth-service:latest'
            }
        }
    }
    
}
