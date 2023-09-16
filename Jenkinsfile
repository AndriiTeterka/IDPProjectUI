pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Install Maven') {
            steps {
                sh 'sudo apt-get update'
                sh 'sudo apt-get install -y maven'
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

        stage('Deploy') {
            steps {
                echo 'Deploying'
            }
        }
    }

    post {
        always {
            echo 'post staff'
        }
    }
}
