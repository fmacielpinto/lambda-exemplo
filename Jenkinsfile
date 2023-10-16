pipeline{
    agent any
    stages{
        stage('Build Image'){
            steps{
                script{
                    dockerapp = docker.build("fmacielpinto/lambda-exemplo", '-f ./src/Dockerfile ./src')
                }
            }

        }

    }


}