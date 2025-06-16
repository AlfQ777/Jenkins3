pipeline {
    agent any
    tools {
        jdk 'jdk17'
    }

    stages {

        stage('Ejecutar pruebas') {
            steps {
                bat("gradlew.bat clean test --tests \"net.serenitybdd.demo.zorro.runners.ZorroRunnerWithPreprocessing\" aggregate -Dwebdriver.driver=chrome || exit 0")
            }
        }

        stage('Publicar evidencias') {
            steps {
                publishHTML(target: [
                reportName: 'Evidencias de Pruebas',
                        reportDir: 'target/site/serenity',
                        reportFiles: 'index.html',
                        keepAll: true,
                        alwaysLinkToLastBuild: true,
                        allowMissing: false
                ])
            }
        }
    }

    post {
        always {
            bat("rmdir /s /q target")
        }
    }
}
