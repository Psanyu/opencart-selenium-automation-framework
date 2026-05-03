pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                bat 'mvn clean test'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
    }
}
