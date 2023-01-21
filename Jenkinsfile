pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building project...'
                sh 'mvn clean install'
            }
        }
        stage('Dockerize') {
            steps {
            echo 'Creating Docker image...'
            sh 'docker build -t my-microservice .'
            }
        }
    }
    post {
        success {
            echo 'Build and Dockerization successful!'
        }
        failure {
            echo 'Build and Dockerization failed!'
        }
    }