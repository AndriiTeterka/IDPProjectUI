pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test') {
            steps {
                sh 'mvn clean compile test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }
