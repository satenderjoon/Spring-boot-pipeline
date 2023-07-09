node {
    checkout scm
    stage('Build') {
        withMaven(globalMavenSettingsConfig: '', jdk: 'JDK11', maven: 'Maven3.5.3', mavenSettingsConfig: '', traceability: true) {
            sh 'mvn clean install'
        }
        
    }
    stage('Test') {
        echo 'Testing....'
    }
    stage('Deploy') {
        echo 'Deploying....'
    }
}