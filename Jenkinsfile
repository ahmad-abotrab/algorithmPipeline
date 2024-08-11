pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-17' // Using Maven with Java 17 in Docker
            args '-v /root/.m2:/root/.m2'  // Caching Maven dependencies (optional)
        }
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm // Checkout code from the repository
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile' // Clean and compile the project using Maven
            }
        }

        stage('Test') {
            steps {
                // Run the tests
                sh 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml' // Archive test results in Jenkins
                }
            }
        }
    }

    post {
        success {
            echo 'Build and tests succeeded!'
        }
        failure {
            echo 'Build or tests failed.'
        }
    }
}
